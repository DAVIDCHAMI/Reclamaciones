package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.Tablas;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ExposicionesAutomaticasPage extends GeneralPage {

  @FindBy(id = "ClaimExposures:ClaimExposuresScreen:ExposuresLV")
  WebElementFacade tblExposicionesAutomaticas;

  private boolean valorLineaReserva = true;

  public ExposicionesAutomaticasPage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean validarExposiciones(
      List<ExposicionesAutomaticasAutos> datosExposicionesAutomaticas) {
    obtenerCabecerasDeUnaTabla(
        $("//div[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV']"), Tablas.CABECERAS_CC);
    for (int i = 0; i < datosExposicionesAutomaticas.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblExposicionesAutomaticas,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                  datosExposicionesAutomaticas.get(i).getColumnaDevolverTablaExposiciones())
              .getText();
      if (lineaReservaTbl.equals(datosExposicionesAutomaticas.get(i).getExposicionAutomatica())) {
        String valorReserva =
            obtenerElementoLista(
                    tblExposicionesAutomaticas,
                    Tablas.CABECERAS_CC,
                    Tablas.REGISTROS_CC,
                    datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                    datosExposicionesAutomaticas.get(0).getColumnaDevolverTablaExposiciones())
                .getText();
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}
