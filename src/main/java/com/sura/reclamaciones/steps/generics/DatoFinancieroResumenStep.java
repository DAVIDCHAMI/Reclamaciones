package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.DatoFinancieroResumenPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.DATOS_FINANCIEROS;

public class DatoFinancieroResumenStep {

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    DatoFinancieroResumenPage datoFinancieroResumenPage;

    @Step
    public void validarValorReservas(List<Reserva> lineaReserva) {
        menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(DATOS_FINANCIEROS.getValor());
        boolean valorLineaReserva = datoFinancieroResumenPage.obtenerDatosFinancieros(lineaReserva);
        MatcherAssert.assertThat(
                "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
    }
}
