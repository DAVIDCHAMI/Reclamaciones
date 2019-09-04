package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.constantes.ReservaConstante;
import com.sura.reclamaciones.pages.anulaciontransaccion.DetalleTransaccionPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

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

    public String obtenerEstadoReservaRealizada(int posicionEstadoVerificar) {
        final String ESTADO = "Estado";
        return obtenerDatoTablaCabecera(ESTADO, posicionEstadoVerificar);
    }

    private List<WebElement> obtenerFilaAnulada(
            String strNumeroTransaccion, String strTipoAnulacion) {
        List<WebElement> lstTransaccion;
        lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
        return lstTransaccion;
    }

    public boolean verificarEstadoAnulado(
            String strAnulacion, String strNumeroTransaccion, String strTipoAnulacion) {
        List<WebElement> lstTransaccion = obtenerFilaAnulada(strNumeroTransaccion, strTipoAnulacion);
        for (int i = 0; i < lstTransaccion.size(); i++) {
            if (lstTransaccion.get(i).getText().equals(strAnulacion)) {
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
}
