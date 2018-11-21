package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionAutomaticaReservaAutomatica {

  private String exposicionAutomatica;
  private String valorReservaAutomatica;
  private String columnaADevolver;

  public String getExposicionAutomatica() {
    return exposicionAutomatica;
  }

  public String getValorReservaAutomatica() {
    return valorReservaAutomatica;
  }

  public String getColumnaADevolver() {
    return columnaADevolver;
  }

  public ExposicionAutomaticaReservaAutomatica() {
    super();
  }

  private List<ExposicionAutomaticaReservaAutomatica> lstExposicionAutomaticaReservaAutomaticas =
      new ArrayList<>();

  public List<ExposicionAutomaticaReservaAutomatica>
      getLstExposicionAutomaticaReservaAutomaticas() {
    return lstExposicionAutomaticaReservaAutomaticas;
  }

  private ExposicionAutomaticaReservaAutomatica(
      Map<String, String> datosExposicionAutomaticaReservaAutomatica) {
    this.exposicionAutomatica =
        datosExposicionAutomaticaReservaAutomatica.get("exposicionAutomatica");
    this.valorReservaAutomatica =
        datosExposicionAutomaticaReservaAutomatica.get("valorReservaAutomatica");
    this.columnaADevolver = datosExposicionAutomaticaReservaAutomatica.get("columnaADevolver");
  }

  public ExposicionAutomaticaReservaAutomatica(
      List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    asignarDatos(datosExposicionAutomaticaReservaAutomatica);
  }

  private void asignarDatos(List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    for (Map<String, String> dato : datosExposicionAutomaticaReservaAutomatica) {
      lstExposicionAutomaticaReservaAutomaticas.add(
          new ExposicionAutomaticaReservaAutomatica(dato));
    }
  }
}
