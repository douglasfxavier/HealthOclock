package com.example.doug.healthoclock.model;

import java.util.Calendar;

/**
 * Created by Doug on 07/02/2017.
 */

public class ControleExame extends Controle{
    private String nomeUnidadeMedica;
    private String enderecoDaUnidade;
    private Paciente paciente;
    private String dadosClinicos;
    private String especialidadeMedicoRequisitante;
    private String materialExaminar;
    private String tipoExame;
    private Calendar dataRealizacao;

    public ControleExame() {
    }

    public ControleExame(int id, String nomeUnidadeMedica, String enderecoDaUnidade,
                         Paciente paciente, String dadosClinicos,
                         String especialidadeMedicoRequisitante, String materialExaminar,
                         String tipoExame, long dataRealizacao) {
        super(id,paciente,dataRealizacao);
        this.nomeUnidadeMedica = nomeUnidadeMedica;
        this.enderecoDaUnidade = enderecoDaUnidade;
        this.paciente = paciente;
        this.dadosClinicos = dadosClinicos;
        this.especialidadeMedicoRequisitante = especialidadeMedicoRequisitante;
        this.materialExaminar = materialExaminar;
        this.tipoExame = tipoExame;
        this.dataRealizacao = Calendar.getInstance();
        this.dataRealizacao.setTimeInMillis(dataRealizacao);
    }
    public ControleExame(String nomeUnidadeMedica, String enderecoDaUnidade,
                         Paciente paciente, String dadosClinicos,
                         String especialidadeMedicoRequisitante, String materialExaminar,
                         String tipoExame, long dataRealizacao) {
        super(paciente,dataRealizacao);
        this.nomeUnidadeMedica = nomeUnidadeMedica;
        this.enderecoDaUnidade = enderecoDaUnidade;
        this.paciente = paciente;
        this.dadosClinicos = dadosClinicos;
        this.especialidadeMedicoRequisitante = especialidadeMedicoRequisitante;
        this.materialExaminar = materialExaminar;
        this.tipoExame = tipoExame;
        this.dataRealizacao = Calendar.getInstance();
        this.dataRealizacao.setTimeInMillis(dataRealizacao);
    }

    public ControleExame(String nomeUnidadeMedica, String enderecoDaUnidade,
                         Paciente paciente, String dadosClinicos,
                         String especialidadeMedicoRequisitante, String materialExaminar,
                         String tipoExame, int dia, int mes, int ano) {
        super(paciente,dia,mes,ano);
        this.nomeUnidadeMedica = nomeUnidadeMedica;
        this.enderecoDaUnidade = enderecoDaUnidade;
        this.paciente = paciente;
        this.dadosClinicos = dadosClinicos;
        this.especialidadeMedicoRequisitante = especialidadeMedicoRequisitante;
        this.materialExaminar = materialExaminar;
        this.tipoExame = tipoExame;
        this.dataRealizacao = Calendar.getInstance();
        this.dataRealizacao.set(dia,mes,ano);
    }

    public ControleExame(int id,String nomeUnidadeMedica, String enderecoDaUnidade,
                         Paciente paciente, String dadosClinicos,
                         String especialidadeMedicoRequisitante, String materialExaminar,
                         String tipoExame, int dia, int mes, int ano) {
        super(id,paciente,dia,mes,ano);
        this.nomeUnidadeMedica = nomeUnidadeMedica;
        this.enderecoDaUnidade = enderecoDaUnidade;
        this.paciente = paciente;
        this.dadosClinicos = dadosClinicos;
        this.especialidadeMedicoRequisitante = especialidadeMedicoRequisitante;
        this.materialExaminar = materialExaminar;
        this.tipoExame = tipoExame;
        this.dataRealizacao = Calendar.getInstance();
        this.dataRealizacao.set(dia,mes,ano);
    }

    public String getNomeUnidadeMedica() {
        return nomeUnidadeMedica;
    }

    public void setNomeUnidadeMedica(String nomeUnidadeMedica) {
        this.nomeUnidadeMedica = nomeUnidadeMedica;
    }

    public String getEnderecoDaUnidade() {
        return enderecoDaUnidade;
    }

    public void setEnderecoDaUnidade(String enderecoDaUnidade) {
        this.enderecoDaUnidade = enderecoDaUnidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDadosClinicos() {
        return dadosClinicos;
    }

    public void setDadosClinicos(String dadosClinicos) {
        this.dadosClinicos = dadosClinicos;
    }

    public String getEspecialidadeMedicoRequisitante() {
        return especialidadeMedicoRequisitante;
    }

    public void setEspecialidadeMedicoRequisitante(String especialidadeMedicoRequisitante) {
        this.especialidadeMedicoRequisitante = especialidadeMedicoRequisitante;
    }

    public String getMaterialExaminar() {
        return materialExaminar;
    }

    public void setMaterialExaminar(String materialExaminar) {
        this.materialExaminar = materialExaminar;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipo_exame) {
        this.tipoExame = tipo_exame;
    }

    public Calendar getDataRealizacao() {
        return dataRealizacao;
    }

    public  String getDataRealizacaoString(){
        return String.format("%d/%d/%d",this.dataRealizacao.get(Calendar.DAY_OF_MONTH),
                                        this.dataRealizacao.get(Calendar.MONTH) +1,
                                        this.dataRealizacao.get(Calendar.YEAR));
    }

    public void setDataRealizacao(Calendar dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}