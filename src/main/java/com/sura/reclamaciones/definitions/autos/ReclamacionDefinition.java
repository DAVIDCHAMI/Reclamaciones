package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;
  @Steps private NuevaReclamacionAutoStep reclamacionStep;
  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;

  @Dado("^que se tiene una poliza con las coberturas (.*)$")
  public void recibirReclamo(String st) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSimple"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Cuando("^se genere un siniestro por la causa (.*) y la culpabilidad (.*)$")
  public void ingresarDatosSiniestro(String causa, String culpabilidad) throws IOException {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarVehiculo(reclamacionAuto.getLstReclamacionAuto(),culpabilidad);
    reclamacionStep.completarCategorizacion(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.diligenciarReclamacion(culpabilidad);
    reclamacionStep.finalizarReclamacion();
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada (.*)$")
  public void generarReclamacion(String culpabilidad) throws SQLException {
    reclamacionStep.validarReclamacion();
    reclamacionStep.visualizarResumenSiniestro();
    reclamacionStep.consultarReclamacion();
    reclamacionStep.consultarExposicionesyReservas(culpabilidad);
  }
}
