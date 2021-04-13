
-------------------------------------------------------
--  DDL for View VIEW_OM_ACTIVE_TRANSACTION
--------------------------------------------------------

CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "SYS"."VIEW_OM_ACTIVE_TRANSACTION" ("VW_ID", "SID", "USERNAME", "START_TIME", "NAME", "USED_UBLK", "STATUS") AS 
select rownum as vw_id, sid, username, start_time, name, used_ublk, status from (
select
s.sid,
username,
t.start_time,
t.name,
t.used_ublk,
decode(t.space, 'YES', 'Space TX', decode(t.recursive, 'YES', 'Recursive TX', decode(t.noundo, 'YES', 'No UNDO TX', t.status))) as status
from
sys.v_$transaction t, sys.v_$rollname r, sys.v_$session s
where t.xidusn = r.usn
and t.ses_addr = s.saddr)
;

--------------------------------------------------------
--  DDL for View VIEW_OM_DATABASE_INFO
--------------------------------------------------------

CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "SYS"."VIEW_OM_DATABASE_INFO" ("DBINFO_ID", "DBINFO_KEY", "DBINFO_VALUE") AS 
select 1 as dbinfo_id, 'Instance Number' as dbinfo_key, to_char(instance_number) as dbinfo_value from v$instance
union
select 2 as dbinfo_id, 'Instance Name' as dbinfo_key, instance_name as dbinfo_value from v$instance
union
select 3 as dbinfo_id, 'Host Name' as dbinfo_key, host_name as dbinfo_value from v$instance
union
select 4 as dbinfo_id, 'Version' as dbinfo_key, version_full as dbinfo_value from v$instance
union
select 5 as dbinfo_id, 'Startup Time' as dbinfo_key, to_char(startup_time, 'DD/MM/YYYY HH24:MI:SS') as dbinfo_value from v$instance
union
select 6 as dbinfo_id, 'Status' as dbinfo_key, status as dbinfo_value from v$instance
union
select 7 as dbinfo_id, 'Archiver' as dbinfo_key, archiver as dbinfo_value from v$instance
union
select 8 as dbinfo_id, 'Edition' as dbinfo_key, edition as dbinfo_value from v$instance
union
select 9 as dbinfo_id, comments as dbinfo_key, to_char(value) as dbinfo_value from V$osstat where stat_name = 'NUM_CPUS'
union
select 10 as dbinfo_id, comments as dbinfo_key, to_char(value) as dbinfo_value from V$osstat where stat_name = 'NUM_CPU_CORES'
union
select 11 as dbinfo_id, comments as dbinfo_key, to_char(value) as dbinfo_value from V$osstat where stat_name = 'NUM_CPU_SOCKETS'
union
select 12 as dbinfo_id, comments as dbinfo_key, concat(round(value / 1024 / 1024 / 1024, 2), ' GB') as dbinfo_value from V$osstat where stat_name = 'PHYSICAL_MEMORY_BYTES'
union
select 13 as dbinfo_id, comments as dbinfo_key, concat(round(value / 1024 / 1024 / 1024, 2), ' GB') as dbinfo_value from V$osstat where stat_name = 'FREE_MEMORY_BYTES'
;

--------------------------------------------------------
--  DDL for View VIEW_OM_DATAFILE_UTILIZ
--------------------------------------------------------

CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "SYS"."VIEW_OM_DATAFILE_UTILIZ" ("VW_ID", "FILE_NAME", "ALLOCATED_MB", "USED_MB", "FREE_SPACE_MB") AS 
select rownum as vw_id, file_name, allocated_mb, used_mb, free_space_mb from (
select
substr(df.name, 1, 64) as file_name,
(df.bytes / 1024 / 1024) as allocated_mb,
((df.bytes / 1024 / 1024) - nvl(sum(dfs.bytes) / 1024 / 1024, 0)) as used_mb,
nvl(sum(dfs.bytes) / 1024 / 1024, 0) as free_space_mb
from
v$datafile df, dba_free_space dfs
where
df.file# = dfs.file_id (+)
group by
dfs.file_id, df.name, df.file#, df.bytes
order by
file_name)
;

--------------------------------------------------------
--  DDL for View VIEW_OM_MEMORY_USED
--------------------------------------------------------

CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "SYS"."VIEW_OM_MEMORY_USED" ("VW_ID", "NM", "MB") AS 
select rownum as vw_id, nm, mb from (
select
decode(grouping(nm), 1, 'total', nm) as nm,
round(sum(val / 1024 / 1024), 2) as mb
from
(
select 'sga' nm, sum(value) val
from v$sga
union all
select 'pga', sum(a.value)
from v$sesstat a , v$statname b
where b.name = 'session pga memory'
and a.statistic# = b.statistic#
)
group by rollup(nm))
;

--------------------------------------------------------
--  DDL for View VIEW_OM_TEN_TOP_LARGE_TB
--------------------------------------------------------

CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "SYS"."VIEW_OM_TEN_TOP_LARGE_TB" ("VW_ID", "SEGMENT_NAME", "SEGMENT_TYPE", "MB", "GB", "TABLESPACE_NAME") AS 
select rownum as vw_id, SEGMENT_NAME, SEGMENT_TYPE, MB, GB ,TABLESPACE_NAME
from (
select segment_name, segment_type, round((bytes/1024/1024), 4) "MB", round((bytes/1024/1024/1024), 4) "GB", tablespace_name
from dba_segments
--where tablespace_name = 'USERS'
order by 3 desc
)
where rownum <= 10
;

-- Cria o usuário orclmetrics, concede permissão para acessar as view e cria public synonym
create user orclmetrics identified by orclmetrics quota unlimited on users;

grant connect, resource to orclmetrics;

GRANT SELECT ON "VIEW_OM_ACTIVE_TRANSACTION" TO orclmetrics;
GRANT SELECT ON "VIEW_OM_DATABASE_INFO" TO orclmetrics;
GRANT SELECT ON "VIEW_OM_DATAFILE_UTILIZ" TO orclmetrics;
GRANT SELECT ON "VIEW_OM_MEMORY_USED" TO orclmetrics;
GRANT SELECT ON "VIEW_OM_TEN_TOP_LARGE_TB" TO orclmetrics;

CREATE OR REPLACE NONEDITIONABLE PUBLIC SYNONYM "VW_OM_ACTIVE_TRANSACTION" FOR "SYS"."VIEW_OM_ACTIVE_TRANSACTION";
CREATE OR REPLACE NONEDITIONABLE PUBLIC SYNONYM "VW_OM_DATABASE_INFO" FOR "SYS"."VIEW_OM_DATABASE_INFO";
CREATE OR REPLACE NONEDITIONABLE PUBLIC SYNONYM "VW_OM_DATAFILE_UTILIZ" FOR "SYS"."VIEW_OM_DATAFILE_UTILIZ";
CREATE OR REPLACE NONEDITIONABLE PUBLIC SYNONYM "VW_OM_MEMORY_USED" FOR "SYS"."VIEW_OM_MEMORY_USED";
CREATE OR REPLACE NONEDITIONABLE PUBLIC SYNONYM "VW_OM_TEN_TOP_LARGE_TB" FOR "SYS"."VIEW_OM_TEN_TOP_LARGE_TB";