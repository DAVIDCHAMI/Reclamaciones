package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Utilidades;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends GeneralPage {

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
  private WebElementFacade btnContactManager;

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

  @FindBy(id = "calendarfechaOcurrenciaInformacionSiniestroEmp")
  private WebElementFacade calendarioFechaSiniestro;

  @FindBy(className = "datePickerMonth")
  private WebElementFacade indicadorAnioMes;

  private String btnCambioMesAnio =
      "//table[@class='datePickerMonthSelector']//td[COMODIN]//div[@class='html-face']";
  private String diaMes =
      "//td[@class='datePickerDay ' or @class='datePickerDay datePickerDayIsWeekend '][contains(text(),'COMODIN')]";
  private String auxMes = "";
  private String auxiliarReemplazo = "";

  public InformacionBasicaPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarAutorReporte() {
    txtNombreAutor.waitUntilVisible();
    txtNombreAutor.click();
    if (lstAutorReporteCliente.isVisible()) {
      lstAutorReporteCliente.waitUntilVisible();
      lstAutorReporteCliente.click();
      realizarEsperaCarga();
    } else {
      btnContactManager.waitUntilClickable();
      btnContactManager.click();
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

  public void seleccionarDiaCalendario(String diaUsuario) {
    navegarMenu(diaUsuario, diaMes);
  }

  public void seleccionarMesAnterior(int valorMesAnterior, int valorMesActual) {
    int buscadorValor = valorMesActual - valorMesAnterior;
    int numeroClick = 0;
    auxiliarReemplazo = btnCambioMesAnio.replace(ConstanteGlobal.COMODIN, "2");
    while (numeroClick < buscadorValor) {
      $(auxiliarReemplazo).waitUntilVisible().click();
      numeroClick++;
    }
  }

  public void seleecionarMesPosterior(int valorMesPosterior, int valorMesActual) {
    int buscadorValor = valorMesPosterior - valorMesActual;
    int numeroClick = 0;
    auxiliarReemplazo = btnCambioMesAnio.replace(ConstanteGlobal.COMODIN, "4");
    while (numeroClick < buscadorValor) {
      $(auxiliarReemplazo).waitUntilVisible().click();
      numeroClick++;
    }
  }

  public void seleccionarAnioAnterior(int valorAnioAnterior, int valorAnioActual) {
    int buscadorValor = valorAnioActual - valorAnioAnterior;
    int numeroClick = 0;
    auxiliarReemplazo = btnCambioMesAnio.replace(ConstanteGlobal.COMODIN, "1");
    while (numeroClick < buscadorValor) {
      $(auxiliarReemplazo).waitUntilVisible().click();
      numeroClick++;
    }
  }

  public void seleccionarAnioPosterior(int valorAnioPosterior, int valorAnioActual) {
    int buscadorValor = valorAnioPosterior - valorAnioActual;
    int numeroClick = 0;
    auxiliarReemplazo = btnCambioMesAnio.replace(ConstanteGlobal.COMODIN, "5");
    while (numeroClick < buscadorValor) {
      $(auxiliarReemplazo).waitUntilVisible().click();
      numeroClick++;
    }
  }

  public void seleccionarFechaAviso(String fechaAviso) {
    String diaUsuario = fechaAviso.substring(9, 11);
    String mesUsuario = fechaAviso.substring(5, 8);
    String anioUsuario = fechaAviso.substring(0, 4);
    realizarEsperaCarga();
    calendarioFechaSiniestro.waitUntilVisible().click();
    String auxIndicadorAnioMes = indicadorAnioMes.getText();
    String mesCalendarioAtr = auxIndicadorAnioMes.substring(5, 8);
    String anioCalendarioAtr = auxIndicadorAnioMes.substring(0, 4);
    if ("0".equalsIgnoreCase(diaUsuario.substring(0, 1))) {
      diaUsuario = diaUsuario.substring(1, 2);
    }
    int valorMesCalendarioAtr = Utilidades.valorarMes(mesCalendarioAtr);
    int valorMesUsuario = Utilidades.valorarMes(mesUsuario);
    int valorAnioCalendarioAtr = Utilidades.conversorCadenaEntero(anioCalendarioAtr);
    int valorAnioUsuario = Utilidades.conversorCadenaEntero(anioUsuario);
    if (valorAnioUsuario < valorAnioCalendarioAtr) {
      seleccionarAnioAnterior(valorAnioUsuario, valorAnioCalendarioAtr);
    } else if (valorAnioUsuario > valorAnioCalendarioAtr) {
      seleccionarAnioPosterior(valorAnioUsuario, valorAnioCalendarioAtr);
    }
    if (valorMesUsuario == valorMesCalendarioAtr) {
      seleccionarDiaCalendario(diaUsuario);
    }
    if (valorMesUsuario < valorMesCalendarioAtr) {
      seleccionarMesAnterior(valorMesUsuario, valorMesCalendarioAtr);
      seleccionarDiaCalendario(diaUsuario);
    } else {
      seleecionarMesPosterior(valorMesUsuario, valorMesCalendarioAtr);
      seleccionarDiaCalendario(diaUsuario);
    }
  }
}
