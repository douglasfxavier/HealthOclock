package com.example.doug.healthoclock.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.model.ControleExame;

import java.util.List;

/**
 * Created by Cida on 09/02/2017.
 */

public class ExameListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ControleExame> lista;
    private final Activity activity;

    public ExameListViewAdapter(Activity activity, List<ControleExame> lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.item_lista_exame, null);

        ControleExame exame = lista.get(position);

       /* if(position % 2 == 0)
        {
            view.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
        }
        else{
            view.setBackgroundColor(activity.getResources().getColor(R.color.linha_impar));
        }*/

        TextView tipoExame = (TextView) view.findViewById(R.id.itemTipoExame);
        tipoExame.setText(exame.getTipoExame());

//        ImageView imagem = (ImageView) view.findViewById(R.id.itemFoto);
//        imagem.setImageResource(R.drawable.tipo_exame);
//
//        TextView unidade = (TextView) view.findViewById(R.id.inputUnidade);
//        unidade.setText(exame.getNomeUnidadeMedica());
//
//        ImageView imagemU = (ImageView) view.findViewById(R.id.img_unidade);
//        imagemU.setImageResource(R.drawable.ic_casa);
//        if (convertView == null){
//            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = li.inflate(R.layout.exame_layout, null);
//        }
//
//        TextView tv = (TextView) convertView.findViewById(R.id.idCelulaTexto);
//        tv.setText(this.lista.get(position).getTipoExame());
//
//        convertView.setMinimumHeight(80);
//
//        return convertView;

       return view;
    }
}
