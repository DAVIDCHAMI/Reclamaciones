package com.sura.reclamaciones.steps.primapendiente;

import static com.sura.reclamaciones.constantes.MenuConstante.POLIZA;

import com.sura.reclamaciones.pages.autos.reclamacion.PolizaGeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class PrimaPendienteStep {

  @Page
  PolizaGeneralPage polizaGeneralPage;

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  String valorPrimaPendiente;

  public void verificarEstadoPrimaPendiente() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(POLIZA);
    valorPrimaPendiente=polizaGeneralPage.verificarEstadoPrimaPendiente();
  }

  public void verificarValorPagoPrimaPendiente() {
    MatcherAssert.assertThat(
        "No se hizo el pago de la prima pendiente",
    verificacionDatosFinancierosPage.verificarValorPagoPrimaPendiente(valorPrimaPendiente));
  }

  public void verificarValorPagoMenosPrimaPendiente() {

  }
}
