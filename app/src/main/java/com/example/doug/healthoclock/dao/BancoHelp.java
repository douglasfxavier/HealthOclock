package com.example.doug.healthoclock.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Doug on 07/02/2017.
 */

public class BancoHelp extends SQLiteOpenHelper{
    private static final String DB_NAME = "health_oclock";
    private Context context;
    private HashMap<Integer,String> scripts = new HashMap<Integer, String>();

    public BancoHelp(Context context) throws IOException {
        super(context,DB_NAME,null,1);
        this.context = context;
        this.scripts.put(0,"script_create_tipouso");
        this.scripts.put(1,"script_create_remedio");
        this.scripts.put(2,"script_create_doenca");
        this.scripts.put(3,"script_create_exame");
        this.scripts.put(4,"script_create_paciente");
        this.scripts.put(5,"script_create_login");
        this.scripts.put(6,"script_insert_remedio");
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        String script;

        for(int i=0; i<scripts.size();i++){
            try {
                script = lerScript(context,scripts.get(i));
                banco.execSQL(script);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//          banco.execSQL("INSERT INTO Remedio VALUES (1,'ORENCIA');");

//        Log.i("HEALTH",script_schema);
//        Log.i("HEALTH",script_dados);
    }



    private String lerScript(Context context, String nome_arquivo) throws IOException {
        String script = "";
        try{
             script = getText(context.getAssets().open(nome_arquivo));

        }catch (IOException e){

        }
        return script;
    }

    private String getText(InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();

        try{
            if (inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                while ((line = bufferedReader.readLine())!= null){
                    stringBuilder.append(line+"\n");
                }
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
