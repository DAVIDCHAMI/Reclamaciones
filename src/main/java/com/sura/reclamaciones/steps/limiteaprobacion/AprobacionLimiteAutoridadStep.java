package com.sura.reclamaciones.steps.limiteaprobacion;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.MenuConstante.PLAN_TRABAJO;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.limiteaprobacion.PlanTrabajoActividadesPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AprobacionLimiteAutoridadStep {

  @Page MenuClaimPage menuClaimPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  @Page PlanTrabajoActividadesPage planTrabajoActividadesPage;

  String numeroReclamacion;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    final String TRANSACCION_RESERVA = "Reservas";
    final String ESTADO_SOLICITADO = "Solicitado";
    final int POSICION_ESTADO_SOLICITADO=2;
    final int POSICION_ESTADO_PENDIENTE_APROBACION=1;
    String strEstadoTransaccion = "";
    int posicionEstadoVerificar;
    if (strEstadoTransaccionReserva.equals(ESTADO_SOLICITADO)) {
      posicionEstadoVerificar = POSICION_ESTADO_SOLICITADO;
    } else {
      posicionEstadoVerificar = POSICION_ESTADO_PENDIENTE_APROBACION;
    }
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
      planTrabajoActividadesPage.realizarEsperaCarga();
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      verificacionDatosFinancierosPage.seleccionarTipoTransaccion(TRANSACCION_RESERVA);
      strEstadoTransaccion =
          verificacionDatosFinancierosPage.obtenerEstadoReservaRealizada(posicionEstadoVerificar);
      boolean estadoTransaccionPantalla = strEstadoTransaccionReserva.equals(strEstadoTransaccion);
      if (estadoTransaccionPantalla) {
        break;
      }
    }
    MatcherAssert.assertThat(
        "El estado de la reserva es diferente al de " + strEstadoTransaccionReserva,
        strEstadoTransaccionReserva.equals(strEstadoTransaccion));
    numeroReclamacion = planTrabajoActividadesPage.obtenerNumeroSiniestro();
  }

  public void cerrarNavegador() {
    planTrabajoActividadesPage.cerrarNavegador();
  }

  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) {
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(PLAN_TRABAJO);
    planTrabajoActividadesPage.verificarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    planTrabajoActividadesPage.aprobarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }
}
