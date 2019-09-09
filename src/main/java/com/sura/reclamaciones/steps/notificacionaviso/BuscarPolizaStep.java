package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.FECHA_HOY;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA_CONSTITUCION;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page GeneralPage generalPage;

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
          generalPage.seleccionarPais(poliza.getPais());
          generalPage.seleccionarDepartamento(poliza.getDepartamento());
          buscarPolizaPage.buscarPoliza();
          buscarPolizaPage.seleccionarPoliza();
          generalPage.continuarSiguientePantalla();
        });
  }
}
