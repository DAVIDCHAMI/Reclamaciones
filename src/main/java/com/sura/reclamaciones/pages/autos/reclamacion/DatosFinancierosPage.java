package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.Tablas;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DatosFinancierosPage extends GeneralPage {

  @FindBy(
    id =
        "ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:FinancialsSummaryPanelSet:FinancialsSummaryLV"
  )
  WebElementFacade tblResumenDatosFinancieros;

  private boolean valorLineaReserva = true;

  public DatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean obtenerDatosFinancieros(List<Reserva> datosLineaReserva) {
    obtenerCabecerasDeUnaTabla(
        $(
            "//div[@id='ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:FinancialsSummaryPanelSet:FinancialsSummaryLV']"),
        Tablas.CABECERAS_CC);
    for (int i = 0; i < datosLineaReserva.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblResumenDatosFinancieros,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosLineaReserva.get(i).getLineaReserva(),
                  "")
              .getText();
      if (lineaReservaTbl.equals(datosLineaReserva.get(i).getLineaReserva())) {
        String valorReserva =
            obtenerElementoLista(
                    tblResumenDatosFinancieros,
                    Tablas.CABECERAS_CC,
                    Tablas.REGISTROS_CC,
                    datosLineaReserva.get(i).getLineaReserva(),
                    datosLineaReserva.get(0).getColumnaDevolverTablaDatosFinancieros())
                .getText();
        if (valorReserva.equals(datosLineaReserva.get(i).getValorReserva())) {
          valorLineaReserva = true;
        } else if (!valorReserva.equals(datosLineaReserva.get(i).getValorReserva())) {
          String totalizarLineaReserva = valorReserva;
          int totalReserva = 0;
          totalizarLineaReserva =
              totalizarLineaReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
          String valorDeducible =
              obtenerElementoLista(
                      tblResumenDatosFinancieros,
                      Tablas.CABECERAS_CC,
                      Tablas.REGISTROS_CC,
                      datosLineaReserva.get(i).getLineaReserva(),
                      datosLineaReserva.get(0).getValorDeducible())
                  .getText();
          valorDeducible = valorDeducible.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
          totalReserva = Integer.parseInt(totalizarLineaReserva) + Integer.parseInt(valorDeducible);
          if ((String.valueOf(totalReserva)).equals(datosLineaReserva.get(i).getValorReserva())) {
            valorLineaReserva = true;
          }
        }
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}
