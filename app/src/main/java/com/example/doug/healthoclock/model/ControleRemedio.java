package com.example.doug.healthoclock.model;

import java.util.Calendar;

/**
 * Created by Doug on 07/02/2017.
 */

public class ControleRemedio extends Controle{
    private Remedio remedio;
    private Calendar dataInicialUso;

    public ControleRemedio(Paciente paciente, long dataInicio, long dataFim, int repeticao, Remedio remedio, Calendar dataInicialUso) {
        super(paciente, dataInicio, dataFim, repeticao);
        this.remedio = remedio;
        this.dataInicialUso = dataInicialUso;
    }

    public ControleRemedio(Paciente paciente, int diaInicio, int mesInicio, int anoInicio, int diaFim, int mesFim, int anoFim, int repeticao, Remedio remedio, Calendar dataInicialUso) {
        super(paciente, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim, repeticao);
        this.remedio = remedio;
        this.dataInicialUso = dataInicialUso;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    public Calendar getDataInicialUso() {
        return dataInicialUso;
    }

    public void setDataInicialUso(Calendar dataInicialUso) {
        this.dataInicialUso = dataInicialUso;
    }

    public  String getDataInicalUsoString(){
        return String.format("%d/%d/%d",this.dataInicialUso.get(Calendar.DAY_OF_MONTH),
                this.dataInicialUso.get(Calendar.MONTH) +1,
                this.dataInicialUso.get(Calendar.YEAR));
    }
}
