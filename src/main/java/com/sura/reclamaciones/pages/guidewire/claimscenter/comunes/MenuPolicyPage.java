package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPolicyPage extends GeneralPage {

  private static final String XPATH_CONTENEDOR_MENU_SUPERIOR = ".//*[@id=':tabs-innerCt']";

  @FindBy(
    xpath =
        ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  WebElementFacade mnuSegundoNivel;

  @FindBy(xpath = "//input[@id='QuickJump-inputEl']")
  WebElementFacade txtComandoPolicy;

  @FindBy(xpath = "//html")
  WebElementFacade mnuPrimerNivel;

  @FindBy(xpath = ".//*[@id='TabBar:PolicyTab:PolicyTab_SubmissionNumberSearchItem-inputEl']")
  WebElementFacade txtJobNumber;

  @FindBy(xpath = "//div[@class='x-container g-banner x-container-default x-box-layout-ct']")
  WebElementFacade mnuPrincipalGuidewire;

  @FindBy(xpath = ".//span[@id='PolicyFile:PolicyFileMenuActions-btnEl']")
  WebElementFacade mnuAccionesPrincipal;

  @FindBy(
    xpath =
        ".//div[@class='x-panel-body x-menu-body x-unselectable x-panel-body-default x-box-layout-ct x-panel-body-default x-noborder-trbl']"
  )
  WebElementFacade lstOpcionMenuAccionesPrincipal;

  public MenuPolicyPage(WebDriver wDriver) {
    super(wDriver);
  }

  public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
    WebElementFacade opcionMenuSuperior =
        $(XPATH_CONTENEDOR_MENU_SUPERIOR + "//span[contains(text(), '" + nombreOpcion + "')]");
    clickElemento(opcionMenuSuperior);
    realizarEsperaCarga();
  }

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    $(XPATH_CONTENEDOR_MENU_SUPERIOR)
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    mnuSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
  }

  public void buscarJobNumber(String jobNumber) {
    getDriver().findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.ALT, "p"));
    txtJobNumber.sendKeys(jobNumber, Keys.ENTER);
    realizarEsperaCarga();
  }

  public void seleccionarMenuGeneral() {
    WebElement elemento =
        mnuPrincipalGuidewire.findElement(By.xpath(".//span[@id=':TabLinkMenuButton-btnIconEl']"));
    waitFor(elemento).waitUntilClickable().click();
  }
}
