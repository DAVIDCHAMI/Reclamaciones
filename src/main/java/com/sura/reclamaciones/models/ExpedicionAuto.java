package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpedicionAuto {
  private String version;
  private String metodo;
  private String codigoPlan;
  private String valorCotizar;
  private String fasecolda;
  private String anio;
  private String ciudadCirculacion;
  private String accesorio;
  private boolean ceroKms;
  private String bonificacionComercial;
  private String bonificacionTecnica;
  private String valorLimiteDanioTercero;
  private String valorDeducibleDanioTercero;
  private String valorPerdidaTotalDaniosCarro;
  private String valorPerdidaParcialDaniosCarro;
  private String valorGastoTransporteDaniosCarro;
  private String valorSustraccionTotal;
  private String valorSustraccionParcial;
  private String valorHurtoGastoTransporte;
  private String valorPerdidaParcialVehiculoReemplazo;
  private String valorPerdidaTotalVehiculoReemplazo;
  private String valorAccidenteConductor;
  private String valorPerdidaLlave;
  private String valorAsistencias;
  private String expedicionTotal;
  private List<ExpedicionAuto> lstExpedicion = new ArrayList<>();

  public ExpedicionAuto() {}

  public ExpedicionAuto(List<Map<String, String>> datosExpedicion) {
    asignarDatos(datosExpedicion);
  }

  public ExpedicionAuto(Map<String, String> datosExpedicion) {
    this.version = datosExpedicion.get("version");
    this.metodo = datosExpedicion.get("method");
    this.codigoPlan = datosExpedicion.get("codigoPlan");
    this.valorCotizar = datosExpedicion.get("valorCotizar");
    this.fasecolda = datosExpedicion.get("fasecolda");
    this.anio = datosExpedicion.get("ano");
    this.ciudadCirculacion = datosExpedicion.get("ciudadCirculacion");
    this.accesorio = datosExpedicion.get("accesorios");
    this.ceroKms = Boolean.parseBoolean(datosExpedicion.get("ceroKms"));
    this.bonificacionComercial = datosExpedicion.get("bonificacionComercial");
    this.bonificacionTecnica = datosExpedicion.get("bonificacionTecnica");
    this.valorLimiteDanioTercero = datosExpedicion.get("valorLimiteDanoTercero");
    this.valorDeducibleDanioTercero = datosExpedicion.get("valorDeducibleDanoTercero");
    this.valorPerdidaTotalDaniosCarro = datosExpedicion.get("valorPerdidaTotalDanosCarro");
    this.valorPerdidaParcialDaniosCarro = datosExpedicion.get("valorPerdidaParcialDanosCarro");
    this.valorGastoTransporteDaniosCarro = datosExpedicion.get("valorGastoTransporteDanosCarro");
    this.valorSustraccionTotal = datosExpedicion.get("valorHurtoTotal");
    this.valorSustraccionParcial = datosExpedicion.get("valorHurtoParcial");
    this.valorHurtoGastoTransporte = datosExpedicion.get("valorHurtoGasTrans");
    this.valorPerdidaParcialVehiculoReemplazo =
        datosExpedicion.get("valorPerdidaParcialCarroReemplazo");
    this.valorPerdidaTotalVehiculoReemplazo =
        datosExpedicion.get("valorPerdidaTotalCarroReemplazo");
    this.valorAccidenteConductor = datosExpedicion.get("valorAccidentesConductor");
    this.valorPerdidaLlave = datosExpedicion.get("valorPerdidaLlaves");
    this.valorAsistencias = datosExpedicion.get("valorAsistencia");
    this.expedicionTotal = datosExpedicion.get("ExpedicionTotal");
  }

  public List<ExpedicionAuto> getLstExpedicion() {
    return lstExpedicion;
  }

  public void asignarDatos(List<Map<String, String>> datosExpedicion) {
    for (Map<String, String> dato : datosExpedicion) {
      lstExpedicion.add(new ExpedicionAuto(dato));
    }
  }

  public void setValorLimiteDanoTercero(String valorLimiteDanoTercero) {
    this.valorLimiteDanioTercero = valorLimiteDanoTercero;
  }

  public void setValorDeducibleDanoTercero(String valorDeducibleDanoTercero) {
    this.valorDeducibleDanioTercero = valorDeducibleDanoTercero;
  }

  public void setValorPerdidaTotalDanosCarro(String valorPerdidaTotalDanosCarro) {
    this.valorPerdidaTotalDaniosCarro = valorPerdidaTotalDanosCarro;
  }

  public void setValorPerdidaParcialDanosCarro(String valorPerdidaParcialDanosCarro) {
    this.valorPerdidaParcialDaniosCarro = valorPerdidaParcialDanosCarro;
  }

  public void setValorGastoTransporteDanosCarro(String valorGastoTransporteDanosCarro) {
    this.valorGastoTransporteDaniosCarro = valorGastoTransporteDanosCarro;
  }

  public void setValorHurtoTotal(String valorHurtoTotal) {
    this.valorSustraccionTotal = valorHurtoTotal;
  }

  public void setValorHurtoParcial(String valorHurtoParcial) {
    this.valorSustraccionParcial = valorHurtoParcial;
  }

  public void setValorHurtoGasTrans(String valorHurtoGasTrans) {
    this.valorHurtoGastoTransporte = valorHurtoGasTrans;
  }

  public void setValorPerdidaParcialCarroReemplazo(String valorPerdidaParcialCarroReemplazo) {
    this.valorPerdidaParcialVehiculoReemplazo = valorPerdidaParcialCarroReemplazo;
  }

  public void setValorPerdidaTotalCarroReemplazo(String valorPerdidaTotalCarroReemplazo) {
    this.valorPerdidaTotalVehiculoReemplazo = valorPerdidaTotalCarroReemplazo;
  }

  public void setValorAccidentesConductor(String valorAccidentesConductor) {
    this.valorAccidenteConductor = valorAccidentesConductor;
  }

  public void setValorPerdidaLlaves(String valorPerdidaLlaves) {
    this.valorPerdidaLlave = valorPerdidaLlaves;
  }

  public void setValorAsistencia(String valorAsistencia) {
    this.valorAsistencias = valorAsistencia;
  }

  public String getVersion() {
    return version;
  }

  public String getMetodo() {
    return metodo;
  }

  public String getValorCotizar() {
    return valorCotizar;
  }

  public String getFasecolda() {
    return fasecolda;
  }

  public String getAnio() {
    return anio;
  }

  public String getCiudadCirculacion() {
    return ciudadCirculacion;
  }

  public String getAccesorio() {
    return accesorio;
  }

  public boolean isCeroKms() {
    return ceroKms;
  }

  public String getBonificacionComercial() {
    return bonificacionComercial;
  }

  public String getBonificacionTecnica() {
    return bonificacionTecnica;
  }

  public String getValorLimiteDanoTercero() {
    return valorLimiteDanioTercero;
  }

  public String getValorDeducibleDanoTercero() {
    return valorDeducibleDanioTercero;
  }

  public String getValorPerdidaTotalDanosCarro() {
    return valorPerdidaTotalDaniosCarro;
  }

  public String getValorPerdidaParcialDanosCarro() {
    return valorPerdidaParcialDaniosCarro;
  }

  public String getValorGastoTransporteDanosCarro() {
    return valorGastoTransporteDaniosCarro;
  }

  public String getValorHurtoTotal() {
    return valorSustraccionTotal;
  }

  public String getValorHurtoParcial() {
    return valorSustraccionParcial;
  }

  public String getValorHurtoGasTrans() {
    return valorHurtoGastoTransporte;
  }

  public String getValorPerdidaParcialCarroReemplazo() {
    return valorPerdidaParcialVehiculoReemplazo;
  }

  public String getValorPerdidaTotalCarroReemplazo() {
    return valorPerdidaTotalVehiculoReemplazo;
  }

  public String getValorAccidentesConductor() {
    return valorAccidenteConductor;
  }

  public String getValorPerdidaLlaves() {
    return valorPerdidaLlave;
  }

  public String getValorAsistencia() {
    return valorAsistencias;
  }

  public String getExpedicionTotal() {
    return expedicionTotal;
  }

  public String getCodigoPlan() {
    return codigoPlan;
  }
}
