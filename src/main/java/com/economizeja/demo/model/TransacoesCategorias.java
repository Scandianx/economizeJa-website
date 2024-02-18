package com.economizeja.demo.model;

public enum TransacoesCategorias {
    ALIMENTACAO("Alimentação"),
    MORADIA("Moradia"),
    TRANSPORTE("Transporte"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    LAZER("Lazer e Entretenimento"),
    VESTUARIO("Vestuário e Beleza"),
    DIVIDAS("Dívidas e Empréstimos"),
    INVESTIMENTOS("Investimentos"),
    IMPOSTOS("Impostos e Taxas"),

    SALARIO("Salário"),
    BONUS("Bônus"),
    RENDIMENTOS("Rendimentos"),
    REEMBOLSO("Reembolso"),
    OUTROS("Outros");

    private final String descricao;

    TransacoesCategorias(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

