package com.sura.reclamaciones.models;

public class Vehiculo {
  private String placa;
  private String modelo;
  private String fasecolda;
  private String clase;
  private String marca;
  private String linea;
  private String ciudadCirculacion;
  private String tipoServicio;
  private String motor;
  private String chasis;
  private String uso;
  private boolean remolque;
  private boolean combustible;
  private boolean importado;
  private boolean ceroKM;

  public Vehiculo(
      String placa,
      String modelo,
      String fasecolda,
      String clase,
      String marca,
      String linea,
      String ciudadCirculacion,
      String tipoServicio,
      String motor,
      String chasis,
      String uso,
      String remolque,
      String combustible,
      String importado,
      String ceroKM) {
    this.placa = placa;
    this.modelo = modelo;
    this.fasecolda = fasecolda;
    this.clase = clase;
    this.marca = marca;
    this.linea = linea;
    this.ciudadCirculacion = ciudadCirculacion;
    this.tipoServicio = tipoServicio;
    this.motor = motor;
    this.chasis = chasis;
    this.uso = uso;

    this.remolque = Boolean.parseBoolean(remolque);
    this.combustible = Boolean.parseBoolean(combustible);
    this.importado = Boolean.parseBoolean(importado);
    this.ceroKM = Boolean.parseBoolean(ceroKM);
  }

  //region propiedades_GET
  public String getPlaca() {
    return placa;
  }

  public String getModelo() {
    return modelo;
  }

  public String getFasecolda() {
    return fasecolda;
  }

  public String getClase() {
    return clase;
  }

  public String getMarca() {
    return marca;
  }

  public String getLinea() {
    return linea;
  }

  public String getCiudadCirculacion() {
    return ciudadCirculacion;
  }

  public String getTipoServicio() {
    return tipoServicio;
  }

  public String getMotor() {
    return motor;
  }

  public String getChasis() {
    return chasis;
  }

  public String getUso() {
    return uso;
  }

  public boolean isRemolque() {
    return remolque;
  }

  public boolean isCombustible() {
    return combustible;
  }

  public boolean isImportado() {
    return importado;
  }

  public boolean isCeroKM() {
    return ceroKM;
  }
  //endregion propiedades_GET

}
