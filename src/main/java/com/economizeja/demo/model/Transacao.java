package com.economizeja.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    private TransacaoTipo tipo;
    @Column(nullable = false)
    private TransacoesCategorias categoria;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private Date data;
    public Transacao(TransacaoTipo tipo, double valor, Poupanca poupanca, TransacoesCategorias categoria) {
        this.tipo = tipo;
        this.valor = valor;
        this.poupanca = poupanca;
        this.data = new Date();
        this.categoria= categoria;
    }
    @ManyToOne
    @JsonBackReference(value = "poupancaValue")
    private Poupanca poupanca;

}
