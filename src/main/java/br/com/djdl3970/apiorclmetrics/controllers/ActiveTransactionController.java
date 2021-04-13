package br.com.djdl3970.apiorclmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djdl3970.apiorclmetrics.models.ActiveTransactionModel;
import br.com.djdl3970.apiorclmetrics.repository.ActiveTransactionRepository;


@RestController
@RequestMapping(value = "apiorclmetrics")
public class ActiveTransactionController {
    
    @Autowired
    ActiveTransactionRepository activeTransactionRepository;

    @GetMapping(value="activetransaction")
    public List<ActiveTransactionModel> listActiveTransaction() {
        return activeTransactionRepository.findAll();
    }
    

}
