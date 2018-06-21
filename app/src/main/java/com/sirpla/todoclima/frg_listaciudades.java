package com.sirpla.todoclima;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class frg_listaciudades extends Fragment {


    public frg_listaciudades() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View fragCiudad =inflater.inflate(R.layout.frg_listaciudades, container, false);


        return fragCiudad;
    }

}
