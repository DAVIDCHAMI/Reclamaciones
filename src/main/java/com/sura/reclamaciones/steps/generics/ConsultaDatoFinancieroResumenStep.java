package com.sura.reclamaciones.steps.generics;

import static com.sura.reclamaciones.constantes.Constantes.DATOS_FINANCIEROS;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.general.DatoFinancieroResumenPage;
import com.sura.reclamaciones.pages.general.MenuClaimPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsultaDatoFinancieroResumenStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DatoFinancieroResumenPage datoFinancieroResumenPage;

  @Step
  public void validarValorReservas(List<Reserva> lineaReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(DATOS_FINANCIEROS.getValor());
    boolean valorLineaReserva = datoFinancieroResumenPage.obtenerDatosFinancieros(lineaReserva);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }
}
