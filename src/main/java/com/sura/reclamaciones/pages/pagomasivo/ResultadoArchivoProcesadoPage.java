package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.constantes.Constantes.POSICION_FILA;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultadoArchivoProcesadoPage extends GeneralPage {
  public ResultadoArchivoProcesadoPage(WebDriver wdriver) {
    super(wdriver);
  }

  @FindBy(id = "BulkPayWizard:BulkPayWizard_BulkItemsLoadScreen:BulkPayWizard_InvoiceItemsLV")
  private WebElementFacade tblResultadoArchivoProcesado;

  public void consultarResultadoArchivoProcesado() {
    final String RESULTADO_ARCHIVO_PROCESADO = "Valido";
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblResultadoArchivoProcesado,
            RESULTADO_ARCHIVO_PROCESADO,
            Integer.parseInt(POSICION_FILA.getValor()));
    int tamanoLista = elementoEncontrado.size();
    String resultadoValidacionArchivoXls = "Sí";

    for (int i = 0; i <= tamanoLista - 1; i++) {
      MatcherAssert.assertThat(
          "El archivo Xls no cumple con las validaciones del sistema",
          (resultadoValidacionArchivoXls.equals(elementoEncontrado.get(i).getText())));
    }
  }
}
