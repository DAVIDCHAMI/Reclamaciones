package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionVehiculoTercero {

  private String placaTercero;
  private String taller;

  private List<ExposicionVehiculoTercero> lstExposicionTercero = new ArrayList<>();

  public ExposicionVehiculoTercero() {
    super();
  }

  private ExposicionVehiculoTercero(Map<String, String> datosExposicionTercero) {
    this.placaTercero = datosExposicionTercero.get("placaTercero");
    this.taller = datosExposicionTercero.get("taller");
  }

  public ExposicionVehiculoTercero(List<Map<String, String>> datosTerceroAuto) {
    asignarDatos(datosTerceroAuto);
  }

  public List<ExposicionVehiculoTercero> getLstExposicionTerceros() {
    return lstExposicionTercero;
  }

  public String getTaller() {
    return taller;
  }

  public String getPlacaTercero() {
    return placaTercero;
  }

  private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
    for (Map<String, String> dato : datosTerceroAuto) {
      lstExposicionTercero.add(new ExposicionVehiculoTercero(dato));
    }
  }
}
