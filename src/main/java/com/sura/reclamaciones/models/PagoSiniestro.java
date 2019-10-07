package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoSiniestro extends Transacciones {

  private List<PagoSiniestro> lstPagoSiniestro = new ArrayList<>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;
  private String tipoDireccion;
  private String descuento;
  private String impuesto;
  private String description;
  private String esPagoAutomatico;

  public PagoSiniestro() {}

  private PagoSiniestro(Map<String, String> datosPagosEmpresariales) {
    super(datosPagosEmpresariales);
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
    this.descuento = datosPagosEmpresariales.get("descuento");
    this.impuesto = datosPagosEmpresariales.get("impuesto");
    this.description = datosPagosEmpresariales.get("description");
    this.esPagoAutomatico = datosPagosEmpresariales.get("esPagoAutomatico");
  }

  public PagoSiniestro(List<Map<String, String>> datosPagosEmpresariales) {
    for (Map<String, String> dato : datosPagosEmpresariales) {
      lstPagoSiniestro.add(new PagoSiniestro(dato));
    }
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

  public String getEsPagoAutomatico() {
    return esPagoAutomatico;
  }

  public List<PagoSiniestro> getLstPago() {
    return lstPagoSiniestro;
  }

  public String getDescuento() {
    return descuento;
  }

  public String getImpuesto() {
    return impuesto;
  }

  public String getDescription() {
    return description;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstPagoSiniestro.add(new PagoSiniestro(dato));
    }
  }
}
