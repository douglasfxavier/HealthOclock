package com.example.doug.healthoclock.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public Remedio localizarPorId(Long idRemedio){
        String query = "SELECT * FROM Remedio WHERE id = " + idRemedio + ";";

        Cursor cursor = this.banco.rawQuery(query,null);
        cursor.moveToFirst();
        String nome = cursor.getString(cursor.getColumnIndex("Nome"));
        String principioAtivo = cursor.getString(cursor.getColumnIndex("PrincipioAtivo"));
        String laboratorio = cursor.getString(cursor.getColumnIndex("Laboratorio"));
        String classeTerapeutica = cursor.getString(cursor.getColumnIndex("ClasseTerapeutica"));

        Remedio remedio = new Remedio(idRemedio,nome,principioAtivo,laboratorio,classeTerapeutica);

        return remedio;
    }

    public Remedio localizarPorNome(String nome){
        String query = "SELECT * FROM Remedio WHERE Nome = \'" + nome +"\';";
        Log.i("HEALTH",query);
        Cursor cursor = this.banco.rawQuery(query,null);
        cursor.moveToFirst();
        Long id = cursor.getLong(cursor.getColumnIndex("Id"));
        String principioAtivo = cursor.getString(cursor.getColumnIndex("PrincipioAtivo"));
        String laboratorio = cursor.getString(cursor.getColumnIndex("Laboratorio"));
        String classeTerapeutica = cursor.getString(cursor.getColumnIndex("ClasseTerapeutica"));

        Remedio remedio = new Remedio(id,nome,principioAtivo,laboratorio,classeTerapeutica);

        return remedio;
    }

    public List<Remedio> getRemedios(){
        List<Remedio> remedios = new ArrayList<Remedio>();
        String colunas[] = {"Id","Nome","PrincipioAtivo","Laboratorio","ClasseTerapeutica"};

        Cursor cursor = banco.query("Remedio",colunas,null,null,null,null,"nome");

        cursor.moveToFirst();
        do{
            Long id = cursor.getLong(cursor.getColumnIndex("Id"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String principioAtivo = cursor.getString(cursor.getColumnIndex("PrincipioAtivo"));
            String laboratorio = cursor.getString(cursor.getColumnIndex("Laboratorio"));
            String classeTerapeutica = cursor.getString(cursor.getColumnIndex("ClasseTerapeutica"));
            remedios.add(new Remedio(id,nome,principioAtivo,laboratorio,classeTerapeutica));
        }while (cursor.moveToNext());

        return remedios;
    }
}
