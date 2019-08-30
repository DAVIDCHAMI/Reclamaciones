package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.*;

public class DatosFinancierosPagosPage  extends GeneralPage {

    @FindBy(
            xpath =
                    "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV']"
    )
    private WebElementFacade tblTransaccion;


    @FindBy(
            xpath =
                    "//a[@id='ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV:0:GrossAmount']"
    )
    private WebElementFacade lnkReservaTransaccion;

    public DatosFinancierosPagosPage(WebDriver wdriver) {
        super(wdriver);
    }

    public String obtenerNumeroPagoRealizado() {
        return obtenerDatoTablaCabecera(NUMERO_PAGO.getValor(), 1);
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
}
