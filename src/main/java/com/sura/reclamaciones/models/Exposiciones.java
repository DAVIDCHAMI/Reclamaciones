package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposiciones {

  private String exposicionAutomatica;
  private String columnaDevolver;

  public String getExposicionAutomatica() {
    return exposicionAutomatica;
  }

  public String getColumnaDevolver() {
    return columnaDevolver;
  }

  public Exposiciones() {
    super();
  }

  private List<Exposiciones> lstExposiciones = new ArrayList<>();

  public List<Exposiciones> getLstExposiciones() {
    return lstExposiciones;
  }

  private Exposiciones(Map<String, String> datosExposicionAutomaticaReservaAutomatica) {
    this.exposicionAutomatica =
        datosExposicionAutomaticaReservaAutomatica.get("exposicionAutomatica");
    this.columnaDevolver = datosExposicionAutomaticaReservaAutomatica.get("columnaDevolver");
  }

  public Exposiciones(List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    asignarDatos(datosExposicionAutomaticaReservaAutomatica);
  }

  private void asignarDatos(List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    for (Map<String, String> dato : datosExposicionAutomaticaReservaAutomatica) {
      lstExposiciones.add(new Exposiciones(dato));
    }
  }
}
