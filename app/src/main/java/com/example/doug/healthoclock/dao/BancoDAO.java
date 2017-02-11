package com.example.doug.healthoclock.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

/**
 * Created by Doug on 08/02/2017.
 */

public class BancoDAO {
    private SQLiteDatabase banco;

    public BancoDAO(Context context) throws IOException {

        this.banco = new BancoHelp(context).getWritableDatabase();
    }
}
