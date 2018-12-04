package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposiciones {

  private String exposicionAutomatica;
  private String columnaDevolver;

  private List<Exposiciones> lstExposiciones = new ArrayList<>();

  public Exposiciones() {
    super();
  }

  private Exposiciones(Map<String, String> datosExposicionAutomaticaReservaAutomatica) {
    this.exposicionAutomatica =
        datosExposicionAutomaticaReservaAutomatica.get("exposicionAutomatica");
    this.columnaDevolver = datosExposicionAutomaticaReservaAutomatica.get("columnaDevolver");
  }

  public Exposiciones(List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    asignarDatos(datosExposicionAutomaticaReservaAutomatica);
  }

  public List<Exposiciones> getLstExposiciones() {
    return lstExposiciones;
  }

  public String getExposicionAutomatica() {
    return exposicionAutomatica;
  }

  public String getColumnaDevolver() {
    return columnaDevolver;
  }

  private void asignarDatos(List<Map<String, String>> datosExposicionAutomaticaReservaAutomatica) {
    for (Map<String, String> dato : datosExposicionAutomaticaReservaAutomatica) {
      lstExposiciones.add(new Exposiciones(dato));
    }
  }
}
