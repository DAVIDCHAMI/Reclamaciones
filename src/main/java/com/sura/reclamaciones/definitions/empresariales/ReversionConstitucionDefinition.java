package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.ReservaConstante.*;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.reserva.ReversionConstitucionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ReversionConstitucionDefinition {

  Reserva reserva;
  @Steps ReversionConstitucionStep reversionConstitucionStep;
  @Steps GenericStep genericStep;

  @Dado("^que se genera un siniestro del producto (.*)$")
  public void consultarReserva(String producto) throws Throwable {
    reserva = new Reserva(genericStep.getFilasModelo(RESERVA, REVERSION_CONSTITUCION));
    reversionConstitucionStep.consultarReclamacion(reserva.getLstReclamo());
  }

  @Cuando("^se ajuste la reserva con un valor de (.*)$")
  public void ajustarReserva(String ajusteReserva) {
    reversionConstitucionStep.ajustarReserva(ajusteReserva);
  }

  @Entonces(
      "^se obtiene una reversión de constitución y el deducible es generado por un valor (.*)$")
  public void verificarReversionConstitucion(String deducible) {
    //To Do
  }
}
