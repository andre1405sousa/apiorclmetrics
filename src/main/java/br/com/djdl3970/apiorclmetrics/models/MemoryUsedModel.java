package br.com.djdl3970.apiorclmetrics.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "VW_OM_MEMORY_USED")
public class MemoryUsedModel {
    @Id
    private Integer vw_id;
    private String nm;
    private String mb;
    public Integer getVw_id() {
        return vw_id;
    }
    public void setVw_id(Integer vw_id) {
        this.vw_id = vw_id;
    }
    public String getNm() {
        return nm;
    }
    public void setNm(String nm) {
        this.nm = nm;
    }
    public String getMb() {
        return mb;
    }
    public void setMb(String mb) {
        this.mb = mb;
    }
}
