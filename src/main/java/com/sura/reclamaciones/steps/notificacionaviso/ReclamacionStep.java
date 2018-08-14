package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReclamacionStep {

  @Page private InformacionBasicaPage informacionBasicaPage;

  @Page private BuscarPolizaPage buscarPolizaPage;

  @Page private AgregarInformacionPage agregarInformacionPage;

  @Page private DetalleVehiculoPage detalleVehiculoPage;

  @Page private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

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

  public void seleccionarNombreAutorReporte() {
    informacionBasicaPage.seleccionarNombre();
  }

  public void validarReclamacion(List<ReclamacionAuto> reclamaciones) {
    reclamaciones.forEach(
        dato -> {
          String mensajeValidado = nuevaReclamacionGuardadaPage.obtenerMensajeValidador();
          MatcherAssert.assertThat(
              "No se encontro el mensaje a validar",
              mensajeValidado.equals(dato.getMensajeValidar()));
        });
  }

  public void finalizarReclamacion() {
    agregarInformacionPage.concluirReclamacion();
  }
}
