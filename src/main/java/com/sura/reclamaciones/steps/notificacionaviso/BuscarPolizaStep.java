package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

  @Page BuscarPolizaPage BuscarPolizaPage;

  @Step
  public void seleccionarTipoPoliza(String poliza, String numPoliza) {
    BuscarPolizaPage.cliquearBuscarPoliza();
    BuscarPolizaPage.seleccionarPoliza(poliza);
    BuscarPolizaPage.escribirNumeroPoliza(numPoliza);
  }

  @Step
  public void seleccionarDocumento(String tipDocumento, String numDocumento) {
    BuscarPolizaPage.seleccionarTipoDocumento(tipDocumento);
    BuscarPolizaPage.escribirNumeroDocumento(numDocumento);
  }

  @Step
  public void seleccionarFecha(String fecha) {
    if (fecha == "Hoy") {
      BuscarPolizaPage.seleccionarFechaHoySiniestro();
    } else {
      BuscarPolizaPage.escribirFechaSiniestro(fecha);
    }
  }

  @Step
  public void seleccionarUbicacion() {
    BuscarPolizaPage.seleccionarPais();
    BuscarPolizaPage.seleccionarDepartamento();
    BuscarPolizaPage.seleccionarCiudad();
  }

  @Step
  public void buscarPoliza() {
    BuscarPolizaPage.cliquearBuscar();
  }

  @Step
  public void tomarAseguradoAutorReporte(){
    BuscarPolizaPage.tomarAsegurado();
    BuscarPolizaPage.cliquearSiguiente();
  }
}
