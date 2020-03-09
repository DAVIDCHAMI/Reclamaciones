package com.sura.reclamaciones.steps.guidewire.claimscenter;

import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.constantes.Constantes.PAGOS;

import com.sura.reclamaciones.pages.general.MenuClaimPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.ExposicionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.IntroducirInformacionPagoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevoPagoStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page ExposicionPage exposicionPage;

  @Step
  public void crearNuevoPago() {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
  }

  @Step
  public void declararReclamacionPerdidaTotal() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    exposicionPage.seleccionarExposicion();
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

  public void marcarReclamacionAutosPerdidaTotal() {
    declararReclamacionPerdidaTotal();
    ingresarEstadoLegalReclamacion();
  }
}
