package com.sirpla.todoclima;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class miadaptador extends BaseAdapter {

    private Activity contexto;
    private ArrayList<Ciudad> localciudad;

    private LayoutInflater inflador = null;


    miadaptador(Activity a, ArrayList<Ciudad> p) {

        this.contexto = a;
        this.localciudad = p;

        inflador = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {return localciudad.size();}

    @Override
    public Object getItem(int position) {return localciudad.get(position); }

    @Override
    public long getItemId(int position) {return localciudad.get(position).getId(); }

    @Override
    public View getView(int position, View vi, ViewGroup parent) {

        View customRow = inflador.inflate( R.layout.listrow_ciudades, null);

        Ciudad ciudad = localciudad.get(position);

        TextView nombreCiudad = customRow.findViewById(R.id.txt_NombreCiudad);
        TextView temperatura = customRow.findViewById(R.id.txt_Temperatura);
        ImageView foto = customRow.findViewById(R.id.img_IconoClima);

        nombreCiudad.setText(ciudad.getNombreCiudad());
        temperatura.setText(Float.toString( ciudad.getTemperatura()));
        foto.setImageResource(contexto.getResources().getIdentifier(
                ciudad.getNombreImagen(),"drawable",  contexto.getPackageName()));

        return customRow;
    }
}
