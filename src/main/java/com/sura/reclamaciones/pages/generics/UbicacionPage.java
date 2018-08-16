package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class UbicacionPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Country-inputEl']"
  )
  private WebElementFacade mnuPais;

  @FindBy(
    xpath =
        "//td[.='Departamento']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']"
  )
  private WebElementFacade mnuDepartamento;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl']"
  )
  private WebElementFacade txtCiudad;

  private String selectOpcion = "//li[.='COMODIN']";
  private String auxSelectOpcion = "";

  public UbicacionPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarPais(String pais) {
    mnuPais.waitUntilVisible();
    mnuPais.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, pais);
    $(auxSelectOpcion).click();
  }

  public void seleccionarDepartamento(String departamento) {
    mnuDepartamento.waitUntilVisible();
    mnuDepartamento.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, departamento);
    $(auxSelectOpcion).click();
  }

  public void seleccionarCiudad(String ciudad) {
    txtCiudad.waitUntilVisible();
    realizarEsperaCarga();
    txtCiudad.clear();
    txtCiudad.type(ciudad);
  }
}
