package website.demo.controller;

import jakarta.validation.Valid;
import website.demo.dtos.AuthenticationDTO;
import website.demo.dtos.LoginResponseDTO;
import website.demo.dtos.RegisterDTO;
import website.demo.model.Usuario;
import website.demo.model.UsuarioRole;
import website.demo.repository.UsuarioRepository;
import website.demo.security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin("*")
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    

    @PostMapping("/register")
    public Usuario register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByUsername(data.username()) != null) {
            return new Usuario();
        }

        String eP = new BCryptPasswordEncoder().encode(data.password());

        Usuario usuario = new Usuario(data.username(), eP, data.fullName(), UsuarioRole.USER);
        repository.save(usuario);
        return usuario;

    }

}
