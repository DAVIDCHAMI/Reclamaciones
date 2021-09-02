package com.sura.reclamaciones.pages.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.enums.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.pages.general.GeneralPage;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProcesoBatchPage extends GeneralPage {

  @FindBy(id = "QuickJump-inputEl")
  public WebElementFacade txtBuscarClaim;

  @FindBy(id = "BatchProcessInfo:BatchProcessScreen:BatchProcessesLV")
  private WebElementFacade tblNombreProcesoBatch;

  @FindBy(id = "ServerTools:InternalToolsMenuActions")
  public WebElementFacade mnuAcciones;

  @FindBy(xpath = "//div[contains(@class, 'x-box-inner x-vertical-box-overflow-body')]")
  private List<WebElementFacade> mnuPanelOpcionesPrimerNivel;

  public ProcesoBatchPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void ejecutarBatch() {
    String letraT = "T";
    String comando = Keys.chord(Keys.ALT, Keys.SHIFT, letraT);
    txtBuscarClaim.sendKeys(comando);
    realizarEsperaCarga();
  }

  public void ejecutarProcesoBatch(String nombreProcesoBatch) {
    List<String> nombresProcesoBatch = new ArrayList<String>();
    final String NOMBRE_BATCH = "Proceso por lotes";
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblNombreProcesoBatch, NOMBRE_BATCH, Integer.parseInt(POSICION_FILA.getValor()));
    int tamanoLista = elementoEncontrado.size();
    for (int i = 0; i <= tamanoLista - 1; i++) {
      nombresProcesoBatch.add(i, elementoEncontrado.get(i).getText());
      if (nombresProcesoBatch.get(i).equals(nombreProcesoBatch)) {
        tblNombreProcesoBatch.waitUntilPresent();
        esperarCargaElemento();
        tblNombreProcesoBatch.findBy("//tr[@data-recordindex='" + i + "']//a").click();
        esperarCargaElemento();
        realizarEsperaCarga();
        break;
      }
    }
  }

  public void seleccionarOpcionMenuAccion() {
    esperarCargaElemento();
    mnuAcciones.waitUntilPresent().waitUntilEnabled();
    esperarCargaElemento();
    mnuAcciones.click();
  }

  public void seleccionarOpcionMenuAccionesPrimerNivel(String nombreOpcion) {
    mnuPanelOpcionesPrimerNivel
        .iterator()
        .next()
        .findBy(
            By.xpath(
                "//span[contains(@class,'x-menu-item-text')][contains(text(),'"
                    + nombreOpcion
                    + "')]"))
        .click();
    realizarEsperaCarga();
  }
}
