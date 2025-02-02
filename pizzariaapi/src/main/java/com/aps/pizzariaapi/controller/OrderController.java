package com.aps.pizzariaapi.controller;

import com.aps.pizzariaapi.dto.OrderRequestDTO;
import com.aps.pizzariaapi.dto.OrderResponseDTO;
import com.aps.pizzariaapi.entity.Order;
import com.aps.pizzariaapi.entity.enums.OrderStatus;
import com.aps.pizzariaapi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        List<OrderResponseDTO> orderList = this.orderService.findAllOrders();
        return ResponseEntity.ok().body(orderList);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long orderId) {
        this.orderService.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long orderId, @RequestBody Map<String, String> statusUpdate) {
        orderService.updateStatus(orderId, OrderStatus.valueOf(statusUpdate.get("status")));
        return ResponseEntity.ok().build();
    }
}
