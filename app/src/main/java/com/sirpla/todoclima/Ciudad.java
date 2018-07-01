package com.sirpla.todoclima;

public class Ciudad {
    private long id;
    private String nombreCiudad;
    private float temperatura;
    private String nombreImagen;
    private double longitud;
    private double latitud;
    private double presion;
    private double humedad;
    private double tMinima;
    private double tMaxima;
    private double visibilidad;
    private double velocidadViento;

    public Ciudad(){
        this.id=0;
        this.nombreCiudad="";
        this.temperatura=0;
        this.nombreImagen="";
        this.longitud=0;
        this.latitud=0;
        this.presion=0;
        this.humedad=0;
        this.tMinima=0;
        this.tMaxima=0;
        this.visibilidad=0;
        this.velocidadViento=0;

    }

    public Ciudad(long Id, String nombreCiudad, float temperatura, String nombreImagen,
                  double longitud, double latitud, double presion, double humedad, double tMinima,
                  double tMaxima, double visibilidad, double velocidadViento){
        this.id=id;
        this.nombreCiudad=nombreCiudad;
        this.temperatura=temperatura;
        this.nombreImagen=nombreImagen;
        this.longitud=longitud;
        this.latitud=latitud;
        this.presion=presion;
        this.humedad=humedad;
        this.tMinima=tMinima;
        this.tMaxima=tMaxima;
        this.visibilidad=visibilidad;
        this.velocidadViento=velocidadViento;
    }

    public long getId(){
        return this.id;
    }

    public String getNombreCiudad(){
        return this.nombreCiudad;
    }

    public float getTemperatura(){
        return this.temperatura;
    }

    public String getNombreImagen(){
        return this.nombreImagen;
    }

    public double getLongitud(){return  this.longitud;}

    public double getLatitud() {return this.latitud;}

    public double getPresion() {return this.presion;}

    public double getHumedad(){return this.humedad;}

    public double gettMinima(){return this.tMinima;}

    public double gettMaxima(){return this.tMaxima;}

    public double getVisibilidad(){return this.visibilidad;}

    public double getVelocidadViento(){return this.velocidadViento;}

    public void setId(long id){
        this.id=id;
    }

    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad=nombreCiudad;
    }

    public void setTemperatura(float temperatura){
        this.temperatura=temperatura;
    }

    public void setNombreImagen(String nombreImagen1){
        this.nombreImagen=nombreImagen1;
    }

    public void setLongitud(double longitud){
        this.longitud=longitud;
    }

    public void setLatitud(double latitud){this.latitud=latitud;}

    public void setPresion(double presion){this.presion=presion;}

    public void setHumedad(double humedad){this.humedad=humedad;}

    public void settMinima(double tMinima){this.tMinima=tMinima;}

    public void settMaxima(double tMaxima){this.tMaxima=tMaxima;}

    public void setVisibilidad(double Visiblidad){this.visibilidad=visibilidad;}

    public void setVelocidadViento(double velocidadViento){this.velocidadViento=velocidadViento;}
}
