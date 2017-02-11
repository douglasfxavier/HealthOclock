package com.example.doug.healthoclock.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.doug.healthoclock.R;
import com.example.doug.healthoclock.model.Remedio;

import java.util.List;

/**
 * Created by Doug on 09/02/2017.
 */

public class RemediosListViewAdapter extends BaseAdapter {
    private List<Remedio> remedios;
    private Context context;

    public RemediosListViewAdapter(Context context, List<Remedio> remedios) {
        this.remedios = remedios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.remedios.size();
    }

    @Override
    public Object getItem(int position) {
        return this.remedios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;
        Remedio remedio = this.remedios.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.list_view_item_remedios,null);
            layout.setMinimumHeight(200);
        }else {
            layout = convertView;
        }

        FrameLayout tarja = (FrameLayout) layout.findViewById(R.id.tarja);
        TextView itemRemedio = (TextView) layout.findViewById(R.id.itemRemedioTextView);

        itemRemedio.setText(remedio.getNome());

        return layout;
    }


}
