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
  private String tipoPago;
  private String paymentType;
  private String descuento;
  private String codigoRetencion;
  private String lineCategory;
  private String impuesto;
  private String taxesTypeExt;
  private String codigoProducto;
  private String description;
  private String condicionPago;
  private String paymentConditionTypeExt;

  public PagoSiniestro() {
    super();
  }

  private PagoSiniestro(Map<String, String> datosPagosEmpresariales) {
    super(datosPagosEmpresariales);
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
    this.tipoPago = datosPagosEmpresariales.get("tipoPago");
    this.paymentType = datosPagosEmpresariales.get("paymentType");
    this.descuento = datosPagosEmpresariales.get("descuento");
    this.codigoRetencion = datosPagosEmpresariales.get("codigoRetencion");
    this.lineCategory = datosPagosEmpresariales.get("lineCategory");
    this.impuesto = datosPagosEmpresariales.get("impuesto");
    this.taxesTypeExt = datosPagosEmpresariales.get("taxesType_Ext");
    this.codigoProducto = datosPagosEmpresariales.get("prefijo");
    this.description = datosPagosEmpresariales.get("description");
    this.condicionPago = datosPagosEmpresariales.get("condicionPago");
    this.paymentConditionTypeExt = datosPagosEmpresariales.get("paymentConditionType_Ext");
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

  public String getTipoPago () {
    return tipoPago;
  }

  public String getPaymentType() { return paymentType; }

  public String getDescuento() { return descuento; }

  public String getCodigoRetencion() { return codigoRetencion; }

  public String getLineCategory() { return lineCategory; }

  public String getImpuesto() { return impuesto; }

  public String getTaxesTypeExt() { return taxesTypeExt; }

  public String getCodigoProducto() { return codigoProducto; }

  public String getDescription() { return description; }

  public String getCondicionPago() { return condicionPago; }

  public String getPaymentConditionTypeExt() { return paymentConditionTypeExt; }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstPagoSiniestro.add(new PagoSiniestro(dato));
    }
  }
}
