package com.mk.mkspringboot.models;

public class Pessoa {

    private String nome;
    private String sobreNome;
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
