package com.example.doug.healthoclock.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Paciente;
import com.example.doug.healthoclock.model.Remedio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doug on 09/02/2017.
 */

public class ControleRemedioDAO {

    private  SQLiteDatabase banco;
    private PacienteDAO pacienteDAO;
    private RemedioDAO remedioDAO;

    public ControleRemedioDAO(Context context) {

        try {
            this.banco = new BancoHelp(context).getWritableDatabase();
            pacienteDAO = new PacienteDAO(context);
            remedioDAO = new RemedioDAO(context);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int inserirControleRemedio(ControleRemedio controleRemedio){
        ContentValues values = new ContentValues();
        int idPaciente = controleRemedio.getPaciente().getId();
        Long idRemedio = controleRemedio.getRemedio().getId();
        Long dataInicioUso = controleRemedio.getDataInicio().getTimeInMillis();
        Long dataFinalUso = controleRemedio.getDataFim().getTimeInMillis();
        String dosagem = controleRemedio.getDosagem();
        String formaUso = controleRemedio.getFormaUso();
        String tarja = controleRemedio.getTarja();
        values.put("IdPaciente",idPaciente);
        values.put("IdRemedio",idRemedio);
        values.put("DataInicioUso",dataInicioUso);
        values.put("DataFinalUso",dataFinalUso);
        values.put("Dosagem",dosagem);
        values.put("FormaUso",formaUso);
        values.put("Tarja",tarja);

        String query = "SELECT * FROM ControleRemedio WHERE " +
                "IdPaciente = " + idPaciente +
                " and IdRemedio = " + idRemedio +
                " and DataInicioUso = " + dataInicioUso +";";

        this.banco.insert("ControleRemedio",null,values);
        Cursor cursor = this.banco.rawQuery(query,null);

        cursor.moveToFirst();

        int idControleRemedio = cursor.getInt(cursor.getColumnIndex("Id"));

        return idControleRemedio;
    }

    public void deletarControleRemedio(int controleRemedioId){

        String sql = "DELETE FROM ControleRemedio WHERE " +
                       "Id = " + controleRemedioId + ";";

        this.banco.execSQL(sql);
    }

    public ControleRemedio getById(int idControleRemedio,int idPaciente){
        ControleRemedio controleRemedio;
        Paciente paciente = pacienteDAO.localizarPorId(idPaciente);

        String query = "SELECT * FROM ControleRemedio WHERE Id = " + idControleRemedio +";";
        Cursor cursor = this.banco.rawQuery(query,null);

        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        long idRemedio = cursor.getLong(cursor.getColumnIndex("IdRemedio"));
        Remedio remedio = remedioDAO.localizarPorId(idRemedio);
        Long dataInicioUso = cursor.getLong(cursor.getColumnIndex("DataInicioUso"));
        Long dataFinalUso = cursor.getLong(cursor.getColumnIndex("DataFinalUso"));
        String dosagem = cursor.getString(cursor.getColumnIndex("Dosagem"));
        String formaUso = cursor.getString(cursor.getColumnIndex("FormaUso"));
        String tarja = cursor.getString(cursor.getColumnIndex("Tarja"));

        controleRemedio = new ControleRemedio(idControleRemedio,paciente,remedio,dataInicioUso,dataFinalUso,
                dosagem,formaUso,tarja);

        return controleRemedio;
    }

    public List<ControleRemedio> getControlesRemediosPorPaciente(int idPaciente){
        List<ControleRemedio> controlesRemedios = new ArrayList<ControleRemedio>();
        String query = "SELECT * FROM ControleRemedio WHERE IdPaciente = " + idPaciente +";";
        Cursor cursor = this.banco.rawQuery(query,null);

        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        do{
            int idControleRemedio = cursor.getInt(cursor.getColumnIndex("Id"));
            Paciente paciente = pacienteDAO.localizarPorId(idPaciente);
            Long idRemedio = cursor.getLong(cursor.getColumnIndex("IdRemedio"));
            Remedio remedio = remedioDAO.localizarPorId(idRemedio);
            Long dataInicioUso = cursor.getLong(cursor.getColumnIndex("DataInicioUso"));
            Long dataFinalUso = cursor.getLong(cursor.getColumnIndex("DataFinalUso"));
            String dosagem = cursor.getString(cursor.getColumnIndex("Dosagem"));
            String formaUso = cursor.getString(cursor.getColumnIndex("FormaUso"));
            String tarja = cursor.getString(cursor.getColumnIndex("Tarja"));
            controlesRemedios.add(new ControleRemedio(idControleRemedio,paciente,remedio,dataInicioUso,dataFinalUso,
                    dosagem,formaUso,tarja));

        }while (cursor.moveToNext());

        return controlesRemedios;
    }

}
