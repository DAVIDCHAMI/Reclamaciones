package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.constantes.Tablas.REGISTROS_CC;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.Tablas;
import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.steps.StepInterceptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class GeneralPage extends PageObject {

  @FindBy(
    xpath =
        "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box')]/div/ul"
  )
  public WebElementFacade lstOpcionesCombobox;

  @FindBy(xpath = "//div[contains(@class,'x-mask x-mask-fixed')]")
  public WebElementFacade pgrBarCarga;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:Next-btnInnerEl' or @id='NormalCreateCheckWizard:Next-btnInnerEl' or @id='NormalCreateCheckWizard:Next-btnWrap']"
  )
  private WebElementFacade btnSiguiente;

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-next ']//parent::span")
  private WebElementFacade btnCambioPagina;

  @FindBy(xpath = ".//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Aceptar')]")
  private WebElementFacade btnAceptar;

  @FindBy(xpath = ".//span[contains(@id,'Finish-btnInnerEl')]")
  private WebElementFacade btnFinalizar;

  @FindBy(
    xpath =
        "//input[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLVRangeInput-inputEl']"
  )
  private WebElementFacade txtTransacciones;

  @FindBy(xpath = "//div[@class='x-panel x-panel-default x-grid']")
  public WebElementFacade tblVerificacion;

  @FindBy(xpath = "//input")
  private WebElementFacade mnuDinamico;

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnUltimaPagina;

  private String tblPago =
      "//tr//td//div//a[contains(text(),'%s')]//parent::div//parent::td//parent::tr//td";

  private String tblTransaccion =
      "//tr//td//div[contains(text(),'%s')]//parent::td//parent::tr//td";

  private String lstDinamico = "//li[.='COMODIN']";
  private String auxLstUbicacion = "";

  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  protected WebDriver driver;

  public GeneralPage(WebDriver wdriver) {
    super(wdriver);
    driver = wdriver;
  }

  public String getTblPago() {
    return tblPago;
  }

  public String getTblTransaccion() {
    return tblTransaccion;
  }

  public void seleccionarOpcionCombobox(String opcion) {
    lstOpcionesCombobox.waitUntilVisible().waitUntilClickable();
    lstOpcionesCombobox
        .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + opcion + "')]"))
        .click();
  }

  public void clickElemento(WebElementFacade elemento) {
    elemento.click();
  }

  public List<String> obtenerCabecerasDeUnaTabla(
      WebElementFacade elementoTabla, Tablas enumCabecerasTabla) {
    return elementoTabla
        .findElements(By.xpath(enumCabecerasTabla.getXpath()))
        .stream()
        .map(cabecera -> cabecera.getText().trim())
        .collect(Collectors.toList());
  }

  public WebElement obtenerElementoColumnaTabla(
      WebElementFacade elementoTabla,
      Tablas enumRegistroTabla,
      String datoEnFilaABuscar,
      int posicionDatoADevolver) {
    return elementoTabla
        .findElements(By.xpath(enumRegistroTabla.getXpath()))
        .stream()
        .filter(fila -> fila.getText().contains(datoEnFilaABuscar))
        .map(columnas -> columnas.findElement(By.xpath("./td[" + posicionDatoADevolver + "]")))
        .findFirst()
        .get();
  }

  public List<WebElement> obtenerFilasTabla(
      WebElementFacade elementoTabla, Tablas enumRegistroTabla) {
    return elementoTabla
        .findElements(By.xpath(enumRegistroTabla.getXpath()))
        .stream()
        .collect(Collectors.toList());
  }

  public WebElement obtenerElementoLista(
      WebElementFacade elemento,
      Tablas cabeceras,
      Tablas registros,
      String datoEnFilaABuscar,
      String columnaADevolver) {
    List<String> cabeceraFacturarCargos = obtenerCabecerasDeUnaTabla(elemento, cabeceras);
    int posicionDatoADevolver = cabeceraFacturarCargos.indexOf(columnaADevolver) + 1;
    return obtenerElementoColumnaTabla(
        elemento, registros, datoEnFilaABuscar, posicionDatoADevolver);
  }

  public void realizarEsperaCarga() {
    if (pgrBarCarga.isVisible()) {
      pgrBarCarga.waitUntilPresent().waitUntilNotVisible();
    }
  }

  public void realizarEsperaFinalizarReclamacion() {
    int numeroIntentos = ConstanteGlobal.NUMERO_INTENTOS_ESPERA_ELEMENTO;
    while (numeroIntentos > 0) {
      if (!pgrBarCarga.isPresent()) {
        break;
      }
      numeroIntentos--;
    }
  }

  public void aceptarOpcion() {
    btnAceptar.waitUntilVisible();
    btnAceptar.click();
  }

  public void continuarSiguientePantalla() {
    btnSiguiente.waitUntilClickable();
    btnSiguiente.click();
    realizarEsperaCarga();
  }

  public void finalizarProceso() {
    btnFinalizar.waitUntilClickable();
    btnFinalizar.click();
    realizarEsperaCarga();
  }

  public List<WebElement> obtenerElementoTablaDatoDesconocido(
      WebElementFacade elemento, String encabezadoColumnaDevolver, int posicionFila) {
    List<String> cabeceraTabla = obtenerCabecerasDeUnaTabla(elemento, CABECERAS_CC);
    int posicionDatoDevolver = cabeceraTabla.indexOf(encabezadoColumnaDevolver) + posicionFila;
    List<WebElement> elementoEncontrado = obtenerFilasTabla(elemento, REGISTROS_CC);
    return elementoEncontrado
        .stream()
        .map(
            fila -> fila.findElement(By.xpath(String.format("./td[%d]/div", posicionDatoDevolver))))
        .collect(Collectors.toList());
  }

  public void seleccionarTipoTransaccion(String tipoTransaccion) {
    txtTransacciones.waitUntilClickable().click();
    seleccionarOpcionCombobox(tipoTransaccion);
    realizarEsperaCarga();
  }

  public void seleccionarElementoListado(String elementoEtiqueta, String ubicacion) {
    mnuDinamico
        .findElement(By.xpath(String.format("//input[contains(@id,'%s')]", elementoEtiqueta)))
        .click();
    auxLstUbicacion = lstDinamico.replace(ConstanteGlobal.COMODIN, ubicacion);
    $(auxLstUbicacion).click();
    realizarEsperaCarga();
  }

  public void irUltimaPagina() {
    if (btnUltimaPagina.isVisible()) {
      btnUltimaPagina.click();
      realizarEsperaCarga();
    }
  }

  public void irSiguientePagina() {
    if (btnCambioPagina.isVisible()) {
      btnCambioPagina.waitUntilClickable().click();
      realizarEsperaCarga();
    }
  }

  public String obtenerDatoTablaCabecera(String strDatoCabecera, int posicionElemento) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblVerificacion, strDatoCabecera, 1);
    int longitudTabla = elementoEncontrado.size();
    return elementoEncontrado.get(longitudTabla - posicionElemento).getText();
  }

  public List<WebElement> obtenerFilaTabla(
      String strIdentificadorFila, String strXpathElementoTabla) {
    tblVerificacion.waitUntilVisible();
    List<WebElement> lstFila = null;
    lstFila =
        tblVerificacion.findElements(
            By.xpath(String.format(strXpathElementoTabla, strIdentificadorFila)));
    return lstFila;
  }
}
