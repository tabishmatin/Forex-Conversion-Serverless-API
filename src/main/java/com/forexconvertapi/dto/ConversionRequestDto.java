package com.forexconvertapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequestDto {

    String sourceCurrency;
    String targetCurrency;
    Float sourceAmount;
}
