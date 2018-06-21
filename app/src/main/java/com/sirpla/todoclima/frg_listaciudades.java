package com.sirpla.todoclima;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


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

    //TODO "Escribir el armado de la lista"

    //TODO "Escribir el click de la lista"

    //Aqui defino el AsyncTask
    public class LeerClimaInternet extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute(){
            dialog = ProgressDialog.show(getContext(), "Por favor espere...", "Descargando clima...", true);
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(String... urls) {
            InputStream streamDeIngreso=null;                   //Inicializo un inputStream
            String resultado="";                                //Inicializo una variable resultado
            try{                                                //Inicializo un manejo de errores
                streamDeIngreso=new URL(urls[0]).openStream();  //Abro el inputStream
                if(streamDeIngreso != null){                    //Si el inputStream tiene datos
                    //comienza la lectura
                    BufferedReader lectura = new BufferedReader(new InputStreamReader(streamDeIngreso));
                    String linea="";
                    int i=0;
                    while((linea=lectura.readLine())!=null){
                        resultado+=linea;
                    }
                    streamDeIngreso.close();
                } else {
                    //Error
                }
            }catch(Exception E){
                //Error
                Toast.makeText(getContext(),E.getMessage(),Toast.LENGTH_LONG).show();
            }
            return resultado;                   //Retorno la variable Resultado
        }

        @Override
        protected void onPostExecute(String resultado){
            dialog.cancel();
            try{
                JSONObject json = new JSONObject(resultado);        //Transformo en un objeto Json el texto obtenido

                String jsonCode = json.getString("Cod");        //busco el codigo inidicado

                    JSONArray datosclima = json.getJSONArray("weather");    //armo array con los datos identificados por weather

                    JSONObject clima = new JSONObject("main");          //guardo los datos del clime



                //aqui comienzo a levantar los datos del Json y a trabajar con ellos. En este caso abria que
                //pasarlos al ArrayList de Clase Ciudad

                //TODO "Asignar los datos del clima del Json a los datos de la clase en el ArrayList



            }catch (Exception E){
                Toast.makeText(getContext(),E.getMessage(),Toast.LENGTH_LONG).show();
            }

        }
    }

}
