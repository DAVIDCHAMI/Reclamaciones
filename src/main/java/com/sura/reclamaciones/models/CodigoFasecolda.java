package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodigoFasecolda {
  private String claseVehiculo;
  private String modelo;
  private String marca;
  private String linea;

  private List<CodigoFasecolda> lstCodigoFasecolda = new ArrayList<>();

  public CodigoFasecolda() {}

  public CodigoFasecolda(List<Map<String, String>> datosCodigoFasecolda) {
    asignarDatos(datosCodigoFasecolda);
  }

  public CodigoFasecolda(Map<String, String> datosCodigoFasecolda) {
    this.claseVehiculo = datosCodigoFasecolda.get("claseVehiculo");
    this.modelo = datosCodigoFasecolda.get("modelo");
    this.marca = datosCodigoFasecolda.get("marca");
    this.linea = datosCodigoFasecolda.get("linea");
  }

  public List<CodigoFasecolda> getLstCodigoFasecolda() {
    return lstCodigoFasecolda;
  }

  public String getClaseVehiculo() {
    return claseVehiculo;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getLinea() {
    return linea;
  }

  public void asignarDatos(List<Map<String, String>> datosCodigoFasecolda) {
    for (Map<String, String> dato : datosCodigoFasecolda) {
      lstCodigoFasecolda.add(new CodigoFasecolda(dato));
    }
  }
}
