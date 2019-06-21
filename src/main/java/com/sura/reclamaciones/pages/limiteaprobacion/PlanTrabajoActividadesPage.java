package com.sura.reclamaciones.pages.limiteaprobacion;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanTrabajoActividadesPage extends GeneralPage {


  @FindBy(id = "ClaimWorkplan:ClaimWorkplanScreen:WorkplanLV")
  public WebElementFacade tblPlanTrabajo;

  @FindBy(id = "ApprovalDetailWorksheet:ApprovalDetailScreen:ApprovalDetailWorksheet_ApproveButton-btnInnerEl")
  public WebElementFacade btnAprobarActividad;


  public PlanTrabajoActividadesPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void verificarActividadesPlanTrabajo(String actividadAprobarReserva) {
    final String NOMBRE_ACTIVIDAD = "Asunto";
    List<WebElement> elementoEncontrado = obtenerElementoTablaDatoDesconocido(tblPlanTrabajo,
        NOMBRE_ACTIVIDAD, 1);
    MatcherAssert.assertThat("No se genero la actividad de Revisar y aprobar cambio de reserva",
        elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).getText().equals(actividadAprobarReserva));
  }

  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    final String NOMBRE_ACTIVIDAD = "Asunto";
    List<WebElement> elementoEncontrado = obtenerElementoTablaDatoDesconocido(tblPlanTrabajo,
        NOMBRE_ACTIVIDAD, 1);
    elementoEncontrado.forEach(
        elemento -> {
          if (elemento.getText().equals(actividadAprobarReserva)) {
            elemento.click();
            realizarEsperaCarga();
            btnAprobarActividad.click();
          }
        }
    );
  }
}
