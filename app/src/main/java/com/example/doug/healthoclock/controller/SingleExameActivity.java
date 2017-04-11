package com.example.doug.healthoclock.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.doug.healthoclock.dao.ControleExameDAO;
import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.model.ControleExame;

public class SingleExameActivity extends AppCompatActivity {
    private ControleExameDAO controleExameDAO;
    private TextView unidade;
    private TextView endereco;
    private TextView dados;
    private TextView especialidade;
    private TextView material;
    private TextView exame;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_exame_layout);

        controleExameDAO = new ControleExameDAO(this);

        Bundle b = getIntent().getExtras();
        int controleExameId = b.getInt("controleExameId");
        Log.i("HEALTH","O id do ControleExame é: " + String.valueOf(controleExameId));
//      ControleExame controleExame = controleExameDAO.getById(exameId,1);
        ControleExame controleExame = controleExameDAO.getById(controleExameId,1);


        this.unidade = (TextView) findViewById(R.id.textUnidade);
        this.endereco = (TextView) findViewById(R.id.textEndereco);
        this.dados = (TextView) findViewById(R.id.textDados);
        this.especialidade = (TextView) findViewById(R.id.textEspecialidade);
        this.material = (TextView) findViewById(R.id.textMaterial);
        this.exame = (TextView) findViewById(R.id.textExame);
        this.data = (TextView) findViewById(R.id.textData);

        unidade.setText(controleExame.getNomeUnidadeMedica());
        endereco.setText(controleExame.getEnderecoDaUnidade());
        dados.setText(controleExame.getDadosClinicos());
        especialidade.setText(controleExame.getEspecialidadeMedicoRequisitante());
        material.setText(controleExame.getMaterialExaminar());
        exame.setText(controleExame.getTipoExame());
        data.setText(controleExame.getDataInicioString());
    }
}
