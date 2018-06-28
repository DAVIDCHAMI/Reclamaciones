package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class BuscarPolizaStep {

    @Page
    BuscarPolizaPage buscarPolizaPage;

    @Step
    public void seleccionarTipoPoliza(String tipoPoliza, String numeroPoliza, List<Vehiculo> datoVehiculo) {
        datoVehiculo.forEach(
                dato -> {
                    buscarPolizaPage.seleccionarTipoPoliza(tipoPoliza);
                    switch (tipoPoliza) {
                        case "autos":
                            buscarPolizaPage.escribirPlaca(dato.getPlaca());
                            break;
                        case "multi riesgo":
                            buscarPolizaPage.escribirNumeroPoliza(numeroPoliza);
                            break;
                    }
                });
    }

    @Step
    public void seleccionarDocumento(String tipDocumento, String numDocumento) {
        buscarPolizaPage.seleccionarTipoDocumento(tipDocumento);
        buscarPolizaPage.escribirNumeroDocumento(numDocumento);
    }

    @Step
    public void seleccionarFecha(String fecha) {
        if (fecha == "Hoy") {
            buscarPolizaPage.seleccionarFechaHoySiniestro();
        } else {
            buscarPolizaPage.escribirFechaSiniestro(fecha);
        }
    }

    @Step
    public void seleccionarUbicacion() {
        buscarPolizaPage.seleccionarPais();
        buscarPolizaPage.seleccionarDepartamento();
        buscarPolizaPage.seleccionarCiudad();
    }

    @Step
    public void buscarPoliza() {
        buscarPolizaPage.cliquearBuscar();
    }

    @Step
    public void tomarAseguradoAutorReporte() {
        buscarPolizaPage.tomarAsegurado();
        buscarPolizaPage.cliquearSiguiente();
    }
}
