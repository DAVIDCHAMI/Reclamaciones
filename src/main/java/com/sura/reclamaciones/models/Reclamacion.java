package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {

  private String origen;
  private String tipoPoliza;
  private String numPoliza;
  private String fechaSiniestro;
  private String lugarSiniestro;
  private String reservaTransaccion;
  private String fechaAvisoSiniestro;
  private String causaSiniestro;
  private String descripcionHechosSiniestro;
  private String identificacionAutor;
  private String valorPerdidaSiniestro;
  private String tipoMonedaPoliza;
  private String esPolizaPropiedad;

  public Reclamacion() {}

  public Reclamacion(Map<String, String> datosReclamacion) {
    this.origen = datosReclamacion.get("origen");
    this.fechaSiniestro = datosReclamacion.get("fechaSiniestro");
    this.tipoPoliza = datosReclamacion.get("tipoPoliza");
    this.numPoliza = datosReclamacion.get("numPoliza");
    this.lugarSiniestro = datosReclamacion.get("lugarSiniestro");
    this.reservaTransaccion = datosReclamacion.get("reservaTransaccion");
    this.fechaAvisoSiniestro = datosReclamacion.get("fechaAviso");
    this.causaSiniestro = datosReclamacion.get("causaPerdida");
    this.descripcionHechosSiniestro = datosReclamacion.get("descripcionHechos");
    this.identificacionAutor = datosReclamacion.get("idAutor");
    this.valorPerdidaSiniestro = datosReclamacion.get("valorPerdida");
    this.tipoMonedaPoliza = datosReclamacion.get("tipoMoneda");
    this.esPolizaPropiedad = datosReclamacion.get("esPolizaPropiedad");
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

  public String getFechaAvisoSiniestro() {
    return fechaAvisoSiniestro;
  }

  public String getCausaSiniestro() {
    return causaSiniestro;
  }

  public String getDescripcionHechosSiniestro() {
    return descripcionHechosSiniestro;
  }

  public String getIdentificacionAutor() {
    return identificacionAutor;
  }

  public Integer getValorPerdidaSiniestro() {
    int valorPerdida = Integer.parseInt(valorPerdidaSiniestro);
    return valorPerdida;
  }

  public String getTipoMonedaPoliza() {
    return tipoMonedaPoliza;
  }

  public boolean getIsPolicyProperty() {
    boolean IsPolicyProperty = Boolean.parseBoolean(esPolizaPropiedad);
    return IsPolicyProperty;
  }
}
