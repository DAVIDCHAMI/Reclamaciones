package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagosEmpresariales extends Reclamacion {

  private List<PagosEmpresariales> lstPagoEmp = new ArrayList<>();
  private String tipoBeneficiario;
  private String comentarios;
  private String numeroFactura;
  private String valorPago;


  public PagosEmpresariales() {
    super();
  }

  private PagosEmpresariales(Map<String, String> datosPagosEmp) {
    super(datosPagosEmp);
    this.tipoBeneficiario = datosPagosEmp.get("tipoBeneficiario");
    this.comentarios = datosPagosEmp.get("comentario");
    this.numeroFactura = datosPagosEmp.get("numeroFactura");
    this.valorPago = datosPagosEmp.get("valorPago");
  }

  public PagosEmpresariales(List<Map<String, String>> datosPagosEmp) {
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

  public List<PagosEmpresariales> getLstPago() {
    return lstPagoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmp) {
    for (Map<String, String> dato : datosPagosEmp) {
      lstPagoEmp.add(new PagosEmpresariales(dato));
    }
  }
}
