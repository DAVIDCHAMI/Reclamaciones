package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_FACTURA_PAGO_MASIVO;

public class FacturaVolumenPage extends GeneralPage
{

    @FindBy(xpath = ".//a[@data-qtip='Última página']")
    private WebElementFacade lblFechaRecepcionFactura;

    @FindBy(id = "BulkPay:BulkPayScreen:BulkInvoicesLV-body")
    private WebElementFacade tblNumeroFacturaPagoMasivo;

    public FacturaVolumenPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void obtenerUltimaPagina()
    {
        lblFechaRecepcionFactura.waitUntilPresent();
        lblFechaRecepcionFactura.click();
    }

    public void buscarNumeroFacturaPagoMasivo() {
        List<String> numerosFacturaPagoMasivo = new ArrayList<String>();
        final String NUMERO_FACTURA = "N.° de factura";
        List<WebElement> elementoEncontrado =
                obtenerElementoTablaDatoDesconocido(
                        tblNumeroFacturaPagoMasivo, SESION_CC_NUMERO_FACTURA_PAGO_MASIVO.getValor(), Integer.parseInt(POSICION_FILA.getValor()));


        int tamanoLista = elementoEncontrado.size();

        /*for (int i = 0; i <= tamanoLista - 1; i++) {
            nombresProcesoBatch.add(i, elementoEncontrado.get(i).getText());
            if (nombresProcesoBatch.get(i).equals(nombreProcesoBatch)) {
                tblNombreProcesoBatch.waitUntilPresent();
                tblNombreProcesoBatch.findBy("//tr[@data-recordindex='" + i + "']//a").click();
                realizarEsperaCarga();
                break;
            }*/
        }


}

