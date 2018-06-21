package com.sirpla.todoclima;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter{
    private Activity contexto;
    private ArrayList<Ciudad> ciudad;

    private LayoutInflater inflador = null;

    public MiAdaptador(Activity a, ArrayList<Ciudad> c){
        this.contexto = a;
        this.ciudad = c;

        inflador = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return ciudad.size();
    }

    @Override
    public Object getItem(int position) {
        return ciudad.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ciudad.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       //TODO "Escribir el metodo getView de MiAdaptador"
        return null;
    }
}
