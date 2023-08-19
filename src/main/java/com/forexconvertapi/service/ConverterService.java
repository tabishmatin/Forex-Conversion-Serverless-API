package com.forexconvertapi.service;

import com.forexconvertapi.dto.ConversionRequestDto;
import reactor.core.publisher.Mono;

public interface ConverterService {

    Mono<Double> convert(ConversionRequestDto dto);
    Mono<String> getForexData();
}
