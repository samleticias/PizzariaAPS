package com.aps.pizzariaapi.controller;

import com.aps.pizzariaapi.dto.PizzaDTO;
import com.aps.pizzariaapi.entity.Pizza;
import com.aps.pizzariaapi.service.PizzaService;
import com.aps.pizzariaapi.service.exception.PizzaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas(){
        return new ResponseEntity<>(pizzaService.getAllPizzas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) throws PizzaNotFoundException {
        return new ResponseEntity<>(pizzaService.getPizzaById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody PizzaDTO pizzaDTO) {
        return new ResponseEntity<>(pizzaService.createPizza(pizzaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePizza(@PathVariable Long id) throws PizzaNotFoundException {
        pizzaService.deletePizza(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody PizzaDTO pizzaDTO) throws PizzaNotFoundException {
        Pizza pizza = pizzaService.updatePizza(id, pizzaDTO);
        return ResponseEntity.ok(pizza);
    }
}
