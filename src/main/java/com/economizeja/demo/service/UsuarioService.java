package com.economizeja.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.economizeja.demo.dtos.PoupancaGetDTO;
import com.economizeja.demo.model.Poupanca;
import com.economizeja.demo.model.Usuario;


import jakarta.servlet.http.HttpServletRequest;

@Service
public class UsuarioService {
    
    @Autowired
    private PoupancaService poupancaService;

    public ResponseEntity<List<PoupancaGetDTO>> getPoupanca(HttpServletRequest request) {
        Usuario user = poupancaService.converterToken(request);
        List <PoupancaGetDTO> listaDTO = new ArrayList<>();
        if (user!=null) {
            for (Poupanca p: user.getPoupancas()) {
                listaDTO.add(new PoupancaGetDTO(p.getSaldo(), p.getNome(), p.getId()));
            }
            return ResponseEntity.ok(listaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}
