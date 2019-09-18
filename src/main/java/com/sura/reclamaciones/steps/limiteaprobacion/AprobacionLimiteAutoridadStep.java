package com.sura.reclamaciones.steps.limiteaprobacion;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_RECUPERO;
import static com.sura.reclamaciones.constantes.MenuConstante.PLAN_TRABAJO;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.limiteaprobacion.PlanTrabajoActividadPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AprobacionLimiteAutoridadStep {

  @Page MenuClaimPage menuClaimPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  @Page PlanTrabajoActividadPage planTrabajoActividadPage;

  String numeroReclamacion;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    final String TRANSACCION_RESERVA = "Reservas";
    final String ESTADO_SOLICITADO = "Solicitado";
    final int POSICION_ESTADO_SOLICITADO = 2;
    String strEstadoTransaccion = "";
    int posicionEstadoVerificar;
    if (strEstadoTransaccionReserva.equals(ESTADO_SOLICITADO)) {
      posicionEstadoVerificar = POSICION_ESTADO_SOLICITADO;
    } else {
      posicionEstadoVerificar = Integer.parseInt(POSICION_FILA.getValor());
    }
      planTrabajoActividadPage.realizarEsperaCarga();
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_RECUPERO.getValor()); i++) {
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
    numeroReclamacion = consultaReclamacionPage.obtenerNumeroSiniestro();
  }

  public void cerrarNavegador() {
    planTrabajoActividadPage.cerrarNavegador();
  }

  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) {
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(PLAN_TRABAJO);
    planTrabajoActividadPage.verificarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    planTrabajoActividadPage.aprobarActividadRevisarAprobarCambioReserva(actividadAprobarReserva);
  }
}
