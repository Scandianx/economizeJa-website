package com.economizeja.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransacaoTipo {
    DEPOSITO("deposito"),
    SAQUE("saque");

    private String tipo;

    public String getRole() {
        return tipo;
    }
}
