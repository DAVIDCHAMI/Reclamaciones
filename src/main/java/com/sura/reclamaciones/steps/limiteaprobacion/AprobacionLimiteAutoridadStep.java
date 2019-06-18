package com.sura.reclamaciones.steps.limiteaprobacion;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.limiteaprobacion.AprobacionLimiteAutoridadPage;
import org.fluentlenium.core.annotation.Page;

public class AprobacionLimiteAutoridadStep {

 private static final String TRANSACCION_RESERVA="Reservas";

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page
  AprobacionLimiteAutoridadPage aprobacionLimiteAutoridadPage;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    verificacionDatosFinancierosPage.seleccionarTipoTransaccion(TRANSACCION_RESERVA);
  }
}
