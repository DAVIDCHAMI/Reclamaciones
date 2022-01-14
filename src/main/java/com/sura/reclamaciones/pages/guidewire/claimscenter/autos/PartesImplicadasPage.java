package com.sura.reclamaciones.pages.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.enums.Constantes.COLUMNA_VALIDACION_SARLAFT;
import static com.sura.reclamaciones.utils.enums.Constantes.SIN_VALIDAR_SARLAFT;
import static com.sura.reclamaciones.utils.enums.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.utils.enums.Tablas.REGISTROS_CONTACTOS_CC;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebElement;

public class PartesImplicadasPage extends PageObject {

  @FindBy(
      xpath =
          "//div[@id='ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:"
              + "PeopleInvolvedDetailedLV']")
  public WebElementFacade tabla;

  @FindBy(id = "Claim:MenuLinks:Claim_ClaimPartiesGroup")
  public WebElementFacade mnuPartesImplicadas;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV_tb:"
              + "SarlaftValidationToolbarButtonSet:SarlaftValidationToolbarButtons_SarlaftValidationButton")
  public WebElementFacade btnValidarSarlaft;

  @Page GeneralPage generalPage;

  public void validarSarlaft() {
    btnValidarSarlaft.waitUntilClickable().click();
    generalPage.realizarEsperaCarga();
  }

  public boolean validarEstadoSarlaft(String beneficiarioPago) {
    String estadoSarlaft;
    mnuPartesImplicadas.waitUntilClickable().click();
    generalPage.realizarEsperaCarga();
    WebElement columnaValidacionSarlaft =
        generalPage.obtenerElementoLista(
            tabla,
            CABECERAS_CC,
            REGISTROS_CONTACTOS_CC,
            beneficiarioPago,
            COLUMNA_VALIDACION_SARLAFT.getValor());
    estadoSarlaft = columnaValidacionSarlaft.getText();
    if (estadoSarlaft.equalsIgnoreCase(SIN_VALIDAR_SARLAFT.getValor())) {
      columnaValidacionSarlaft.click();
      generalPage.realizarEsperaCarga();
      return false;
    } else {
      return true;
    }
  }
}
