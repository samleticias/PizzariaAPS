package com.aps.pizzariaapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 255)
    private String street;  // logradouro

    @Column(nullable = false, length = 50)
    private String neighborhood;  // bairro

    @Column(nullable = false, length = 20)
    private String number;  // número da residência

    @Column(nullable = false, length = 50)
    private String city;  // cidade

    @Column(nullable = false, length = 50)
    private String state;  // estado

    @Column(nullable = false, length = 20)
    private String zipCode;  // CEP

    @Column(nullable = false, length = 100)
    private String country;  // país
}
