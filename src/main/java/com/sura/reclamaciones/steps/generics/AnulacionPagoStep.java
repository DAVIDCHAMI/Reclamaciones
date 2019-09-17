package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.generics.DatoFinancieroPagoPage;
import com.sura.reclamaciones.pages.generics.DetalleChequePage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;

public class AnulacionPagoStep {

    @Page
    DatoFinancieroPagoPage datoFinancieroPagoPage;

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    DetalleChequePage detalleChequePage;

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
    public void verificarAnulacionPago(String strAnulacionPago) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
                MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
        MatcherAssert.assertThat(
                "El pago no quedo en estado anulado",
                datoFinancieroPagoPage.verificarEstadoAnuladoPago(strAnulacionPago, strNumeroCheque, detalleChequePage.getTblPago()));
    }
}
