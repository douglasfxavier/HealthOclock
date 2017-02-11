package com.example.doug.healthoclock.controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.doug.healthoclock.R;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnMeuHO, btnOutrosPacientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        //Apresenta caixa de diálogo assim que o login é realizado com sucesso
        String welcome_message = "Olá, Usuário! Como está se sentindo hoje?";
        AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
        builder.setTitle("Checando sua saúde...");
        builder.setMessage(welcome_message);
        builder.setIcon(R.drawable.healthoclock_icone_azul_42x42);
        builder.setPositiveButton("Bem",null);
        builder.setNegativeButton("Mal",null);
        builder.create().show();

        this.btnMeuHO = (Button) findViewById(R.id.btnMeuHO);
        this.btnOutrosPacientes = (Button) findViewById(R.id.btnOutrosPacientes);

        this.btnMeuHO.setOnClickListener(new OnClickBotao());
        this.btnOutrosPacientes.setOnClickListener(new OnClickBotao());
    }
    private class OnClickBotao implements OnClickListener {

        @Override
        public void onClick(View v) {

            if (v.equals(WelcomeActivity.this.btnMeuHO)) {
                Intent welcomeview = new Intent(WelcomeActivity.this, MenuActivity.class);
                startActivity(welcomeview);
            }
        }

    }
}
