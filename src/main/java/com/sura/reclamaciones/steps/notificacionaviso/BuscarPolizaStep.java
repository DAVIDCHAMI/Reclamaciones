package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.steps.generics.UbicacionStep;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.FECHA_HOY;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA_CONSTITUCION;

public class BuscarPolizaStep {

    @Page
    BuscarPolizaPage buscarPolizaPage;

    @Page
    GeneralPage generalPage;

    @Steps
    UbicacionStep ubicacionStep;

    public void buscarPolizaEmpresarial(List<ReclamacionEmpresarial> datosPolizaEmpresarial) {
        datosPolizaEmpresarial.forEach(
                poliza -> {
                    Serenity.setSessionVariable(SESION_CC_VALOR_RESERVA_CONSTITUCION.getValor())
                            .to(poliza.getReservaTransaccion());
                    buscarPolizaPage.seleccionarOpcionBuscarPoliza();
                    buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
                    if (FECHA_HOY.getValor().equals(poliza.getFechaSiniestro())) {
                        buscarPolizaPage.seleccionarFechaHoySiniestro();
                    } else {
                        buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
                    }
                    ubicacionStep.seleccionarUbicacion(datosPolizaEmpresarial);
                    buscarPolizaPage.buscarPoliza();
                    buscarPolizaPage.seleccionarPoliza();
                    generalPage.continuarSiguientePantalla();
                });
    }
}
