package com.example.doug.healthoclock.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Lembrete;
import com.example.doug.healthoclock.model.Paciente;
import com.example.doug.healthoclock.model.Remedio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Doug on 09/02/2017.
 */

public class LembreteDAO {

    private  SQLiteDatabase banco;
    private PacienteDAO pacienteDAO;
    private RemedioDAO remedioDAO;
    private ControleRemedioDAO controleRemedioDAO;

    public LembreteDAO(Context context) {

        try {
            this.banco = new BancoHelp(context).getWritableDatabase();
            pacienteDAO = new PacienteDAO(context);
            remedioDAO = new RemedioDAO(context);
            controleRemedioDAO = new ControleRemedioDAO(context);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirLembrete(Lembrete lembrete){
        ContentValues values = new ContentValues();
        values.put("IdPaciente",lembrete.getControle().getPaciente().getId());
        values.put("IdControle",lembrete.getControle().getId());
        values.put("DataHora",lembrete.getDataHora().getTimeInMillis());
        values.put("Visto",false);
        values.put("Cumprido",false);

        this.banco.insert("Lembrete",null,values);
    }

    public void  atualizarLembreteVisto(Lembrete lembrete){
        int idPaciente = lembrete.getControle().getPaciente().getId();
        String query = "UPDATE Lembrete SET Visto = 1 WHERE IdPaciente = " + idPaciente +";";

        this.banco.execSQL(query);

    }

    public List<Lembrete> getLembretesPorPaciente(int idPaciente){
        List<Lembrete> lembretes = new ArrayList<Lembrete>();
        String query = "SELECT * FROM Lembrete WHERE IdPaciente = " + idPaciente +";";
        Cursor cursor = this.banco.rawQuery(query,null);

        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        do{

            int idControle = cursor.getInt(cursor.getColumnIndex("IdControle"));
            ControleRemedio controleRemedio = controleRemedioDAO.localizarPorId(idControle);

            Long dataHora = cursor.getLong(cursor.getColumnIndex("DataHora"));

            Boolean boolVisto;
            int visto = cursor.getInt(cursor.getColumnIndex("Visto"));
            if (visto == 1){
               boolVisto = true;
            }else{
                boolVisto = false;
            }
            Boolean boolCumprido;
            int cumprido = cursor.getInt(cursor.getColumnIndex("Cumprido"));
            if (cumprido == 1){
                boolCumprido = true;
            }else {
                boolCumprido = false;
            }
            lembretes.add(new Lembrete(controleRemedio,dataHora,boolVisto,boolCumprido));

        }while (cursor.moveToNext());

        return lembretes;
    }

    public List<Lembrete> getLembretesNaoVistos(int idPaciente){
        List<Lembrete> lembretes = new ArrayList<Lembrete>();
        String query = "SELECT * FROM Lembrete WHERE IdPaciente = " + idPaciente +
                " AND DataHora < " + Calendar.getInstance().getTimeInMillis() +
                " AND Visto = 0" + ";";
        Log.i("HEALTH",query);
        Cursor cursor = this.banco.rawQuery(query,null);

        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        do {
            int idControle = cursor.getInt(cursor.getColumnIndex("IdControle"));
            ControleRemedio controleRemedio = controleRemedioDAO.localizarPorId(idControle);

            Long dataHora = cursor.getLong(cursor.getColumnIndex("DataHora"));

            lembretes.add(new Lembrete(controleRemedio,dataHora,false,false));

        }while(cursor.moveToNext());

        return lembretes;
    }
}
