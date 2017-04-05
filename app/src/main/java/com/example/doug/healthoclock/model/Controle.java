package com.example.doug.healthoclock.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 08/02/2017.
 */

public abstract class Controle {
    private int id;
    private Paciente paciente;
    private Calendar dataInicio;
    private Calendar dataFim;
    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public Controle() {
    }

    public Controle(Paciente paciente, long dataInicio, long dataFim) {
        this.paciente = paciente;
        this.dataInicio = Calendar.getInstance();
        this.dataInicio.setTimeInMillis(dataInicio);
        this.dataFim = Calendar.getInstance();
        this.dataFim.setTimeInMillis(dataFim);
    }

    public Controle(Paciente paciente, int diaInicio, int mesInicio,  int anoInicio,
                    int diaFim, int mesFim, int anoFim) {
        this.paciente = paciente;
        this.dataInicio = Calendar.getInstance();
        this.dataInicio.set(diaInicio,mesInicio,anoInicio);
        this.dataFim = Calendar.getInstance();
        this.dataFim.set(anoFim,mesFim,diaFim);
    }

    //Construtor usado para as instâncias de exames
    public Controle(Paciente paciente, int dia, int mes, int ano) {
        this.paciente = paciente;
        this.dataInicio = Calendar.getInstance();
        this.dataInicio.set(ano,mes,dia);
    }

    //Construtor usado para as instâncias de exames
    public Controle(Paciente paciente, long dataInicio) {
        this.paciente = paciente;
        this.dataInicio = Calendar.getInstance();
        this.dataInicio.setTimeInMillis(dataInicio);
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public  String getDataInicioString(){
        return String.format("%d/%d/%d",this.dataInicio.get(Calendar.DAY_OF_MONTH),
                this.dataInicio.get(Calendar.MONTH) +1,
                this.dataInicio.get(Calendar.YEAR));
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public  String getDataFimString(){
        return String.format("%d/%d/%d",this.dataFim.get(Calendar.DAY_OF_MONTH),
                this.dataFim.get(Calendar.MONTH) +1,
                this.dataFim.get(Calendar.YEAR));
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public void addLembrete (Lembrete l){
        this.lembretes.add(l);
    }

    public Lembrete getLembrete (int indice){
        return lembretes.get(indice);
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public void setDataFimInMilles(Long dataFim) {
        this.dataFim = Calendar.getInstance();
        this.dataFim.setTimeInMillis(dataFim);
    }

}
