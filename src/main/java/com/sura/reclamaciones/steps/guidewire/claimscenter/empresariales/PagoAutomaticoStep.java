package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.TRANSACCIONES;
import static com.sura.reclamaciones.utils.enums.Constantes.DATOS_FINANCIEROS;
import static com.sura.reclamaciones.utils.enums.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.utils.enums.Constantes.PAGOS;
import static com.sura.reclamaciones.utils.enums.Constantes.UBICACION_ESTADO_PAGO;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroPagoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.NuevaReclamacionGuardadaPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class PagoAutomaticoStep {

  List<WebElement> lstFilaPago;

  @Page DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

  @Page DatoFinancieroPagoPage datoFinancieroPagoPage;

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  public void verificarMontoReservaAutomatica(List<Reserva> lstReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        DATOS_FINANCIEROS.getValor(), TRANSACCIONES);
    lstReserva.forEach(
        reserva ->
            MatcherAssert.assertThat(
                "El valor de la reserva es diferente a:"
                    + reserva.getValorReserva()
                    + ". Revisar en configuración comercial la parametrización de reservas automáticas.",
                datoFinancieroTransaccionPage
                    .obtenerMontoReserva()
                    .equals(reserva.getValorReserva())));
  }

  public void verificarPagoAutomatico(List<PagoSiniestro> lstPago) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        DATOS_FINANCIEROS.getValor(), PAGOS.getValor());
    lstPago.forEach(
        pago -> {
          for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
            generalPage.realizarEsperaCarga();
            lstFilaPago =
                datoFinancieroPagoPage.obtenerFilaTabla(
                    datoFinancieroPagoPage.obtenerNumeroPagoRealizado(),
                    datoFinancieroPagoPage.getTblPago());
            WebElement elementoXpath =
                lstFilaPago.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
            boolean estadoTransaccionPantalla =
                generalPage.actualizarPantalla(pago.getEstadoTransaccion(), elementoXpath);
            if (estadoTransaccionPantalla) break;
          }
          MatcherAssert.assertThat(
              "No se realizó el pago automático. Revisar en configuración comercial la parametrización de pagos automáticos.",
              datoFinancieroPagoPage.verificarPagoMenuTransaccion(
                  pago.getEsPagoAutomatico(), lstFilaPago));
          MatcherAssert.assertThat(
              "El valor del pago es diferente a: " + pago.getValorTransaccion(),
              datoFinancieroPagoPage.verificarPagoMenuTransaccion(
                  pago.getValorTransaccion(), lstFilaPago));
          MatcherAssert.assertThat(
              "No llego a SAP el pago",
              (datoFinancieroPagoPage.verificarPagoMenuTransaccion(
                  pago.getEstadoTransaccion(), lstFilaPago)));
        });
  }
}
