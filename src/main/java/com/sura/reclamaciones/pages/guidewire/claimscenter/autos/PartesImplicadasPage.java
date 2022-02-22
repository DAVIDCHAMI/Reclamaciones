package com.sura.reclamaciones.pages.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.enums.Constantes.CODIGO_REGION_COLOMBIA;
import static com.sura.reclamaciones.utils.enums.Constantes.COLUMNA_VALIDACION_SARLAFT;
import static com.sura.reclamaciones.utils.enums.Constantes.SIN_VALIDAR_SARLAFT;
import static com.sura.reclamaciones.utils.enums.Constantes.TIPO_DOCUMENTO_CEDULA;
import static com.sura.reclamaciones.utils.enums.EnumFormatos.FORMATO_FECHA_DDMMYYYY;
import static com.sura.reclamaciones.utils.enums.EnumFormatos.FORMATO_FECHA_YYYYMMDD;
import static com.sura.reclamaciones.utils.enums.NombresCsv.TOMADOR;
import static com.sura.reclamaciones.utils.enums.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.utils.enums.Tablas.REGISTROS_CONTACTOS_CC;

import com.sura.reclamaciones.models.Tomador;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.Fecha;
import com.sura.reclamaciones.utils.UtilidadesCSV;
import java.io.IOException;
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

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV_tb:"
              + "ContactDetailToolbarButtonSet:Edit-btnWrap")
  public WebElementFacade btnEditar;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV:"
              + "AdditionalInfoInputSet:IdentificationIssueDate_Ext-inputEl")
  public WebElementFacade txtFechaExpedicionDocuumento;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV:"
              + "AdditionalInfoInputSet:CountryOfBirth_Ext-inputEl")
  public WebElementFacade cmbPaisNacinacimiento;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV_tb:"
              + "ContactDetailToolbarButtonSet:CustomUpdateButton2-btnEl")
  public WebElementFacade btnActualizar;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV:"
              + "BusinessContactInfoInputSet:Work:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl")
  public WebElementFacade txtNumeroTrabajo;

  @FindBy(
      id =
          "ClaimContacts:ClaimContactsScreen:PeopleInvolvedDetailedListDetail:ContactBasicsDV:"
              + "BusinessContactInfoInputSet:Work:GlobalPhoneInputSet:CountryCode-inputEl")
  public WebElementFacade cmbCodigoRegion;

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

  public void completarDatosBeneficiario() throws IOException {
    final String FILTRO_TOMADOR = "tomador riesgo estándar";
    btnEditar.click();
    generalPage.realizarEsperaCarga();
    Tomador tomador =
        new Tomador(UtilidadesCSV.obtenerPrimerDatoPrueba(TOMADOR.getValor(), FILTRO_TOMADOR));
    if (tomador.getTipoDocumento().equalsIgnoreCase(TIPO_DOCUMENTO_CEDULA.getValor())) {
      String fechaExpedicionDocumento =
          Fecha.obtenerFechaConFormato(
              tomador.getFechaExpedicionDocumento(),
              FORMATO_FECHA_DDMMYYYY.getValor(),
              FORMATO_FECHA_YYYYMMDD.getValor());
      txtFechaExpedicionDocuumento.sendKeys(fechaExpedicionDocumento);
      cmbPaisNacinacimiento.click();
      generalPage.seleccionarOpcionCombobox(tomador.getNacionalidad());
    } else {
      cmbCodigoRegion.click();
      generalPage.seleccionarOpcionCombobox(CODIGO_REGION_COLOMBIA.getValor());
      txtNumeroTrabajo.sendKeys(tomador.getNumeroTrabajo());
    }
    generalPage.realizarEsperaCarga();
    btnActualizar.click();
    generalPage.realizarEsperaCarga();
  }
}
