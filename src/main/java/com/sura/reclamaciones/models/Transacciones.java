package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Transacciones {

  private String numeroReclamacion;
  private String pais;
  private String departamento;
  private String ciudad;
  private String valorTransaccion;
  private String estadoTransaccion;

  public Transacciones() {}

  Transacciones(Map<String, String> datosTransaccion) {
    this.numeroReclamacion = datosTransaccion.get("numeroReclamacion");
    this.pais = datosTransaccion.get("pais");
    this.departamento = datosTransaccion.get("departamento");
    this.ciudad = datosTransaccion.get("ciudad");
    this.valorTransaccion = datosTransaccion.get("valorTransaccion");
    this.estadoTransaccion = datosTransaccion.get("estadoTransaccion");
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
