package com.sura.reclamaciones.pages.generics;

import java.util.List;

import com.sura.reclamaciones.constantes.MenuConstante;
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
        ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  private WebElementFacade mnuSegundoNivel;

  @FindBy(
    xpath =
        ".//div[contains(@id,'ext-gen') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  private WebElementFacade mnuSegundoNivelEscritorio;

  @FindBy(xpath = "//input[@id='QuickJump-inputEl']")
  private WebElementFacade txtComandoPolicy;

  @FindBy(xpath = " //div[@id='westPanel-innerCt']")
  private WebElementFacade mnuLateralPrimerNivel;

  @FindBy(xpath = "//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']")
  private WebElementFacade mnuBuscar;

  @FindBy(xpath = "//span[@id='Claim:ClaimMenuActions-btnIconEl']")
  private WebElementFacade btnAcciones;

  @FindBy(
    xpath = "//table[@class='x-columnmenu-table']//td//a[contains(@id, 'Claim:ClaimMenuActions')]"
  )
  private List<WebElementFacade> mnuPanelOpcionesPrimerNivel;

  @FindBy(xpath = "//span[contains(@class,'x-menu-item-text')][contains(text(),'")
  private WebElementFacade opcionMenuAcciones;

  @FindBy(
    id =
        "Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item-textEl"
  )
  private WebElementFacade mnuNuevaExposicion;

  @FindBy(
    id =
        "Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage"
  )
  private WebElementFacade mnuExposicion;

  @FindBy(
    xpath =
        ".//div[@class='x-panel x-layer x-panel-default x-menu x-border-box x-vertical-scroller x-panel-vertical-scroller x-panel-default-vertical-scroller']"
  )
  WebElementFacade mnuReclamacion;

  @FindBy(
    id =
        "Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewTransaction_CheckSet-textEl"
  )
  WebElementFacade lblPagos;

  public MenuClaimPage(WebDriver wDriver) {
    super(wDriver);
  }

  public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
    mnuPrimerNivel
        .findElement(By.xpath(String.format(".//a[contains(.,'%s')]", nombreOpcion)))
        .sendKeys(Keys.ARROW_DOWN);
  }

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    mnuPrimerNivel
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);

    if(nombreOpcion.equals(MenuConstante.ESCRITORIO_MENU))
    {
      mnuSegundoNivelEscritorio.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
    }
    else
      if (nombreOpcion.equals(MenuConstante.RECLAMACION_MENU))
      {
        mnuSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
      }
  }

  public void seleccionarOpcionMenuLateralPrimerNivel(String nombreOpcion) {
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
