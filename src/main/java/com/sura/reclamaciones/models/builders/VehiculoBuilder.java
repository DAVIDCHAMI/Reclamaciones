package com.sura.reclamaciones.models.builders;

import com.sura.reclamaciones.models.Vehiculo;


public class VehiculoBuilder implements ConModelo, ConPlaca {

  private String placa;
  private String modelo;
  private String clase;
  private String linea;
  private String motor;
  private String chasis;

  public Vehiculo deMarca(String marca){
    return new Vehiculo(placa, clase, modelo, marca, linea, motor, chasis);
  }

  public static ConPlaca unVehiculo(){
    return new VehiculoBuilder();
  }

  @Override
  public VehiculoBuilder conPlaca (String placa) {
    this.placa = placa;
    return this;
  }

  @Override
  public VehiculoBuilder conModelo(String modelo) {
    this.modelo = modelo;
    return this;
  }

  public VehiculoBuilder conClase(String clase) {
    this.clase = clase;
    return this;
  }

  public VehiculoBuilder conLinea(String linea) {
    this.linea = linea;
    return this;
  }

  public VehiculoBuilder conMotor(String motor) {
    this.motor = motor;
    return this;
  }

  public VehiculoBuilder conChasis(String chasis) {
    this.chasis = chasis;
    return this;
  }
}
