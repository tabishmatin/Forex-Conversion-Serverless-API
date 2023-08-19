package com.forexconvertapi.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversionRequestDto {

    String sourceCurrency;
    String targetCurrency;
    Double sourceAmount;
}
