package com.sura.reclamaciones.pages.exposiciones;

import static com.sura.reclamaciones.constantes.Constantes.EXPOSICION_DANOS_ASEGURADO;
import static com.sura.reclamaciones.constantes.Constantes.TIPO;

import com.sura.reclamaciones.constantes.Tablas;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ExposicionPage extends GeneralPage {

  private String columnaTipoExposicion;
  private boolean valorLineaReserva = true;

  @FindBy(id = "ClaimExposures:ClaimExposuresScreen:ExposuresLV")
  private WebElementFacade tblExposicionesAutomaticas;

  @FindBy(xpath = "//a[contains(text(),'Vehículo')]")
  private WebElementFacade exposicionAutomatica;

  public ExposicionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarExposicion() {
    obtenerCabecerasTabla(
        $("//div[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV']"), Tablas.CABECERAS_CC);
    obtenerTextoElementoLista(
            tblExposicionesAutomaticas,
            Tablas.CABECERAS_CC,
            Tablas.REGISTROS_CC,
            EXPOSICION_DANOS_ASEGURADO.getValor(),
            TIPO.getValor())
        .click();
    realizarEsperaCarga();
  }

  public boolean validarExposiciones(
      List<ExposicionesAutomaticasAutos> datosExposicionesAutomaticas) {
    obtenerCabecerasTabla(
        $("//div[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV']"), Tablas.CABECERAS_CC);
    for (int i = 0; i < datosExposicionesAutomaticas.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblExposicionesAutomaticas,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                  datosExposicionesAutomaticas.get(i).getDatoDevolverTablaExposiciones())
              .getText();
      if (lineaReservaTbl.equals(datosExposicionesAutomaticas.get(i).getExposicionAutomatica())) {
        obtenerElementoLista(
                tblExposicionesAutomaticas,
                Tablas.CABECERAS_CC,
                Tablas.REGISTROS_CC,
                datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                datosExposicionesAutomaticas.get(0).getDatoDevolverTablaExposiciones())
            .getText();
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}
