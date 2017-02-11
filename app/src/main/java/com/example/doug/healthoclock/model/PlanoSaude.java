package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 07/02/2017.
 */

public class PlanoSaude{
    private int Id;
    private String nome;

    public PlanoSaude() {
    }

    public PlanoSaude(String nome, int id) {
        this.nome = nome;
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}