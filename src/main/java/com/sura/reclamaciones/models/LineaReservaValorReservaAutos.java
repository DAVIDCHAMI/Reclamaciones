package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LineaReservaValorReservaAutos {

  private String lineaReserva;
  private String valorReserva;
  private String columnaADevolver;
  private String valorDeducible;

  public String getValorDeducible() {
    return valorDeducible;
  }

  public String getLineaReserva() {
    return lineaReserva;
  }

  public String getValorReserva() {
    return valorReserva;
  }

  public String getColumnaADevolver() {
    return columnaADevolver;
  }

  public LineaReservaValorReservaAutos() {
    super();
  }

  private List<LineaReservaValorReservaAutos> lstLineasReservaValoresReserva = new ArrayList<>();

  public List<LineaReservaValorReservaAutos> getLstLineasReservaValoresReserva() {
    return lstLineasReservaValoresReserva;
  }

  private LineaReservaValorReservaAutos(Map<String, String> datosLineasReservaValoresReserva) {
    this.lineaReserva = datosLineasReservaValoresReserva.get("lineaReserva");
    this.valorReserva = datosLineasReservaValoresReserva.get("valorReserva");
    this.columnaADevolver = datosLineasReservaValoresReserva.get("columnaADevolver");
    this.valorDeducible = datosLineasReservaValoresReserva.get("valorDeducible");
  }

  public LineaReservaValorReservaAutos(List<Map<String, String>> datosLineasReservaValoresReserva) {
    asignarDatos(datosLineasReservaValoresReserva);
  }

  private void asignarDatos(List<Map<String, String>> datosLineasReservaValoresReserva) {
    for (Map<String, String> dato : datosLineasReservaValoresReserva) {
      lstLineasReservaValoresReserva.add(new LineaReservaValorReservaAutos(dato));
    }
  }
}
