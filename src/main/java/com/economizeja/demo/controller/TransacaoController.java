package com.economizeja.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economizeja.demo.dtos.TransacaoRequestDTO;
import com.economizeja.demo.dtos.TransacaoResponseDTO;

import com.economizeja.demo.service.TransacaoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("api/poupanca/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> novaTransacao (@RequestBody TransacaoRequestDTO data) {
        return transacaoService.novaTransacao(data);
    }
}
