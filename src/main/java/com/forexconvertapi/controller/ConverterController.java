package com.forexconvertapi.controller;

import com.forexconvertapi.dto.ConversionRequestDto;
import com.forexconvertapi.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/convert/{currency}/amt/{amount}/target/{target-currency}")
    public Mono<Double> convert(@PathVariable("currency") String sourceCurrency,
                                @PathVariable("amount") Double sourceAmount,
                                @PathVariable("target-currency") String targetCurrency) {

        return converterService.convert(ConversionRequestDto.builder()
                .sourceCurrency(sourceCurrency)
                .sourceAmount(sourceAmount)
                .targetCurrency(targetCurrency)
                .build());
    }
}
