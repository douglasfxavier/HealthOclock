package com.example.doug.healthoclock.controller;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.LembreteDAO;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editEmail, editSenha;
    private Button btnEntrar;
    private DataHoraBroadcastReceiver dataHoraBroadcastReceiver;
    private IntentFilter dataHoraIntentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        this.dataHoraBroadcastReceiver = new DataHoraBroadcastReceiver();
        this.dataHoraIntentFilter = new IntentFilter();
        dataHoraIntentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(dataHoraBroadcastReceiver,dataHoraIntentFilter);

        this.editEmail = (EditText) findViewById(R.id.editEmailLogin);
        this.editSenha = (EditText) findViewById(R.id.editSenhaLogin);
        this.btnEntrar = (Button) findViewById(R.id.btnEntrarLogin);

        this.btnEntrar.setOnClickListener(new OnClickBotao());
    }



    private class OnClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if (v.equals(MainActivity.this.btnEntrar)){
                Intent welcomeIntent = new Intent(MainActivity.this,WelcomeActivity.class);
                startActivity(welcomeIntent);
            }

        }
    }

    private class LembretesNaoVistos extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... params) {
            LembreteDAO lembreteDAO = new LembreteDAO(MainActivity.this);

            List<Lembrete> lembretes = lembreteDAO.getLembretesNaoVistos(1);
            if (lembretes != null && lembretes.size()!=0){
                for(int i=0; i<lembretes.size();i++){
                    String nomeRemedio = ((ControleRemedio) lembretes.get(i).getControle())
                            .getRemedio().getNome();
                    String msg = String.format("Está na hora de tomar seu remédio %s",nomeRemedio);
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }

}
