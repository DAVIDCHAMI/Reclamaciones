package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.DIRECCION_EXPOSICION_LESIONES;
import static com.sura.reclamaciones.constantes.Filtros.DIRECCION_EXPOSICION_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICIONES_ARCHIVO;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICIONES_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.constantes.Filtros.LINEA_RESERVA_ARCHIVO;
import static com.sura.reclamaciones.constantes.Filtros.RECLAMACION_ARCHIVO;
import static com.sura.reclamaciones.constantes.Filtros.RECLAMACION_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.constantes.Filtros.RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.constantes.Filtros.RECLAMACION_SUBROGACION;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_DIRECCION_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_PERSONA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_LINEA_RESERVA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.generics.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevoAvisoSiniestroAutoStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAutoDefinition {

  @Steps private GenericStep genericStep;

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  @Steps private NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private PersonaReclamacion personaReclamacion;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;
  private static String RESPONSABILIDAD_CIVIL_VEHICULO;
  private static String RESPONSABILIDAD_CIVIL_LESIONES;

  @Dado("^que se tiene una póliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    RESPONSABILIDAD_CIVIL_LESIONES = parametrosSiniestro.raw().get(1).get(2);
    RESPONSABILIDAD_CIVIL_VEHICULO = parametrosSiniestro.raw().get(1).get(3);
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                RESPONSABILIDAD_CIVIL_VEHICULO));
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_PERSONA.getValor(), RESPONSABILIDAD_CIVIL_VEHICULO));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(),
                DIRECCION_EXPOSICION_VEHICULAR.getValor()));
    crearNuevaExposicionVehicular();
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_PERSONA.getValor(), RESPONSABILIDAD_CIVIL_LESIONES));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(),
                DIRECCION_EXPOSICION_LESIONES.getValor()));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES.getValor(),
                RESPONSABILIDAD_CIVIL_LESIONES));
    reclamacionStep.crearNuevaExposicionLesiones(
        personaReclamacion.getLstPersonaReclamacion(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    nuevaReclamacionGuardadaStep.abrirReclamacionGuardada();
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_RESPONSABILIDAD_CIVIL.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_ARCHIVO.getValor()));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_ARCHIVO.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.finalizarReclamacionAutos();
    nuevaReclamacionGuardadaStep.abrirReclamacionGuardada();
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_ARCHIVO.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                PARAMETRO_LINEA_RESERVA.getValor(), LINEA_RESERVA_ARCHIVO.getValor()));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SUBROGACION.getValor()));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_SUBROGACION.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Dado("^que se tiene una póliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(),
                RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Entonces(
      "^se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                PARAMETRO_LINEA_RESERVA.getValor(),
                RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  private void crearNuevaExposicionVehicular() {
    reclamacionStep.crearExposicionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacion.getLstPersonaReclamacion(),
        direccionReclamacion.getLstReclamacionAuto());
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
