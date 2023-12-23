package com.example.demo;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private DemoRepository demoRepository;

    @Test
    void save() {
        Demo demo = new Demo();
        demo.setName("demo");
        demoRepository.save(demo);
        System.out.println(demo.getId());
    }


    @Test
    void get() {
        Demo demo =  demoRepository.get(1);
        log.info("demo: {}", demo);
    }




}
