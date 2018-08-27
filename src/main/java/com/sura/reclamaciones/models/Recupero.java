package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recupero {
  private List<Recupero> lstRecupero = new ArrayList<>();
  private String numeroReclamacion;
  private String pagador;
  private String lineaRecupero;
  private String moneda;
  private String pais;
  private String departamento;
  private String ciudad;
  private String cantidad;
  private String categoriaRecupero;
  private String estadoRecupero;

  public Recupero() {}

  private Recupero(Map<String, String> datosRecupero) {
    this.numeroReclamacion = datosRecupero.get("numeroReclamacion");
    this.pagador = datosRecupero.get("pagador");
    this.lineaRecupero = datosRecupero.get("lineaReserva");
    this.moneda = datosRecupero.get("moneda");
    this.pais = datosRecupero.get("pais");
    this.departamento = datosRecupero.get("departamento");
    this.ciudad = datosRecupero.get("ciudad");
    this.cantidad = datosRecupero.get("cantidad");
    this.categoriaRecupero = datosRecupero.get("categoriaRecupero");
    this.estadoRecupero = datosRecupero.get("estadoRecupero");
  }

  public Recupero(List<Map<String, String>> datosRecupero) {
    asignarDatos(datosRecupero);
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getPagador() {
    return pagador;
  }

  public String getLineaRecupero() {
    return lineaRecupero;
  }

  public String getMoneda() {
    return moneda;
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

  public String getCantidad() {
    return cantidad;
  }

  public String getCategoriaRecupero() {
    return categoriaRecupero;
  }

  public String getEstadoRecupero() {
    return estadoRecupero;
  }

  public List<Recupero> getLstRecupero() {
    return lstRecupero;
  }

  private void asignarDatos(List<Map<String, String>> datosRecupero) {
    for (Map<String, String> dato : datosRecupero) {
      lstRecupero.add(new Recupero(dato));
    }
  }
}
