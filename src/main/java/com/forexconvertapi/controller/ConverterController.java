package com.forexconvertapi.controller;

import com.forexconvertapi.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/forex")
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/data")
    public Mono<String> getForexData() {
        return converterService.getForexData();
    }


}
