package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {

    private String numeroReclamacion;
    private String origen;
    private String tipoPoliza;
    private String numPoliza;
    private String fechaSiniestro;
    private String lugarSiniestro;
    private String reservaTransaccion;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String tipoDireccion;
    private String fechaAvisoSiniestro;
    private String causaPerdida;
    private String descripcionHechosSiniestro;
    private String identificacionAutor;
    private String valorPerdidaSiniestro;
    private String tipoMonedaPoliza;
    private String esPolizaPropiedad;

    public Reclamacion() {
    }

    public Reclamacion(Map<String, String> datosReclamacion) {
        this.numeroReclamacion = datosReclamacion.get("numeroReclamacion");
        this.origen = datosReclamacion.get("origen");
        this.fechaSiniestro = datosReclamacion.get("fechaSiniestro");
        this.tipoPoliza = datosReclamacion.get("tipoPoliza");
        this.numPoliza = datosReclamacion.get("numPoliza");
        this.lugarSiniestro = datosReclamacion.get("lugar");
        this.reservaTransaccion = datosReclamacion.get("reservaTransaccion");
        this.pais = datosReclamacion.get("pais");
        this.departamento = datosReclamacion.get("departamento");
        this.ciudad = datosReclamacion.get("ciudad");
        this.direccion = datosReclamacion.get("direccion");
        this.tipoDireccion = datosReclamacion.get("tipoDireccion");
        this.fechaAvisoSiniestro = datosReclamacion.get("fechaAviso");
        this.causaPerdida = datosReclamacion.get("causaPerdida");
        this.descripcionHechosSiniestro = datosReclamacion.get("descripcionHechos");
        this.identificacionAutor = datosReclamacion.get("idAutor");
        this.valorPerdidaSiniestro = datosReclamacion.get("valorPerdida");
        this.tipoMonedaPoliza = datosReclamacion.get("tipoMoneda");
        this.esPolizaPropiedad = datosReclamacion.get("esPolizaPropiedad");
    }


    public String getNumeroReclamacion() {
        return numeroReclamacion;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public String getNumPoliza() {
        return numPoliza;
    }

    public String getFechaSiniestro() {
        return fechaSiniestro;
    }

    public String getLugarSiniestro() {
        return lugarSiniestro;
    }

    public String getReservaTransaccion() {
        return reservaTransaccion;
    }

    public String getPais() {
        return pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public String getFechaAvisoSiniestro() {
        return fechaAvisoSiniestro;
    }

    public String getCausaPerdida() {
        return causaPerdida;
    }

    public String getDescripcionHechosSiniestro() {
        return descripcionHechosSiniestro;
    }

    public String getIdentificacionAutor() {
        return identificacionAutor;
    }

    public Integer getValorPerdidaSiniestro() {
        return Integer.parseInt(valorPerdidaSiniestro);
    }

    public String getTipoMonedaPoliza() {
        return tipoMonedaPoliza;
    }

    public boolean getEsPolizaPropiedad() {
        return Boolean.parseBoolean(esPolizaPropiedad);
    }
}
