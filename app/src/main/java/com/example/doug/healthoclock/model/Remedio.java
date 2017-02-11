package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 08/02/2017.
 */

public class Remedio {
    private int id;
    private String nome;

    public Remedio() {
    }

    public Remedio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
