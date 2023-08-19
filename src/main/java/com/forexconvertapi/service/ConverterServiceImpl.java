package com.forexconvertapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public Mono<Double> convert(ConversionRequestDto dto) {
        /*
        Conversion logic here
         */
        return getForexData().flatMap(rates -> {

            double targetAmount = 0;
            try {
                JsonNode jsonNode = new ObjectMapper().readTree(rates).get("rates");
                double sourceRate = jsonNode.get(dto.getSourceCurrency().toUpperCase()).asDouble();
                double baseEquivalent = (1 / sourceRate) * dto.getSourceAmount();
                double targetRate = jsonNode.get(dto.getTargetCurrency().toUpperCase()).asDouble();
                targetAmount = targetRate * baseEquivalent;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return Mono.just(targetAmount);
        });
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
