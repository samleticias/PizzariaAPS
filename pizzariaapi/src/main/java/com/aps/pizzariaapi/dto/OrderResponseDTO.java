package com.aps.pizzariaapi.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long id,
        LocalDateTime createdAt,
        String status,
        String clientName,
        List<OrderItemResponseDTO> items
) {
}
