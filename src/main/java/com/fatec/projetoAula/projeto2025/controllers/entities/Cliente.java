package com.fatec.projetoAula.projeto2025.controllers.entities;

public class Cliente {
    private Integer id ;
    private String nome;
    private Integer idade;

    

    public Cliente() {

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
}
