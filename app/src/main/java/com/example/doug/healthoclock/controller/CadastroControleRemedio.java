package com.example.doug.healthoclock.controller;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.ControleRemedioDAO;
import com.example.doug.healthoclock.dao.LembreteDAO;
import com.example.doug.healthoclock.dao.PacienteDAO;
import com.example.doug.healthoclock.dao.RemedioDAO;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;
import com.example.doug.healthoclock.model.Paciente;
import com.example.doug.healthoclock.model.Remedio;

import java.util.Calendar;

public class CadastroControleRemedio extends AppCompatActivity {
    private static BroadcastReceiver notificacaoReceiver;
    private RadioButton radioButtonTarjaBranca, radioButtonTarjaVermelha,radioButtonTarjaPreta, radioButtonUsoContinuo, radioButtonTempoDeterminado,
            radioButtonDiariamente, radioButtonDiasAlternados;
    private TextView textViewDiasUso;
    private EditText editTextControleNomeRemedio,editTextControleDosagem, editTextDiasUso;
    private Button btnSalvarControleRemedio, btnCancelarControleRemedio;
    private DatePicker datePickerDataInicialRemedio;
    private TimePicker timePickerHoraInicialRemedio;
    private CheckBox chkSegunda, chkTerca, chkQuarta, chkQuinta, chkSexta, chkSabado, chkDomingo;
    private Spinner spinnerIntervaloHoras;
    private LinearLayout layoutDiasSemana;
    private ControleRemedioDAO controleRemedioDAO;
    private ControleRemedio controleRemedio;
    private PacienteDAO pacienteDAO;
    private Paciente paciente;
    private RemedioDAO remedioDAO;
    private Remedio remedio;
    private LembreteDAO lembreteDAO;
    private int qtdDias, intervaloHoras;
    private Long dataInicio, dataFim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_controle_remedio_layout);


        controleRemedioDAO = new ControleRemedioDAO(this);
        remedioDAO = new RemedioDAO(this);
        pacienteDAO = new PacienteDAO(this);
        lembreteDAO = new LembreteDAO(this);

        this.editTextControleNomeRemedio = (EditText) findViewById(R.id.editTextControleNomeRemedio);
        this.editTextControleDosagem = (EditText) findViewById(R.id.editTextControleDosagem);

        this.radioButtonTarjaBranca = (RadioButton) findViewById(R.id.radioButtonTarjaBranca);
        this.radioButtonTarjaVermelha = (RadioButton) findViewById(R.id.radioButtonTarjaVermelha);
        this.radioButtonTarjaPreta = (RadioButton) findViewById(R.id.radioButtonTarjaPreta);

        this.datePickerDataInicialRemedio = (DatePicker) findViewById(R.id.datePickerDataInicalRemedio);

        this.timePickerHoraInicialRemedio = (TimePicker) findViewById(R.id.timePickerHoraInicialRemedio);
        this.timePickerHoraInicialRemedio.setIs24HourView(true);

        this.radioButtonUsoContinuo = (RadioButton) findViewById(R.id.radioButtonUsoContinuo);
        this.radioButtonUsoContinuo.setOnClickListener(new OnClickRadioButton());

        this.radioButtonTempoDeterminado = (RadioButton) findViewById(R.id.radioButtonTempoDeterminado);
        this.radioButtonTempoDeterminado.setOnClickListener(new OnClickRadioButton());

        this.radioButtonDiariamente= (RadioButton) findViewById(R.id.radioButtonDiariamente);
        this.radioButtonDiariamente.setOnClickListener(new OnClickRadioButton());

        this.radioButtonDiasAlternados = (RadioButton) findViewById(R.id.radioButtonDiasAlternados);
        this.radioButtonDiasAlternados.setOnClickListener(new OnClickRadioButton());

        this.textViewDiasUso = (TextView) findViewById(R.id.textViewDiasUso);
        this.editTextDiasUso = (EditText) findViewById(R.id.editTextDiasUso);

        this.layoutDiasSemana = (LinearLayout) findViewById(R.id.layoutDiasSemana);

        this.chkSegunda = (CheckBox) findViewById(R.id.controleChkSegunda);
        this.chkTerca = (CheckBox) findViewById(R.id.controleChkTerca);
        this.chkQuarta = (CheckBox) findViewById(R.id.controleChkQuarta);
        this.chkQuinta = (CheckBox) findViewById(R.id.controleChkQuinta);
        this.chkSexta = (CheckBox) findViewById(R.id.controleChkSexta);
        this.chkSabado = (CheckBox) findViewById(R.id.controleChkSabado);
        this.chkDomingo = (CheckBox) findViewById(R.id.controleChkDomingo);

        this.spinnerIntervaloHoras = (Spinner) findViewById(R.id.spinnerIntervaloHoras);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.intervalos_horas,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIntervaloHoras.setAdapter(adapter);

        this.btnCancelarControleRemedio = (Button) findViewById(R.id.btnCancelarCadastroRemedio);
        this.btnCancelarControleRemedio.setOnClickListener(new OnClickBotao());
        this.btnSalvarControleRemedio = (Button) findViewById(R.id.btnSalvarCadastroRemedio);
        this.btnSalvarControleRemedio.setOnClickListener(new OnClickBotao());

     }

    private class OnClickRadioButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (v.equals(CadastroControleRemedio.this.radioButtonTempoDeterminado)) {
                CadastroControleRemedio.this.textViewDiasUso.setVisibility(TextView.VISIBLE);
                CadastroControleRemedio.this.editTextDiasUso.setVisibility(EditText.VISIBLE);
            }else if (v.equals(CadastroControleRemedio.this.radioButtonUsoContinuo)){
                CadastroControleRemedio.this.textViewDiasUso.setVisibility(TextView.GONE);
                CadastroControleRemedio.this.editTextDiasUso.setVisibility(EditText.GONE);
            }else if (v.equals(CadastroControleRemedio.this.radioButtonDiasAlternados)){
                CadastroControleRemedio.this.layoutDiasSemana.setVisibility(LinearLayout.VISIBLE);
            }else if (v.equals(CadastroControleRemedio.this.radioButtonDiariamente)){
                CadastroControleRemedio.this.layoutDiasSemana.setVisibility(LinearLayout.GONE);
            }
        }
    }

    private class OnClickBotao implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.equals(CadastroControleRemedio.this.btnSalvarControleRemedio)){
                String nomeRemedio = CadastroControleRemedio.this.editTextControleNomeRemedio.getText().toString();
                remedio = remedioDAO.localizarPorNome(nomeRemedio);
                paciente = pacienteDAO.localizarPorId(1);
                String dosagem = CadastroControleRemedio.this.editTextControleDosagem.getText().toString();
                String tarja = qualTarja();
                qtdDias = Integer.parseInt(CadastroControleRemedio.this.editTextDiasUso.getText().toString());
                dataInicio = getDataHoraInicial();
                dataFim = gerarDataFim();

                intervaloHoras = getIntervaloHoras();

                controleRemedio = new ControleRemedio(paciente,remedio,dataInicio,dataFim,dosagem,null,tarja);

                int idControleRemedio = controleRemedioDAO.inserirControleRemedio(controleRemedio);
                controleRemedio.setId(idControleRemedio);

                gerarLembretes();

                Intent intent = new Intent(CadastroControleRemedio.this,RemediosActivity.class);
                startActivity(intent);

            }else if(v.equals(CadastroControleRemedio.this.btnCancelarControleRemedio)){

            }
        }
    }

    private String qualTarja(){
        if (CadastroControleRemedio.this.radioButtonTarjaBranca.isChecked()){
            return "Branca";
        }else if(CadastroControleRemedio.this.radioButtonTarjaVermelha.isChecked()){
            return "Vermelha";
        }else if(CadastroControleRemedio.this.radioButtonTarjaPreta.isChecked()){
            return "Preta";
        }else{
            return null;
        }
    }

     private long getDataHoraInicial(){
         int dia, mes, ano, hora, minuto;
         dia = CadastroControleRemedio.this.datePickerDataInicialRemedio.getDayOfMonth();
         mes = CadastroControleRemedio.this.datePickerDataInicialRemedio.getMonth();
         ano = CadastroControleRemedio.this.datePickerDataInicialRemedio.getYear();
         hora = 0;
         minuto = 0;
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             hora = CadastroControleRemedio.this.timePickerHoraInicialRemedio.getHour();
         }else{
             hora = CadastroControleRemedio.this.timePickerHoraInicialRemedio.getCurrentHour();
         }
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             minuto = CadastroControleRemedio.this.timePickerHoraInicialRemedio.getMinute();
         }else{
             minuto = CadastroControleRemedio.this.timePickerHoraInicialRemedio.getCurrentMinute();
         }

         Calendar dataHora = Calendar.getInstance();
         dataHora.set(ano,mes,dia,hora,minuto);

         return dataHora.getTimeInMillis();

     }

    private Long gerarDataFim(){
        return dataInicio + (--qtdDias*24*60*60*1000);
    }

    private void gerarLembretes(){

        if (radioButtonDiariamente.isChecked()){
            Log.i("HEALTH","Intervalo de horas: " + intervaloHoras);
            Long dataLembrete = dataInicio;
            Lembrete lembrete;
            //Gerar lembrentes, a partir da hora inicial, somando-se o intervalo de horas selecionado
            do {
                lembrete = new Lembrete(controleRemedio,dataLembrete,false,false);
                lembreteDAO.inserirLembrete(lembrete);
                Log.i("HEALTH",lembrete.getDataHoraString());
                dataLembrete = dataLembrete+(intervaloHoras*60*60*1000);
            }while (dataLembrete<=dataFim);
        }else{

        }
    }

    private int getIntervaloHoras(){
        String itemIntervaloHoras = spinnerIntervaloHoras.getSelectedItem().toString();
        switch (itemIntervaloHoras){
            case "12 em 12 horas"   :  return 12;
            case "6 em 6 horas"     :  return 6;
            case "4 em 4 horas"     :  return 4;
            case "3 em 3 horas"     :  return 3;
            case "2 em 2 horas"     :  return 2;
            case "1 em 1 hora"      :  return 1;
            default                 :  return 24;
        }
    }

}
