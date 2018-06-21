package com.sirpla.todoclima;

public class Ciudad {
    private Integer id;
    private String nombreCiudad;
    private String temperatura;
    private String nombreImagen;

    public Ciudad(){
        this.id=0;
        this.nombreCiudad="";
        this.temperatura="";
        this.nombreImagen="";

    }

    public Ciudad(int Id, String nombreCiudad, String temperatura, String nombreImagen){
        this.id=id;
        this.nombreCiudad=nombreCiudad;
        this.temperatura=temperatura;
        this.nombreImagen=nombreImagen;
    }

    public Integer getId(){
        return this.id;
    }

    public String getNombreCiudad(){
        return this.nombreCiudad;
    }

    public String getTemperatura(){
        return this.temperatura;
    }

    public String getNombreImagen(){
        return this.nombreImagen;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad=nombreCiudad;
    }

    public void setTemperatura(String temperatura){
        this.temperatura=temperatura;
    }

    public void setNombreImagen(String nombreImagen1){
        this.nombreImagen=nombreImagen1;
    }
}
