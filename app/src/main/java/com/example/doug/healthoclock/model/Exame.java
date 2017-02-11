package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 08/02/2017.
 */

public class Exame {
    private int idAns;
    private String descricao;

    public Exame() {
    }

    public Exame(int idAns, String descricao) {
        this.idAns = idAns;
        this.descricao = descricao;
    }

    public int getIdAns() {
        return idAns;
    }

    public void setIdAns(int idAns) {
        this.idAns = idAns;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
