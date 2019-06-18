package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.steps.limiteaprobacion.AprobacionLimiteAutoridadStep;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class AprobacionLimiteAutoridadDefinition {

  @Steps AprobacionLimiteAutoridadStep aprobacionLimiteAutoridadStep;

  @Entonces("^el estado de la transacción de reserva queda en (.*)$")
  public void verificarEstadoTransaccion(String strEstadoTransaccionReserva) {
    aprobacionLimiteAutoridadStep.verificarEstadoTransaccionReserva(strEstadoTransaccionReserva);
  }
}
