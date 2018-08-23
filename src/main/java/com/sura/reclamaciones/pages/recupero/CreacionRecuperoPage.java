package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CreacionRecuperoPage extends GeneralPage {

  public CreacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//table[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:Payer-triggerWrap']//td/following-sibling::td/div"
  )
  private WebElementFacade txtPagador;

  @FindBy(
    id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:ReserveLineInputSet:ReserveLine-inputEl"
  )
  private WebElementFacade txtLineaReserva;

  @FindBy(
    xpath = "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:Currency-inputEl']"
  )
  private WebElementFacade cbxMoneda;

  @FindBy(
    xpath =
        "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Country-inputEl']"
  )
  private WebElementFacade txtPais;

  @FindBy(
    xpath =
        "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:State-inputEl']"
  )
  private WebElementFacade txtDepartamento;

  @FindBy(
    xpath =
        "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl']"
  )
  private WebElementFacade cbxCiudad;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:RecoveryCategory-inputEl")
  private WebElementFacade cbxCategoriaRecuperacion;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:idIngresoSAP-inputEl")
  private WebElementFacade txtComprobanteBancario;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:dateTransaction-inputEl")
  private WebElementFacade txtFechaComprobante;

  @FindBy(xpath = "//*[@id=\"gridview-1143-record-ext-record-5564\"]/td[2]/div")
  private WebElementFacade txtCodigoRetencion;

  @FindBy(xpath = "//div[@class='altVal']")
  private WebElementFacade txtCantidad;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:Update-btnInnerEl")
  private WebElementFacade btnActualizar;

  private String selectOpcion = "//li[.='COMODIN']";
  private String auxSelectOpcion = "";

  public void seleccionarPagador(String pagador) {
    txtPagador.waitUntilClickable();
    txtPagador.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, pagador);
    $(auxSelectOpcion).click();
  }

  public void seleccionarLineaReserva(String lineaReserva) {
    realizarEsperaCarga();
    txtLineaReserva.click();
    seleccionarOpcionCombobox(lineaReserva);
  }

  public void seleccionarMoneda(String moneda) {
    realizarEsperaCarga();
    cbxMoneda.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, moneda);
    $(auxSelectOpcion).click();
  }

  public void seleccionarPais(String pais) {
    realizarEsperaCarga();
    txtPais.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, pais);
    $(auxSelectOpcion).click();
  }

  public void seleccionarDepartamento(String departamento) {
    txtDepartamento.waitUntilClickable();
    txtDepartamento.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, departamento);
    $(auxSelectOpcion).click();
  }

  public void seleccionarCiudad(String ciudad) {
    realizarEsperaCarga();
    cbxCiudad.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, ciudad);
    $(auxSelectOpcion).click();
  }

  public void seleccionarCategoriaRecuperacion(String recupero) {
    realizarEsperaCarga();
    cbxCategoriaRecuperacion.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, recupero);
    $(auxSelectOpcion).click();
  }

  public void diligenciarCodigoRetencion(String codigoRetencion) {
    realizarEsperaCarga();
    txtCodigoRetencion.click();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, codigoRetencion);
    $(auxSelectOpcion).click();
  }

  public void diligenciarCantidadRecupero(String cantidad) {
    txtCantidad.waitUntilClickable();
    txtCantidad.click();
    txtCantidad.sendKeys(cantidad);
    txtCantidad.click();
  }

  public void actualizarRecupero() {
    btnActualizar.waitUntilClickable();
    btnActualizar.click();
  }
}
