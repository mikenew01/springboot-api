package com.mk.mkspringboot.services;

import com.mk.mkspringboot.domain.models.pessoa.Pessoa;
import com.mk.mkspringboot.domain.repository.PessoaRepository;
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
