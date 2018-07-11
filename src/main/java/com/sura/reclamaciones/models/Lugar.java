package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lugar {

    private String lugar;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccion;
    private List<Lugar> lugares = new ArrayList<>();

    public Lugar(){

    }

    public Lugar(Map<String, String> datoLugares){
        this.lugar = datoLugares.get("lugar");
        this.lugar = datoLugares.get("pais");
        this.lugar = datoLugares.get("departamento");
        this.lugar = datoLugares.get("ciudad");
        this.lugar = datoLugares.get("direccion");
    }

    public Lugar(List<Map<String, String>> datosLugar){
        asignarDatos(datosLugar);
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public String getLugar() {
        return lugar;
    }

    public String getPais() {
        return pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void asignarDatos(List<Map<String, String>> datosLugares){
        for (Map<String, String> dato : datosLugares){
            lugares.add(new Lugar(dato));
        }
    }
}
