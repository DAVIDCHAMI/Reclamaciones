package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.DATOS_FINANCIEROS;
import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarExposicionLesionesPage;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.CreacionServicioPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DatosFinancierosPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.exposiciones.ExposicionPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevoAvisoSiniestroAutoStep {

  @Page InformacionBasicaPage informacionBasicaPage;

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page AgregarInformacionPage agregarInformacionPage;

  @Page DetalleVehiculoPage detalleVehiculoPage;

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  @Page DatosFinancierosPage datosFinancierosPage;

  @Page ExposicionPage exposicionPage;

  @Page AgregarExposicionLesionesPage agregarExposicionLesionesPage;

  @Page MenuClaimPage menuClaimPage;

  @Page CreacionServicioPage crearServicioPage;

  @Step
  public void completarDetalleSiniestro(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionPage.cerrarVentanaEmergente();
          agregarInformacionPage.seleccionarLugar(dato.getLugarSiniestro());
          agregarInformacionPage.escribirSucedido(dato.getDescripcionHechos());
          agregarInformacionPage.seleccionarCausa(dato.getCausaPerdida());
          agregarInformacionPage.seleccionarOrigen(dato.getOrigenCausa());
          agregarInformacionPage.escribirValorPretension(dato.getValorPretension());
          agregarInformacionPage.seleccionarIntervinoAutoridad(dato.getAutoridadTransito());
        });
  }

  @Step
  public void completarDatosReclamacionAutos(List<ReclamacionAuto> datosReclamacion) {
    for (ReclamacionAuto dato : datosReclamacion) {
      agregarInformacionPage.seleccionarCulpabilidad(dato.getCulpabilidad());
    }
  }

  @Step
  public void crearExposicionVehicular(
      List<ExposicionVehiculoTercero> datosExposicionTercero,
      List<PersonaReclamacion> datosPersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto) {
    agregarInformacionPage.agregarExposicionVehiculoTercero();
    detalleVehiculoPage.agregarConductor();
    agregarPersonaConductor(datosPersonaReclamacion);
    agregarDireccionConductor(datosReclamacionAuto);
    agregarDatosExposicionTercero(datosExposicionTercero);
  }

  @Step
  public void crearExposicionLesiones(
      List<PersonaReclamacion> datopersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionLesiones> datosExposicionLesiones) {
    agregarExposicionLesionesPage.agregarPersonaLesionada();
    agregarPersonaLesionada(datopersonaReclamacion);
    agregarDireccionLesionado(datosReclamacionAuto);
    agregarDatosExposicionLesiones(datosExposicionLesiones);
  }

  @Step
  private void agregarPersonaConductor(List<PersonaReclamacion> datosPersonaReclamacion) {
    for (PersonaReclamacion conductorVehiculoAfectado : datosPersonaReclamacion) {
      detalleVehiculoPage.seleccionarTipoDocumento(conductorVehiculoAfectado.getTipoDocumento());
      detalleVehiculoPage.ingresarNumeroDocumento(conductorVehiculoAfectado.getNumDocumento());
      detalleVehiculoPage.ingresarPrimerNombre(conductorVehiculoAfectado.getPrimerNombre());
      detalleVehiculoPage.ingresarPrimerApellido(conductorVehiculoAfectado.getPrimerApellido());
    }
  }

  @Step
  private void agregarDireccionConductor(List<ReclamacionAuto> datosReclamacionAuto) {
    for (ReclamacionAuto direccionConductor : datosReclamacionAuto) {
      detalleVehiculoPage.seleccionarDepartamento(direccionConductor.getDepartamento());
      detalleVehiculoPage.seleccionarCiudad(direccionConductor.getCiudad());
      detalleVehiculoPage.ingresarDireccion(direccionConductor.getDireccion());
      detalleVehiculoPage.seleccionarTipoDireccion(direccionConductor.getTipoDireccion());
    }
  }

  @Step
  private void agregarDatosExposicionTercero(
      List<ExposicionVehiculoTercero> datosExposicionTercero) {
    for (ExposicionVehiculoTercero datosVehiculo : datosExposicionTercero) {
      detalleVehiculoPage.ingresarVehiculoTercero(datosVehiculo.getPlacaTercero());
      detalleVehiculoPage.recuperarInformacionVehiculo();
      detalleVehiculoPage.seleccionarServicioTaller();
      detalleVehiculoPage.agregarTaller();
      detalleVehiculoPage.buscarProveedor();
      crearServicioPage.seleccionarProveedor(datosVehiculo.getTallerReparacionAsignado());
      detalleVehiculoPage.aceptarOpcion();
      detalleVehiculoPage.volverPasoAnterior();
    }
  }

  @Step
  private void agregarPersonaLesionada(List<PersonaReclamacion> datopersonaReclamacion) {
    for (PersonaReclamacion personaLesionada : datopersonaReclamacion) {
      detalleVehiculoPage.seleccionarTipoDocumento(personaLesionada.getTipoDocumento());
      detalleVehiculoPage.ingresarNumeroDocumento(personaLesionada.getNumDocumento());
      detalleVehiculoPage.ingresarPrimerNombre(personaLesionada.getPrimerNombre());
      detalleVehiculoPage.ingresarPrimerApellido(personaLesionada.getPrimerApellido());
    }
  }

  @Step
  private void agregarDireccionLesionado(List<ReclamacionAuto> datosReclamacionAuto) {
    for (ReclamacionAuto direccionLesionado : datosReclamacionAuto) {
      detalleVehiculoPage.seleccionarDepartamento(direccionLesionado.getDepartamento());
      detalleVehiculoPage.seleccionarCiudad(direccionLesionado.getCiudad());
      detalleVehiculoPage.ingresarDireccion(direccionLesionado.getDireccion());
      detalleVehiculoPage.seleccionarTipoDireccion(direccionLesionado.getTipoDireccion());
    }
  }

  @Step
  private void agregarDatosExposicionLesiones(List<ExposicionLesiones> datosExposicionLesiones) {
    for (ExposicionLesiones lesionesPersona : datosExposicionLesiones) {
      agregarExposicionLesionesPage.seleccionarLesiones();
      agregarExposicionLesionesPage.seleccionarGravedadLesion(lesionesPersona.getGravedadLesion());
      agregarExposicionLesionesPage.ingresarDescripcionLesiones(
          lesionesPersona.getDescribirLesiones());
      agregarExposicionLesionesPage.seleccionarTipoLesion(lesionesPersona.getTipoLesion());
      agregarExposicionLesionesPage.seleccionarDetalleLesion(
          lesionesPersona.getDetallesTipoLesion());
      agregarExposicionLesionesPage.finalizarExposicion();
    }
  }

  @Step
  public void editarInformacionVehiculo(List<ReclamacionAuto> datosReclamacion) {
    agregarInformacionPage.ingresarEdicionVehiculo();
    detalleVehiculoPage.agregarConductor();
    detalleVehiculoPage.seleccionarConductorVehiculoAsegurado();
    datosReclamacion.forEach(
        datoReclamacionAutos -> {
          if (!datoReclamacionAutos
              .getCulpabilidad()
              .equals(ReclamacionConstante.CULPABILIDAD_SOLO_RC)) {
            detalleVehiculoPage.seleccionarServicioTaller();
            detalleVehiculoPage.agregarTaller();
            detalleVehiculoPage.buscarProveedor();
            detalleVehiculoPage.realizarEsperaCarga();
            crearServicioPage.seleccionarProveedor(datoReclamacionAutos.getTallerReparacion());
            detalleVehiculoPage.aceptarOpcion();
            detalleVehiculoPage.volverPasoAnterior();
          } else {
            detalleVehiculoPage.aceptarOpcion();
          }
        });
  }

  @Step
  public void seleccionarNombreAutorReporte(List<ReclamacionAuto> lstReclamacionAuto) {
    lstReclamacionAuto.forEach(
        autorReporte -> {
          informacionBasicaPage.seleccionarNombre();
          informacionBasicaPage.validarMsjAdvertenciaRelacionAsegurado(
              autorReporte.getRelacionAsegurado());
        });
  }

  @Step
  public void validarReclamacionAutos() {
    String mensajeValidado = nuevaReclamacionGuardadaPage.obtenerMensajeValidador();
    MatcherAssert.assertThat(
        "No se encontro el mensaje a validar",
        mensajeValidado.equals(ReclamacionConstante.VALIDADOR_NUEVA_RECLAMACION));
  }

  @Step
  public void validarExposicion(List<ExposicionesAutomaticasAutos> datosExposicionAutomatica) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    boolean exposicionAutomatica = exposicionPage.validarExposiciones(datosExposicionAutomatica);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", exposicionAutomatica);
  }

  @Step
  public void finalizarReclamacionAutos() {
    agregarInformacionPage.concluirReclamacion();
  }

  @Step
  public void completarFormularioBuscarPoliza(
      List<ReclamacionAuto> datosReclamacion, List<Vehiculo> datosVehiculo) {
    for (Vehiculo datoReclamacion : datosVehiculo) {
      buscarPolizaPage.escribirPlaca(datoReclamacion.getPlaca());
    }
    for (ReclamacionAuto dato : datosReclamacion) {
      seleccionarFecha(dato.getFechaSiniestro());
    }
  }

  @Step
  public void seleccionarFecha(String fecha) {
    if ("Hoy".equals(fecha)) {
      buscarPolizaPage.seleccionarFechaHoySiniestro();
    } else {
      buscarPolizaPage.escribirFechaSiniestro(fecha);
    }
  }

  @Step
  public void buscarPoliza() {
    buscarPolizaPage.buscarPoliza();
  }

  @Step
  public void seleccionarOpcionMenuPrincipal() {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
  }

  @Step
  public void consultarReclamacionAutos() {
    nuevaReclamacionGuardadaPage.abrirReclamacion();
  }

  @Step
  public void validarValorReservas(List<Reserva> lineaReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(DATOS_FINANCIEROS.getValor());
    boolean valorLineaReserva = datosFinancierosPage.obtenerDatosFinancieros(lineaReserva);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }

  @Step
  public void consultarPoliza(List<ReclamacionAuto> reclamacionAuto, List<Vehiculo> vehiculo) {
    seleccionarOpcionMenuPrincipal();
    completarFormularioBuscarPoliza(reclamacionAuto, vehiculo);
    buscarPoliza();
    continuar();
  }

  @Step
  public void continuar() {
    buscarPolizaPage.continuarSiguientePantalla();
  }

  @Step
  public void crearNuevaExposicionLesiones(
      List<PersonaReclamacion> personaReclamacionAuto,
      List<ReclamacionAuto> reclamacionAuto,
      List<ExposicionLesiones> exposicionLesiones) {
    crearExposicionLesiones(personaReclamacionAuto, reclamacionAuto, exposicionLesiones);
    finalizarReclamacionAutos();
    validarReclamacionAutos();
    consultarReclamacionAutos();
  }
}
