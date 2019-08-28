package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.COP;
import static com.sura.reclamaciones.constantes.Constantes.NUMERO_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.PAGO;
import static com.sura.reclamaciones.constantes.Constantes.USD;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.constantes.ReservaConstante;
import com.sura.reclamaciones.pages.anulaciontransaccion.DetalleTransaccionPage;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.Variables;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionDatosFinancierosPage extends GeneralPage {

    @Page
    DetalleTransaccionPage detalleTransaccionPage;

    @FindBy(id = "ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV:0:CheckNumber")
    private WebElementFacade lblNumeroPago;

    @FindBy(
            xpath =
                    "//div[@id='ClaimFinancialsTransactionsDetail:ClaimFinancialsTransactionsDetailScreen:TransactionDetailPanelSet:TransactionReserveDV:TransactionBasicsInputSet:Amount-inputEl']"
    )
    private WebElementFacade lblCantidadDeducible;

    @FindBy(
            xpath =
                    "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV']"
    )
    private WebElementFacade tblTransaccion;

    @FindBy(
            xpath =
                    "//a[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:0:Amount']"
    )
    private WebElementFacade lnkReservaTransaccion;

    public VerificacionDatosFinancierosPage(WebDriver wdriver) {
        super(wdriver);
    }

    public boolean verificarNumeroPago() {
        boolean estado = false;
        if (lblNumeroPago.isVisible()) {
            estado = true;
        }
        return estado;
    }

    public String obtenerNumeroPagoRealizado() {
        return obtenerDatoTablaCabecera(NUMERO_PAGO.getValor(), 1);
    }

    public String obtenerEstadoReservaRealizada(int posicionEstadoVerificar) {
        final String ESTADO = "Estado";
        return obtenerDatoTablaCabecera(ESTADO, posicionEstadoVerificar);
    }

    public boolean verificarPagoMenuTransaccion(String datoValidar, List<WebElement> lstFilaPago) {
        int i;
        for (i = 0; i < lstFilaPago.size(); i++) {
            String strDatoPantalla = lstFilaPago.get(i).getText();
            if (strDatoPantalla.contains(COP.getValor()) || strDatoPantalla.contains(USD.getValor())) {
                strDatoPantalla = strDatoPantalla.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
            }
            if (strDatoPantalla.equals(datoValidar)) {
                return true;
            }
        }
        return false;
    }

    private List<WebElement> obtenerFilaAnulada(
            String strNumeroTransaccion, String strTipoAnulacion) {
        List<WebElement> lstPago;
        if (strTipoAnulacion.equals(PAGO.getValor())) {
            lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblPago());
        } else {
            lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
        }
        return lstPago;
    }

    public boolean verificarEstadoAnulado(
            String strAnulacion, String strNumeroTransaccion, String strTipoAnulacion) {
        List<WebElement> lstPago = obtenerFilaAnulada(strNumeroTransaccion, strTipoAnulacion);
        for (int i = 0; i < lstPago.size(); i++) {
            if (lstPago.get(i).getText().equals(strAnulacion)) {
                return true;
            }
        }
        return false;
    }

    public String obtenerDeducibleReversionConstitucion() {
        irUltimaPagina();
        tblTransaccion.waitUntilPresent();
        List<WebElement> elementroEncontrado =
                obtenerElementoTablaDatoDesconocido(
                        tblTransaccion, ReservaConstante.CANTIDAD, Integer.parseInt(POSICION_FILA.getValor()));
        int longitudTabla = elementroEncontrado.size();
        int datoPosicionReserva = longitudTabla - Integer.parseInt(POSICION_FILA.getValor());
        elementroEncontrado
                .listIterator()
                .next()
                .findElement(
                        By.xpath(
                                "//a[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:"
                                        + datoPosicionReserva
                                        + ":Amount']"))
                .click();
        String cantidadDeducible = lblCantidadDeducible.getText();
        cantidadDeducible = cantidadDeducible.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
        return cantidadDeducible;
    }

    public String obtenerMontoReservaAutomatica(String montoReserva) {
        String validarReservaTransaccion ="";
        if (lnkReservaTransaccion.isVisible()) {
            validarReservaTransaccion = lnkReservaTransaccion.waitUntilVisible().getText();
            validarReservaTransaccion =
                    validarReservaTransaccion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
        } else {
            Utilidades.getLogger().info("No se ha generado reserva en la sección de transacciones");
        }
        return validarReservaTransaccion;
    }
}
