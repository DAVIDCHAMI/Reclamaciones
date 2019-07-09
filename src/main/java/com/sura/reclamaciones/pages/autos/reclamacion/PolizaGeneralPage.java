package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class PolizaGeneralPage extends GeneralPage {

  @FindBy(id = "ClaimPolicyGeneral:ClaimPolicyGeneralScreen:PolicyGeneralPanelSet:PolicyGeneralDV:FinancedPolicyBalanceSAP-inputEl")
  private WebElementFacade lblValorPrimaPendiente;

  public PolizaGeneralPage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean verificarEstadoPrimaPendiente() {
    if (lblValorPrimaPendiente.getText().replaceAll("\\D+", "").equals(VALOR_CERO.getValor())) {
      return false;
    } else {
      return true;
    }
  }
}
