package com.sura.reclamaciones.steps.notificacionaviso;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

  @Page BuscarPolizaPage BuscarPolizaPage;

  @Step
  public void openCC() {
    AmbientesUtil ambienteUtils = new AmbientesUtil();
    BuscarPolizaPage.open(ambienteUtils.getAmbiente(), withParameters(""));
  }

  @Step
  public void seleccionarTipoPoliza(List<ReclamacionEmpresariales> datosPoliza) {
    datosPoliza.forEach(
        poliza -> {
          BuscarPolizaPage.seleccionarPoliza(poliza.getTipoPoliza());
          BuscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          BuscarPolizaPage.cliquearBuscarPoliza();
        });
  }

  @Step
  public void seleccionarDocumento(List<Persona> datosDocumento) {
    datosDocumento.forEach(
        documento -> {
          BuscarPolizaPage.seleccionarTipoDocumento(documento.getTipoDocumento());
          BuscarPolizaPage.escribirNumeroDocumento(documento.getNumDocumento());
        });
  }

  @Step
  public void seleccionarFecha(List<ReclamacionEmpresariales> datosFecha) {
    datosFecha
        .stream()
        .forEach(
            fecha -> {
              if (fecha.getFechaSiniestro().equals("Hoy")) {
                BuscarPolizaPage.seleccionarFechaHoySiniestro();
              } else {
                BuscarPolizaPage.escribirFechaSiniestro(fecha.getFechaSiniestro());
              }
            });
  }

  @Step
  public void seleccionarUbicacion(List<ReclamacionEmpresariales> datosUbicacion) {
    datosUbicacion.forEach(
        ubicacion -> {
          BuscarPolizaPage.seleccionarPais(ubicacion.getPais());
          BuscarPolizaPage.seleccionarDepartamento(ubicacion.getDepartamento());
          BuscarPolizaPage.seleccionarCiudad(ubicacion.getCiudad());
        });
  }

  @Step
  public void buscarPoliza() {
    BuscarPolizaPage.cliquearBuscar();
  }
}
