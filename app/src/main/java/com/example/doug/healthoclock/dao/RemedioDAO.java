package com.example.doug.healthoclock.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.doug.healthoclock.controller.LoginAcitvity;
import com.example.doug.healthoclock.model.Remedio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doug on 09/02/2017.
 */

public class RemedioDAO {

    private  SQLiteDatabase banco;

    public RemedioDAO(Context context) {

        try {
            this.banco = new BancoHelp(context).getWritableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Remedio> getRemedios(){
        List<Remedio> remedios = new ArrayList<Remedio>();
        String colunas[] = {"id","nome"};

        Cursor cursor = banco.query("Remedio",colunas,null,null,null,null,"nome");

        cursor.moveToFirst();
        do{
            int id = cursor.getInt(cursor.getColumnIndex("Id"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            remedios.add(new Remedio(id,nome));
        }while (cursor.moveToNext());

        return remedios;
    }
}
