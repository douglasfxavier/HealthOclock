package com.example.doug.healthoclock.model;

import java.util.Calendar;

/**
 * Created by Doug on 07/02/2017.
 */

public class ControleRemedio extends Controle{
    private Remedio remedio;
    private String dosagem;
    private String formaUso;
    private String tarja;

    public ControleRemedio(Paciente paciente, Remedio remedio, long dataInicio, long dataFim,
                           String dosagem, String formaUso, String tarja) {
        super(paciente, dataInicio, dataFim);
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.formaUso = formaUso;
        this.tarja = tarja;
    }

    public ControleRemedio(int id, Paciente paciente, Remedio remedio, long dataInicio, long dataFim,
                           String dosagem, String formaUso, String tarja) {
        super(id,paciente, dataInicio, dataFim);
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.formaUso = formaUso;
        this.tarja = tarja;
    }


    public ControleRemedio(Paciente paciente, int diaInicio, int mesInicio, int anoInicio,
                                int diaFim, int mesFim, int anoFim,
                                Remedio remedio, Calendar dataInicialUso, String dosagem, String formaUso, String tarja) {
        super(paciente, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim);
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.formaUso = formaUso;
        this.tarja = tarja;
    }

    public ControleRemedio(int id, Paciente paciente, int diaInicio, int mesInicio, int anoInicio,
                           int diaFim, int mesFim, int anoFim,
                           Remedio remedio, Calendar dataInicialUso, String dosagem, String formaUso, String tarja) {
        super(id,paciente, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim);
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.formaUso = formaUso;
        this.tarja = tarja;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFormaUso() {
        return formaUso;
    }

    public void setFormaUso(String formaUso) {
        this.formaUso = formaUso;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }
}


