package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

public class ResultadoValidacionArchivoPage extends GeneralPage {
  int numeroRegistrosPantalla;

  @FindBy(xpath = ".//label[contains(@class,'x-component x-component-default')]")
  private WebElementFacade lblNroRegistrosFactura;

  public ResultadoValidacionArchivoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void capturarNumeroRegistrosPantalla() {
    numeroRegistrosPantalla =
        Integer.parseInt(lblNroRegistrosFactura.getText().replaceAll("\\D+", ""));
  }

  public void validarNumeroRegistrosArchivoXls() {
    String numeroRegistrosArchivo =
        (Serenity.sessionVariableCalled(SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS.getValor())
            .toString());
    int numeroRegistrosArchivoXls = Integer.parseInt(numeroRegistrosArchivo);
    MatcherAssert.assertThat(
        "El número de registros de la pantalla no es igual al número de registros del archivo XLS",
        (numeroRegistrosArchivoXls == numeroRegistrosPantalla));
  }
}
