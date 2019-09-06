package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.steps.generics.DatoFinancieroTransaccionStep;
import com.sura.reclamaciones.steps.limiteaprobacion.AprobacionLimiteAutoridadStep;
import com.sura.reclamaciones.steps.login.LoginClaimStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

import static com.sura.reclamaciones.constantes.Constantes.ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO;

public class AprobacionLimiteAutoridadDefinition {

  @Steps AprobacionLimiteAutoridadStep aprobacionLimiteAutoridadStep;

  @Steps LoginClaimStep loginClaimStep;

  @Steps
  DatoFinancieroTransaccionStep datoFinancieroTransaccionStep;

  @Entonces("^el estado de la transacción de reserva queda en (.*)$")
  public void verificarEstadoTransaccion(String strEstadoTransaccionReserva) {
    datoFinancieroTransaccionStep.verificarEstadoTransaccionReserva(strEstadoTransaccionReserva);
  }

  @Y(
      "^se genera la actividad, (.*) al Director o Gerente de atención de reclamaciones Empresariales$")
  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) throws IOException {
    aprobacionLimiteAutoridadStep.cerrarNavegador();
    loginClaimStep.iniciarSesionLab(ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO.getValor());
    aprobacionLimiteAutoridadStep.verificarGeneracionActividadRevisarAprobarCambioReserva(
        actividadAprobarReserva);
  }

  @Cuando("^es aprobada la actividad (.*)$")
  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    aprobacionLimiteAutoridadStep.aprobarActividadRevisarAprobarCambioReserva(
        actividadAprobarReserva);
  }
}
