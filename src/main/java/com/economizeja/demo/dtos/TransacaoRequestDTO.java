package com.economizeja.demo.dtos;

import com.economizeja.demo.model.TransacaoTipo;
import com.economizeja.demo.model.TransacoesCategorias;

public record TransacaoRequestDTO(long poupancaId, TransacaoTipo tipo, TransacoesCategorias categoria, double valor) {
    
}
