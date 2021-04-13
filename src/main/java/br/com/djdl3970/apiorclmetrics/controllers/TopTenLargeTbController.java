package br.com.djdl3970.apiorclmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djdl3970.apiorclmetrics.models.TopTenLargeTbModel;
import br.com.djdl3970.apiorclmetrics.repository.TopTenLargeTbRepository;


@RestController
@RequestMapping(value = "apiorclmetrics")
public class TopTenLargeTbController {
    
    @Autowired
    TopTenLargeTbRepository topTenLargeTbRepository;

    @GetMapping(value = "topten")
    public List<TopTenLargeTbModel> listTopTenLargeTb() {
        return topTenLargeTbRepository.findAll();
    }
    
}
