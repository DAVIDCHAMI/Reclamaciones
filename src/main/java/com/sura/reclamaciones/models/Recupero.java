package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recupero extends Transacciones {
  private List<Recupero> lstRecupero = new ArrayList<>();
  private String pagador;
  private String lineaRecupero;
  private String categoriaRecupero;
  private String fechaComprobante;

  public Recupero() {}

  private Recupero(Map<String, String> datosRecupero) {
    this.pagador = datosRecupero.get("pagador");
    this.lineaRecupero = datosRecupero.get("lineaReserva");
    this.categoriaRecupero = datosRecupero.get("categoriaRecupero");
    this.fechaComprobante = datosRecupero.get("fechaComprobante");
  }

  public Recupero(List<Map<String, String>> datosRecupero) {
    asignarDatos(datosRecupero);
  }

  public String getPagador() {
    return pagador;
  }

  public String getLineaRecupero() {
    return lineaRecupero;
  }

  public String getCategoriaRecupero() {
    return categoriaRecupero;
  }

  public String getFechaComprobante() {
    return fechaComprobante;
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
