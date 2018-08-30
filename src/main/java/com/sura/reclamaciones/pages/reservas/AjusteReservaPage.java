package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.MenuConstante.*;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class AjusteReservaPage extends GeneralPage {

  @FindBy(xpath = "//img[@class='x-grid-checkcolumn']")
  WebElementFacade chkLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Remove-btnInnerEl']")
  WebElementFacade btnQuitar;

@Page
  MenuClaimPage menuClaimPage;

  public AjusteReservaPage(WebDriver driver) {
    super(driver);
  }

  public void ajustarReserva(String reservaModificar, String montoModificar ){
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
if(chkLineaReserva.isVisible()){
  chkLineaReserva.click();
  btnQuitar.waitUntilClickable().click();
}
  }

}
