package br.com.mk.gestaoeducacional.domain.repository;

import br.com.mk.gestaoeducacional.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
