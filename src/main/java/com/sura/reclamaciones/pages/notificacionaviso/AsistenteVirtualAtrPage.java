package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class AsistenteVirtualAtrPage extends GeneralPage {

  private String mnuAsistenteVirtual = "//span[contains(text(),'COMODIN')]";
  private String auxMnuAsistenteVirtual = "";

  @FindBy(xpath = "//img[@title='Asistente Virtual']")
  private WebElementFacade bntAsistenteVirtual;

  @FindBy(xpath = "//div[@class='ig_ac11e92_r5 rootMenu rootMenu nodeSubMenu nodeSubMenuSelected']/span")
  private WebElementFacade lstAsistenteVirtual;

  public AsistenteVirtualAtrPage(WebDriver driver) {
    super(driver);
  }

  public void accederHerramientaAvisoEmpresa(){
    bntAsistenteVirtual.waitUntilVisible().click();
    enfocarVentana();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Asistente virtual");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Herramientas");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Reclamaciones");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Ingresar aviso  de Empresas");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
  }

}
