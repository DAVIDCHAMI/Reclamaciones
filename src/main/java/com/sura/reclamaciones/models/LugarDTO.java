package com.sura.reclamaciones.models;

import cucumber.api.java.it.Ma;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LugarDTO {

    private String lugar;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccion;
    private List<LugarDTO> lugares = new ArrayList<>();

    public LugarDTO(){

    }

    public LugarDTO(Map<String, String> datoLugares){
        this.lugar = datoLugares.get("lugar");
        this.lugar = datoLugares.get("pais");
        this.lugar = datoLugares.get("departamento");
        this.lugar = datoLugares.get("ciudad");
        this.lugar = datoLugares.get("direccion");
    }

    public LugarDTO(List<Map<String, String>> datosLugar){
        asignarDatos(datosLugar);
    }

    public List<LugarDTO> getLugares() {
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
            lugares.add(new LugarDTO(dato));
        }
    }
}
