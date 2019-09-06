package com.sura.reclamaciones.steps.generics;

import static com.sura.reclamaciones.constantes.Constantes.*;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TOTAL_PAGO_RESERVAS;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.anulaciontransaccion.DetalleTransaccionPage;
import com.sura.reclamaciones.pages.generics.DatoFinancieroPagoPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class AnulacionPagoStep {

  private String strTipoAnulacion;
  List<WebElement> lstFilaPago;

  @Page DatoFinancieroPagoPage datoFinancieroPagoPage;

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleTransaccionPage detalleTransaccionPage;

  @Step
  public void ingresarAnulacionPago(List<PagoSiniestro> lstPago) {
    strTipoAnulacion = PAGO.getValor();
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
    for (PagoSiniestro diligenciador : lstPago) {
      String strNumeroTransaccion = datoFinancieroPagoPage.obtenerNumeroPagoRealizado();
      MatcherAssert.assertThat(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion, diligenciador.getEstadoTransaccion(), strTipoAnulacion));
      MatcherAssert.assertThat(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(strTipoAnulacion));
      Serenity.setSessionVariable(SESION_CC_NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void verificarAnulacionPagoRealizada(String strAnulacionPago) {
    String strNumeroTransaccion =
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_TRANSACCION.getValor());
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
    MatcherAssert.assertThat(
        "El pago no quedo en estado anulado",
        datoFinancieroPagoPage.verificarEstadoAnuladoPago(strAnulacionPago, strNumeroTransaccion));
  }
}
