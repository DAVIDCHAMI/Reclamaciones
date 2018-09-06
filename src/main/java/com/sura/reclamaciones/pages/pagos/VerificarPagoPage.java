package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerificarPagoPage extends GeneralPage{


    public VerificarPagoPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(
            xpath =
                    "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV-body']"
    )
    private WebElementFacade tblVerificacionPago;


    public String capturarNumeroPagoRealizado(String strNumeroPago) {

    List<WebElement> elementoEncontrado = obtenerElementoTablaDatoDesconocido(tblVerificacionPago, PagoConstante.PAGO_RECUPERO);
        elementoEncontrado.forEach(
                elemento -> {
                  elemento.findElement(By.xpath("//div[last()]")).getText();
                });

    return strNumeroPago;

    }
}
