package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_VALOR_RESERVA_CONSTITUCION;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.BuscarPolizaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;

public class BusquedaPolizaStep {

  private static final String FECHA_HOY = "Hoy";

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

  public void buscarPolizaEmpresarial(List<ReclamacionEmpresarial> datosPolizaEmpresarial) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    datosPolizaEmpresarial.forEach(
        poliza -> {
          Serenity.setSessionVariable(SESION_CC_VALOR_RESERVA_CONSTITUCION.getValor())
              .to(poliza.getReservaTransaccion());
          buscarPolizaPage.seleccionarOpcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if (FECHA_HOY.equals(poliza.getFechaSiniestro())) {
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
