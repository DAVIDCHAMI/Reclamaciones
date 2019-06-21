package com.sura.reclamaciones.steps.limiteaprobacion;

import static com.sura.reclamaciones.constantes.MenuConstante.PLAN_TRABAJO;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.limiteaprobacion.PlanTrabajoActividadesPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AprobacionLimiteAutoridadStep {

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page
  ConsultaReclamacionPage consultaReclamacionPage;

  @Page
  PlanTrabajoActividadesPage planTrabajoActividadesPage;

  String numeroReclamacion;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    final String TRANSACCION_RESERVA = "Reservas";
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    verificacionDatosFinancierosPage.seleccionarTipoTransaccion(TRANSACCION_RESERVA);
    String strEstadoTransaccion = verificacionDatosFinancierosPage.obtenerEstadoReservaRealizada();
    MatcherAssert.assertThat("El estado de la reserva es diferente al de Aprobación pendiente ",
        strEstadoTransaccionReserva.equals(strEstadoTransaccion));
    numeroReclamacion= planTrabajoActividadesPage.obtenerNumeroSiniestro();
  }

  public void cerrarNavegador(){
    planTrabajoActividadesPage.cerrarNavegador();
  }

  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) {
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(PLAN_TRABAJO);
    planTrabajoActividadesPage.verificarActividadesPlanTrabajo(actividadAprobarReserva);
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    planTrabajoActividadesPage.aprobarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }
}
