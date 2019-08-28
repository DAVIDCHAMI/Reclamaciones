package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.LINEA_RESERVA_LESIONES_CORPORALES;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.procesoauditoria.AuditoriaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;


public class InstruccionPagoStep {

  List<WebElement> lstFilaPago;

  @Page GeneralPage generalPage;

  @Page AuditoriaPage auditoriaPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  private static final String MENSAJE_RECHAZO_PAGO =
      "Elementos de línea : Para realizar el pago, primero debe verificar los detalles de investigación de auditoría";

  @Step
  public void establecerInstruccionPago(List<PagoSiniestro> lstPago, String lineaReserva) {
    generalPage.irSiguientePagina();
    if (auditoriaPage.verificarMensajeRechazo()) {
      MatcherAssert.assertThat(
          "No generó la validación de NO pago a asegurado por proceso de auditoría",
          auditoriaPage.capturarMensajeRechazo().equalsIgnoreCase(MENSAJE_RECHAZO_PAGO));
    } else if (!lineaReserva.equals(LINEA_RESERVA_LESIONES_CORPORALES.getValor())) {
      establecerInstruccionPagoPage.obtenerPagoReservas();
      establecerInstruccionPagoPage.ingresarFechaFactura();
      establecerInstruccionPagoPage.ingresarNumeroFactura(
          lstPago.listIterator().next().getNumeroFactura());
      establecerInstruccionPagoPage.finalizarProceso();
    }
  }

}
