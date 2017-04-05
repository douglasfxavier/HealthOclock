package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 08/02/2017.
 */

public class Remedio {
    private Long id;
    private String nome;
    private String principioAtivo;
    private String laboratorio;
    private String classeTerapeutica;

    public Remedio() {
    }

    public Remedio(Long id, String nome, String principioAtivo, String laboratorio, String classeTerapeutica) {
        this.id = id;
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.laboratorio = laboratorio;
        this.classeTerapeutica = classeTerapeutica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }
}
