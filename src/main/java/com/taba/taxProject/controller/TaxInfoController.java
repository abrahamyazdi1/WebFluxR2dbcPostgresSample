package com.taba.taxProject.controller;

import com.taba.taxProject.model.taxInfo;
import com.taba.taxProject.service.TaxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/apiTax")
public class TaxInfoController {
    @Autowired
    TaxInfoService txInfSrv;
    @GetMapping("/getAllTaxMethods")
    @ResponseStatus(HttpStatus.OK)
    public Flux<taxInfo> getAllTutorials() {
        return txInfSrv.findAll();
    }
    @PostMapping("/createtaxinfo")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<taxInfo> createtaxinfo(@RequestBody taxInfo txInf) {
        return txInfSrv.save(new taxInfo( txInf.getDescription(), txInf.isFuncStatus()));
    }
    @PostMapping("/updateTaxInfo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<taxInfo> updateTutorial(@PathVariable("id") int id, @RequestBody taxInfo taxinfo) {
        return txInfSrv.update(id, taxinfo);
    }
}
