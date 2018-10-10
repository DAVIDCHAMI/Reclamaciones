package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;
  @Steps private NuevaReclamacionAutoStep reclamacionStep;
  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;

  @Dado("^que se recibe un auto con causa de siniestro por danos$")
  public void recibirReclamo() throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSimple"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Cuando("se toman los datos del siniestro")
  public void ingresarDatosSiniestro() throws IOException {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarCategorizacion(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.finalizarReclamacion();
  }

  @Entonces("^se le brindara al reclamante un numero de reclamacion$")
  public void generarReclamacion() {
    reclamacionStep.validarReclamacion();
    reclamacionStep.visualizarResumenSiniestro();
  }
}
