package br.com.djdl3970.apiorclmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djdl3970.apiorclmetrics.models.DBInfoModel;
import br.com.djdl3970.apiorclmetrics.repository.DBInfoRepository;

@RestController
@RequestMapping(value = "apiorclmetrics")
public class DBInfoController {

    @Autowired
    DBInfoRepository dbInfoRepository;

    @GetMapping(value="omdbinfo")
    public List<DBInfoModel> listDbInfo() {
        return dbInfoRepository.findAll();
    }
    
    
}
