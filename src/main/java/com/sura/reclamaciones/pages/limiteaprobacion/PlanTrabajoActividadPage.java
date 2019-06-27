package com.sura.reclamaciones.pages.limiteaprobacion;

import static com.sura.reclamaciones.constantes.Constantes.POSICION_FILA;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PlanTrabajoActividadPage extends GeneralPage {

  @FindBy(id = "ClaimWorkplan:ClaimWorkplanScreen:WorkplanLV")
  public WebElementFacade tblPlanTrabajo;

  @FindBy(
    id =
        "ApprovalDetailWorksheet:ApprovalDetailScreen:ApprovalDetailWorksheet_ApproveButton-btnInnerEl"
  )
  public WebElementFacade btnAprobarActividad;

  final String CAMPO_NOMBRE_ACTIVIDAD = "Asunto";

  public PlanTrabajoActividadPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void verificarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblPlanTrabajo, CAMPO_NOMBRE_ACTIVIDAD, Integer.parseInt(POSICION_FILA.getValor()));
    MatcherAssert.assertThat(
        "No se genero la actividad de Revisar y aprobar cambio de reserva",
        elementoEncontrado
            .get(Integer.parseInt(VALOR_CERO.getValor()))
            .getText()
            .equals(actividadAprobarReserva));
    realizarEsperaCarga();
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblPlanTrabajo, CAMPO_NOMBRE_ACTIVIDAD, Integer.parseInt(POSICION_FILA.getValor()));
    if (elementoEncontrado
        .get(Integer.parseInt(VALOR_CERO.getValor()))
        .getText()
        .equals(actividadAprobarReserva)) {
      elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).click();
      realizarEsperaCarga();
      btnAprobarActividad.click();
    }
  }
}
