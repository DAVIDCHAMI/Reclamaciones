package com.sura.reclamaciones.steps.empresariales;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.limiteaprobacion.PlanTrabajoActividadPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;

import static com.sura.reclamaciones.constantes.MenuConstante.PLAN_TRABAJO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

public class AprobacionLimiteAutoridadStep {

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    ConsultaReclamacionPage consultaReclamacionPage;

    @Page
    PlanTrabajoActividadPage planTrabajoActividadPage;

    public void cerrarNavegador() {
        planTrabajoActividadPage.cerrarNavegador();
    }

    public void verificarGeneracionActividadRevisarAprobarCambioReserva(
            String actividadAprobarReserva) {
        String numeroReclamacion
                = Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()).toString();
        consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
        menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(PLAN_TRABAJO);
        planTrabajoActividadPage.verificarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
    }

    public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
        planTrabajoActividadPage.aprobarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
    }
}
