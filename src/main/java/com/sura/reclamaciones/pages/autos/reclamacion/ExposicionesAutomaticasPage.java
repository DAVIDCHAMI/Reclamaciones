package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.DatosFinancierosConstante;
import com.sura.reclamaciones.constantes.Tablas;
import com.sura.reclamaciones.models.Exposiciones;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class ExposicionesAutomaticasPage extends GeneralPage {

  public ExposicionesAutomaticasPage(WebDriver wdriver) {
    super(wdriver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(id = "ClaimExposures:ClaimExposuresScreen:ExposuresLV")
  WebElementFacade tblExposicionesAutomaticas;

  public boolean valorLineaReserva = true;

  public boolean validarExposiciones(List<Exposiciones> datosExposicionesAutomaticas) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(DatosFinancierosConstante.EXPOSICIONES);
    obtenerCabecerasDeUnaTabla(
        $("//div[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV']"), Tablas.CABECERAS_CC);

    for (int i = 0; i < datosExposicionesAutomaticas.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblExposicionesAutomaticas,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                  datosExposicionesAutomaticas.get(i).getColumnaDevolver())
              .getText();
      if (lineaReservaTbl.equals(datosExposicionesAutomaticas.get(i).getExposicionAutomatica())) {
        String valorReserva =
            obtenerElementoLista(
                    tblExposicionesAutomaticas,
                    Tablas.CABECERAS_CC,
                    Tablas.REGISTROS_CC,
                    datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                    datosExposicionesAutomaticas.get(0).getColumnaDevolver())
                .getText();
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}
