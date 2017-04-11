package com.example.doug.healthoclock.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.ControleExameDAO;
import com.example.doug.healthoclock.dao.ControleRemedioDAO;
import com.example.doug.healthoclock.dao.LembreteDAO;
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
    private Button btnExcluirControleRemedio;
    private int controleRemedioId;
    private ControleRemedio controleRemedio;
    private LembreteDAO lembreteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_remedio_layout);

        controleRemedioDAO = new ControleRemedioDAO(this);
        lembreteDAO = new LembreteDAO(this);

        Bundle bundle = getIntent().getExtras();
        controleRemedioId = bundle.getInt("controleRemedioId");
        controleRemedio = controleRemedioDAO.getById(controleRemedioId,1);


        this.nomeRemedio = (TextView) findViewById(R.id.textRemedio);
        this.nomeLaboratorio = (TextView) findViewById(R.id.textLaboratorio);
        this.principioAtivo = (TextView) findViewById(R.id.textPrincipioAtivo);
        this.classeTerapeutica = (TextView) findViewById(R.id.textClasseTerapeutica);
        this.dosagem = (TextView) findViewById(R.id.textDosagem);
        this.tarja = (TextView) findViewById(R.id.textTarja);
        this.btnExcluirControleRemedio = (Button) findViewById(R.id.btnExcluirControleRemedio);

        this.nomeRemedio.setText(controleRemedio.getRemedio().getNome().toString());
        this.nomeLaboratorio.setText(controleRemedio.getRemedio().getLaboratorio().toString());
        this.principioAtivo.setText(controleRemedio.getRemedio().getPrincipioAtivo());
        this.classeTerapeutica.setText(controleRemedio.getRemedio().getClasseTerapeutica());
        this.dosagem.setText(controleRemedio.getDosagem());
        this.tarja.setText(controleRemedio.getTarja());

        this.btnExcluirControleRemedio.setOnClickListener(new OnClickBotao());

    }

    private class OnClickBotao implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.equals(SingleRemedioActivity.this.btnExcluirControleRemedio)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SingleRemedioActivity.this);
                builder.setTitle("Confirmação");
                builder.setMessage(String.format("Você deseja mesmo excluir o(a) %s?", controleRemedio.getRemedio().getNome()));
                builder.setIcon(R.drawable.healthoclock_icone_azul_42x42);
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controleRemedioDAO.deletarControleRemedio(controleRemedioId);
                        lembreteDAO.deletarLembrete(1,controleRemedioId);
                        Intent intent = new Intent(SingleRemedioActivity.this, ListaControleRemedioActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();

            }
        }
    }
}
