package website.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import website.demo.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("poupanca")
public class UsuarioController {
    @SuppressWarnings("unused")
    @Autowired
    private UsuarioRepository repository;
    
    
}
