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

public class NotificacionAvisoSiniestroAutoDefinition<$> {

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
  private static String direccion_Exposicion_Vehicular = "direccionExposicionVehicular";
  private static String direccion_Exposicion_Lesiones = "direccionExposicionLesiones";
  private static String exposiciones_Responsabilidad_Civil = "exposicionesRC";
  private static String exposiciones_Solo_Responsabilidad_Civil = "exposicionesSoloRC";
  private static String reclamacion_Responsabilidad_Civil = "responsabilidadCivil";
  private static String reclamacion_Solo_Responsabilidad_Civil = "soloRC";
  private static String reclamacion_Archivo = "archivo";
  private static String reclamacion_Subrogacion = "subrogacion";
  private static String exposiciones_Archivo = "exposicionesArchivo";
  private static String linea_Reserva_Archivo = "archivoSubrogacion";
  private static String responsabilidadCivilVehiculo;
  private static String responsabilidadCivilLesiones;

  @Dado("^que se tiene una póliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION, reclamacion_Responsabilidad_Civil));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO,
                reclamacion_Responsabilidad_Civil));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    responsabilidadCivilLesiones = parametrosSiniestro.raw().get(1).get(2).toString();
    responsabilidadCivilVehiculo = parametrosSiniestro.raw().get(1).get(3).toString();
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO,
                responsabilidadCivilVehiculo));
    personaReclamacionAuto =
        new Persona(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_PERSONA, responsabilidadCivilVehiculo));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, direccion_Exposicion_Vehicular));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_PERSONA, responsabilidadCivilLesiones));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, direccion_Exposicion_Lesiones));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES,
                responsabilidadCivilLesiones));
    reclamacionStep.crearNuevaExposicionLesiones(
        personaReclamacionAuto.getLstPersona(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA,
                exposiciones_Responsabilidad_Civil));
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil(DataTable reservas) throws IOException {
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_LINEA_RESERVA, reclamacion_Responsabilidad_Civil));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION, reclamacion_Archivo));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, reclamacion_Archivo));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo(DataTable reservas) throws IOException {
    reclamacionStep.finalizarReclamacionAutos();
    reclamacionStep.validarReclamacionAutos();
    reclamacionStep.consultarReclamacionAutos();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA, exposiciones_Archivo));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_LINEA_RESERVA, linea_Reserva_Archivo));
    reclamacionStep.validarValorReservasArchivo(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION, reclamacion_Subrogacion));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, reclamacion_Subrogacion));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Dado("^que se tiene una póliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION, reclamacion_Solo_Responsabilidad_Civil));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO,
                reclamacion_Solo_Responsabilidad_Civil));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad SoloRC con Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo$")
  public void ingresarDatosSiniestroSoloResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    responsabilidadCivilLesiones = parametrosSiniestro.raw().get(1).get(2).toString();
    responsabilidadCivilVehiculo = parametrosSiniestro.raw().get(1).get(3).toString();
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO,
                responsabilidadCivilVehiculo));
    personaReclamacionAuto =
        new Persona(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_PERSONA, responsabilidadCivilVehiculo));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, direccion_Exposicion_Vehicular));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_PERSONA, responsabilidadCivilLesiones));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_DIRECCION_SINIESTRO, direccion_Exposicion_Lesiones));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES,
                responsabilidadCivilLesiones));
    reclamacionStep.crearNuevaExposicionLesiones(
        personaReclamacionAuto.getLstPersona(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA,
                exposiciones_Responsabilidad_Civil));
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_EXPOSICION_AUTOMATICA,
                exposiciones_Solo_Responsabilidad_Civil));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETRO_LINEA_RESERVA, reclamacion_Solo_Responsabilidad_Civil));
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
