package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.PAGOS;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroPagoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DetalleChequePage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AnulacionPagoStep {

  @Page DatoFinancieroPagoPage datoFinancieroPagoPage;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleChequePage detalleChequePage;

  String strNumeroCheque;

  @Step
  public void ingresarAnulacionPago(List<PagoSiniestro> lstPago) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
    strNumeroCheque = datoFinancieroPagoPage.obtenerNumeroPagoRealizado();
    for (PagoSiniestro diligenciador : lstPago) {
      MatcherAssert.assertThat(
          "El estado de la transaccion no permite que sea anulada",
          datoFinancieroPagoPage.ingresarDetalleCheque(
              strNumeroCheque, diligenciador.getEstadoTransaccion()));
      MatcherAssert.assertThat(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleChequePage.realizarAnulacionCheque());
    }
  }

  @Step
  public void verificarAnulacionPago() {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
    MatcherAssert.assertThat(
        "El pago no quedo en estado anulado",
        datoFinancieroPagoPage.verificarEstadoAnuladoPago(
            strNumeroCheque, detalleChequePage.getTblPago()));
  }
}
