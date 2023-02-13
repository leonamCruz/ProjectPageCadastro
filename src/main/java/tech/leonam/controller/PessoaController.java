package controller;

import jakarta.validation.Valid;
import model.dto.PessoaDTO;
import model.entity.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import service.PessoaServiceImplement;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaServiceImplement pessoaServiceImplement;

    public PessoaController(PessoaServiceImplement pessoaServiceImplement) {
        this.pessoaServiceImplement = pessoaServiceImplement;
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody @Valid PessoaDTO pessoaDTO) {
        var pessoa = new Pessoa();
        var bCryptPasswordEncoder = new BCryptPasswordEncoder();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoa.setSenha(bCryptPasswordEncoder.encode(pessoaDTO.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaServiceImplement.save(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaServiceImplement.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Object> getById(@PathVariable(value = "uuid") UUID uuid) {
        var pessoaOptional = pessoaServiceImplement.findById(uuid);

        return pessoaOptional.<ResponseEntity<Object>>map(pessoa ->
                ResponseEntity.status(HttpStatus.OK).body(pessoa)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível localizar esse ID"));

    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Object> delete(@PathVariable(value = "uuid") UUID uuid) {
        var pessoaOptional = pessoaServiceImplement.findById(uuid);

        if (pessoaOptional.isPresent()) {
            pessoaServiceImplement.delete(uuid);
            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizei o ID, então não posso apagar");
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Object> put(@PathVariable(value = "uuid") UUID uuid, @RequestBody @Valid PessoaDTO pessoaDTO) {
        var pessoaOptional = pessoaServiceImplement.findById(uuid);

        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizei o Id, então não posso alterar");
        }
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoa.setUuid(pessoaOptional.get().getUuid());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaServiceImplement.save(pessoa));
    }
}

