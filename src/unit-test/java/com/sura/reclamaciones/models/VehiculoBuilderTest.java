package com.sura.reclamaciones.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import com.sura.reclamaciones.models.builders.VehiculoBuilder;
import org.junit.Test;

public class VehiculoBuilderTest {
  @Test
  public void crearUnVehiculoConTodosLosDatos(){
    Vehiculo vehiculo = VehiculoBuilder
        .unVehiculo()
        .conPlaca("asd123")
        .conModelo("2014")
        .conClase("xxx")
        .conLinea("yyy")
        .conMotor("asdf")
        .conChasis("asdf")
        .deMarca("Mazda");

    assertThat(vehiculo.getPlaca(), equalTo("asd123"));
    assertThat(vehiculo.getModelo(), equalTo("2014"));
    assertThat(vehiculo.getClase(), equalTo("xxx"));
    assertThat(vehiculo.getLinea(), equalTo("yyy"));
    assertThat(vehiculo.getMotor(), equalTo("asdf"));
    assertThat(vehiculo.getChasis(), equalTo("asdf"));
    assertThat(vehiculo.getMarca(), equalTo("Mazda"));
  }

  @Test
  public void crearUnVehiculoConDatosObligatorios(){
    Vehiculo vehiculo = VehiculoBuilder
        .unVehiculo()
        .conPlaca("asd123")
        .deMarca("Mazda");

    assertThat(vehiculo.getPlaca(), equalTo("asd123"));
    assertThat(vehiculo.getModelo(), equalTo("2014"));
    assertThat(vehiculo.getClase(), isEmptyOrNullString());
    assertThat(vehiculo.getLinea(), isEmptyOrNullString());
    assertThat(vehiculo.getMotor(), isEmptyOrNullString());
    assertThat(vehiculo.getChasis(), isEmptyOrNullString());
    assertThat(vehiculo.getMarca(), equalTo("Mazda"));
  }
}
