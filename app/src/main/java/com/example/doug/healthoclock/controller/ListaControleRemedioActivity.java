package com.example.doug.healthoclock.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.dao.ControleRemedioDAO;
import com.example.doug.healthoclock.model.ControleRemedio;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ListaControleRemedioActivity extends AppCompatActivity {
    private ListView listViewRemedios;
    private ControleRemedioDAO controleRemedioDAO;
    private List<ControleRemedio> controlesRemedios;
    private SearchView searchRemedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_remedios_layout);

        this.controleRemedioDAO = new ControleRemedioDAO(this);
        this.controlesRemedios = new ArrayList<ControleRemedio>();

        //Carregamento da ListView com a lista de remédios do Paciente
        this.controlesRemedios = controleRemedioDAO.getControlesRemediosPorPaciente(1);

        if (controlesRemedios != null) {
            this.listViewRemedios = (ListView) findViewById(R.id.listViewRemedios);
            RemedioListViewAdapter adapter = new RemedioListViewAdapter(this, this.controlesRemedios);
            this.listViewRemedios.setAdapter(adapter);
            this.listViewRemedios.setOnItemClickListener(new OnClickItem());
        }else{
            Toast.makeText(ListaControleRemedioActivity.this,"Você não tem remédios cadastrados!",Toast.LENGTH_LONG).show();
        }


        //Adicionar listener de busca dinâmica ao SearchView
//        this.searchRemedio = (SearchView) findViewById(R.id.searchRemedio);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchRemedio.setOnQueryTextListener(new BuscaDinamica());
//        searchRemedio.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        FloatingActionButton botaoAdicionar = (FloatingActionButton) findViewById(R.id.btnAdicionarRemedio);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaControleRemedioActivity.this,CadastroControleRemedioActivity.class);
                startActivity(intent);
            }
        });

    }

    private class OnClickItem implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ControleRemedio controleRemedio = ListaControleRemedioActivity.this.controlesRemedios.get(position);
            Intent intent = new Intent(ListaControleRemedioActivity.this, SingleRemedioActivity.class);
            intent.putExtra("controleRemedioId", controlesRemedios.get(position).getId());
            Log.i("HEALTH","Id: " + String.valueOf(controlesRemedios.get(position).getId()));
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
