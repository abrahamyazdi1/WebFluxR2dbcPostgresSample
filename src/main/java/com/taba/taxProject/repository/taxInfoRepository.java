package com.taba.taxProject.repository;

import com.taba.taxProject.model.taxInfo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface taxInfoRepository extends R2dbcRepository<taxInfo, Integer> {
    Flux<taxInfo> findByDescriptionContaining(String description);

    Flux<taxInfo> findByFuncStatus(boolean funcStatus);
}
