package com.example.doug.healthoclock.model;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 07/02/2017.
 */

public class Paciente {
    private int id;
    private String nome;
    private Calendar dataNascimento;
    private String sexo;
    private String planoSaude;
    private String tipoSanguineo;
    private List<DoencaCID> doenças;
    private List<ControleRemedio> controleremedios;
    private List<Lembrete> lembretes;

    public Paciente() {
    }

    public Paciente(int id, String nome, int dia, int mes, int ano,
                    String sexo, String planoSaude, String tipoSanguineo,
                    List<DoencaCID> doenças, List<ControleRemedio> controleremedios) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = Calendar.getInstance();
        this.dataNascimento.set(ano,mes,dia);
        this.sexo = sexo;
        this.planoSaude = planoSaude;
        this.tipoSanguineo = tipoSanguineo;
        this.doenças = doenças;
        this.controleremedios = controleremedios;
    }

    public Paciente(int id, String nome, long dataNascimento, String sexo,
                    String planoSaude, String tipoSanguineo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = Calendar.getInstance();
        this.dataNascimento.setTimeInMillis(dataNascimento);
        this.sexo = sexo;
        this.planoSaude = planoSaude;
        this.tipoSanguineo = tipoSanguineo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public  String getDataNascimentoString(){
        return String.format("%d/%d/%d",this.dataNascimento.get(Calendar.DAY_OF_MONTH),
                this.dataNascimento.get(Calendar.MONTH) +1,
                this.dataNascimento.get(Calendar.YEAR));
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public List<DoencaCID> getDoenças() {
        return doenças;
    }

    public void setDoenças(List<DoencaCID> doenças) {
        this.doenças = doenças;
    }

    public List<ControleRemedio> getControleremedios() {
        return controleremedios;
    }

    public void setControleremedios(List<ControleRemedio> controleremedios) {
        this.controleremedios = controleremedios;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }
}
