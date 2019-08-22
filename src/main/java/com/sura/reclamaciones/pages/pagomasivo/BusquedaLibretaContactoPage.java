package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusquedaLibretaContactoPage extends GeneralPage {

  @FindBy(
    id = "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:ContactSubtype-inputEl"
  )
  private WebElementFacade cmbTipoContacto;

  @FindBy(xpath = "//ul[@class='x-list-plain']")
  private WebElementFacade lstTipoContacto;

  @FindBy(
    id =
        "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:NameInputSet:GlobalContactNameInputSet:Name-inputEl"
  )
  private WebElementFacade txtNombreContacto;

  @FindBy(
    id =
        "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"
  )
  private WebElementFacade btnBuscarContacto;

  @FindBy(id = "ext-gen")
  private WebElementFacade btnSeleccionarContactoPagoMasivo;

  public BusquedaLibretaContactoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarTipoContacto(String tipoContacto) {
    cmbTipoContacto.click();
    lstTipoContacto
        .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + tipoContacto + "')]"))
        .click();
  }

  public void ingresarNombreContacto(String nombreContacto) {
    txtNombreContacto.waitUntilPresent();
    txtNombreContacto.sendKeys(nombreContacto);
  }

  public void buscarContacto() {
    btnBuscarContacto.waitUntilPresent();
    btnBuscarContacto.waitUntilClickable();
    btnBuscarContacto.click();
  }
}
