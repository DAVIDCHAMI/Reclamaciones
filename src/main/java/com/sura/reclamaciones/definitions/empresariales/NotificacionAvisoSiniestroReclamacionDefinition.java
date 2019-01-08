package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroReclamacionDefinition {

  @Steps ReclamacionEmpresarial reclamacionEmpresarial;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

  @Steps GenericStep genericStep;

  @Dado("^que se tiene una poliza de (.*)$")
  public void buscarPoliza(String tipoCobertura) throws Throwable {
    Serenity.setSessionVariable(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()).to(tipoCobertura);
    reclamacionEmpresarial =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(
                ReclamacionConstante.RECLAMACION_EMPRESARIAL, tipoCobertura));
    nuevaReclamacionEmpresarialStep.seleccionarNuevaReclamacion(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    nuevaReclamacionEmpresarialStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
  }

  @Cuando("^se genere un siniestro por causal (.*) con un valor de pretension de (.*)$")
  public void tomarDatosSiniestro(String causaSiniestro, String valorPretension) {
    nuevaReclamacionEmpresarialStep.seleccionarPropiedadImplicada();
    nuevaReclamacionEmpresarialStep.diligenciarInformacionPersonal(
        reclamacionEmpresarial.getLstReclamo());
    nuevaReclamacionEmpresarialStep.seleccionarCausalIncidente(causaSiniestro, valorPretension);
  }

  @Cuando("^un incidente de tipo (.*)$")
  public void tomarTipoIncidente(String tipoIncidente) {
    nuevaReclamacionEmpresarialStep.diligenciarInformacionIncidente(
        reclamacionEmpresarial.getLstReclamo(), tipoIncidente);
  }

  @Entonces("^se obtiene una reclamacion que (.*) genera exposicion$")
  public void verificarExposicion(String exposicion) {
    nuevaReclamacionEmpresarialStep.validarReclamacion();
    nuevaReclamacionEmpresarialStep.visualizarResumenReclamacion();
    nuevaReclamacionEmpresarialStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envia correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    nuevaReclamacionEmpresarialStep.validarReservaDatosFinancieros(
        reclamacionEmpresarial.getLstReclamo());
  }
}
