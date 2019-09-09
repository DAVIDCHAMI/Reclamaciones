package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.constantes.ReservaConstante;
import com.sura.reclamaciones.pages.anulaciontransaccion.DetalleTransaccionPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatoFinancieroTransaccionPage extends GeneralPage {

  @Page DetalleTransaccionPage detalleTransaccionPage;

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV']"
  )
  private WebElementFacade tblTransaccion;

  public DatoFinancieroTransaccionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerEstadoReservaRealizada(int posicionEstadoVerificar) {
    final String ESTADO = "Estado";
    return obtenerDatoTablaCabecera(ESTADO, posicionEstadoVerificar);
  }

  private List<WebElement> obtenerFilaAnulada(String strNumeroTransaccion) {
    List<WebElement> lstTransaccion;
    lstTransaccion =
        obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
    return lstTransaccion;
  }

  public boolean verificarEstadoAnulado(String strAnulacion, String strNumeroTransaccion) {
    List<WebElement> lstTransaccion = obtenerFilaAnulada(strNumeroTransaccion);
    for (int i = 0; i < lstTransaccion.size(); i++) {
      if (lstTransaccion.get(i).getText().equals(strAnulacion)) {
        return true;
      }
    }
    return false;
  }

  public void ingresarDatoReserva() {
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
  }
}
