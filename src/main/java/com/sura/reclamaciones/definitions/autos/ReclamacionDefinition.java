package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.*;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAutoStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import groovy.transform.stc.FirstParam;
import net.thucydides.core.annotations.Steps;
import org.apache.tools.ant.types.resources.First;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;
  @Steps private NuevaReclamacionAutoStep reclamacionStep;
  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private ExposicionPersona exposicionPersona;
  private LineaReservaValorReservaAutos lineaReservaValorReservaAutos;
  private List<String> coberturas;
  private Map<String, String> lstCausaCulpabilidad;

  @Dado("^que se tiene una poliza con las coberturas$")
  public void recibirReclamoRC(List<String> coberturas) throws IOException {
    this.coberturas=coberturas;
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
     public void ingresarDatosSiniestro(DataTable dtl_causaCulpabilidad) throws IOException {
      reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarCategorizacion(reclamacionAuto.getLstReclamacionAuto());
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada RC$")
  public void generarReclamacionRC(DataTable dtl_culpabilidad) throws SQLException, IOException {
    List<List<String>> data = dtl_culpabilidad.raw();
    String culpabilidad = data.get(1).get(0);
      exposicionVehiculoTercero = new ExposicionVehiculoTercero(genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
      reclamacionStep.crearExposionVehiculoTercero(exposicionVehiculoTercero.getLstExposicionTerceros());
      exposicionPersona = new ExposicionPersona(genericStep.getFilasModelo("responsabilidad_civil_persona","exposicionRcPersona"));
      reclamacionStep.crearExposicionPersona(exposicionPersona.getLstExposicionPersona());
      reclamacionStep.finalizarReclamacion();
      reclamacionStep.validarReclamacion();
      reclamacionStep.visualizarResumenSiniestro();
      reclamacionStep.consultarReclamacion();
      lineaReservaValorReservaAutos = new LineaReservaValorReservaAutos(genericStep.getFilasModelo("linea_reserva_valor_reserva","RC_Vehiculo_y_peaton"));
      reclamacionStep.consultarLineaReservaValorReservaRC(lineaReservaValorReservaAutos.getLstLineasReservaValoresReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(List<String> coberturas) throws IOException {
    this.coberturas=coberturas;
    reclamacionAuto =
            new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionArchivo"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionArchivo"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
            reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Entonces(
          "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo(DataTable dtl_culpabilidad) throws SQLException, IOException {
    List<List<String>> data = dtl_culpabilidad.raw();
    String culpabilidad = data.get(1).get(0);
    reclamacionStep.finalizarReclamacion();
    reclamacionStep.validarReclamacion();
    reclamacionStep.visualizarResumenSiniestro();
    reclamacionStep.consultarReclamacion();
    lineaReservaValorReservaAutos = new LineaReservaValorReservaAutos(genericStep.getFilasModelo("linea_reserva_valor_reserva","Archivo_Subrogacion"));
    reclamacionStep.consultarLineayValorReservaArchivo(lineaReservaValorReservaAutos.getLstLineasReservaValoresReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(List<String> coberturas) throws IOException {
    this.coberturas=coberturas;
    reclamacionAuto =
            new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSubrogacion"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSubrogacion"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
            reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Dado("^que se tiene una poliza con las coberturas para SoloRC$")
  public void recibirReclamoSoloRC(List<String> coberturas) throws IOException {
    this.coberturas=coberturas;
    reclamacionAuto =
            new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSoloRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSoloRC"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
            reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }
  @Entonces(
          "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada SoloRC$")
  public void generarReclamacionSoloRC(DataTable dtl_culpabilidad) throws SQLException, IOException {
    List<List<String>> data = dtl_culpabilidad.raw();
    String culpabilidad = data.get(1).get(0);
    exposicionVehiculoTercero = new ExposicionVehiculoTercero(genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
    reclamacionStep.crearExposionVehiculoTercero(exposicionVehiculoTercero.getLstExposicionTerceros());
    exposicionPersona = new ExposicionPersona(genericStep.getFilasModelo("responsabilidad_civil_persona","exposicionRcPersona"));
    reclamacionStep.crearExposicionPersona(exposicionPersona.getLstExposicionPersona());
    reclamacionStep.finalizarReclamacion();
    reclamacionStep.validarReclamacion();
    reclamacionStep.visualizarResumenSiniestro();
    reclamacionStep.consultarReclamacion();
    lineaReservaValorReservaAutos = new LineaReservaValorReservaAutos(genericStep.getFilasModelo("linea_reserva_valor_reserva","SoloRC|"));
    reclamacionStep.consultarLineaReservaValorReservaRC(lineaReservaValorReservaAutos.getLstLineasReservaValoresReserva());
  }

}
