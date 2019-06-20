package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Constantes.ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO;

import com.sura.reclamaciones.steps.limiteaprobacion.AprobacionLimiteAutoridadStep;
import com.sura.reclamaciones.steps.login.LoginClaimStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class AprobacionLimiteAutoridadDefinition {

  @Steps
  AprobacionLimiteAutoridadStep aprobacionLimiteAutoridadStep;

  @Steps
  LoginClaimStep loginClaimStep;

  @Entonces("^el estado de la transacción de reserva queda en (.*)$")
  public void verificarEstadoTransaccion(String strEstadoTransaccionReserva) {
    aprobacionLimiteAutoridadStep.verificarEstadoTransaccionReserva(strEstadoTransaccionReserva);
  }

  @Y("^se genera la actividad, (.*) al Director o Gerente de atención de reclamaciones Empresariales$")
  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) throws IOException {
    aprobacionLimiteAutoridadStep.cerrarNavegador();
    loginClaimStep.iniciarSesionLab(ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO.getValor());
    aprobacionLimiteAutoridadStep.verificarGeneracionActividadRevisarAprobarCambioReserva();
  }
}
