package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

  @Page BuscarPolizaPage buscarPolizaPage;

  MenuClaimPage menuClaimPage;

  @Step
  public void completarFormularioBuscarPoliza(
      List<ReclamacionAuto> datosReclamacion, List<Vehiculo> datosVehiculo) {
    datosVehiculo.forEach(
        datoReclamacion -> {
          buscarPolizaPage.escribirPlaca(datoReclamacion.getPlaca());
        });
    datosReclamacion.forEach(
        dato -> {
          seleccionarFecha(dato.getFechaSiniestro());
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
  public void buscarPoliza() {
    buscarPolizaPage.buscarPoliza();
  }

  public void seleccionarMenu() {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
  }

  @Step
  public void buscarPolizaEmpresarial(List<ReclamacionEmpresariales> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          buscarPolizaPage.opcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if ("Hoy".equals(poliza.getFechaSiniestro())) {
            buscarPolizaPage.seleccionarFechaHoySiniestro();
          } else {
            buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
          }
          buscarPolizaPage.seleccionarPais(poliza.getPais());
          buscarPolizaPage.seleccionarDepartamento(poliza.getDepartamento());
          buscarPolizaPage.seleccionarCiudad(poliza.getCiudad());
          buscarPolizaPage.buscarPoliza();
        });
  }
}
