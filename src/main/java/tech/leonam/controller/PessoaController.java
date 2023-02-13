package tech.leonam.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tech.leonam.model.dto.PessoaDTO;
import tech.leonam.model.entity.Pessoa;
import tech.leonam.service.PessoaServiceImplement;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaServiceImplement pessoaServiceImplement;

    public PessoaController(PessoaServiceImplement pessoaServiceImplement) {
        this.pessoaServiceImplement = pessoaServiceImplement;
    }

    @PostMapping()
    public ResponseEntity<Object> post(@RequestBody @Valid PessoaDTO pessoaDTO) {
        var pessoa = new Pessoa();
        var bCryptPasswordEncoder = new BCryptPasswordEncoder();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoa.setSenha(bCryptPasswordEncoder.encode(pessoaDTO.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaServiceImplement.save(pessoa));
    }
}
