package com.example.doug.healthoclock.controller;

/**
 * Created by Doug on 09/02/2017.
 */

public class ListViewItemCustomizado {
    private String nomeItem;
    private int imagemItem;

    public ListViewItemCustomizado(String nomeActivity, int imagemActivity) {
        this.nomeItem = nomeActivity;
        this.imagemItem = imagemActivity;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public int getImagemItem() {
        return imagemItem;
    }
}