package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposicion {

    private String tipoExposicion;
    private String exposureType;
    private String cobertura;
    private String coverageType;
    private String subtipoCobertura;
    private String coverageSubtype;

    private List<Exposicion> lstExposicion = new ArrayList<>();

    public Exposicion() {}

    public Exposicion(List<Map<String, String>> datosExposicion) {
        asignarDatos(datosExposicion);
    }

    public Exposicion(Map<String, String> datosExposicion) {
        this.tipoExposicion = datosExposicion.get("tipoExposicion");
        this.exposureType = datosExposicion.get("exposureType");
        this.cobertura = datosExposicion.get("cobertura");
        this.coverageType = datosExposicion.get("coverageType");
        this.subtipoCobertura = datosExposicion.get("subtipoCobertura");
        this.coverageSubtype = datosExposicion.get("coverageSubtype");
    }
    public List<Exposicion> getLstExposicion() {
        return lstExposicion;
    }

    public String getTipoExposicion(){return tipoExposicion;}
    public String getexposureType () {return exposureType;}
    public String getcobertura () {return cobertura;}
    public String getcoverageType () {return coverageType;}
    public String getsubtipoCobertura () {return subtipoCobertura;}
    public String getcoverageSubtype () {return coverageSubtype;}

    public void asignarDatos(List<Map<String, String>> datosExposicion) {
        for (Map<String, String> dato : datosExposicion) {
            lstExposicion.add(new Exposicion(dato));
        }
    }
}
