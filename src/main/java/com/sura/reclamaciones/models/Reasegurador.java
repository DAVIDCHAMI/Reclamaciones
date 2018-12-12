package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reasegurador {

  private List<Reasegurador> lstReasegurador = new ArrayList<>();
  private String codigoSura;
  private String porcentajeParticipacion;

  public Reasegurador(Map<String, String> datosReasegurador) {
    this.codigoSura = datosReasegurador.get("codigoSura");
    this.porcentajeParticipacion = datosReasegurador.get("porcentajeParticipacion");
  }

  public Reasegurador(List<Map<String, String>> datosReasegurador) {
    asignarDatos(datosReasegurador);
  }

  public List<Reasegurador> getLstReasegurador() {
    return lstReasegurador;
  }

  public String getCodigoSura() {
    return codigoSura;
  }

  public String getPorcentajeParticipacion() {
    return porcentajeParticipacion;
  }

  private void asignarDatos(List<Map<String, String>> datosReasegurador) {
    for (Map<String, String> dato : datosReasegurador) {
      lstReasegurador.add(new Reasegurador(dato));
    }
  }
}
