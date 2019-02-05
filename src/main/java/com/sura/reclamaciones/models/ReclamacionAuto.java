package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionAuto extends Reclamacion {

  private String fechaNotificacionSiniestro;
  private String relacionAsegurado;
  private String descripcionHechos;
  private String origenCausa;
  private String vehiculoRetenido;
  private String culpabilidad;
  private String valorPretension;
  private String mensajeValidador;
  private String pais;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;
  private String numeroMaca;
  private String codigoCulpabilidad;
  private String segmento;
  private String autoridadTransito;
  private String valorPerdida;
  private String tipoMoneda;
  private String tallerReparacion;
  private String partePerdida;
  private String tipoPerdida;
  private boolean sospechoso;
  private String descripcionSospecha;
  private String departamento;

  @Override
  public String getDepartamento() {
    return departamento;
  }

  @Override
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  private List<ReclamacionAuto> lstReclamacionAuto = new ArrayList<>();

  public ReclamacionAuto() {
    super();
  }

  private ReclamacionAuto(Map<String, String> datosReclamacionAut) {
    super(datosReclamacionAut);
    this.fechaNotificacionSiniestro = datosReclamacionAut.get("fechaNotificacionSiniestro");
    this.relacionAsegurado = datosReclamacionAut.get("relacionAsegurado");
    this.descripcionHechos = datosReclamacionAut.get("descripcionHechos");
    this.origenCausa = datosReclamacionAut.get("origenCausa");
    this.vehiculoRetenido = datosReclamacionAut.get("vehiculoRetenido");
    this.culpabilidad = datosReclamacionAut.get("culpabilidad");
    this.valorPretension = datosReclamacionAut.get("valorPretension");
    this.mensajeValidador = datosReclamacionAut.get("mensajeValidador");
    this.pais = datosReclamacionAut.get("pais");
    this.ciudad = datosReclamacionAut.get("ciudad");
    this.direccion = datosReclamacionAut.get("direccion");
    this.tipoDireccion = datosReclamacionAut.get("tipoDireccion");
    this.numeroMaca = datosReclamacionAut.get("numeroMaca");
    this.codigoCulpabilidad = datosReclamacionAut.get("codigoCulpabilidad");
    this.segmento = datosReclamacionAut.get("segmento");
    this.autoridadTransito = datosReclamacionAut.get("autoridadTransito");
    this.valorPerdida = datosReclamacionAut.get("valorPerdida");
    this.tipoMoneda = datosReclamacionAut.get("tipoMoneda");
    this.tallerReparacion = datosReclamacionAut.get("tallerReparacion");
    this.partePerdida = datosReclamacionAut.get("partePerdida");
    this.tipoPerdida = datosReclamacionAut.get("tipoPerdida");
    this.sospechoso = Boolean.parseBoolean(datosReclamacionAut.get("sospechoso"));
    this.descripcionSospecha = datosReclamacionAut.get("descripcionSospecha");
    this.departamento = datosReclamacionAut.get("departamento");
      }

  public ReclamacionAuto(List<Map<String, String>> datosReclamacionAut) {
    asignarDatos(datosReclamacionAut);
  }

  public String getFechaNotificacionSiniestro() {
    return fechaNotificacionSiniestro;
  }

  public String getMensajeValidador() {
    return mensajeValidador;
  }

  public String getRelacionAsegurado() {
    return relacionAsegurado;
  }

  public String getDescripcionHechos() {
    return descripcionHechos;
  }

  public String getOrigenCausa() {
    return origenCausa;
  }

  public String getVehiculoRetenido() {
    return vehiculoRetenido;
  }

  public String getCulpabilidad() {
    return culpabilidad;
  }

  public String getValorPretension() {
    return valorPretension;
  }

  public String getPais() {
    return pais;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getNumeroMaca() {
    return numeroMaca;
  }

  public void setNumeroMaca(String numeroMaca) {
    this.numeroMaca = numeroMaca;
  }

  public String getCodigoCulpabilidad() {
    return codigoCulpabilidad;
  }

  public void setCodigoCulpabilidad(String codigoCulpabilidad) {
    this.codigoCulpabilidad = codigoCulpabilidad;
  }

  public String getSegmento() {
    return segmento;
  }

  public void setSegmento(String segmento) {
    this.segmento = segmento;
  }

  public String getAutoridadTransito() {
    return autoridadTransito;
  }

  public void setAutoridadTransito(String autoridadTransito) {
    this.autoridadTransito = autoridadTransito;
  }

  public String getValorPerdida() {
    return valorPerdida;
  }

  public void setValorPerdida(String valorPerdida) {
    this.valorPerdida = valorPerdida;
  }

  public String getTipoMoneda() {
    return tipoMoneda;
  }

  public void setTipoMoneda(String tipoMoneda) {
    this.tipoMoneda = tipoMoneda;
  }

  public String getTallerReparacion() {
    return tallerReparacion;
  }

  public void setTallerReparacion(String tallerReparacion) {
    this.tallerReparacion = tallerReparacion;
  }

  public String getPartePerdida() {
    return partePerdida;
  }

  public void setPartePerdida(String partePerdida) {
    this.partePerdida = partePerdida;
  }

  public String getTipoDireccion() {
    return tipoDireccion;
  }

  public void setTipoDireccion(String tipoDireccion) {
    this.tipoDireccion = tipoDireccion;
  }

  public String getTipoPerdida() {
    return tipoPerdida;
  }

  public void setTipoPerdida(String tipoPerdida) {
    this.tipoPerdida = tipoPerdida;
  }

  public boolean getSospechoso() {
    return sospechoso;
  }

  public void setSospechoso(boolean sospechoso) {
    this.sospechoso = sospechoso;
  }

  public String getDescripcionSospecha() {
    return descripcionSospecha;
  }

  public void setDescripcionSospecha(String descripcionSospecha) {
    this.descripcionSospecha = descripcionSospecha;
  }

  public List<ReclamacionAuto> getLstReclamacionAuto() {
    return lstReclamacionAuto;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionAut) {
    for (Map<String, String> dato : datosReclamacionAut) {
      lstReclamacionAuto.add(new ReclamacionAuto(dato));
    }
  }
}
