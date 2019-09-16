package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionBasicaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionReclamacionStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.steps.notificacionaviso.PropiedadesImplicadasStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroDefinition {

  @Steps ReclamacionEmpresarial reclamacionEmpresarial;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

  @Steps BuscarPolizaStep buscarPolizaStep;

  @Steps InformacionReclamacionStep informacionReclamacionStep;

  @Steps InformacionBasicaStep informacionBasicaStep;

  @Steps PropiedadesImplicadasStep propiedadesImplicadasStep;

  @Steps NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  @Dado("^que se tiene una póliza de (.*)$")
  public void buscarPoliza(String tipoCobertura) throws IOException {
    Serenity.setSessionVariable(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()).to(tipoCobertura);
    reclamacionEmpresarial =
        new ReclamacionEmpresarial(
            obtenerDatosPrueba(ReclamacionConstante.RECLAMACION_EMPRESARIAL, tipoCobertura));
    buscarPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
  }

  @Cuando(
      "^se genere un siniestro por causal (.*) con un valor de pretensión de (.*) y un incidente de tipo (.*)$")
  public void tomarDatosSiniestro(
      String causaSiniestro, String valorPretension, String tipoIncidente) {
    propiedadesImplicadasStep.seleccionarPropiedadImplicada();
    informacionBasicaStep.diligenciarInformacionBasica(reclamacionEmpresarial.getLstReclamo());
    informacionReclamacionStep.diligenciarInformacionReclamacion(
        causaSiniestro, valorPretension, tipoIncidente);
  }

  @Entonces("^se obtiene una reclamación que (.*) genera exposición$")
  public void verificarExposicion(String exposicion) {
    nuevaReclamacionEmpresarialStep.validarReclamacion();
    nuevaReclamacionGuardadaStep.obtenerNumeroReclamacionGuardada();
    nuevaReclamacionEmpresarialStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envía correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    nuevaReclamacionEmpresarialStep.validarReservaDatosFinancieros(
        reclamacionEmpresarial.getLstReclamo());
  }
}
