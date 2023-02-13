package service;

import jakarta.transaction.Transactional;
import model.entity.Pessoa;
import org.springframework.stereotype.Service;
import repository.PessoaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaServiceImplement implements PessoaServiceInterface{
    private final PessoaRepository pessoaRepository;
    public PessoaServiceImplement(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    @Transactional
    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    @Transactional
    @Override
    public void delete(UUID uuid) {
        pessoaRepository.deleteById(uuid);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> findById(UUID uuid) {
        return pessoaRepository.findById(uuid);
    }
}
