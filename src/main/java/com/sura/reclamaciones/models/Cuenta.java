package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cuenta {

  private List<Cuenta> lstCuenta = new ArrayList<>();

  private String titularCuenta;
  private String nombreBanco;
  private String numeroCuenta;
  private String tipoCuenta;

  public Cuenta() {}

  private Cuenta(Map<String, String> datosCuenta) {

    this.titularCuenta = datosCuenta.get("titularCuenta");
    this.nombreBanco = datosCuenta.get("nombreBanco");
    this.numeroCuenta = datosCuenta.get("numeroCuenta");
    this.tipoCuenta = datosCuenta.get("tipoCuenta");
  }

  public Cuenta(List<Map<String, String>> datosCuenta) {
    asignarDatos(datosCuenta);
  }

  public String getTitularCuenta() {
    return titularCuenta;
  }

  public String getNombreBanco() {
    return nombreBanco;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public List<Cuenta> getLstCuenta() {
    return lstCuenta;
  }

  private void asignarDatos(List<Map<String, String>> datosCuenta) {
    for (Map<String, String> dato : datosCuenta) {
      lstCuenta.add(new Cuenta(dato));
    }
  }
}
