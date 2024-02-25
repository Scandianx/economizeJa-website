package com.economizeja.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economizeja.demo.dtos.PoupancaGetDTO;

import com.economizeja.demo.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin("*")
@RequestMapping("usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    
    
    @GetMapping
    public ResponseEntity<List<PoupancaGetDTO>> getPoupanca(HttpServletRequest request) {
        return usuarioService.getPoupanca(request);
    }
    
}
