package com.example.doug.healthoclock.model;

/**
 * Created by Doug on 08/02/2017.
 */

public class Login {
    private int idpaciente;
    private String email;
    private String senha;

    public Login(int idpaciente, String email, String senha) {
        this.idpaciente = idpaciente;
        this.email = email;
        this.senha = senha;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
