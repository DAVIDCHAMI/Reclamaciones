package com.sura.reclamaciones.steps.limiteaprobacion;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AprobacionLimiteAutoridadStep {

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    final String TRANSACCION_RESERVA = "Reservas";
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    verificacionDatosFinancierosPage.seleccionarTipoTransaccion(TRANSACCION_RESERVA);
    String strEstadoTransaccion = verificacionDatosFinancierosPage.obtenerEstadoReservaRealizada();
    MatcherAssert.assertThat("El estado de la reserva es diferente al de Aprobación pendiente ",
        strEstadoTransaccionReserva.equals(strEstadoTransaccion));
  }
}
