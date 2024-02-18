package com.economizeja.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UsuarioRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    public String getRole() {
        return role;
    }

}
