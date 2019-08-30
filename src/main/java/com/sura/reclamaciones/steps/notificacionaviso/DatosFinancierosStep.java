package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.DATOS_FINANCIEROS;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.constantes.MenuConstante.PAGOS;

public class DatosFinancierosStep {

    List<WebElement> lstFilaPago;

    @Page
    VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

    @Page
    DatosFinancierosPagosPage datosFinancierosPagosPage;

    @Page
    GeneralPage generalPage;

    @Page
    MenuClaimPage menuClaimPage;

    public void verificarMontoReservaAutomatica(List<Reserva> lstReserva) {
        lstReserva.forEach(
                reserva -> {
                    MatcherAssert.assertThat(
                            "El valor de la reserva es diferente a:" + reserva.getValorReserva() + ". Revisar en configuración comercial la parametrización de reservas automáticas.",
                            verificacionDatosFinancierosPage.obtenerMontoReservaAutomatica(reserva.getValorReserva()).equals(reserva.getValorReserva()));
                });
    }

    public void verificarPagoAutomatico(List<PagoSiniestro> lstPago) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(DATOS_FINANCIEROS.getValor(), PAGOS);
        lstPago.forEach(
                pago -> {
                    for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
                        generalPage.realizarEsperaCarga();
                        lstFilaPago =
                                datosFinancierosPagosPage.obtenerFilaTabla(
                                        datosFinancierosPagosPage.obtenerNumeroPagoRealizado(), datosFinancierosPagosPage.getTblPago());
                        WebElement elementoXpath =
                                lstFilaPago.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
                        boolean estadoTransaccionPantalla =
                                generalPage.actualizarPantalla(pago.getEstadoTransaccion(), elementoXpath);
                        if (estadoTransaccionPantalla) break;
                    }
                    MatcherAssert.assertThat(
                            "No se realizó el pago automático. Revisar en configuración comercial la parametrización de pagos automáticos.",
                            datosFinancierosPagosPage.verificarPagoMenuTransaccion(
                                    pago.getEsPagoAutomatico(), lstFilaPago));
                    MatcherAssert.assertThat(
                            "El valor del pago es diferente a: " + pago.getValorTransaccion(),
                            datosFinancierosPagosPage.verificarPagoMenuTransaccion(
                                    pago.getValorTransaccion(), lstFilaPago));
                    MatcherAssert.assertThat(
                            "No llego a SAP el pago",
                            (datosFinancierosPagosPage.verificarPagoMenuTransaccion(
                                    pago.getEstadoTransaccion(), lstFilaPago)));
                });
    }
}