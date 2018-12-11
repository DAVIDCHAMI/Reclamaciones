package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionesAutomaticasAutos {

  private String exposicionAutomatica;
  private String columnaDevolverTablaExposiciones;

  private List<ExposicionesAutomaticasAutos> lstExposiciones = new ArrayList<>();

  public ExposicionesAutomaticasAutos() {
    super();
  }

  private ExposicionesAutomaticasAutos(
      Map<String, String> datosExposicionAutomaticaReservaAutomatica) {
    this.exposicionAutomatica =
        datosExposicionAutomaticaReservaAutomatica.get("exposicionAutomatica");
    this.columnaDevolverTablaExposiciones =
        datosExposicionAutomaticaReservaAutomatica.get("columnaDevolverTablaExposiciones");
  }

  public ExposicionesAutomaticasAutos(
      List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    asignarDatos(datosExposicionAutomaticaReservaAutomatica);
  }

  public List<ExposicionesAutomaticasAutos> getLstExposiciones() {
    return lstExposiciones;
  }

  public String getExposicionAutomatica() {
    return exposicionAutomatica;
  }

  public String getColumnaDevolverTablaExposiciones() {
    return columnaDevolverTablaExposiciones;
  }

  private void asignarDatos(List<Map<String, String>> datosExposicionAutomatica) {
    for (Map<String, String> dato : datosExposicionAutomatica) {
      lstExposiciones.add(new ExposicionesAutomaticasAutos(dato));
    }
  }
}
