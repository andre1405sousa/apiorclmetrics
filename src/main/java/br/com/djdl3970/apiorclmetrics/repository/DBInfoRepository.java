package br.com.djdl3970.apiorclmetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djdl3970.apiorclmetrics.models.DBInfoModel;

public interface DBInfoRepository extends JpaRepository<DBInfoModel, Long> {
    
}
