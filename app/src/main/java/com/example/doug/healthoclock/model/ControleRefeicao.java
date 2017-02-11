package com.example.doug.healthoclock.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 08/02/2017.
 */

public class ControleRefeicao extends Controle{
    private String prato;
    private String tipoRefeicao;
    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public ControleRefeicao() {
    }

    public ControleRefeicao(Paciente paciente, int dia, int mes, int ano,
                            String prato, String tipoRefeicao) {
        super(paciente, dia, mes, ano);
        this.prato = prato;
        this.tipoRefeicao = tipoRefeicao;
    }

    public ControleRefeicao(Paciente paciente, long dataInicio, String prato, String tipoRefeicao) {
        super(paciente, dataInicio);
        this.prato = prato;
        this.tipoRefeicao = tipoRefeicao;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

}
