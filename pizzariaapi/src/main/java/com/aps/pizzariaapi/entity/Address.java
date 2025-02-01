package com.aps.pizzariaapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 255)
    private String street;  // logradouro

    @Column(nullable = false, length = 20)
    private String number;  // número da residência

    @Column(nullable = false, length = 20)
    private String zipCode;  // CEP
<<<<<<< HEAD
=======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
>>>>>>> 57ffd5b4eb3138e3f9fc494cfe08cdf0ddfd8fdd
}
