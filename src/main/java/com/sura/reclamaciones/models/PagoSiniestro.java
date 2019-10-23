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
  private String esPagoAutomatico;
  private String tipoPago;
  private String codigoTipoPago;
  private String descuento;
  private String codigoRetencion;
  private String codigoLineaCategoria;
  private String impuesto;
  private String codigoTipoImpuesto;
  private String codigoProducto;
  private String descripcion;
  private String condicionPago;
  private String codigoCondicionTipoPago;

  public PagoSiniestro() {
    super();
  }

  private PagoSiniestro(Map<String, String> datosPagosEmpresariales) {
    super(datosPagosEmpresariales);
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
    this.esPagoAutomatico = datosPagosEmpresariales.get("esPagoAutomatico");
    this.tipoPago = datosPagosEmpresariales.get("tipoPago");
    this.codigoTipoPago = datosPagosEmpresariales.get("paymentType");
    this.descuento = datosPagosEmpresariales.get("descuento");
    this.codigoRetencion = datosPagosEmpresariales.get("codigoRetencion");
    this.codigoLineaCategoria = datosPagosEmpresariales.get("lineCategory");
    this.impuesto = datosPagosEmpresariales.get("impuesto");
    this.codigoTipoImpuesto = datosPagosEmpresariales.get("taxesType_Ext");
    this.codigoProducto = datosPagosEmpresariales.get("prefijo");
    this.descripcion = datosPagosEmpresariales.get("description");
    this.condicionPago = datosPagosEmpresariales.get("condicionPago");
    this.codigoCondicionTipoPago = datosPagosEmpresariales.get("paymentConditionType_Ext");
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

  public String getTipoPago() {
    return tipoPago;
  }

  public String getCodigoTipoPago() {
    return codigoTipoPago;
  }

  public String getDescuento() {
    return descuento;
  }

  public String getCodigoRetencion() {
    return codigoRetencion;
  }

  public String getCodigoLineaCategoria() {
    return codigoLineaCategoria;
  }

  public String getImpuesto() {
    return impuesto;
  }

  public String getCodigoTipoImpuesto() {
    return codigoTipoImpuesto;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getCondicionPago() {
    return condicionPago;
  }

  public String getCodigoCondicionTipoPago() {
    return codigoCondicionTipoPago;
  }
}
