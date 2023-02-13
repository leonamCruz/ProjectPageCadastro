package service;

import jakarta.transaction.Transactional;
import model.entity.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaServiceInterface {
    @Transactional
    Pessoa save(Pessoa pessoa);
    @Transactional
    void delete(UUID uuid);
    List<Pessoa> findAll();
    Optional<Pessoa> findById(UUID uuid);

}
