package com.taba.taxProject.service;

import com.taba.taxProject.model.taxInfo;
import com.taba.taxProject.repository.taxInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TaxInfoService {
    @Autowired
    taxInfoRepository taxinfoRepository;
    public Flux<taxInfo> findAll() {
        return taxinfoRepository.findAll();
    }
    public Mono<taxInfo> save(taxInfo taxinfo) {
        return taxinfoRepository.save(taxinfo);
    }

    public Mono<taxInfo> update(int id, taxInfo taxinfo) {
        return taxinfoRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTaxInfo -> {
                    if (optionalTaxInfo.isPresent()) {
                        taxinfo.setId(id);
                        return taxinfoRepository.save(taxinfo);
                    }

                    return Mono.empty();
                });
    }
}
