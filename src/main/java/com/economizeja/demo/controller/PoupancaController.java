package com.economizeja.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.economizeja.demo.dtos.PoupancaRequestDTO;
import com.economizeja.demo.dtos.PoupancaResponseDTO;

import com.economizeja.demo.service.PoupancaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("api/poupanca")
public class PoupancaController {
    @Autowired
    private PoupancaService poupancaService;

    @PostMapping()
    public ResponseEntity<PoupancaResponseDTO> criarPoupanca (@RequestBody PoupancaRequestDTO data, HttpServletRequest request) {
        return poupancaService.criarPoupanca(data, request);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarPoupanca(@PathVariable("id") long poupancaId, HttpServletRequest request) {
        return poupancaService.deletarPoupanca(poupancaId, request);
    }
}
