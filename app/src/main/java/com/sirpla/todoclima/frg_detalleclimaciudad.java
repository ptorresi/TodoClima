package com.sirpla.todoclima;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class frg_detalleclimaciudad extends Fragment {

    private long id;
    private String nombreCiudad;
    private Float temperatura;
    private String nombreImagen;
    private double longitud;
    private double latitud;
    private double presion;
    private double humedad;
    private double tMinima;
    private double tMaxima;
    private double visibilidad;
    private double velocidadViento;

    public frg_detalleclimaciudad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            id = arguments.getLong("id");
            nombreCiudad=arguments.getString( "nombreCiudad" );
            temperatura=arguments.getFloat( "temperatura" );
            nombreImagen=arguments.getString( "nombreImagen" );
            longitud=arguments.getDouble( "longitud" );
            latitud=arguments.getDouble( "latitud" );
            presion=arguments.getDouble("presion");
            humedad=arguments.getDouble( "humedad" );
            tMinima=arguments.getDouble( "tMinima" );
            tMaxima=arguments.getDouble( "tMaxima" );
            visibilidad=arguments.getDouble( "visibilidad" );
            velocidadViento=arguments.getDouble( "velocidadViento" );
        }



        // Inflate the layout for this fragment
        View fragDetalleClima = inflater.inflate(R.layout.frg_detalleclimaciudad, container,
                false);

        // Comienzo con la captura de objetos
        TextView NombreCiudad = fragDetalleClima.findViewById( R.id.txt_NombreCiudad );
        ImageView ImagenClima = fragDetalleClima.findViewById( R.id.img_IconoClima );
        TextView Temperatura=fragDetalleClima.findViewById( R.id.txt_Temperatura );
        TextView Latitud=fragDetalleClima.findViewById( R.id.txtlatitud );
        TextView Longitud=fragDetalleClima.findViewById( R.id.txtlongitud );
        TextView Presion = fragDetalleClima.findViewById( R.id.txtPresion );
        TextView Humedad = fragDetalleClima.findViewById( R.id.txthumedad );
        TextView TMinima = fragDetalleClima.findViewById( R.id.txttMinima );
        TextView TMaxima = fragDetalleClima.findViewById( R.id.txttMaxima );
        TextView Visibilidad=fragDetalleClima.findViewById( R.id.txtvisibilidad );
        TextView VelocidadViento=fragDetalleClima.findViewById( R.id.txtvelocidadViento );


        // Muestro los valores
        NombreCiudad.setText( nombreCiudad );
        ImagenClima.setImageResource(getActivity().getResources().getIdentifier(
                nombreImagen,"drawable",  getActivity().getPackageName()));
        Temperatura.setText( Float.toString( temperatura ) );
        Latitud.setText( Double.toString( latitud ) );
        Longitud.setText( Double.toString( longitud ) );
        Presion.setText( Double.toString( presion ) );
        Humedad.setText( Double.toString( humedad ) );
        TMinima.setText( Double.toString( tMinima ));
        TMaxima.setText( Double.toString( tMaxima ) );
        Visibilidad.setText( Double.toString( visibilidad ) );
        VelocidadViento.setText( Double.toString( velocidadViento ) );

        return fragDetalleClima;

    }

}
