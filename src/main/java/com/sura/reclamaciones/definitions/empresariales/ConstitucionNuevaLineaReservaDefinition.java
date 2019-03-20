package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.steps.reserva.ReversionConstitucionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ConstitucionNuevaLineaReservaDefinition {

  @Steps
  ReversionConstitucionStep reversionConstitucionStep;

  @Cuando("^se crea una nueva (.*) por (.*) de (.*) por un valor de (.*)$")
  public void crearNuevaLineaReserva(String lineaReserva, String categoriaCosto, String tipoCosto, String valorNuevaReserva) throws Throwable {
    reversionConstitucionStep.crearNuevaLineaReserva(lineaReserva,tipoCosto, categoriaCosto, valorNuevaReserva);
  }

  @Entonces("^se genera una nueva Líne de reserva de (.*) con un deducible de (.*)$")
  public void verificarConstitucionNuevaLineaReserva(String categoriaCosto, String deducible)
      throws Throwable {
    reversionConstitucionStep.verificarAjusteReserva(categoriaCosto,deducible);
  }
}
