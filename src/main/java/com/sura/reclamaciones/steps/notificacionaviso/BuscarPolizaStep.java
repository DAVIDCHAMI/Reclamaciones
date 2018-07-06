package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Reclamacion;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class BuscarPolizaStep {

    @Page
    BuscarPolizaPage buscarPolizaPage;

    @Step
    public void completarFormularioBuscarPoliza(String tipoPoliza, List<Reclamacion> datosReclamacion, List<Vehiculo> datosVehiculo) {
        buscarPolizaPage.seleccionarTipoPoliza(tipoPoliza);
        switch (tipoPoliza) {
            case "Autos":
                datosVehiculo.stream().forEach(
                        datoVehiculo -> {
                            buscarPolizaPage.escribirPlaca(datoVehiculo.getPlaca());
                        }
                );
                break;
            case "multi riesgo":
                buscarPolizaPage.escribirNumeroPoliza("");
                break;
        }
        datosReclamacion.stream().forEach(
                datoReclamacion -> {
                    seleccionarFecha(datoReclamacion.getFechaSiniestro());
                });
    }

    @Step
    public void seleccionarDocumento(String tipDocumento, String numDocumento) {
        buscarPolizaPage.seleccionarTipoDocumento(tipDocumento);
        buscarPolizaPage.escribirNumeroDocumento(numDocumento);
    }

    @Step
    public void seleccionarFecha(String fecha) {
        if (fecha.equals("Hoy")) {
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
        buscarPolizaPage.cliquearSiguiente();
    }

    @Step
    public void tomarAseguradoAutorReporte() {
        buscarPolizaPage.tomarAsegurado();
        buscarPolizaPage.cliquearSiguiente();
    }
}
