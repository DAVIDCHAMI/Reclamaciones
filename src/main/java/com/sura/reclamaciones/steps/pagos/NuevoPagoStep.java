package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevoPagoStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page ExposicionAutomaticaPage exposicionAutomaticaPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  @Step
  public void agregarPagoNuevaLineaReserva() {
    introducirInformacionPagoPage.agregarNuevoPago();
  }

  @Step
  public void crearNuevoPago() {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
  }

  @Step
  public void seleccionarExposicionVehicularAsegurado() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    exposicionAutomaticaPage.seleccionarExposicion();
  }

  @Step
  public void declararReclamacionPerdidaTotal() {
    detalleExposicionAutomaticaPage.seleccionarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.editarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.seleccionarIncineracionTotalVehiculo();
    detalleExposicionAutomaticaPage.seleccionarMotorDestruidoFuego();
    detalleExposicionAutomaticaPage.seleccionarHabitaculoPasajerosIncinerado();
    detalleExposicionAutomaticaPage.actualizarCalculadoraPerdidaTotal();
  }

  @Step
  public void ingresarEstadoLegalReclamacion() {
    detalleExposicionAutomaticaPage.seleccionarDetalleExposicion();
    detalleExposicionAutomaticaPage.editarDetalleExposicion();
    detalleExposicionAutomaticaPage.ingresarEstadoLegalReclamacion();
    detalleExposicionAutomaticaPage.actualizarDetalleExposicion();
  }
}
