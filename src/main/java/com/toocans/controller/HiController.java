package com.toocans.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class HiController {

    @PostMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "simbabdytech") String name) {
        return "hi " + name;
    }
}
