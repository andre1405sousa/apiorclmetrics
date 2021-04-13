package br.com.djdl3970.apiorclmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djdl3970.apiorclmetrics.models.DataFilesUtilzModel;
import br.com.djdl3970.apiorclmetrics.repository.DataFilesUtilzRepository;

@RestController
@RequestMapping(value = "apiorclmetrics")
public class DataFileUtilzController {

    @Autowired
    DataFilesUtilzRepository dataFileUtilzRepository;

    @GetMapping(value = "datafilesutilz")
    public List<DataFilesUtilzModel> listDataFilesUtilz () {
        return dataFileUtilzRepository.findAll();
    }
}
