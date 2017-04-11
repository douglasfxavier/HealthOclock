package com.example.doug.healthoclock.controller;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.model.ControleExame;
import com.example.doug.healthoclock.dao.ControleExameDAO;

import java.util.List;

public class ListaControleExameActivity extends AppCompatActivity {
    private List<ControleExame> controlesExames;
    private ListView listViewExames;
    private ControleExameDAO controleExameDAO;
    private FloatingActionButton botaoAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_exames_layout);

        controleExameDAO = new ControleExameDAO(this);
        controlesExames = controleExameDAO.getControleExames(1);

        if (controlesExames != null) {
            this.listViewExames = (ListView) findViewById(R.id.listView);
            ExameListViewAdapter adapter = new ExameListViewAdapter(this, controlesExames);
            this.listViewExames.setAdapter(adapter);
        }else{
            Toast.makeText(this,"Você não tem exames cadastrados ainda!",Toast.LENGTH_SHORT).show();
        }

        this.listViewExames.setOnItemClickListener(new OnClickItem());

        botaoAdicionar = (FloatingActionButton) findViewById(R.id.btnAdicionarExame);
        botaoAdicionar.setOnClickListener(new OnClickBotao());
    }

    @Override
    public void onResume() {
        super.onResume();

        controlesExames = controleExameDAO.getControleExames(1);
        ExameListViewAdapter adapter = new ExameListViewAdapter(this, controlesExames);
        listViewExames.setAdapter(adapter);
    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListaControleExameActivity.this, CadastroControleExameActivity.class);
            startActivity(intent);
        }
    }

    private class OnClickItem implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ControleExame controleExame = ListaControleExameActivity.this.controlesExames.get(position);
            Intent intent = new Intent(ListaControleExameActivity.this, SingleExameActivity.class);
            intent.putExtra("controleExameId", controlesExames.get(position).getId());

            startActivity(intent);
        }
    }

}
