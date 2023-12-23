package com.example.demo.repository;

import com.codingapi.persistence.schema.OperationalDataStore;
import com.example.demo.domain.Demo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class DemoRepository {

    private final OperationalDataStore operationalDataStore;

    public void save(Demo demo) {
        log.info("DemoRepository.save:{}", demo);
        operationalDataStore.save(demo);
    }

    public Demo get(int id) {
        log.info("DemoRepository.get:{}", id);
        return operationalDataStore.get(Demo.class, id);
    }

}
