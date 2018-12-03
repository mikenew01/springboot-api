package br.com.mk.gestaoeducacional.services;

import br.com.mk.gestaoeducacional.domain.repository.PessoaRepository;
import br.com.mk.gestaoeducacional.domain.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PessoaService implements Serializable{

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
