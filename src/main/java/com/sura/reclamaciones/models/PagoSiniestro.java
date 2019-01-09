package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoSiniestro extends Transacciones {

  private List<PagoSiniestro> lstPagoSiniestro = new ArrayList<PagoSiniestro>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;
  private String tipoDireccion;

  public PagoSiniestro() {
    super();
  }

  private PagoSiniestro(Map<String, String> datosPagosEmpresariales) {
    super(datosPagosEmpresariales);
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
  }

  public PagoSiniestro(List<Map<String, String>> datosPagosEmpresariales) {
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

  public String getTipoDireccion() {
    return tipoDireccion;
  }

  public List<PagoSiniestro> getLstPago() {
    return lstPagoSiniestro;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstPagoSiniestro.add(new PagoSiniestro(dato));
    }
  }
}
