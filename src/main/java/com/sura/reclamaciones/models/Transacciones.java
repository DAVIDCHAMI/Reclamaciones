package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transacciones {

    private List<Transacciones> lstTransacciones = new ArrayList<Transacciones>();
    private String numeroReclamacion;
    private String pais;
    private String departamento;
    private String ciudad;
    private String valorTransaccion;
    private String estadoTransaccion;


    public Transacciones() {}

    private Transacciones(Map<String, String> datosRecupero) {
        this.numeroReclamacion = datosRecupero.get("numeroReclamacion");
        this.pais = datosRecupero.get("pais");
        this.departamento = datosRecupero.get("departamento");
        this.ciudad = datosRecupero.get("ciudad");
        this.valorTransaccion = datosRecupero.get("valorTransaccion");
        this.estadoTransaccion = datosRecupero.get("estadoTransaccion");
    }

    public Transacciones(List<Map<String, String>> datosTransacciones) {
    }

    public String getNumeroReclamacion() {
        return numeroReclamacion;
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

    public String getValorTransaccion() {
        return valorTransaccion;
    }

    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

}
