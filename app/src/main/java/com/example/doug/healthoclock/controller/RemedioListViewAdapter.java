package com.example.doug.healthoclock.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.model.ControleRemedio;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Doug on 09/02/2017.
 */

public class RemedioListViewAdapter extends BaseAdapter {
    private List<ControleRemedio> controleRemedios;
    private Context context;

    public RemedioListViewAdapter(Context context, List<ControleRemedio> controleRemedios) {
        this.controleRemedios = controleRemedios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.controleRemedios.size();
    }

    @Override
    public Object getItem(int position) {
        return this.controleRemedios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;
        ControleRemedio controleRemedio = this.controleRemedios.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.item_lista_remedio,null);
            layout.setMinimumHeight(200);
        }else {
            layout = convertView;
        }

        ImageView itemTarja = (ImageView) layout.findViewById(R.id.tarja);
        TextView itemRemedioNome = (TextView) layout.findViewById(R.id.itemRemedioNome);
        TextView itemRemedioDosagem = (TextView) layout.findViewById(R.id.itemRemedioDosagem);
        TextView itemRemedioLaboratorio = (TextView) layout.findViewById((R.id.itemRemedioLaboratorio));

        itemRemedioNome.setText(controleRemedio.getRemedio().getNome());
        itemRemedioLaboratorio.setText(controleRemedio.getRemedio().getLaboratorio());
        itemRemedioDosagem.setText(controleRemedio.getDosagem());



        //Define a cor da tarja que será exibida
        switch (controleRemedio.getTarja()){
            case "Branca": itemTarja.setImageResource(R.color.colorTarjaBranca); break;
            case "Vermelha": itemTarja.setImageResource(R.color.colorTarjaVermelha); break;
            case "Preta": itemTarja.setImageResource(R.color.colorTarjaPreta); break;
        }

        return layout;
    }

}
