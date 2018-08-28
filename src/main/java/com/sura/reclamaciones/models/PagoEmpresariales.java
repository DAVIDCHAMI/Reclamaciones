package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoEmpresariales extends Reclamacion {

  private List<PagoEmpresariales> lstPagoEmp = new ArrayList<>();
  private String tipoBeneficiario;
  private String comentarios;
  private String numeroFactura;
  private String valorPago;


  public PagoEmpresariales() {
    super();
  }

  private PagoEmpresariales(Map<String, String> datosPagosEmp) {
    super(datosPagosEmp);
    this.tipoBeneficiario = datosPagosEmp.get("tipoBeneficiario");
    this.comentarios = datosPagosEmp.get("comentario");
    this.numeroFactura = datosPagosEmp.get("numeroFactura");
    this.valorPago = datosPagosEmp.get("valorPago");
  }

  public PagoEmpresariales(List<Map<String, String>> datosPagosEmp) {
    asignarDatos(datosPagosEmp);
  }

  public String getTipoBeneficiario() {
    return tipoBeneficiario;
  }

  public String getComentarios() {
    return comentarios;
  }

  public String getNumeroFactura() {
    return numeroFactura;
  }

  public String getValorPago() {
    return valorPago;
  }

  public List<PagoEmpresariales> getLstPago() {
    return lstPagoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmp) {
    for (Map<String, String> dato : datosPagosEmp) {
      lstPagoEmp.add(new PagoEmpresariales(dato));
    }
  }
}
