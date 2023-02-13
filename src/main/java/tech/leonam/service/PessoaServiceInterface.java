package tech.leonam.service;

import jakarta.transaction.Transactional;
import tech.leonam.model.entity.Pessoa;

public interface PessoaServiceInterface {
    @Transactional
    Pessoa save(Pessoa pessoa);
}
