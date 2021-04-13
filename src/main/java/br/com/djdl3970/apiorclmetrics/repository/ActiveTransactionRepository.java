package br.com.djdl3970.apiorclmetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djdl3970.apiorclmetrics.models.ActiveTransactionModel;

public interface ActiveTransactionRepository extends JpaRepository<ActiveTransactionModel, Integer>{
    
}
