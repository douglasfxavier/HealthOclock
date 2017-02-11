package com.example.doug.healthoclock.model;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 08/02/2017.
 */

public class Lembrete {
    private int id;
    private Controle controle;
    private Calendar dataHora;
    private Boolean visto;
    private Boolean cumprido;

    public Lembrete( Controle controle, long dataHora, Boolean visto, Boolean cumprido) {
        this.controle = controle;
        this.dataHora = Calendar.getInstance();
        this.dataHora.setTimeInMillis(dataHora);
        this.visto = visto;
        this.cumprido = cumprido;
    }
    public Lembrete(Controle controle, int dia, int mes, int ano, int hora, int minutos, Boolean visto, Boolean cumprido) {
        this.controle = controle;
        this.dataHora = Calendar.getInstance();
        this.dataHora.set(dia,mes,ano,hora,minutos);
        this.visto = visto;
        this.cumprido = cumprido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean isVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public Boolean isCumprido() {
        return cumprido;
    }

    public void setCumprido(Boolean cumprido) {
        this.cumprido = cumprido;
    }
}
