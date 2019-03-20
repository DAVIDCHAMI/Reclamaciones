package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.reserva.ReversionConstitucionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ConstitucionNuevaLineaReservaDefinition {

  @Steps
  ReversionConstitucionStep reversionConstitucionStep;

  @Steps
  NuevoPagoStep nuevoPagoStep;

  @Cuando("^se crea una nueva Línea de reserva por la Exposición de (.*) por (.*) de (.*) por un valor de (.*)$")
  public void crearNuevaLineaReserva(String lineaReserva, String categoriaCosto, String tipoCosto, String valorNuevaReserva) throws Throwable {
    nuevoPagoStep.consultarNumeroReclamacion();
    reversionConstitucionStep.crearNuevaLineaReserva(lineaReserva,tipoCosto, categoriaCosto, valorNuevaReserva);
  }

  @Entonces("^se genera una nueva Línea de reserva de (.*) con un deducible de (.*)$")
  public void verificarConstitucionNuevaLineaReserva(String categoriaCosto, String deducible)
      throws Throwable {
    reversionConstitucionStep.verificarAjusteReserva(categoriaCosto,deducible);
  }
}
