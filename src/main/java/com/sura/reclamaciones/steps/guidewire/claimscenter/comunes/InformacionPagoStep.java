package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.IntroducirInformacionPagoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionPagoStep {

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Step
  public void ingresarInformacionPago(
      String lineaReserva, String tipoPago, List<PagoSiniestro> lstPago) {
    introducirInformacionPagoPage.seleccionarLineaReserva(lineaReserva);
    introducirInformacionPagoPage.seleccionarTipoPago(tipoPago);
    introducirInformacionPagoPage.ingresarComentario(lstPago.listIterator().next().getComentario());
  }

  @Step
  public void seleccionarPrimaPendiente() {
    introducirInformacionPagoPage.seleccionarOpcionDescontarSaldoPrima();
  }

  @Step
  public void ingresarInformacionRetencion(List<String> codigoRetencion, String tipoPago) {
    for (int i = 1; i < codigoRetencion.size(); i++) {
      introducirInformacionPagoPage.ingresarCantidadPago(tipoPago, i, codigoRetencion.size());
      if (i < (codigoRetencion.size() - 1)) {
        introducirInformacionPagoPage.agregarNuevaRetencion();
      }
    }
  }
}
