package com.example.doug.healthoclock.controller;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.doug.healthoclock.dao.LembreteDAO;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;

import java.util.List;

public class Background extends AppCompatActivity {
    private DataHoraBroadcastReceiver dataHoraBroadcastReceiver;
    private IntentFilter intentFilterDataHora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.dataHoraBroadcastReceiver = new DataHoraBroadcastReceiver();
//        this.intentFilterDataHora = new IntentFilter();
//        intentFilterDataHora.addAction("android.intent.action.BOOT_COMPLETED");
//        registerReceiver(dataHoraBroadcastReceiver,intentFilterDataHora);

        LembreteDAO lembreteDAO = new LembreteDAO(this);

            List<Lembrete> lembretes = lembreteDAO.getLembretesNaoVistos(1);
            if (lembretes != null && lembretes.size()!=0){
                for(int i=0; i<lembretes.size();i++){
                    String nomeRemedio = ((ControleRemedio) lembretes.get(i).getControle())
                            .getRemedio().getNome();
                    String msg = String.format("Está na hora de tomar seu remédio %s",nomeRemedio);
                    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                }
            }

    }
}
