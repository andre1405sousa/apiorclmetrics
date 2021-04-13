package br.com.djdl3970.apiorclmetrics.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VW_OM_TEN_TOP_LARGE_TB")

public class TopTenLargeTbModel {
    @Id
    public Integer vw_id;
    public String segment_name;
    public String segment_type;
    public String mb;
    public String gb;
    public String tablespace_name;
    public Integer getVw_id() {
        return vw_id;
    }
    public void setVw_id(Integer vw_id) {
        this.vw_id = vw_id;
    }
    public String getSegment_name() {
        return segment_name;
    }
    public void setSegment_name(String segment_name) {
        this.segment_name = segment_name;
    }
    public String getSegment_type() {
        return segment_type;
    }
    public void setSegment_type(String segment_type) {
        this.segment_type = segment_type;
    }
    public String getMb() {
        return mb;
    }
    public void setMb(String mb) {
        this.mb = mb;
    }
    public String getGb() {
        return gb;
    }
    public void setGb(String gb) {
        this.gb = gb;
    }
    public String getTablespace_name() {
        return tablespace_name;
    }
    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }
}
