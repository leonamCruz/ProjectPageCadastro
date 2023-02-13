package tech.leonam.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.leonam.model.entity.Pessoa;
import tech.leonam.repository.PessoaRepository;

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
}
