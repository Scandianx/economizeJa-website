package com.economizeja.demo.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poupanca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    @JsonBackReference(value = "usuarioValue")
    private Usuario usuario;
    @Column(nullable=false)
    private double saldo;
    @Column(nullable=false)
    private String nome;
    @OneToMany(mappedBy="poupanca")
    @JsonManagedReference(value="poupancaValue")
    private List<Transacao> transacoes;
    public Poupanca(Usuario usuario, double saldo, String nome, List<Transacao> transacoes) {
        this.usuario = usuario;
        this.nome = nome;
        this.saldo = saldo;
        this.transacoes = transacoes;
    }
}
