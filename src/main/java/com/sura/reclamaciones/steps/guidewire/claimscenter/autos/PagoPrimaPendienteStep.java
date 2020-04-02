package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.POLIZA;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.InformacionPolizaGeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
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
