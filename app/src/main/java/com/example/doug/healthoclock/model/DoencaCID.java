package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 07/02/2017.
 */

public class DoencaCID {
    private int id_cid;
    private String descricao;

    public DoencaCID() {
    }

    public DoencaCID(int id_cid, String descricao) {
        this.id_cid = id_cid;
        this.descricao = descricao;
    }

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}