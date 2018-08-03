package com.sura.reclamaciones.steps.notificacionaviso;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

  @Page BuscarPolizaPage buscarPolizaPage;

  @Step
  public void openCC() {
    AmbientesUtil ambienteUtils = new AmbientesUtil();
    buscarPolizaPage.open(ambienteUtils.getAmbiente(), withParameters(""));
  }

  @Step
  public void buscarPolizaEmpresarial(List<ReclamacionEmpresariales> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          buscarPolizaPage.opcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if (poliza.getFechaSiniestro().equals("Hoy")) {
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
