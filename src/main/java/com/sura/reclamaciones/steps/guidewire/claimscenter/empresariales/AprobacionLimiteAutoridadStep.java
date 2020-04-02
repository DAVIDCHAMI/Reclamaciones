package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.PLAN_TRABAJO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.ConsultaReclamacionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.empresariales.PlanTrabajoActividadPage;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;

public class AprobacionLimiteAutoridadStep {

  @Page MenuClaimPage menuClaimPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  @Page PlanTrabajoActividadPage planTrabajoActividadPage;

  public void cerrarNavegador() {
    planTrabajoActividadPage.cerrarNavegador();
  }

  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) {
    String numeroReclamacion =
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()).toString();
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(PLAN_TRABAJO);
    planTrabajoActividadPage.verificarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    planTrabajoActividadPage.aprobarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }
}
