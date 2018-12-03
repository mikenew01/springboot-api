package br.com.mk.gestaoeducacional.domain.models;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "TB_PESSOA")
@AttributeOverride(name = "id", column = @Column(name = "ID_PESSOA", unique = true, nullable = false))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa extends BaseEntity {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRE_NOME")
    private String sobreNome;

    @Column(name = "IDADE")
    private Integer idade;
}
