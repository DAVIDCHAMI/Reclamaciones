package com.sura.reclamaciones.steps.limiteaprobacion;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.MenuConstante.PLAN_TRABAJO;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.datosfinancieros.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.limiteaprobacion.PlanTrabajoActividadPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AprobacionLimiteAutoridadStep {

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

    @Page
    ConsultaReclamacionPage consultaReclamacionPage;

    @Page
    PlanTrabajoActividadPage planTrabajoActividadPage;

    String numeroReclamacion;

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
