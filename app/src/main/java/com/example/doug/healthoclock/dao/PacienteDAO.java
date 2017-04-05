package com.example.doug.healthoclock.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.doug.healthoclock.model.Paciente;

import java.io.IOException;

/**
 * Created by Doug on 07/02/2017.
 */

public class PacienteDAO {
    private SQLiteDatabase banco;

    public PacienteDAO(Context context) {

        try {
            this.banco = new BancoHelp(context).getWritableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Paciente localizarPorId(int idPaciente){
        String query = "SELECT * FROM Paciente WHERE Id = " + idPaciente + ";";
        Log.i("HEALTH",query);
        Cursor cursor = this.banco.rawQuery(query,null);

        if (cursor == null){
            return null;
        }
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex("Id"));
        String nome = cursor.getString(cursor.getColumnIndex("Nome"));
        Long dataNascimento = cursor.getLong(cursor.getColumnIndex("DataNascimento"));
        String sexo = cursor.getString(cursor.getColumnIndex("Sexo"));
        String planoSaude = cursor.getString(cursor.getColumnIndex("PlanoSaude"));
        String tipoSanguineo = cursor.getString(cursor.getColumnIndex("TipoSanguineo"));

        Paciente paciente = new Paciente(id,nome,dataNascimento,sexo,planoSaude,tipoSanguineo);

        return paciente;
    }

}
