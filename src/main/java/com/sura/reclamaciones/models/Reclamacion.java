package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Reclamacion {

  private String origen;
  private String tipoPoliza;
  private String numPoliza;
  private String lossDate;
  private String lugar;
  private String reservaTransaccion;
  private String notificationDate;
  private String lossCause;
  private String description;
  private String authorUser;
  private String amount;
  private String currency;
  private String isPolicyProperty;

  public Reclamacion() {}

  public Reclamacion(Map<String, String> datosReclamacion) {
    this.origen = datosReclamacion.get("origen");
    this.lossDate = datosReclamacion.get("fechaSiniestro");
    this.tipoPoliza = datosReclamacion.get("tipoPoliza");
    this.numPoliza = datosReclamacion.get("numPoliza");
    this.lugar = datosReclamacion.get("lugar");
    this.reservaTransaccion = datosReclamacion.get("reservaTransaccion");
    this.notificationDate = datosReclamacion.get("fechaAviso");
    this.lossCause = datosReclamacion.get("causaPerdida");
    this.description = datosReclamacion.get("descripcionHechos");
    this.authorUser = datosReclamacion.get("idAutor");
    this.amount = datosReclamacion.get("valorPerdida");
    this.currency = datosReclamacion.get("tipoMoneda");
    this.isPolicyProperty = datosReclamacion.get("esPolizaPropiedad");
  }

  public String getOrigen() {
    return origen;
  }

  public String getTipoPoliza() {
    return tipoPoliza;
  }

  public String getNumPoliza() {
    return numPoliza;
  }

  public String getFechaSiniestro() {
    return lossDate;
  }

  public String getLugar() {
    return lugar;
  }

  public String getReservaTransaccion() {
    return reservaTransaccion;
  }

  public String getFechaAviso() {
    return notificationDate;
  }

  public String getCausaPerdida() {
    return lossCause;
  }

  public String getDescripcionHechos() {
    return description;
  }

  public String getIdAutor() {
    return authorUser;
  }

  public Integer getAmount() {
    int Amount = Integer.parseInt(amount);
    return Amount;
  }

  public String getCurrency() {
    return currency;
  }

  public boolean getIsPolicyProperty() {
    boolean IsPolicyProperty = Boolean.parseBoolean(isPolicyProperty);
    return IsPolicyProperty;
  }
}
