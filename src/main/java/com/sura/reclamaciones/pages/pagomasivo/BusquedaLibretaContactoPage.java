package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_COLUMNA_MENOS_DOS;
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

  @FindBy(id = "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchLV")
  private WebElementFacade tblResultadoBusquedaContacto;

  @FindBy(id = "ext-gen")
  private WebElementFacade btnSeleccionarContactoPagoMasivo;

  int posicionNombreContactoEncontrado, tamanoLista;

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

  public void seleccionarContactoPagoMasivo(String nombreContacto) {
    final String RESULTADO_BUSQUEDA_CONTACTO = "Nombre";
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblResultadoBusquedaContacto,
            RESULTADO_BUSQUEDA_CONTACTO,
            Integer.parseInt(POSICION_COLUMNA_MENOS_DOS.getValor()));
    elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).click();
  }
}
