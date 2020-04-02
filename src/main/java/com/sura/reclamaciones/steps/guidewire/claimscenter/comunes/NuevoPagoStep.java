package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.utils.enums.Constantes.PAGOS;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.ExposicionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.IntroducirInformacionPagoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
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
