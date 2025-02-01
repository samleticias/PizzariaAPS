package com.aps.pizzariaapi.dto;

public record ClientResponseDTO(
        String username,
        String phone,
        AddressDTO address
) {
}
