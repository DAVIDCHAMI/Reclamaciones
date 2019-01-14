package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.steps.reserva.ReversionConstitucionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReversionConstitucionDefinition {

  @Steps ReversionConstitucionStep reversionConstitucionStep;
  @Steps NuevaReclamacionEmpresarialStep reclamacionEmpresarialStep;
  @Steps GenericStep genericStep;
  ReclamacionEmpresarial reserva;

  @Dado(
      "^que se genera un siniestro del producto (.*) con causa (.*), valor de pretensión (.*) y tipo incidente de (.*)$")
  public void consultarReserva(
      String producto, String causa, String valorPretension, String tipoIncidente)
      throws IOException {
    reserva =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo("reclamacion_empresarial", "AvisoEmpresariales"));
    reclamacionEmpresarialStep.seleccionarNuevaReclamacion(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    reclamacionEmpresarialStep.buscarPolizaEmpresarial(reserva.getLstReclamo());
    reclamacionEmpresarialStep.seleccionarPropiedadImplicada();
    reclamacionEmpresarialStep.diligenciarInformacionPersonal(reserva.getLstReclamo());
    reclamacionEmpresarialStep.seleccionarCausalIncidente(causa, valorPretension);
    reclamacionEmpresarialStep.diligenciarInformacionIncidente(
        reserva.getLstReclamo(), tipoIncidente);
    reclamacionEmpresarialStep.visualizarResumenReclamacion();
  }

  @Cuando("^se ajuste la reserva con un valor de (.*)$")
  public void ajustarReserva(String ajusteReserva) {
    reversionConstitucionStep.ajustarReserva(ajusteReserva);
  }

  @Entonces(
      "^se obtiene una reversión de constitución y el deducible es generado por un valor (.*)$")
  public void verificarReversionConstitucion(String deducible) {
    reversionConstitucionStep.verificarAjusteReserva(deducible);
  }
}
