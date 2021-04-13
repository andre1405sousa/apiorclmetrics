package br.com.djdl3970.apiorclmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djdl3970.apiorclmetrics.models.MemoryUsedModel;
import br.com.djdl3970.apiorclmetrics.repository.MemoryUsedRepository;

@RestController
@RequestMapping(value = "apiorclmetrics")
public class MemoryUsedController {
    
    @Autowired
    MemoryUsedRepository memoryUsedRepository;

    @GetMapping(value="memoryused")
    public List<MemoryUsedModel> listMemoryUsed() {
        return memoryUsedRepository.findAll();
    }
    
}
