package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contrato {

  private List<Contrato> lstContrato = new ArrayList<>();
  private String proporcionExcendente;
  private String proporcionCuotaParte;
  private String nombreContrato;
  private String deducibleMinimo;
  private String porcentajeDeducibleminimo;

  public Contrato(Map<String, String> datosReaseguro) {
    this.proporcionExcendente = datosReaseguro.get("proporcionExcedente");
    this.proporcionCuotaParte = datosReaseguro.get("proporcionCuotaParte");
    this.nombreContrato = datosReaseguro.get("nombreContrato");
    this.deducibleMinimo = datosReaseguro.get("deducibleMinimo");
    this.porcentajeDeducibleminimo = datosReaseguro.get("porcentajeDeducibleminimo");
  }

  public Contrato(List<Map<String, String>> datosContrato) {
    asignarDatos(datosContrato);
  }

  public List<Contrato> getLstContrato() {
    return lstContrato;
  }

  public String getProporcionExcendente() {
    return proporcionExcendente;
  }

  public String getProporcionCuotaParte() {
    return proporcionCuotaParte;
  }

  public String getNombreContrato() {
    return nombreContrato;
  }

  public String getDeducibleMinimo() {
    return deducibleMinimo;
  }

  public String getPorcentajeDeducibleminimo() {
    return porcentajeDeducibleminimo;
  }

  private void asignarDatos(List<Map<String, String>> datosContrato) {
    for (Map<String, String> dato : datosContrato) {
      lstContrato.add(new Contrato(dato));
    }
  }
}
