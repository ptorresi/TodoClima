package com.sirpla.todoclima;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity implements OnCiudadSelectedFromTheList{

    private static final int FRAG_LISTA  = 0;
    private static final int FRAG_DETAIL = 1;

    private static final Integer PORTRAIT_LAYOUT_MODE   = 1;
    private static final Integer LANDSCAPE_LAYOUT_MODE  = 2;

    private Integer layoutMode = PORTRAIT_LAYOUT_MODE;

    frg_listaciudades fragmentList;
    frg_detalleclimaciudad fragmentDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d( "mainActivity", "onCreate: Ingreso" );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);



        setupfrag(FRAG_LISTA);


    }

    private void setupfrag(int tipoFrag){
        Log.d( "mainActivity", "setupfrag: Ingreso" );

        fragmentDetail = new frg_detalleclimaciudad();
        fragmentList = new frg_listaciudades();

        FragmentTransaction transaction =
            getSupportFragmentManager().beginTransaction();

        if (tipoFrag==FRAG_LISTA)
            transaction.add(R.id.frm_FragmentMain, fragmentList, "LISTACIUDAD");
        else
            transaction.add(R.id.frm_FragmentMain, fragmentDetail, "DETALLECLIMA");


        transaction.commit();
    }


    //TODO "(MAINACTIVITY)-METODO QUE SE UTILIZA PARA COMUNICACION ENTRE FRAGMENTS"


    @Override
    public void OnCiudadSelectedFromTheList(Ciudad C) {
        Bundle args = new Bundle();
        args.putLong("ID", C.getId());
        args.putString("nombreCiudad",C.getNombreCiudad());
        args.putFloat( "temperatura",C.getTemperatura() );
        args.putString("nombreImagen",C.getNombreImagen());
        args.putDouble( "longitud",C.getLongitud() );
        args.putDouble( "latitud",C.getLatitud() );
        args.putDouble( "presion", C.getPresion() );
        args.putDouble( "humedad",C.getHumedad() );
        args.putDouble( "tMinima",C.gettMinima() );
        args.putDouble( "tMaxima",C.gettMinima() );
        args.putDouble("visibilidad",C.getVisibilidad());
        args.putDouble( "velocidadViento",C.getVelocidadViento() );



        if (layoutMode != LANDSCAPE_LAYOUT_MODE) {

            frg_detalleclimaciudad fragment = new frg_detalleclimaciudad();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frm_FragmentMain, fragment,"DETALLECLIMA")
                    .commit();
        }
        //else {

            //Intent i = new Intent(this, DetailActivity.class);
            //i.putExtra("args", args);
            //startActivity(i);
        //}
    }

    @Override
    public void onBackPressed()
    {
        if(getSupportFragmentManager().findFragmentByTag( "DETALLECLIMA" )!= null ) {

            getSupportFragmentManager().beginTransaction().replace( R.id.frm_FragmentMain,
                    fragmentList, "LISTACIUDAD" ).commit();


        }else
                super.onBackPressed();
        }
    }

