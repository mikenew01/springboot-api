package br.com.mk.gestaoeducacional.repository;

import br.com.mk.gestaoeducacional.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
