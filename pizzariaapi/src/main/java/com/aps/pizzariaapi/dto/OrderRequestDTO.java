package com.aps.pizzariaapi.dto;

import java.util.List;

public record OrderRequestDTO(
        ClientResponseDTO client,
        List<OrderItemDTO> orderItems
) {
}
