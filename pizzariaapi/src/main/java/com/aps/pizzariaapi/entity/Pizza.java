package com.aps.pizzariaapi.entity;

import com.aps.pizzariaapi.entity.enums.PizzaSize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
@Entity(name = "pizzas")
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.STRING)
    private PizzaSize size;

    @Column(name = "flavor", nullable = false)
    private String flavor;

    @Column(name = "basePrice", nullable = false)
    private BigDecimal basePrice;
}
