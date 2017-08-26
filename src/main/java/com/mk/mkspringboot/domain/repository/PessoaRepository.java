package com.mk.mkspringboot.domain.repository;

import com.mk.mkspringboot.domain.models.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
