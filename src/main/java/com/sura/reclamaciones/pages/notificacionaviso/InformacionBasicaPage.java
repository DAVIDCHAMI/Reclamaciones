package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends GeneralPage {

  public InformacionBasicaPage(WebDriver driver) {
    super(driver);
  }

  private String diaMes = "//td[@class='datePickerDay ' or @class='datePickerDay datePickerDayIsWeekend '][contains(text(),'COMODIN')]";
  private String auxDiaMes = "";

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputEl']"
  )
  private WebElementFacade txtNombreAutor;

  @FindBy(
    xpath =
        "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li"
  )
  private WebElementFacade lstAutorReporte;

  @FindBy(
    xpath =
        "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li[2]"
  )
  private WebElementFacade lstAutorReporteCliente;

  @FindBy(
    xpath =
        "//textarea[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Description-inputEl']"
  )
  private WebElementFacade txtDetalleHechos;

  @FindBy(
    xpath =
        " //a[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name:ReportedBy_NameMenuIcon']"
  )
  private WebElementFacade btnCotactManager;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name:MenuItem_Search-textEl']"
  )
  private WebElementFacade btnBuscarContactoExistente;

  @FindBy(
    xpath =
        "//input[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:TaxID-inputEl']"
  )
  private WebElementFacade txtNit;

  @FindBy(
    xpath =
        "//a[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']"
  )
  private WebElementFacade btnBuscarNit;

  @FindBy(
    xpath =
        "//a[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchLV:0:_Select']"
  )
  private WebElementFacade btnSeleccionarContacto;

  @FindBy(
    xpath =
        " //input[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Claim_ReportedByType-inputEl']"
  )
  private WebElementFacade btnRelacionAsegurado;

  @FindBy(xpath = "//li[contains(text(),'Amigo')]")
  private WebElementFacade lstAmigo;

  @FindBy(id = "calendarsdfFechaAvisoInformacionSiniestroEmp")
  private WebElementFacade calendarioFechaAviso;

  @FindBy(id = "calendarsdfFechaRecepcionInformacionSiniestroEmp")
  private WebElementFacade calendarioFechaRecepcion;

  @FindBy(id = "calendarfechaOcurrenciaInformacionSiniestroEmp")
  private WebElementFacade calendarioFechaSiniestro;

  @FindBy(className = "datePickerMonth")
  private WebElementFacade indicadorAnioMes;





  public void seleccionarAutorReporte() {
    txtNombreAutor.waitUntilVisible();
    txtNombreAutor.click();
    if (lstAutorReporteCliente.isVisible()) {
      lstAutorReporteCliente.waitUntilVisible();
      lstAutorReporteCliente.click();
      realizarEsperaCarga();
    } else {
      btnCotactManager.waitUntilClickable();
      btnCotactManager.click();
      btnBuscarContactoExistente.waitUntilClickable();
      btnBuscarContactoExistente.click();
      txtNit.waitUntilVisible();
      txtNit.sendKeys(ConstanteGlobal.NIT);
      btnBuscarNit.waitUntilClickable();
      btnBuscarNit.click();
      btnSeleccionarContacto.waitUntilClickable();
      btnSeleccionarContacto.click();
      realizarEsperaCarga();
      btnRelacionAsegurado.waitUntilClickable();
      btnRelacionAsegurado.click();
      lstAmigo.waitUntilVisible();
      lstAmigo.click();
    }
  }

  public void escribirDetallehechos(String detalle) {
    txtDetalleHechos.waitUntilVisible();
    txtDetalleHechos.type(detalle);
    continuarSiguientePantalla();
  }

  public void seleccionarFechaAviso(String fechaAviso){
    //2018/11/15
  // Date date = new Date();
  // DateFormat horaFormateada = new SimpleDateFormat("yyyy/MM/dd");
  // String fechaActual=horaFormateada.format(date);
    String dia = fechaAviso.substring(8,9);
    calendarioFechaAviso.waitUntilVisible().click();
    String auxIndicadorAnioMes = indicadorAnioMes.getText();
    auxIndicadorAnioMes.substring(5,8);
    if(auxIndicadorAnioMes.equalsIgnoreCase(fechaAviso)) {
      auxIndicadorAnioMes = diaMes.replace(ConstanteGlobal.COMODIN, dia);
      $(auxIndicadorAnioMes).click();
    }else{

      }


    }


  }

