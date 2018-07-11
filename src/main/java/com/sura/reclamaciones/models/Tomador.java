package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tomador extends Persona {

  private double porcentajeParticipacion;
  private List<Tomador> lstTomadores = new ArrayList<>();

  public double getPorcentajeParticipacion() {
    return porcentajeParticipacion;
  }

  private void setPorcentajeParticipacion(String porcentajeParticipacion) {
    this.porcentajeParticipacion = Double.parseDouble(porcentajeParticipacion);
  }

  public List<Tomador> getLstTomadores() {
    return lstTomadores;
  }

  public Tomador() {
    super();
  }

  public Tomador(Map<String, String> datosTomador) {
    super(datosTomador);
    setPorcentajeParticipacion(datosTomador.get("porcentajeParticipacion"));
  }

  public Tomador(List<Map<String, String>> datosTomadores) {
    super();
    setPorcentajeParticipacion("0");
    asignarDatos(datosTomadores);
  }

  private void asignarDatos(List<Map<String, String>> datosTomadores) {
    for (Map<String, String> dato : datosTomadores) {
      lstTomadores.add(new Tomador(dato));
    }
  }
}
