package com.aps.pizzariaapi.dto;

public record ClientDTO(
        String username,
        String phone,
        AddressDTO address
) {
}
