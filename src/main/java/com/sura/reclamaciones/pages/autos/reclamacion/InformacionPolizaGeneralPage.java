package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

public class InformacionPolizaGeneralPage extends GeneralPage {

  @FindBy(
    id =
        "ClaimPolicyGeneral:ClaimPolicyGeneralScreen:PolicyGeneralPanelSet:PolicyGeneralDV:FinancedPolicyBalanceSAP-inputEl"
  )
  private WebElementFacade lblValorPrimaPendiente;

  public InformacionPolizaGeneralPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String verificarEstadoPrimaPendiente() {
    String valorPrimaPendiente = lblValorPrimaPendiente.getText();
    MatcherAssert.assertThat(
        "No tiene prima pendiente",
        !(valorPrimaPendiente.replaceAll("\\D+", "").equals(VALOR_CERO.getValor())));
    return valorPrimaPendiente;
  }
}
