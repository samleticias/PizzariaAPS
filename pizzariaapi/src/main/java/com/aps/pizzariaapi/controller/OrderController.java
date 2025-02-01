package com.aps.pizzariaapi.controller;

import com.aps.pizzariaapi.dto.OrderDTO;
import com.aps.pizzariaapi.dto.OrderResponseDTO;
import com.aps.pizzariaapi.entity.Order;
import com.aps.pizzariaapi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        List<OrderResponseDTO> orderList = this.orderService.findAllOrders();
        return ResponseEntity.ok().body(orderList);
    }
}
