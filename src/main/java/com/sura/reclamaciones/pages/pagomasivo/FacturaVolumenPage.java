package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacturaVolumenPage extends GeneralPage {

  @FindBy(xpath = ".//a[@data-qtip='Última página']")
  private WebElementFacade lblObtenerUltimaPagina;

  @FindBy(id = "BulkPay:BulkPayScreen:BulkInvoicesLV")
  private WebElementFacade tblNumeroFacturaPagoMasivo;

  public FacturaVolumenPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void obtenerUltimaPagina() {
    lblObtenerUltimaPagina.waitUntilPresent();
    lblObtenerUltimaPagina.click();
  }

  public void buscarNumeroFacturaPagoMasivo() {
    String SESION_CC_NUMERO_FACTURA_PAGO_MASIVO = "0000001406";
    final String NUMERO_FACTURA = "N.º de factura";
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblNumeroFacturaPagoMasivo, NUMERO_FACTURA, Integer.parseInt(POSICION_FILA.getValor()));
    int tamanoLista = elementoEncontrado.size();
    for (int i = 0; i <= tamanoLista - 1; i++) {
      if (SESION_CC_NUMERO_FACTURA_PAGO_MASIVO.equals(elementoEncontrado.get(i).getText())) {
        elementoEncontrado
            .get(i)
            .findElement(By.id("BulkPay:BulkPayScreen:BulkInvoicesLV:" + i + ":InvoiceNumber"))
            .click();
        break;
      }
    }
  }
}
