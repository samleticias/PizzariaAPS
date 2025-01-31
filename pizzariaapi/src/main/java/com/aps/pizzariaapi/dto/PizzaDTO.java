package com.aps.pizzariaapi.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PizzaDTO(
        @NotBlank
        String name,

        @NotBlank
        String size,

        @NotBlank
        String flavor,

        @NotBlank
        BigDecimal basePrice
) {
}
