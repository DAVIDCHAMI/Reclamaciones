package com.sura.reclamaciones.definitions.notificacionavisomrc;

import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.SeleccionarPropiedadesImplicadasStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoDefinition {

  @Steps BuscarPolizaStep BuscarPolizaStep;
  @Steps SeleccionarPropiedadesImplicadasStep SeleccionarPropiedadesImplicadasStep;
  @Steps CSVStep CSVStep;

  @Dado(
      "^que se recibe un reclamo por parte de un afectado\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
  public void queSeRecibeUnReclamoPorParteDeUnAfectado(
      String poliza, String numPoliza, String tipDocumento, String numDocumento, String fecha) {
    //BuscarPolizaStep.seleccionarTipoPoliza(poliza, numPoliza);
    BuscarPolizaStep.seleccionarDocumento(tipDocumento, numDocumento);
    BuscarPolizaStep.seleccionarFecha(fecha);
    BuscarPolizaStep.seleccionarUbicacion();
    BuscarPolizaStep.buscarPoliza();
    BuscarPolizaStep.tomarAseguradoAutorReporte();
  }

  @Cuando("se tomen los datos del siniestro")
  public void seTomenLosDatosDelSiniestro() {
    SeleccionarPropiedadesImplicadasStep.seleccionarPropiedadImplicada();
  }

  @Entonces("^se le brindara al reclamante un numero de reclamacion radicada")
  public void seLeBrindaraAlReclamanteUnNumeroDeReclamacionRadicada() {}
}
