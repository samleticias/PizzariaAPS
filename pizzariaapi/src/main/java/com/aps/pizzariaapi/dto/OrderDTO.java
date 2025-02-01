package com.aps.pizzariaapi.dto;

import java.util.List;

public record OrderDTO(
        ClientDTO client,
        List<OrderItemDTO> orderItems
) {
}
