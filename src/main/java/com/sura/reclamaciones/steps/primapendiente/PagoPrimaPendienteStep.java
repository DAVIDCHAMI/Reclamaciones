package com.sura.reclamaciones.steps.primapendiente;

import static com.sura.reclamaciones.constantes.MenuConstante.POLIZA;

import com.sura.reclamaciones.pages.autos.reclamacion.InformacionPolizaGeneralPage;
import com.sura.reclamaciones.pages.general.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.general.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class PagoPrimaPendienteStep {

  @Page InformacionPolizaGeneralPage informacionPolizaGeneralPage;

  @Page MenuClaimPage menuClaimPage;

  @Page DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

  String valorPrimaPendiente;

  public void verificarEstadoPrimaPendiente() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(POLIZA);
    valorPrimaPendiente = informacionPolizaGeneralPage.verificarEstadoPrimaPendiente();
  }

  public void verificarValorPagoPrimaPendiente() {
    MatcherAssert.assertThat(
        "No se hizo el pago de la prima pendiente",
        datoFinancieroTransaccionPage.verificarValorPagoPrimaPendiente(valorPrimaPendiente));
  }

  public void verificarValorPagoMenosPrimaPendiente() {
    MatcherAssert.assertThat(
        "El valor del pago menos la prima pendiente no es correcto",
        datoFinancieroTransaccionPage.verificarValorPagoMenosPrimaPendiente(valorPrimaPendiente));
  }
}
