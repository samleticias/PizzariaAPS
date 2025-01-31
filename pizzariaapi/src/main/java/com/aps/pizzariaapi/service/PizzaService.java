package com.aps.pizzariaapi.service;

import com.aps.pizzariaapi.dto.PizzaDTO;
import com.aps.pizzariaapi.entity.Pizza;
import com.aps.pizzariaapi.entity.enums.PizzaSize;
import com.aps.pizzariaapi.repository.PizzaRepository;
import com.aps.pizzariaapi.service.exception.PizzaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    public void savePizza(Pizza pizza) {
        this.pizzaRepository.save(pizza);
    }

    public Pizza getPizzaById(Long id) throws PizzaNotFoundException {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException(("Pizza not found with id: " + id)));
    }

    public Pizza createPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDTO.name());
        pizza.setSize(PizzaSize.valueOf(pizzaDTO.size()));
        pizza.setFlavor(pizzaDTO.flavor());
        pizza.setBasePrice(pizzaDTO.basePrice());

        this.savePizza(pizza);
        return pizza;
    }

    public void deletePizza(Long id) throws PizzaNotFoundException {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (pizza.isEmpty()) throw new PizzaNotFoundException("Pizza not found with id: " + id);
        pizzaRepository.delete(pizza.get());
    }

    public Pizza updatePizza(Long id, PizzaDTO pizzaDTO) throws PizzaNotFoundException {
        Pizza pizza = this.getPizzaById(id);
        pizza.setName(pizzaDTO.name());
        pizza.setSize(PizzaSize.valueOf(pizzaDTO.size()));
        pizza.setFlavor(pizzaDTO.flavor());
        pizza.setBasePrice(pizzaDTO.basePrice());

        this.savePizza(pizza);
        return pizza;
    }
}
