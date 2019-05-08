package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.steps.reserva.MovimientoLineaReservaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ConstitucionNuevaLineaReservaDefinition {

  @Steps MovimientoLineaReservaStep movimientoLineaReservaStep;

  @Cuando(
      "^se crea una nueva línea de reserva por la Exposición de (.*) por (.*) con un tipo de costo (.*) por un valor de (.*)$")
  public void crearNuevaLineaReserva(
      String lineaReserva, String categoriaCosto, String tipoCosto, String valorNuevaReserva) {
    movimientoLineaReservaStep.crearNuevaLineaReserva(
        lineaReserva, tipoCosto, categoriaCosto, valorNuevaReserva);
  }

  @Entonces("^se genera una nueva línea de reserva de (.*) con un deducible de (.*)$")
  public void verificarConstitucionNuevaLineaReserva(String categoriaCosto, String deducible) {
    movimientoLineaReservaStep.verificarAjusteReserva(categoriaCosto, deducible);
  }
}
