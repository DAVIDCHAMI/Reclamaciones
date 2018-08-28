package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MenuRecuperoPage extends GeneralPage {

  public MenuRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = ".//*[@id=':tabs-innerCt']")
  private WebElementFacade mnmPrimerNivel;

  @FindBy(
    xpath =
        ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  private WebElementFacade mnmSegundoNivel;

  @FindBy(xpath = "//span[@id ='Claim:ClaimMenuActions-btnInnerEl']")
  private WebElementFacade btnAcciones;

  @FindBy(
    xpath =
        "//a[@id='Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewOtherTrans-itemEl']"
  )
  private WebElementFacade mnmOtros;

  @FindBy(
    xpath =
        "//span[@id='Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewOtherTrans:ClaimMenuActions_NewTransaction_RecoverySet-textEl']"
  )
  private WebElementFacade mnmRecuperos;

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    mnmPrimerNivel
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    mnmSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
    realizarEsperaCarga();
  }

  public void irMenuRecupero(String tipoReserva) {
    btnAcciones.waitUntilClickable();
    btnAcciones.click();
    mnmOtros.waitUntilClickable();
    mnmOtros.click();
    mnmRecuperos.waitUntilClickable();
    mnmRecuperos.click();
  }
}
