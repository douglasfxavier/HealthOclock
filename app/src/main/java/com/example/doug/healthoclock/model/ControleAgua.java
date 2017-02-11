package com.example.doug.healthoclock.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 08/02/2017.
 */

public class ControleAgua extends Controle{
    private int coposDagua;
    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public ControleAgua(Paciente paciente, long dataInicio, long dataFim, int repeticao,
                        int coposDagua, List<Lembrete> lembretes) {
        super(paciente, dataInicio, dataFim, repeticao);
        this.coposDagua = coposDagua;
        this.lembretes = lembretes;
    }

    public ControleAgua(Paciente paciente, int diaInicio, int mesInicio, int anoInicio,
                        int diaFim, int mesFim, int anoFim, int repeticao, int coposDagua, List<Lembrete> lembretes) {
        super(paciente, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim, repeticao);
        this.coposDagua = coposDagua;
        this.lembretes = lembretes;
    }

    public int getCoposDagua() {
        return coposDagua;
    }

    public void setCoposDagua(int coposDagua) {
        this.coposDagua = coposDagua;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }
}
