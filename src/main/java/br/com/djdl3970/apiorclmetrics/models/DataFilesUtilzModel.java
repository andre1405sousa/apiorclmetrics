package br.com.djdl3970.apiorclmetrics.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "VW_OM_DATAFILE_UTILIZ")
public class DataFilesUtilzModel {

    @Id
    private Integer vw_id;
    private String file_name;
    private String allocated_mb;
    private String used_mb;
    private String free_space_mb;
    public Integer getVw_id() {
        return vw_id;
    }
    public void setVw_id(Integer vw_id) {
        this.vw_id = vw_id;
    }
    public String getFile_name() {
        return file_name;
    }
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
    public String getAllocated_mb() {
        return allocated_mb;
    }
    public void setAllocated_mb(String allocated_mb) {
        this.allocated_mb = allocated_mb;
    }
    public String getUsed_mb() {
        return used_mb;
    }
    public void setUsed_mb(String used_mb) {
        this.used_mb = used_mb;
    }
    public String getFree_space_mb() {
        return free_space_mb;
    }
    public void setFree_space_mb(String free_space_mb) {
        this.free_space_mb = free_space_mb;
    }
    
}
