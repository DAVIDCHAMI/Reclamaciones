package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevoAvisoSiniestroAutoStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private Persona personaReclamacionAuto;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;

  @Dado("^que se tiene una poliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_AUTOS, "responsabilidadCivil"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, "autoReclamacionSimple"));
    reclamacionStep.consultarPoliza(reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad Responsabilidad Civil$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable culpabilidad)throws IOException {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO, "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, "direccionExposicionVehicular"));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES, "exposicionRcPersona"));
    reclamacionStep.crearNuevaExposicionLesiones(personaReclamacionAuto.getLstPersona(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA, "exposicionesRC"));
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
  }


  @Entonces(
      "^se obtendran exposiciones automaticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil(DataTable reservas) throws IOException {
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_LINEA_RESERVA, "rcVehiculoPeaton"));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_AUTOS, "reclamacionArchivo"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, "autoReclamacionSimple"));
    reclamacionStep.consultarPoliza(reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo(DataTable reservas) throws IOException {
    reclamacionStep.finalizarReclamacionAutos();
    reclamacionStep.validarReclamacionAutos();
    reclamacionStep.consultarReclamacionAutos();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA, "exposicionesArchivo"));
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_LINEA_RESERVA, "archivoSubrogacion"));
    reclamacionStep.validarValorReservasArchivo(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_AUTOS, "reclamacionSubrogacion"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, "reclamacionSubrogacion"));
    reclamacionStep.consultarPoliza(reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Dado("^que se tiene una poliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_AUTOS, "reclamacionSoloRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, "reclamacionSoloRC"));
    reclamacionStep.consultarPoliza(reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
      }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil$")
  public void generarReclamacionSoloResponsabilidadCivil(DataTable reservas) throws IOException {
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO, "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, "direccionExposicionVehicular"));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES, "exposicionRcPersona"));
    reclamacionStep.crearNuevaExposicionLesiones(personaReclamacionAuto.getLstPersona(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA, "exposicionesSoloRC"));
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo(ConstanteGlobal.PARAMETRO_LINEA_RESERVA, "soloRC"));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  private void crearNuevaExposicionVehicular() {
    reclamacionStep.crearExposicionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacionAuto.getLstPersona(),
        direccionReclamacion.getLstReclamacionAuto());
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
