package com.example.doug.healthoclock.controller;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.BancoHelp;
import com.example.doug.healthoclock.dao.RemedioDAO;
import com.example.doug.healthoclock.model.Remedio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemediosActivity extends AppCompatActivity {
    private ListView listView;
    private RemedioDAO remediodao;
    private List<Remedio> remedios;
    private SearchView searchRemedio;
    private RemediosListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedios_layout);

        remediodao = new RemedioDAO(this);

        //Carregamento da ListView com a lista de remédios do Paciente

        this.remedios = new ArrayList<Remedio>();
        remedios = remediodao.getRemedios();

        this.listView = (ListView) findViewById(R.id.listViewRemedios);

        adapter = new RemediosListViewAdapter(this,this.remedios);
        this.listView.setAdapter(adapter);

        //Adicionar listener de busca dinâmica ao SearchView
//        this.searchRemedio = (SearchView) findViewById(R.id.searchRemedio);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchRemedio.setOnQueryTextListener(new BuscaDinamica());
//        searchRemedio.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemediosActivity.this,CadastroControleRemedio.class);
                startActivity(intent);
            }
        });

    }


//    private class BuscaDinamica implements SearchView.OnQueryTextListener{
//
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            return false;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//
//            return false;
//        }
//    }

}
