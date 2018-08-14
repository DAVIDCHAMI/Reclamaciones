package com.sura.reclamaciones.definitions.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.*;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoDefinition {

  ReclamacionEmpresariales reclamo;
  @Steps BuscarPolizaStep buscarPolizaStep;
  @Steps NuevaReclamacionStep nuevaReclamacionStep;
  @Steps PropiedadesImplicadasStep propiedadesImplicadasStep;
  @Steps InformacionBasicaStep informacionBasicaStep;
  @Steps InformacionReclamacionStep informacionReclamacionStep;
  @Steps ResumenReclamacionStep resumenReclamacionStep;
  @Steps GenericStep genericStep;

  @Dado("^que se tiene una poliza de (.*)$")
  public void queSeTieneUnaPolizaDeTipoCobertura(String tipoCobertura) throws Throwable {
    reclamo =
        new ReclamacionEmpresariales(
            genericStep.getFilasModelo("reclamacion_empresarial", "escenarioEmpresariales"));
    nuevaReclamacionStep.seleccionarNuevaReclamacion("Re", "Nueva");
    buscarPolizaStep.buscarPolizaEmpresarial(reclamo.getLstReclamo());
  }

  @Cuando("^se genere un siniestro por causal (.*) con un valor de pretension de (.*)$")
  public void tomarDatosSiniestro(String causa, String valorPretension) {
    reclamo.getLstReclamo();
    propiedadesImplicadasStep.seleccionarPropiedadImplicada();
    informacionBasicaStep.informacionPersonal(reclamo.getLstReclamo());
    informacionReclamacionStep.causalIncidente(causa, valorPretension);
  }

  @Y("^un incidente de tipo (.*)$")
  public void tomarTipoIncidente(String tipoIncidente) {
    reclamo.getLstReclamo();
    informacionReclamacionStep.informacionIncidente(reclamo.getLstReclamo(), tipoIncidente);
  }

  @Entonces("^se obtiene una reclamacion que (.*) genera exposicion$")
  public void verificarExposicion(String exposicion) {
    reclamo.getLstReclamo();
    informacionReclamacionStep.validarReclamacion(reclamo.getLstReclamo());
    resumenReclamacionStep.visualizarResumenReclamacion();
    resumenReclamacionStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envia correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    resumenReclamacionStep.validarReservaVisualizada(monto);
  }
}
