package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposicion
{

    private String tipoExposicion;
    private String exposureType;
    private String cobertura;
    private String coverageType;
    private String subTipoCobertura;
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
        this.subTipoCobertura = datosExposicion.get("subtipoCobertura");
        this.coverageSubtype = datosExposicion.get("coverageSubtype");
    }

    public List<Exposicion> getLstExposicion() {
        return lstExposicion;
    }

    public String getTipoExposicion() {
        return tipoExposicion;
    }

    public String getExposureType() {
        return exposureType;
    }

    public String getCobertura() {
        return cobertura;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public String getSubtipoCobertura() {
        return subTipoCobertura;
    }

    public String getCoverageSubtype() {
        return coverageSubtype;
    }

    public void asignarDatos(List<Map<String, String>> datosExposicion) {
        for (Map<String, String> dato : datosExposicion) {
            lstExposicion.add(new Exposicion(dato));
        }
    }
}
