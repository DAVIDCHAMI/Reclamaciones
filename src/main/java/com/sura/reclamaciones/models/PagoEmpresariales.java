package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoEmpresariales {

  private List<PagoEmpresariales> lstPagoEmpresariales = new ArrayList<>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;
  private String valorPago;

  public PagoEmpresariales() {}

  private PagoEmpresariales(Map<String, String> datosPagosEmpresariales) {
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.valorPago = datosPagosEmpresariales.get("valorPago");
  }

  public PagoEmpresariales(List<Map<String, String>> datosPagosEmpresariales) {
    asignarDatos(datosPagosEmpresariales);
  }

  public String getTipoBeneficiario() {
    return tipoBeneficiario;
  }

  public String getComentario() {
    return comentario;
  }

  public String getNumeroFactura() {
    return numeroFactura;
  }

  public String getValorPago() {
    return valorPago;
  }

  public List<PagoEmpresariales> getLstPago() {
    return lstPagoEmpresariales;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresariales) {
    for (Map<String, String> dato : datosPagosEmpresariales) {
      lstPagoEmpresariales.add(new PagoEmpresariales(dato));
    }
  }
}
