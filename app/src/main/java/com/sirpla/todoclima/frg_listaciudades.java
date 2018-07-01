package com.sirpla.todoclima;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.PaintFlagsDrawFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frg_listaciudades extends Fragment implements View.OnClickListener {

    private OnCiudadSelectedFromTheList MiListener;
    private ArrayList<Ciudad> listaCiudad = new ArrayList<Ciudad>();
    private String sNombreCiudad ="";
    private View fragCiudad;



    // Required empty public constructor
    public frg_listaciudades() {

    }
    @Override
    public void onAttach(Activity activity){
        Log.d( "frg_listaciudades", "onAttach: Ingreso" );
        super.onAttach( activity );
        try{
            MiListener=(OnCiudadSelectedFromTheList) activity;
        }catch (ClassCastException e){
            throw new ClassCastException( activity.toString() + "...debe implementar onlvw_ciudadeslistener" );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d( "frg_listaciudades", "onCreateView: Ingreso" );
         fragCiudad =inflater.inflate(R.layout.frg_listaciudades, container, false);

        Button botonClima = fragCiudad.findViewById(R.id.btn_AgregarCiudad );
        final ListView lista = fragCiudad.findViewById( R.id.lvw_Ciudades );


        //TODO "(frg_listaciudades) AGREGA ONCLICK LISTENER"
        //TODO "Escribir el click de la lista"
        botonClima.setOnClickListener( this);
        lista.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ciudad C= (Ciudad)parent.getItemAtPosition( position );

                MiListener.OnCiudadSelectedFromTheList( C );
            }
        } );
        Log.d( "frg_listaciudades", "onCreateView: Se setearon los listener para el boton y la lista" );

        armarLista( fragCiudad,getActivity() );
        return fragCiudad;
    }




    @Override
    public void onClick(View v) {
        Log.d( "frg_listaCiudades", "onClick: Ingreso" );
        switch (v.getId()){
            case(R.id.btn_AgregarCiudad): {
                    EditText ciudad = fragCiudad.findViewById( R.id.edt_Ciudad );


                    sNombreCiudad = ciudad.getText().toString();

                    //Si se hace click cuando el EditText esta vacio
                    if (!sNombreCiudad.isEmpty()){

                        Log.d( "frg_listaciudades", "onClick: Si el click es sobre el botón" );


                        try {
                            new LeerClimaInternet().execute( "http://api.openweathermap.org/data/2.5/weather?q=" +
                                    URLEncoder.encode( sNombreCiudad, "utf-8" ) +
                                    "&APPID=4a13a4fcddcc5f1f6547bb9b4852f6fc" );


                        } catch (UnsupportedEncodingException e) {
                            Toast.makeText( getContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
                        }
                        ciudad.setText( "" );
                        ciudad.setFocusable( true );
                    }
                    //armarLista( fragCiudad,getActivity() );
            }
            break;

            default:
                Log.d( "frg_listaciudades", "onClick: Si se hace click sobre otro componente" );
                break;
        }

    }


    //TODO "(frg_listaciudades) METODO QUE ARMA LA LISTA DE CIUDADES"
    private void  armarLista(View v, Activity a){
        ListView listaciudad = v.findViewById( R.id.lvw_Ciudades );
        miadaptador adaptador = new miadaptador(a,listaCiudad );

        listaciudad.setAdapter(adaptador);

    }

    //TODO "(frg_listaciudades)DEFINICION DE ASYNCTASK"
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

        //TODO "(frg_listaciudades) TRATAMIENTO DEL JSON"
        @Override
        protected void onPostExecute(String resultado){
            dialog.cancel();
            try{
                JSONObject json = new JSONObject(resultado);        //Transformo en un objeto Json el texto obtenido

                String jsonCode = json.getString("cod");        //busco el codigo inidicado
                //aqui comienzo a levantar los datos del Json y a trabajar con ellos. En este caso abria que
                //pasarlos al ArrayList de Clase Ciudad

                //Si es 200 quiere decir que el Json se genero correctamente
                if (jsonCode.equals( "200" )){
                    //nodo coordenadas del JSON
                    JSONObject jsoncoord= json.optJSONObject("coord");
                    double longitud = jsoncoord.getDouble( "lon" );
                    double latitud = jsoncoord.getDouble( "lat" );

                    //Vector del datos de clima
                    JSONArray datosclima = json.getJSONArray("weather");                    //armo array con los datos identificados por weather
                    JSONObject posicion = datosclima.getJSONObject( 0 );
                    String icono = posicion.getString( "icon" );
                    String auxicono=icono.substring( 2 );
                    icono=auxicono+icono;

                    //Datos principales del clima
                    JSONObject clima = json.optJSONObject("main");
                    double temperaturaEnKelvin =clima.getDouble( "temp" );
                    float temperaturaKFloat = ((int) temperaturaEnKelvin * 100) / 100;
                    float temperaturaC = (float) (temperaturaKFloat - 273.15);


                    double  presion=clima.getDouble( "pressure" );
                    double humedad=clima.getDouble( "humidity" );
                    double tMinima=clima.getDouble( "temp_min" );
                    double tMaxima=clima.getDouble( "temp_max" );

                    //Visibilidad en metros
                    double visibilidad=0;
                    if (json.has("visibility")) {
                         visibilidad = (json.getDouble( "visibility" ));
                    }
                    //Velocidad del viento
                    double velocidadviento=0;
                    if (json.has( "wind" )) {
                        JSONObject viento = json.optJSONObject( "wind" );
                        velocidadviento = viento.getDouble( "speed" );
                    }
                    //Id de la ciudad
                    long id=json.getLong( "id" );



                    //TODO "(frg_listaciudades)ASIGNACION DE LOS DATOS DEL JSON AL ARRAYLIST DE CIUDAD

                    long cantVector = listaCiudad.size() + 1;
                    listaCiudad.add(new Ciudad(cantVector,sNombreCiudad,temperaturaC,icono,
                            longitud,latitud,presion,humedad,tMinima,tMaxima,visibilidad,
                            velocidadviento ));

                    armarLista( fragCiudad,getActivity() );
                }else{
                    //Si el codigo no es 200 hay un error de generación en el JSON por eso no lo leo
                    Toast.makeText( getContext(),
                            "Error al leer los datos de Internet. Vuelva a Intentarlo",
                            Toast.LENGTH_LONG ).show();
                }


            }catch (Exception E){
                Toast.makeText(getContext(),E.getMessage(),Toast.LENGTH_LONG).show();
            }

        }


    }



}
