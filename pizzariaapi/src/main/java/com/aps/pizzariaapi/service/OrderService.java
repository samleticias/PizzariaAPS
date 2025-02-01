package com.aps.pizzariaapi.service;

import com.aps.pizzariaapi.dto.OrderDTO;
import com.aps.pizzariaapi.dto.OrderItemDTO;
import com.aps.pizzariaapi.dto.OrderItemResponseDTO;
import com.aps.pizzariaapi.dto.OrderResponseDTO;
import com.aps.pizzariaapi.entity.*;
import com.aps.pizzariaapi.entity.enums.OrderStatus;
import com.aps.pizzariaapi.repository.OrderRepository;
import com.aps.pizzariaapi.service.exception.OrderNotFound;
import com.aps.pizzariaapi.service.exception.PizzaNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private AddressService addressService;
    private ClientService clientService;
    private PizzaService pizzaService;

    public OrderService(OrderRepository orderRepository, AddressService addressService, ClientService clientService, PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.addressService = addressService;
        this.clientService = clientService;
        this.pizzaService = pizzaService;
    }

    @Transactional
    public Order createOrder(OrderDTO request) throws PizzaNotFoundException {
        // Criar endereço do cliente
        Address address = new Address();
        address.setStreet(request.client().address().street());
        address.setNumber(request.client().address().number());
        address.setZipCode(request.client().address().zipCode());
        address = addressService.createAddress(address);

        // Criar cliente
        Client client = new Client();
        client.setUsername(request.client().username());
        client.setPhone(request.client().phone());
        client.setAddress(address);
        client = clientService.createClient(client);

        // Criar pedido
        Order order = new Order();
        order.setClient(client);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.PREPARING);

        // Criar itens do pedido
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO itemRequest : request.orderItems()) {
            Pizza pizza = pizzaService.getPizzaById(itemRequest.pizzaId());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPizza(pizza);
            orderItem.setQuantity(itemRequest.quantity());
            orderItem.setUnitPrice(pizza.getBasePrice());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }

    @Transactional
    public List<OrderResponseDTO> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> {
            List<OrderItemResponseDTO> items = order.getOrderItems().stream().map(item -> {
                OrderItemResponseDTO itemResponse = new OrderItemResponseDTO(item.getPizza().getName(), item.getQuantity());
                return itemResponse;
            }).toList();

            OrderResponseDTO response = new OrderResponseDTO(order.getId(),
                    order.getCreatedAt(),
                    order.getStatus().name(),
                    order.getClient().getUsername(), items);

            return response;
        }).toList();
    }

    public Order findById(Long id) throws OrderNotFound {
        Optional<Order> optionalOrder = this.orderRepository.findById(id);
        return optionalOrder.orElseThrow(() -> new OrderNotFound("Order not found"));
    }

    @Transactional
    public void deleteById(Long id) throws OrderNotFound {
        this.findById(id);
        this.orderRepository.deleteById(id);
    }
}
