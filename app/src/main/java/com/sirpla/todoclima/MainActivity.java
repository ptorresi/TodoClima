package com.sirpla.todoclima;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    private static final int FRAG_LISTA  = 0;
    private static final int FRAG_DETAIL = 1;

    frg_listaciudades fragmentList;
    frg_detalleclimaciudad fragmentDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        setupfrag(FRAG_LISTA);


    }

    private void setupfrag(int tipoFrag){


    fragmentDetail = new frg_detalleclimaciudad();
    fragmentList = new frg_listaciudades();

    FragmentTransaction transaction =
            getSupportFragmentManager().beginTransaction();

    if (tipoFrag==FRAG_LISTA)
        transaction.add(R.id.frgm_Principal, fragmentList, "frag_list");
    else
        transaction.add(R.id.frgm_Principal, fragmentDetail, "frag_detail");


    transaction.commit();
}

}
