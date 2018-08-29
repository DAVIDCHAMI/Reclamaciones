package com.sura.reclamaciones.definitions.empresariales;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class ReversionConstitucionDefinition {


  @Dado("^que se genera un siniestro del producto (.*) con una reserva automática por un monto de (.*)$")
  public void consultarReserva() {
  }


  @Cuando("^se ajuste la reserva  con un valor de (.*)$")
  public void ajustarReserva() {
  }

  @Entonces("^se obtiene una reversión de constitución  y el deducible es generado por  un valor (.*)$")
  public void verificarReversionConstitucion() {

  }

}
