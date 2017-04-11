package com.example.doug.healthoclock.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doug.healthoclock.R;

public class MenuActivity extends AppCompatActivity {
    private Button btnRemedios;
    private Button btnExames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        this.btnRemedios = (Button) findViewById(R.id.btnRemedios);
        this.btnRemedios.setOnClickListener(new OnClickBotao());

        this.btnExames = (Button) findViewById(R.id.btnExames);
        this.btnExames.setOnClickListener(new OnClickBotao());
    }

    private class OnClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v.equals(MenuActivity.this.btnRemedios)){
                Intent intent = new Intent(MenuActivity.this,ListaControleRemedioActivity.class);
                startActivity(intent);
            }else if (v.equals(MenuActivity.this.btnExames)){
                Intent intent = new Intent(MenuActivity.this,ListaControleExameActivity.class);
                startActivity(intent);
            }
        }
    }
}
