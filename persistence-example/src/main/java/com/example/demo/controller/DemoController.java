package com.example.demo.controller;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

    private final DemoRepository demoRepository;


    @PostMapping("/save")
    public int save(@RequestBody Demo demo) {
        demoRepository.save(demo);
        return demo.getId();
    }


}
