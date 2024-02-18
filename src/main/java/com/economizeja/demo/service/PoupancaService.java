package com.economizeja.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.economizeja.demo.dtos.PoupancaRequestDTO;
import com.economizeja.demo.dtos.PoupancaResponseDTO;
import com.economizeja.demo.model.Poupanca;
import com.economizeja.demo.model.Transacao;
import com.economizeja.demo.model.Usuario;
import com.economizeja.demo.repository.PoupancaRepository;
import com.economizeja.demo.repository.UsuarioRepository;
import com.economizeja.demo.security.TokenService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class PoupancaService {
    @Autowired
    private PoupancaRepository poupancaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    public ResponseEntity<PoupancaResponseDTO> criarPoupanca(PoupancaRequestDTO data, HttpServletRequest request) {

        if (request != null) {

            Usuario usuario = converterToken(request);
            List<Transacao> transacoes = new ArrayList<>();
            Poupanca poupanca = new Poupanca(usuario, data.saldo(), data.nome(), transacoes);
            List<Poupanca> transacoesUsuario = usuario.getPoupancas();
            transacoesUsuario.add(poupanca);
            usuarioRepository.save(usuario);
            poupancaRepository.save(poupanca);
            return ResponseEntity.ok(new PoupancaResponseDTO());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    public ResponseEntity<Boolean> deletarPoupanca(long poupancaId, HttpServletRequest request) {

        if (poupancaRepository.existsById(poupancaId)) {
            Poupanca poupanca = poupancaRepository.findById(poupancaId).get();
            Usuario usuario = poupanca.getUsuario();
            if (usuario.getId() != converterToken(request).getId()) {
                return ResponseEntity.ok(false);
            }
            usuario.getPoupancas().remove(poupanca);
            usuarioRepository.save(usuario);
            poupancaRepository.deleteById(poupancaId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);

    }

    private Usuario converterToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        var username = tokenService.validateToken(token);
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(username);
       
        return usuario;

    }
}
