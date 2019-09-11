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
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.CreacionServicioPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DatosFinancierosPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DatosPeatonPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.generics.DatosGeneralesNuevaExposicionPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
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

  @Page DatosFinancierosPage datosFinancierosPage;

  @Page ExposicionAutomaticaPage exposicionAutomaticaPage;

  @Page DatosPeatonPage agregarExposicionLesionesPage;

  @Page MenuClaimPage menuClaimPage;

  @Page CreacionServicioPage crearServicioPage;

  @Page GeneralPage generalPage;

  @Page DatosGeneralesNuevaExposicionPage datosGeneralesNuevaExposicionPage;

  private void completarDetalleSiniestro(List<ReclamacionAuto> datosReclamacion) {
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

  private void completarDatosReclamacionAutos(List<ReclamacionAuto> datosReclamacion) {
    for (ReclamacionAuto dato : datosReclamacion) {
      agregarInformacionPage.seleccionarCulpabilidad(dato.getCulpabilidad());
    }
  }

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

  private void crearExposicionLesiones(
      List<PersonaReclamacion> datopersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionLesiones> datosExposicionLesiones) {
    agregarExposicionLesionesPage.agregarPersonaLesionada();
    agregarPersonaLesionada(datopersonaReclamacion);
    agregarDireccionLesionado(datosReclamacionAuto);
    agregarDatosExposicionLesiones(datosExposicionLesiones);
  }

  private void agregarPersonaConductor(List<PersonaReclamacion> datosPersonaReclamacion) {
    for (PersonaReclamacion conductorVehiculoAfectado : datosPersonaReclamacion) {
      datosGeneralesNuevaExposicionPage.seleccionarTipoDocumento(
          conductorVehiculoAfectado.getTipoDocumento());
      datosGeneralesNuevaExposicionPage.ingresarNumeroDocumento(
          conductorVehiculoAfectado.getNumDocumento());
      datosGeneralesNuevaExposicionPage.ingresarPrimerNombre(
          conductorVehiculoAfectado.getPrimerNombre());
      datosGeneralesNuevaExposicionPage.ingresarPrimerApellido(
          conductorVehiculoAfectado.getPrimerApellido());
    }
  }

  private void agregarDireccionConductor(List<ReclamacionAuto> datosReclamacionAuto) {
    for (ReclamacionAuto direccionConductor : datosReclamacionAuto) {
      datosGeneralesNuevaExposicionPage.seleccionarDepartamento(
          direccionConductor.getDepartamento());
      datosGeneralesNuevaExposicionPage.seleccionarCiudad(direccionConductor.getCiudad());
      datosGeneralesNuevaExposicionPage.ingresarDireccion(direccionConductor.getDireccion());
      datosGeneralesNuevaExposicionPage.seleccionarTipoDireccion(
          direccionConductor.getTipoDireccion());
      generalPage.aceptarOpcion();
    }
  }

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

  private void agregarPersonaLesionada(List<PersonaReclamacion> datopersonaReclamacion) {
    for (PersonaReclamacion personaLesionada : datopersonaReclamacion) {
      datosGeneralesNuevaExposicionPage.seleccionarTipoDocumento(
          personaLesionada.getTipoDocumento());
      datosGeneralesNuevaExposicionPage.ingresarNumeroDocumento(personaLesionada.getNumDocumento());
      datosGeneralesNuevaExposicionPage.ingresarPrimerNombre(personaLesionada.getPrimerNombre());
      datosGeneralesNuevaExposicionPage.ingresarPrimerApellido(
          personaLesionada.getPrimerApellido());
    }
  }

  private void agregarDireccionLesionado(List<ReclamacionAuto> datosReclamacionAuto) {
    for (ReclamacionAuto direccionLesionado : datosReclamacionAuto) {
      datosGeneralesNuevaExposicionPage.seleccionarDepartamento(
          direccionLesionado.getDepartamento());
      datosGeneralesNuevaExposicionPage.seleccionarCiudad(direccionLesionado.getCiudad());
      datosGeneralesNuevaExposicionPage.ingresarDireccion(direccionLesionado.getDireccion());
      datosGeneralesNuevaExposicionPage.seleccionarTipoDireccion(
          direccionLesionado.getTipoDireccion());
    }
  }

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

  private void editarInformacionVehiculo(List<ReclamacionAuto> datosReclamacion) {
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

  private void seleccionarNombreAutorReporte(List<ReclamacionAuto> lstReclamacionAuto) {
    lstReclamacionAuto.forEach(
        autorReporte -> {
          informacionBasicaPage.seleccionarNombre();
          informacionBasicaPage.validarMsjAdvertenciaRelacionAsegurado(
              autorReporte.getRelacionAsegurado());
        });
  }

  @Step
  public void validarExposicion(List<ExposicionesAutomaticasAutos> datosExposicionAutomatica) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    boolean exposicionAutomatica =
        exposicionAutomaticaPage.validarExposiciones(datosExposicionAutomatica);
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
  public void crearAvisoResponsabilidadCivil(
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionVehiculoTercero> datosExposicionTercero,
      List<PersonaReclamacion> datosPersonaReclamacionVehiculoTercero,
      List<ReclamacionAuto> direccionExposicionVehicularTercero,
      List<PersonaReclamacion> datosPersonaLesionada,
      List<ReclamacionAuto> direccionExposicionLesionado,
      List<ExposicionLesiones> exposicionLesiones) {
    seleccionarNombreAutorReporte(datosReclamacionAuto);
    completarDetalleSiniestro(datosReclamacionAuto);
    editarInformacionVehiculo(datosReclamacionAuto);
    completarDatosReclamacionAutos(datosReclamacionAuto);
    crearExposicionVehicular(
        datosExposicionTercero,
        datosPersonaReclamacionVehiculoTercero,
        direccionExposicionVehicularTercero);
    crearExposicionLesiones(
        datosPersonaLesionada, direccionExposicionLesionado, exposicionLesiones);
    finalizarReclamacionAutos();
  }

  @Step
  public void crearAvisoPerdidaParcialDanos(List<ReclamacionAuto> lstReclamacionAuto) {
    seleccionarNombreAutorReporte(lstReclamacionAuto);
    completarDetalleSiniestro(lstReclamacionAuto);
    editarInformacionVehiculo(lstReclamacionAuto);
    completarDatosReclamacionAutos(lstReclamacionAuto);
    finalizarReclamacionAutos();
  }
}
