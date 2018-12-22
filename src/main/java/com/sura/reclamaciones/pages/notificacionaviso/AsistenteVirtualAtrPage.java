package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class AsistenteVirtualAtrPage extends GeneralPage {

  private String mnuAsistenteVirtual = "//span[contains(text(),'COMODIN')]";
  private String auxiliarMnuAsistenteVirtual = "";

  @FindBy(xpath = "//img[@title='Asistente Virtual']")
  private WebElementFacade bntAsistenteVirtual;

  @FindBy(
    xpath = "//div[@class='ig_ac11e92_r5 rootMenu rootMenu nodeSubMenu nodeSubMenuSelected']/span"
  )
  private WebElementFacade lstAsistenteVirtual;

  @FindBy(id = "slbProducto")
  private WebElementFacade lstProducto;

  @FindBy(xpath = "//option[contains(text(),'OTROS PRODUCTOS')]")
  private WebElementFacade mnuOtroProducto;

  @FindBy(xpath = "//img[@src='images/Bot_Aceptar.jpg']")
  private WebElementFacade btnAceptar;

  @FindBy(id = "tipoIdInformacionAsegurado")
  private WebElementFacade lstIdentificacionAsegurado;

  @FindBy(xpath = "//div[contains(.,'Bienvenido al Tour')]/a[2]")
  private WebElementFacade btnCerrarTour;

  public AsistenteVirtualAtrPage(WebDriver driver) {
    super(driver);
  }

  public void accederAsistenteVirtual() {
    resaltarElemento(bntAsistenteVirtual);
    bntAsistenteVirtual.waitUntilVisible().click();
    enfocarVistaAutomatizacion();
  }

  public void accederAvisoEmpresa() {
    if (btnCerrarTour.isVisible()) {
      resaltarElemento(btnCerrarTour);
      btnCerrarTour.click();
    }
    auxiliarMnuAsistenteVirtual =
        mnuAsistenteVirtual.replace(
            ConstanteGlobal.COMODIN, ReclamacionConstante.ASISTENTE_VIRTUAL);
    resaltarElemento($(auxiliarMnuAsistenteVirtual));
    $(auxiliarMnuAsistenteVirtual).waitUntilVisible().click();
    auxiliarMnuAsistenteVirtual =
        mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, ReclamacionConstante.HERRAMIENTAS);
    resaltarElemento($(auxiliarMnuAsistenteVirtual));
    $(auxiliarMnuAsistenteVirtual).waitUntilVisible().click();
    auxiliarMnuAsistenteVirtual =
        mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, ReclamacionConstante.RECLAMACIONES);
    resaltarElemento($(auxiliarMnuAsistenteVirtual));
    $(auxiliarMnuAsistenteVirtual).waitUntilVisible().click();
    auxiliarMnuAsistenteVirtual =
        mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, ReclamacionConstante.EMPRESAS);
    resaltarElemento($(auxiliarMnuAsistenteVirtual));
    $(auxiliarMnuAsistenteVirtual).waitUntilVisible().click();
  }

  public void seleccionarPlanListaProducto() {
    enfocarVistaAutomatizacion();
    lstProducto.waitUntilVisible().click();
    mnuOtroProducto.waitUntilVisible().click();
    btnAceptar.waitUntilVisible().click();
  }
}
