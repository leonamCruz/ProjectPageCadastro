package tech.leonam.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.leonam.service.PessoaServiceImplement;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/login")
public class LoginController {
    private final PessoaServiceImplement pessoaServiceImplement;
    public LoginController(PessoaServiceImplement pessoaServiceImplement) {
        this.pessoaServiceImplement = pessoaServiceImplement;
    }



}
