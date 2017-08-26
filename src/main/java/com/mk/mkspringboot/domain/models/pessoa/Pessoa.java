package com.mk.mkspringboot.domain.models.pessoa;

import com.mk.mkspringboot.domain.models.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
@AttributeOverride(name = "id", column = @Column(name = "COD_PESSOA"))
public class Pessoa extends BaseEntity{

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRE_NOME")
    private String sobreNome;

    @Column(name = "IDADE")
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobreNome, Integer idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
