package com.mk.mkspringboot.domain.models.pessoa;

import com.mk.mkspringboot.domain.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PESSOA")
@AttributeOverride(name = "id", column = @Column(name = "COD_PESSOA"))
@Getter
@Setter
public class Pessoa extends BaseEntity{

    @Column(name = "NOME")
    @Size(min = 1, max = 60)
    private String nome;

    @Column(name = "SOBRE_NOME")
    @Size(min = 1, max = 60)
    private String sobreNome;

    @Column(name = "IDADE")
    @Size(max = 200)
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobreNome, Integer idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }
}
