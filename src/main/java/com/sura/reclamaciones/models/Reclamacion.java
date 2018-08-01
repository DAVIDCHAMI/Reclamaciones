package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {
  private String origen;
  private String valorPretension;
  private String tipoPoliza;
  private String numPoliza;
  private String fechaSiniestro;
  private String lugar;

  public Reclamacion() {}

  public Reclamacion(Map<String, String> datosReclamacion) {
    this.origen = datosReclamacion.get("origen");
    this.valorPretension = datosReclamacion.get("valorPretension");
    this.fechaSiniestro = datosReclamacion.get("fechaSiniestro");
    this.tipoPoliza = datosReclamacion.get("tipoPoliza");
    this.numPoliza = datosReclamacion.get("numPoliza");
    this.lugar = datosReclamacion.get("lugar");
  }

  public String getOrigen() {
    return origen;
  }

  public String getValorPretension() {
    return valorPretension;
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

  public String getLugar() {
    return lugar;
  }
}
