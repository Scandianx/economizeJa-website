package com.economizeja.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.economizeja.demo.dtos.TransacaoRequestDTO;
import com.economizeja.demo.dtos.TransacaoResponseDTO;
import com.economizeja.demo.model.Poupanca;
import com.economizeja.demo.model.Transacao;
import com.economizeja.demo.model.TransacaoTipo;
import com.economizeja.demo.repository.PoupancaRepository;
import com.economizeja.demo.repository.TransacaoRepository;


@Service
public class TransacaoService {
    @Autowired
    private PoupancaRepository poupancaRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    public ResponseEntity<TransacaoResponseDTO> novaTransacao (TransacaoRequestDTO data) {
      Poupanca poupanca= poupancaRepository.findById(data.poupancaId()).get();
      if (data.tipo()==TransacaoTipo.DEPOSITO) {
        poupanca.setSaldo(poupanca.getSaldo() + data.valor());
      }
      else {
        poupanca.setSaldo(poupanca.getSaldo() - data.valor());
      }
      Transacao transacao= new Transacao(data.tipo(), data.valor(), poupanca, data.categoria());
      poupanca.getTransacoes().add(transacao);
      poupancaRepository.save(poupanca);
      transacaoRepository.save(transacao);
      return ResponseEntity.ok(new TransacaoResponseDTO());
    }
    
}
