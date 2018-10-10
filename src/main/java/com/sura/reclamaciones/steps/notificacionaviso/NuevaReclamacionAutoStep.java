package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionAutoStep {

  @Page private InformacionBasicaPage informacionBasicaPage;
  @Page private BuscarPolizaPage buscarPolizaPage;
  @Page private AgregarInformacionPage agregarInformacionPage;
  @Page private DetalleVehiculoPage detalleVehiculoPage;
  @Page private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void completarDetalleSiniestro(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionPage.cerrarVentanaEmergente();
          agregarInformacionPage.seleccionarLugar(dato.getLugar());
          agregarInformacionPage.escribirSucedido(dato.getSucedido());
          agregarInformacionPage.seleccionarCausa(dato.getCausa());
          agregarInformacionPage.seleccionarOrigen(dato.getOrigen());
          agregarInformacionPage.escribirValorPretension(dato.getValorPretension());
          agregarInformacionPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
        });
  }

  @Step
  public void completarCategorizacion(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionPage.seleccionarCulpabilidad(dato.getCulpabilidad());
        });
  }

  @Step
  public void editarVehiculo(List<ReclamacionAuto> datosReclamacion) {
    agregarInformacionPage.ingresarEdicionVehiculo();
    detalleVehiculoPage.agregarConductor();
    datosReclamacion.forEach(
        dato -> {
          detalleVehiculoPage.seleccionarTaller(dato.getTaller());
        });
    detalleVehiculoPage.volverPasoAnterior();
  }

  public void seleccionarNombreAutorReporte(List<ReclamacionAuto> lstReclamacionAuto) {
    lstReclamacionAuto.forEach(
        dato -> {
          informacionBasicaPage.seleccionarNombre();
          informacionBasicaPage.validarMsjAdvertenciaRelacionAsegurado(dato.getRelacionAsegurado());
        });
  }

  public void validarReclamacion() {
    String mensajeValidado = nuevaReclamacionGuardadaPage.obtenerMensajeValidador();
    MatcherAssert.assertThat(
        "No se encontro el mensaje a validar",
        mensajeValidado.equals(ReclamacionConstante.VALIDADOR_NUEVA_RECLAMACION));
  }

  public void visualizarResumenSiniestro(){
    nuevaReclamacionGuardadaPage.obtenerNumeroReclamacion();
  }

  public void finalizarReclamacion() {
    agregarInformacionPage.concluirReclamacion();
  }

  @Step
  public void completarFormularioBuscarPoliza(
      List<ReclamacionAuto> datosReclamacion, List<Vehiculo> datosVehiculo) {
    datosVehiculo.forEach(
        datoReclamacion -> {
          buscarPolizaPage.escribirPlaca(datoReclamacion.getPlaca());
        });
    datosReclamacion.forEach(
        dato -> {
          seleccionarFecha(dato.getFechaSiniestro());
        });
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

  public void seleccionarMenu() {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
  }
}
