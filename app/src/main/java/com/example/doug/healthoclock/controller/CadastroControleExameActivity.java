package com.example.doug.healthoclock.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import com.example.doug.healthoclock.dao.ControleExameDAO;
import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.PacienteDAO;
import com.example.doug.healthoclock.model.ControleExame;
import com.example.doug.healthoclock.model.Paciente;

public class CadastroControleExameActivity extends AppCompatActivity {
    private ControleExameDAO controleExameDAO;
    private PacienteDAO pacienteDAO;
    private EditText unidade;
    private EditText endereco;
    private EditText dados;
    private EditText especialidade;
    private EditText material;
    private EditText exame;
    private DatePicker data;
    private Button botaoSalvar,botaoCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_controle_exame_layout);

        this.controleExameDAO = new ControleExameDAO(this);
        this.pacienteDAO = new PacienteDAO(this);

        this.unidade = (EditText) findViewById(R.id.editTextUnidade);
        this.endereco = (EditText) findViewById(R.id.editTextEndereco);
        this.dados = (EditText) findViewById(R.id.editTextDados);
        this.especialidade = (EditText) findViewById(R.id.editTextEspecialidade);
        this.material = (EditText) findViewById(R.id.editTextMaterial);
        this.exame = (EditText) findViewById(R.id.editTextExame);
        this.data = (DatePicker) findViewById(R.id.editTextData);

        this.data.setCalendarViewShown(true);

        this.botaoSalvar = (Button) findViewById(R.id.btnSalvarCadastroExame);
        this.botaoCancelar = (Button) findViewById(R.id.btnCancelarCadastroExame);
        this.botaoSalvar.setOnClickListener(new OnClickBotao());


    }

     private class OnClickBotao implements View.OnClickListener {
        @Override
        public void onClick(View v) {
           if (v.equals(CadastroControleExameActivity.this.botaoSalvar)){
                String unidade = CadastroControleExameActivity.this.unidade.getText().toString();
                String endereco = CadastroControleExameActivity.this.endereco.getText().toString();
                Paciente paciente = pacienteDAO.localizarPorId(1);
                String dados = CadastroControleExameActivity.this.dados.getText().toString();
                String especialidade = CadastroControleExameActivity.this.especialidade.getText().toString();
                String material = CadastroControleExameActivity.this.material.getText().toString();
                String exame = CadastroControleExameActivity.this.exame.getText().toString();
                int dia = CadastroControleExameActivity.this.data.getDayOfMonth();
                int mes = CadastroControleExameActivity.this.data.getMonth();
                int ano = CadastroControleExameActivity.this.data.getYear();

               ControleExame e = new ControleExame(unidade, endereco, paciente,  dados, especialidade,
                    material, exame, dia, mes, ano);

               controleExameDAO.inserirControleExame(e);

               //gerarLembretes();

               Intent intent = new Intent(CadastroControleExameActivity.this, ListaControleExameActivity.class);
                      startActivity(intent);

            }else if(v.equals(CadastroControleExameActivity.this.botaoCancelar)){

            }
        }
    }

    private void window()
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        AlertDialog.Builder builder = new AlertDialog.Builder(CadastroControleExameActivity.this);
        builder.setTitle("Cadastro realizado");
        //builder.setMessage();
        builder.setIcon(R.drawable.healthoclock_icone_azul_42x42);
        builder.setPositiveButton("Ver Exames", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                }
        );

        builder.setNegativeButton("Novo exame", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        unidade.setText("");
                        endereco.setText("");
                        dados.setText("");
                        especialidade.setText("");
                        material.setText("");
                        exame.setText("");

                        unidade.requestFocus();
                    }
                }
        );

        builder.create().show();
    }
}
