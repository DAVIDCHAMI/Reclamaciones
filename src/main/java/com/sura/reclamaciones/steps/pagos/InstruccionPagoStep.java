package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.LINEA_RESERVA_LESIONES_CORPORALES;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TOTAL_PAGO_RESERVAS;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.procesoauditoria.AuditoriaPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class InstruccionPagoStep {

  List<WebElement> lstFilaPago;

  @Page GeneralPage generalPage;

  @Page AuditoriaPage auditoriaPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  private static final String MENSAJE_RECHAZO_PAGO =
      "Elementos de línea : Para realizar el pago, primero debe verificar los detalles de investigación de auditoría";

  @Step
  public void finalizarCreacionPago(List<PagoSiniestro> lstPago, String lineaReserva) {
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

  @Step
  public void verificarPagoRealizado(List<PagoSiniestro> lstPago) {
    lstPago.forEach(
        (PagoSiniestro validador) -> {
          for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
            generalPage.realizarEsperaCarga();
            String strNumeroTransaccion =
                verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
            lstFilaPago =
                verificacionDatosFinancierosPage.obtenerFilaTabla(
                    strNumeroTransaccion, verificacionDatosFinancierosPage.getTblPago());
            WebElement elementoXpath =
                lstFilaPago.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
            boolean estadoTransaccionPantalla =
                generalPage.actualizarPantalla(validador.getEstadoTransaccion(), elementoXpath);
            if (estadoTransaccionPantalla) break;
          }
          String strValorReserva =
              (Serenity.sessionVariableCalled(SESION_CC_TOTAL_PAGO_RESERVAS.getValor()).toString());
          MatcherAssert.assertThat(
              "El valor reservado no es igual al enviado",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  strValorReserva, lstFilaPago));
          MatcherAssert.assertThat(
              "No llego a SAP el pago",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  validador.getEstadoTransaccion(), lstFilaPago));
        });
  }
}
