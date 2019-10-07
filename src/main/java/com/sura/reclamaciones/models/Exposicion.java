package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exposicion {

  private String cobertura;

  private List<Exposicion> lstExposicion = new ArrayList<>();

  public Exposicion() {}

  public Exposicion(List<Map<String, String>> datosExposicion) {
    asignarDatos(datosExposicion);
  }

  public Exposicion(Map<String, String> datosExposicion) {
    this.cobertura = datosExposicion.get("cobertura");
  }

  public String getCobertura() {
    return cobertura;
  }

  public void asignarDatos(List<Map<String, String>> datosExposicion) {
    for (Map<String, String> dato : datosExposicion) {
      lstExposicion.add(new Exposicion(dato));
    }
  }
}
