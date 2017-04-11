package com.example.doug.healthoclock.controller;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.LembreteDAO;
import com.example.doug.healthoclock.model.Controle;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;

import java.util.List;

/**
 * Created by Doug on 27/02/2017.
 */

public class DataHoraBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LembreteDAO lembreteDAO = new LembreteDAO(context);

        switch (intent.getAction()){
            case Intent.ACTION_TIME_TICK:

            List<Lembrete> lembretes = lembreteDAO.getLembretesNaoVistos(1);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.healthoclock_icone_azul_42x42)
                    .setContentTitle("Lembrete")
                    .setContentText("");
            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);


            if (lembretes != null && lembretes.size()!=0){
                for(int i=0; i<lembretes.size();i++){
                    String nomeRemedio = ((ControleRemedio) lembretes.get(i).getControle())
                            .getRemedio().getNome();
                    String msg = String.format("Está na hora de tomar seu remédio %s",nomeRemedio);
                    //Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
                    notificationBuilder.setContentText("Hora do remédio "+ nomeRemedio);
//                    Intent activityIntent = new Intent(this,MainActivity.class);
//                    PendingIntent pendingIntent = PendingIntent.getActivity(this,0,activityIntent);
//                    notificationBuilder.addAction(null,"Feito!",);
                    notificationManager.notify(i,notificationBuilder.build());
                    lembretes.get(i).setVisto(true);
                    lembreteDAO.atualizarLembreteVisto(lembretes.get(i));
                }
            }
                break;
        }
    }
}
