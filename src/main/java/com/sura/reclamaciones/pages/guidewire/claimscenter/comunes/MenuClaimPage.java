package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MenuClaimPage extends GeneralPage {

  @FindBy(xpath = ".//*[@id=':tabs-innerCt']")
  private WebElementFacade mnuPrimerNivel;

  @FindBy(
      xpath =
          ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']")
  private WebElementFacade mnuSegundoNivel;

  @FindBy(
      xpath =
          ".//div[contains(@id,'ext-gen') and @class='x-panel x-layer x-panel-default x-menu x-border-box']")
  private WebElementFacade mnuSegundoNivelEscritorio;

  @FindBy(xpath = " //div[@id='westPanel-innerCt']")
  private WebElementFacade mnuLateralPrimerNivel;

  @FindBy(xpath = "//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']")
  private WebElementFacade mnuBuscar;

  @FindBy(xpath = "//span[@id='Claim:ClaimMenuActions-btnIconEl']")
  private WebElementFacade btnAcciones;

  @FindBy(
      xpath =
          "//table[@class='x-columnmenu-table']//td//a[contains(@id, 'Claim:ClaimMenuActions')]")
  private List<WebElementFacade> mnuPanelOpcionesPrimerNivel;

  public MenuClaimPage(WebDriver wDriver) {
    super(wDriver);
  }

  public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
    mnuPrimerNivel
        .findElement(By.xpath(String.format(".//a[contains(.,'%s')]", nombreOpcion)))
        .sendKeys(Keys.ARROW_DOWN);
  }

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    final String OPCION_MENU = ".//a[contains(.,'";
    mnuPrimerNivel
        .findElement(By.xpath(OPCION_MENU + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    if (nombreOpcion.equals(MenuConstante.ESCRITORIO_MENU)) {
      mnuSegundoNivelEscritorio.findElement(By.xpath(OPCION_MENU + subItem + "')]")).click();
    } else if (nombreOpcion.equals(MenuConstante.RECLAMACION_MENU)) {
      mnuSegundoNivel.findElement(By.xpath(OPCION_MENU + subItem + "')]")).click();
    }
  }

  public void seleccionarOpcionMenuLateralPrimerNivel(String nombreOpcion) {
    realizarTiempoEsperaCarga();
    mnuLateralPrimerNivel
        .findElement(
            By.xpath(
                String.format(
                    "//span[contains(@class,'x-tree-node-text')][contains(text(),'%s')]",
                    nombreOpcion)))
        .click();
    realizarEsperaCarga();
  }

  public void seleccionarOpcionMenuLateralSegundoNivel(String nombreOpcion, String subItem) {
    seleccionarOpcionMenuLateralPrimerNivel(nombreOpcion);
    realizarEsperaCarga();
    seleccionarOpcionMenuLateralPrimerNivel(subItem);
  }

  public void buscarReclamacion(String strOpcionMenu, String strReclamacion) {
    seleccionarOpcionMenuPrimerNivel(strOpcionMenu);
    mnuBuscar.click();
    mnuBuscar.typeAndEnter(strReclamacion);
    realizarEsperaCarga();
  }

  public void seleccionarOpcionMenuAccionesPrimerNivel(String nombreOpcion) {
    mnuPanelOpcionesPrimerNivel
        .iterator()
        .next()
        .findBy(
            By.xpath(
                "//span[contains(@class,'x-menu-item-text')][contains(text(),'"
                    + nombreOpcion
                    + "')]"))
        .click();
    realizarEsperaCarga();
  }

  public void seleccionarBotonAcciones() {
    btnAcciones.waitUntilVisible().waitUntilClickable().click();
  }
}
