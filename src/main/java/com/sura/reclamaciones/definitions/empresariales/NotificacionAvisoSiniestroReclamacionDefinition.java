package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.utils.Variables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroReclamacionDefinition {

  @Steps ReclamacionEmpresarial reclamo;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionStep;

  @Steps GenericStep genericStep;

  @Dado("^que se tiene una poliza de (.*)$")
  public void buscarPoliza(String tipoCobertura) throws Throwable {
    Serenity.setSessionVariable(Variables.SESION_CC_TIPO_RESERVA).to(tipoCobertura);
    reclamo =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(
                ReclamacionConstante.RECLAMACION_EMPRESARIAL, tipoCobertura));
    nuevaReclamacionStep.seleccionarNuevaReclamacion(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    nuevaReclamacionStep.buscarPolizaEmpresarial(reclamo.getLstReclamo());
  }

  @Cuando("^se genere un siniestro por causal (.*) con un valor de pretension de (.*)$")
  public void tomarDatosSiniestro(String causa, String valorPretension) {
    nuevaReclamacionStep.seleccionarPropiedadImplicada();
    nuevaReclamacionStep.diligenciarInformacionPersonal(reclamo.getLstReclamo());
    nuevaReclamacionStep.seleccionarCausalIncidente(causa, valorPretension);
  }

  @Cuando("^un incidente de tipo (.*)$")
  public void tomarTipoIncidente(String tipoIncidente) {
    nuevaReclamacionStep.diligenciarInformacionIncidente(reclamo.getLstReclamo(), tipoIncidente);
  }

  @Entonces("^se obtiene una reclamacion que (.*) genera exposicion$")
  public void verificarExposicion(String exposicion) {
    nuevaReclamacionStep.validarReclamacion();
    nuevaReclamacionStep.visualizarResumenReclamacion();
    nuevaReclamacionStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envia correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    nuevaReclamacionStep.validarReservaDatosFinancieros(reclamo.getLstReclamo());
  }
}
