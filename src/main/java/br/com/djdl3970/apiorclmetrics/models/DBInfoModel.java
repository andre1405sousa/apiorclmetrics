package br.com.djdl3970.apiorclmetrics.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "vw_om_database_info")
public class DBInfoModel {

    @Id
    @Column(name = "dbinfo_id")
    private Long id;

    @Column(name = "dbinfo_key")
    private String chave;

    @Column(name = "dbinfo_value")
    private String chaveValor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getChaveValor() {
        return chaveValor;
    }

    public void setChaveValor(String chaveValor) {
        this.chaveValor = chaveValor;
    }
    
}
