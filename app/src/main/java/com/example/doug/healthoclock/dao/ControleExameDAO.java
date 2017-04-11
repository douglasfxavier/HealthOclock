package com.example.doug.healthoclock.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doug.healthoclock.model.ControleExame;
import com.example.doug.healthoclock.model.ControleRemedio;
import com.example.doug.healthoclock.model.Exame;
import com.example.doug.healthoclock.model.Paciente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cida on 08/02/2017.
 */

public class ControleExameDAO {
    private SQLiteDatabase banco;
    private PacienteDAO pacienteDAO;

    public ControleExameDAO(Context context)
    {
        try {
            this.banco = new BancoHelp(context).getWritableDatabase();
            pacienteDAO = new PacienteDAO(context);
        } catch (IOException e) {

        }
    }

    public void inserirControleExame(ControleExame controleExame)
    {
        ContentValues cv = new ContentValues();
        cv.put("idpaciente",1);
        cv.put("nome_unidade", controleExame.getNomeUnidadeMedica());
        cv.put("endereco_unidade", controleExame.getEnderecoDaUnidade());
        //cv.put("nome_paciente", e.getPaciente().getNome());
        cv.put("dados_clinicos", controleExame.getDadosClinicos());
        cv.put("especialidade_medico", controleExame.getEspecialidadeMedicoRequisitante());
        cv.put("material_examinar", controleExame.getMaterialExaminar());
        cv.put("tipo_exame", controleExame.getTipoExame());
        cv.put("data_realizacao", controleExame.getDataRealizacaoString());

        banco.insert("ControleExame", null, cv);
    }

    public void deletarControleExame(int controleExameId){

        String sql = "DELETE FROM ControleExame WHERE " +
                "Id = " + controleExameId + ";";

        this.banco.execSQL(sql);
    }


    public List<ControleExame> getControleExames(int idPaciente)
    {
        List<ControleExame> controleExames = new ArrayList<ControleExame>();

        Paciente paciente = pacienteDAO.localizarPorId(idPaciente);
        String colunas[] = {"id", "idpaciente", "nome_unidade", "endereco_unidade",
                "dados_clinicos", "especialidade_medico", "material_examinar","tipo_exame", "data_realizacao"};

        Cursor c = banco.query("ControleExame", colunas, null, null, null, null, "nome_unidade");


        if(c.getCount() > 0)
        {
            c.moveToFirst();
            do{
                int idControleExame = c.getInt(c.getColumnIndex("id"));
                String nome_unidade = c.getString(c.getColumnIndex("nome_unidade"));
                String endereco_unidade = c.getString(c.getColumnIndex("endereco_unidade"));
                String dados_clinicos = c.getString(c.getColumnIndex("dados_clinicos"));
                String especialidade_medico = c.getString(c.getColumnIndex("especialidade_medico"));
                String material_examinar = c.getString(c.getColumnIndex("material_examinar"));
                String tipo_exame = c.getString(c.getColumnIndex("tipo_exame"));
                long data_realizacao = c.getLong(c.getColumnIndex("data_realizacao"));

                controleExames.add(new ControleExame(idControleExame,nome_unidade, endereco_unidade, paciente,
                        dados_clinicos, especialidade_medico, material_examinar, tipo_exame, data_realizacao));
            } while(c.moveToNext());
        }

        return controleExames;
    }

    public ControleExame getById(int idExame, int idPaciente)
    {
        Cursor cursor = banco.rawQuery("SELECT * from ControleExame where id=" + idExame, null);

        if(cursor.getCount() <= 0)
            return null;

        cursor.moveToFirst();

        String nome_unidade = cursor.getString(cursor.getColumnIndex("nome_unidade"));
        String endereco_unidade = cursor.getString(cursor.getColumnIndex("endereco_unidade"));
        Paciente paciente = pacienteDAO.localizarPorId(idPaciente);
        String dados_clinicos = cursor.getString(cursor.getColumnIndex("dados_clinicos"));
        String especialidade_medico = cursor.getString(cursor.getColumnIndex("especialidade_medico"));
        String material_examinar = cursor.getString(cursor.getColumnIndex("material_examinar"));
        String tipo_exame = cursor.getString(cursor.getColumnIndex("tipo_exame"));
        long data_realizacao = cursor.getLong(cursor.getColumnIndex("data_realizacao"));

        ControleExame controleExame = new ControleExame(nome_unidade, endereco_unidade, paciente,
                dados_clinicos, especialidade_medico, material_examinar, tipo_exame, data_realizacao);

        return controleExame;
    }
}