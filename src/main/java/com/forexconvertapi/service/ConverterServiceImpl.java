package com.forexconvertapi.service;

import com.forexconvertapi.dto.ConversionRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConverterServiceImpl implements ConverterService {

    @Value("${exchangeapi.access-key}")
    private String accessKey;

    @Override
    public Mono<Float> convert(ConversionRequestDto dto) {
        /*
        To add conversion logic here
         */

        return Mono.just(0f);
    }

    @Override
    public Mono<String> getForexData() {
        /*
        Returns real-time forex data from external API
         */

        return WebClient
//                .create("https://api.frankfurter.app/latest")
                .create("http://api.exchangeratesapi.io/v1/latest?access_key=" + accessKey)
                .get()
                .retrieve()
                .bodyToMono(String.class);
    }
}
