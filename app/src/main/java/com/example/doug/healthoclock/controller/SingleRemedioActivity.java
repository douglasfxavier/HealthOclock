package com.example.doug.healthoclock.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.ControleExameDAO;
import com.example.doug.healthoclock.dao.ControleRemedioDAO;
import com.example.doug.healthoclock.model.ControleExame;
import com.example.doug.healthoclock.model.ControleRemedio;

public class SingleRemedioActivity extends AppCompatActivity {
    private ControleRemedioDAO controleRemedioDAO;
    private TextView nomeRemedio;
    private TextView nomeLaboratorio;
    private TextView principioAtivo;
    private TextView classeTerapeutica;
    private TextView dosagem;
    private TextView tarja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_remedio_layout);

        controleRemedioDAO = new ControleRemedioDAO(this);

        Bundle bundle = getIntent().getExtras();
        int controleRemedioId = bundle.getInt("controleRemedioId");
        ControleRemedio controleRemedio = controleRemedioDAO.getById(controleRemedioId,1);

        if (controleRemedio == null){
            Log.i("HEALTH", "controleRemedio está null");
        }else{
            Log.i("HEALTH", controleRemedio.getRemedio().getNome());
        }

        this.nomeRemedio = (TextView) findViewById(R.id.textRemedio);
        this.nomeLaboratorio = (TextView) findViewById(R.id.textLaboratorio);
        this.principioAtivo = (TextView) findViewById(R.id.textPrincipioAtivo);
        this.classeTerapeutica = (TextView) findViewById(R.id.textClasseTerapeutica);
        this.dosagem = (TextView) findViewById(R.id.textDosagem);
        this.tarja = (TextView) findViewById(R.id.textTarja);

        this.nomeRemedio.setText(controleRemedio.getRemedio().getNome().toString());
        this.nomeLaboratorio.setText(controleRemedio.getRemedio().getLaboratorio().toString());
        this.principioAtivo.setText(controleRemedio.getRemedio().getPrincipioAtivo());
        this.classeTerapeutica.setText(controleRemedio.getRemedio().getClasseTerapeutica());
        this.dosagem.setText(controleRemedio.getDosagem());
        this.tarja.setText(controleRemedio.getTarja());

    }
}
