package com.aps.pizzariaapi.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterDTO(
        @NotBlank
        String username,

        @NotBlank
        String password
) {
}
