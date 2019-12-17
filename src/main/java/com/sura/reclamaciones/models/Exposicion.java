package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposicion {

  private String tipoExposicion;
  private String codigoTipoExposicion;
  private String cobertura;
  private String codigoTipoCobertura;
  private String subTipoCobertura;
  private String codigoSubTipoCobertura;

  private List<Exposicion> lstExposicion = new ArrayList<>();

  public Exposicion() {}

  public Exposicion(List<Map<String, String>> datosExposicion) {
    asignarDatos(datosExposicion);
  }

  public Exposicion(Map<String, String> datosExposicion) {
    this.tipoExposicion = datosExposicion.get("tipoExposicion");
    this.codigoTipoExposicion = datosExposicion.get("exposureType");
    this.cobertura = datosExposicion.get("cobertura");
    this.codigoTipoCobertura = datosExposicion.get("coverageType");
    this.subTipoCobertura = datosExposicion.get("subtipoCobertura");
    this.codigoSubTipoCobertura = datosExposicion.get("coverageSubtype");
  }

  public List<Exposicion> getLstExposicion() {
    return lstExposicion;
  }

  public String getTipoExposicion() {
    return tipoExposicion;
  }

  public String getCodigoTipoExposicion() {
    return codigoTipoExposicion;
  }

  public String getCobertura() {
    return cobertura;
  }

  public String getCodigoTipoCobertura() {
    return codigoTipoCobertura;
  }

  public String getSubtipoCobertura() {
    return subTipoCobertura;
  }

  public String getCodigoSubTipoCobertura() {
    return codigoSubTipoCobertura;
  }

  public void asignarDatos(List<Map<String, String>> datosExposicion) {
    for (Map<String, String> dato : datosExposicion) {
      lstExposicion.add(new Exposicion(dato));
    }
  }
}
