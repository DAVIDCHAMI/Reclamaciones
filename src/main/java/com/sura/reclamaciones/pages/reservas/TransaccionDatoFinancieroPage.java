package com.sura.reclamaciones.pages.reservas;

import com.sura.reclamaciones.constantes.ReservaConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransaccionDatoFinancieroPage extends GeneralPage {

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV']"
  )
  private WebElementFacade tblTransaccion;

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactionsDetail:ClaimFinancialsTransactionsDetailScreen:TransactionDetailPanelSet:TransactionReserveDV:TransactionBasicsInputSet:Amount-inputEl']"
  )
  private WebElementFacade lblCantidadDeducible;

  public TransaccionDatoFinancieroPage(WebDriver driver) {
    super(driver);
  }

  public String obtenerDeducibleReversionConstitucion() {
    irUltimaPagina();
    tblTransaccion.waitUntilPresent();
    List<WebElement> elementroEncontrado =
        obtenerElementoTablaDatoDesconocido(tblTransaccion, ReservaConstante.CANTIDAD, 1);
    int longitudTabla = elementroEncontrado.size();
    elementroEncontrado.get(longitudTabla - 1).click();
    String cantidadDeducible = lblCantidadDeducible.getText();
    cantidadDeducible = cantidadDeducible.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return cantidadDeducible;
  }
}
