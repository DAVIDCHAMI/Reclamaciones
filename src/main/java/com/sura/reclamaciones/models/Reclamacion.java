package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {
  private String origen;
  private String tipoPoliza;
  private String numPoliza;
  private String fechaSiniestro;
  private String lugar;
  private String reservaTransaccion;

  public Reclamacion() {}

  public Reclamacion(Map<String, String> datosReclamacion) {
    this.origen = datosReclamacion.get("origen");
    this.fechaSiniestro = datosReclamacion.get("fechaSiniestro");
    this.tipoPoliza = datosReclamacion.get("tipoPoliza");
    this.numPoliza = datosReclamacion.get("numPoliza");
    this.lugar = datosReclamacion.get("lugar");
    this.reservaTransaccion = datosReclamacion.get("reservaTransaccion");
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

  public String getLugar() {
    return lugar;
  }

  public String getReservaTransaccion() {
    return reservaTransaccion;
  }
}
