package com.example.doug.healthoclock.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button btnExcluirControleExame;
    private int controleExameId;
    private ControleExame controleExame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_exame_layout);

        controleExameDAO = new ControleExameDAO(this);

        Bundle b = getIntent().getExtras();
        controleExameId = b.getInt("controleExameId");
        controleExame = controleExameDAO.getById(controleExameId,1);


        this.unidade = (TextView) findViewById(R.id.textUnidade);
        this.endereco = (TextView) findViewById(R.id.textEndereco);
        this.dados = (TextView) findViewById(R.id.textDados);
        this.especialidade = (TextView) findViewById(R.id.textEspecialidade);
        this.material = (TextView) findViewById(R.id.textMaterial);
        this.exame = (TextView) findViewById(R.id.textExame);
        this.data = (TextView) findViewById(R.id.textData);
        this.btnExcluirControleExame = (Button) findViewById(R.id.btnExcluirControleExame);

        unidade.setText(controleExame.getNomeUnidadeMedica());
        endereco.setText(controleExame.getEnderecoDaUnidade());
        dados.setText(controleExame.getDadosClinicos());
        especialidade.setText(controleExame.getEspecialidadeMedicoRequisitante());
        material.setText(controleExame.getMaterialExaminar());
        exame.setText(controleExame.getTipoExame());
        data.setText(controleExame.getDataInicioString());

        this.btnExcluirControleExame.setOnClickListener(new OnClickBotao());
    }

    private class OnClickBotao implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.equals(SingleExameActivity.this.btnExcluirControleExame)){

                AlertDialog.Builder builder = new AlertDialog.Builder(SingleExameActivity.this);
                builder.setTitle("Confirmação");
                builder.setMessage(String.format("Você deseja mesmo excluir o(a) %s?", controleExame.getTipoExame()));
                builder.setIcon(R.drawable.healthoclock_icone_azul_42x42);
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                    });
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controleExameDAO.deletarControleExame(controleExameId);
                        Intent intent = new Intent(SingleExameActivity.this,ListaControleExameActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        }
    }
}
