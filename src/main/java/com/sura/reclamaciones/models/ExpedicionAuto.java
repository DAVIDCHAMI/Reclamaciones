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
  private String valorLimiteDanoTercero;
  private String valorDeducibleDanoTercero;
  private String valorPerdidaTotalDanosCarro;
  private String valorPerdidaParcialDanosCarro;
  private String valorGastoTransporteDanosCarro;
  private String valorHurtoTotal;
  private String valorHurtoParcial;
  private String valorHurtoGasTrans;
  private String valorPerdidaParcialCarroReemplazo;
  private String valorPerdidaTotalCarroReemplazo;
  private String valorAccidentesConductor;
  private String valorPerdidaLlaves;
  private String valorAsistencia;
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
    this.valorLimiteDanoTercero = datosExpedicion.get("valorLimiteDanoTercero");
    this.valorDeducibleDanoTercero = datosExpedicion.get("valorDeducibleDanoTercero");
    this.valorPerdidaTotalDanosCarro = datosExpedicion.get("valorPerdidaTotalDanosCarro");
    this.valorPerdidaParcialDanosCarro = datosExpedicion.get("valorPerdidaParcialDanosCarro");
    this.valorGastoTransporteDanosCarro = datosExpedicion.get("valorGastoTransporteDanosCarro");
    this.valorHurtoTotal = datosExpedicion.get("valorHurtoTotal");
    this.valorHurtoParcial = datosExpedicion.get("valorHurtoParcial");
    this.valorHurtoGasTrans = datosExpedicion.get("valorHurtoGasTrans");
    this.valorPerdidaParcialCarroReemplazo =
        datosExpedicion.get("valorPerdidaParcialCarroReemplazo");
    this.valorPerdidaTotalCarroReemplazo = datosExpedicion.get("valorPerdidaTotalCarroReemplazo");
    this.valorAccidentesConductor = datosExpedicion.get("valorAccidentesConductor");
    this.valorPerdidaLlaves = datosExpedicion.get("valorPerdidaLlaves");
    this.valorAsistencia = datosExpedicion.get("valorAsistencia");
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
    this.valorLimiteDanoTercero = valorLimiteDanoTercero;
  }

  public void setValorDeducibleDanoTercero(String valorDeducibleDanoTercero) {
    this.valorDeducibleDanoTercero = valorDeducibleDanoTercero;
  }

  public void setValorPerdidaTotalDanosCarro(String valorPerdidaTotalDanosCarro) {
    this.valorPerdidaTotalDanosCarro = valorPerdidaTotalDanosCarro;
  }

  public void setValorPerdidaParcialDanosCarro(String valorPerdidaParcialDanosCarro) {
    this.valorPerdidaParcialDanosCarro = valorPerdidaParcialDanosCarro;
  }

  public void setValorGastoTransporteDanosCarro(String valorGastoTransporteDanosCarro) {
    this.valorGastoTransporteDanosCarro = valorGastoTransporteDanosCarro;
  }

  public void setValorHurtoTotal(String valorHurtoTotal) {
    this.valorHurtoTotal = valorHurtoTotal;
  }

  public void setValorHurtoParcial(String valorHurtoParcial) {
    this.valorHurtoParcial = valorHurtoParcial;
  }

  public void setValorHurtoGasTrans(String valorHurtoGasTrans) {
    this.valorHurtoGasTrans = valorHurtoGasTrans;
  }

  public void setValorPerdidaParcialCarroReemplazo(String valorPerdidaParcialCarroReemplazo) {
    this.valorPerdidaParcialCarroReemplazo = valorPerdidaParcialCarroReemplazo;
  }

  public void setValorPerdidaTotalCarroReemplazo(String valorPerdidaTotalCarroReemplazo) {
    this.valorPerdidaTotalCarroReemplazo = valorPerdidaTotalCarroReemplazo;
  }

  public void setValorAccidentesConductor(String valorAccidentesConductor) {
    this.valorAccidentesConductor = valorAccidentesConductor;
  }

  public void setValorPerdidaLlaves(String valorPerdidaLlaves) {
    this.valorPerdidaLlaves = valorPerdidaLlaves;
  }

  public void setValorAsistencia(String valorAsistencia) {
    this.valorAsistencia = valorAsistencia;
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
    return valorLimiteDanoTercero;
  }

  public String getValorDeducibleDanoTercero() {
    return valorDeducibleDanoTercero;
  }

  public String getValorPerdidaTotalDanosCarro() {
    return valorPerdidaTotalDanosCarro;
  }

  public String getValorPerdidaParcialDanosCarro() {
    return valorPerdidaParcialDanosCarro;
  }

  public String getValorGastoTransporteDanosCarro() {
    return valorGastoTransporteDanosCarro;
  }

  public String getValorHurtoTotal() {
    return valorHurtoTotal;
  }

  public String getValorHurtoParcial() {
    return valorHurtoParcial;
  }

  public String getValorHurtoGasTrans() {
    return valorHurtoGasTrans;
  }

  public String getValorPerdidaParcialCarroReemplazo() {
    return valorPerdidaParcialCarroReemplazo;
  }

  public String getValorPerdidaTotalCarroReemplazo() {
    return valorPerdidaTotalCarroReemplazo;
  }

  public String getValorAccidentesConductor() {
    return valorAccidentesConductor;
  }

  public String getValorPerdidaLlaves() {
    return valorPerdidaLlaves;
  }

  public String getValorAsistencia() {
    return valorAsistencia;
  }

  public String getExpedicionTotal() {
    return expedicionTotal;
  }

  public String getCodigoPlan() {
    return codigoPlan;
  }
}
