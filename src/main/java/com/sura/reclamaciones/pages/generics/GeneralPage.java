package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.constantes.Tablas.REGISTROS_CC;

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
  WebElementFacade pgrBarCarga;

  @FindBy(xpath = ".//span[contains(@id,'Next-btnInnerEl')]")
  private WebElementFacade btnSiguiente;

  @FindBy(xpath = ".//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Aceptar')]")
  WebElementFacade btnAceptar;

  @FindBy(
    xpath =
        "//input[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLVRangeInput-inputEl']"
  )
  WebElementFacade txtTransacciones;

  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  WebDriver driver;

  public GeneralPage(WebDriver wdriver) {
    super(wdriver);
    driver = wdriver;
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
    pgrBarCarga.waitUntilPresent().waitUntilNotVisible();
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

  public List<WebElement> obtenerElementoTablaDatoDesconocido(
      WebElementFacade elemento, String encabezadoColumnaDevolver) {
    List<String> cabeceraRecuperos = obtenerCabecerasDeUnaTabla(elemento, CABECERAS_CC);
    int posicionDatoDevolver = cabeceraRecuperos.indexOf(encabezadoColumnaDevolver) + 1;
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
  }
}
