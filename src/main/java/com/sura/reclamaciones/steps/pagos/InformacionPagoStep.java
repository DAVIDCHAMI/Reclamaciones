package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionPagoStep {

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page GeneralPage generalPage;

  @Step
  public void ingresarInformacionPago(
      String lineaReserva, String tipoPago, List<PagoSiniestro> lstPago) {
    introducirInformacionPagoPage.seleccionarLineaReserva(lineaReserva);
    introducirInformacionPagoPage.seleccionarTipoPago(tipoPago);
    introducirInformacionPagoPage.ingresarComentario(lstPago.listIterator().next().getComentario());
  }

  @Step
  // public void ingresarInformacionDetallePago(List<List<String>> codigoRetencion, int i, String tipoPago) {
  public void ingresarInformacionRetencion(List<List<String>> codigoRetencion, int i) {
 //  int j=0;
    // for (PagoSiniestro retencion : lstPago) {
    //    introducirInformacionPagoPage.ingresarCodigoRetencion(
    //   codigoRetencion, CODIGO_RETENCION.getValor());
    for (int j = 1; j < codigoRetencion.size(); j++) {
      introducirInformacionPagoPage.agregarCodigoRetencion(codigoRetencion.get(i).get(j-1).trim());
      introducirInformacionPagoPage.ingresarCantidadPago(CANTIDAD.getValor());
      if (i < codigoRetencion.size()){
        introducirInformacionPagoPage.agregarNuevaRetencion();
        i++;
      }
    }

  }

  @Step
  public void ingresarInformacionCantidadPago(String tipoPago) {

    introducirInformacionPagoPage.ingresarCantidadPago(CANTIDAD.getValor());
  }

  @Step
  public void agregarNuevoCodigoRetencion() {
    introducirInformacionPagoPage.agregarNuevaRetencion();
  }
}
