package br.com.djdl3970.apiorclmetrics.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "vw_om_active_transaction")
public class ActiveTransactionModel {
    @Id
    private Integer vw_id;
    private String username;
    private String start_time;
    private String name;
    private String used_ublk;
    private String status;
    public Integer getVw_id() {
        return vw_id;
    }
    public void setVw_id(Integer vw_id) {
        this.vw_id = vw_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsed_ublk() {
        return used_ublk;
    }
    public void setUsed_ublk(String used_ublk) {
        this.used_ublk = used_ublk;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
