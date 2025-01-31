package com.aps.pizzariaapi.entity;

import lombok.Getter;

@Getter
public enum UserRole {

    ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
