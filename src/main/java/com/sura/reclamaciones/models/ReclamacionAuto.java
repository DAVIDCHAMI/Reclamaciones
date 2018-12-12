package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionAuto extends Reclamacion {

  private String fechaNotificacionSiniestro;
  private String relacionAsegurado;
  private String sucedido;
  private String causa;
  private String vehiculoRetenido;
  private String autoridad;
  private String culpabilidad;
  private String taller;
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

  private List<ReclamacionAuto> lstReclamacionAuto = new ArrayList<>();

  public ReclamacionAuto() {
    super();
  }

  private ReclamacionAuto(Map<String, String> datosReclamacionAut) {
    super(datosReclamacionAut);
    this.fechaNotificacionSiniestro = datosReclamacionAut.get("fechaNotificacionSiniestro");
    this.relacionAsegurado = datosReclamacionAut.get("relacionAsegurado");
    this.sucedido = datosReclamacionAut.get("sucedido");
    this.causa = datosReclamacionAut.get("causa");
    this.vehiculoRetenido = datosReclamacionAut.get("vehiculoRetenido");
    this.autoridad = datosReclamacionAut.get("autoridad");
    this.culpabilidad = datosReclamacionAut.get("culpabilidad");
    this.taller = datosReclamacionAut.get("taller");
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

  public String getSucedido() {
    return sucedido;
  }

  public String getCausa() {
    return causa;
  }

  public String getVehiculoRetenido() {
    return vehiculoRetenido;
  }

  public String getAutoridad() {
    return autoridad;
  }

  public String getCulpabilidad() {
    return culpabilidad;
  }

  public String getTaller() {
    return taller;
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

  public List<ReclamacionAuto> getLstReclamacionAuto() {
    return lstReclamacionAuto;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionAut) {
    for (Map<String, String> dato : datosReclamacionAut) {
      lstReclamacionAuto.add(new ReclamacionAuto(dato));
    }
  }
}
