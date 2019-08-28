package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

public class DatosFinancierosStep {

    @Page
    VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

    public void verificarMontoReservaAutomatica(List<Reserva> lstReserva) {
        lstReserva.forEach(
                reserva -> {
                    MatcherAssert.assertThat(
                            "El valor de la reserva es diferente a:" + reserva.getValorReserva() + ". Revisar en configuración comercial la parametrización de reservas automáticas.",
                            verificacionDatosFinancierosPage.obtenerMontoReservaAutomatica(reserva.getValorReserva()).equals(reserva.getValorReserva()));
                });
    }
}