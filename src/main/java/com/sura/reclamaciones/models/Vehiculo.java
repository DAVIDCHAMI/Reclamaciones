package com.sura.reclamaciones.models;

public class Vehiculo {
  private final String placa;
  private final String clase;
  private final String modelo;
  private final String marca;
  private final String linea;
  private final String motor;
  private final String chasis;

  public Vehiculo(String placa, String clase, String modelo, String marca, String linea, String motor, String chasis) {
    this.placa = placa;
    this.clase = clase;
    this.modelo = modelo;
    this.marca = marca;
    this.linea = linea;
    this.motor = motor;
    this.chasis = chasis;
  }

  public String getPlaca() {
    return placa;
  }

  public String getClase() {
    return clase;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getLinea() {
    return linea;
  }

  public String getMotor() {
    return motor;
  }

  public String getChasis() {
    return chasis;
  }

}
