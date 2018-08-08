package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.ReclamacionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  private MenuClaimPage menuClaimPage;

  @Steps private GenericStep genericStep;

  @Steps private BuscarPolizaStep buscarPolizaStep;

  @Steps private ReclamacionStep reclamacionStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;

  @Dado("^que se recibe un auto con causa de siniestro por danos$")
  public void recibirReclamo() throws Exception {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion", "reclamacionSimple"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "COL001"));
    buscarPolizaStep.seleccionarMenu();
    buscarPolizaStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    buscarPolizaStep.buscarPoliza();
  }

  @Cuando("se toman los datos del siniestro")
  public void ingresarDatosSiniestro() throws IOException {
    reclamacionStep.seleccionarNombreAutorReporte();
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarCategorizacion(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.finilizarReclamacion();
  }

  @Entonces("se le brindara al reclamante un numero de reclamacion")
  public void generarReclamacion() {
    reclamacionStep.validarReclamacion(reclamacionAuto.getLstReclamacionAuto());
  }
}
