package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {
  private String origen;
  private String tipoPoliza;
  private String numPoliza;
  private String fechaSiniestro;
  private String lugar;
  private String reservaTransaccion;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;

  public Reclamacion() {}

  public Reclamacion(Map<String, String> datosReclamacion) {
    this.origen = datosReclamacion.get("origen");
    this.fechaSiniestro = datosReclamacion.get("fechaSiniestro");
    this.tipoPoliza = datosReclamacion.get("tipoPoliza");
    this.numPoliza = datosReclamacion.get("numPoliza");
    this.lugar = datosReclamacion.get("lugar");
    this.reservaTransaccion = datosReclamacion.get("reservaTransaccion");
    this.departamento = datosReclamacion.get("departamento");
    this.ciudad = datosReclamacion.get("ciudad");
    this.direccion = datosReclamacion.get("direccion");
    this.tipoDireccion = datosReclamacion.get("tipoDireccion");
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
}
