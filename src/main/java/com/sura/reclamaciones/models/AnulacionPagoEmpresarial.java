package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnulacionPagoEmpresarial {

  private List<AnulacionPagoEmpresarial> lstAnulacionPagoEmpresarial =
      new ArrayList<AnulacionPagoEmpresarial>();
  private String numeroReclamacion;
  private String numeroPago;
  private String estadoPrevio;

  public AnulacionPagoEmpresarial() {}

  private AnulacionPagoEmpresarial(Map<String, String> datosPagosEmpresariales) {
    this.numeroReclamacion = datosPagosEmpresariales.get("numeroReclamacion");
    this.numeroPago = datosPagosEmpresariales.get("numeroPago");
    this.estadoPrevio = datosPagosEmpresariales.get("estadoPrevio");
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getNumeroPago() {
    return numeroPago;
  }

  public String getEstadoPrevio() {
    return estadoPrevio;
  }

  public AnulacionPagoEmpresarial(List<Map<String, String>> datosPagosEmpresariales) {
    asignarDatos(datosPagosEmpresariales);
  }

  public List<AnulacionPagoEmpresarial> getLstAnulacionPagoEmpresarialPago() {
    return lstAnulacionPagoEmpresarial;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstAnulacionPagoEmpresarial.add(new AnulacionPagoEmpresarial(dato));
    }
  }
}
