package com.example.doug.healthoclock.controller;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.LembreteDAO;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;
import com.example.doug.healthoclock.model.Remedio;

import java.util.List;

/**
 * Created by Doug on 27/02/2017.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

        }
    }
}
