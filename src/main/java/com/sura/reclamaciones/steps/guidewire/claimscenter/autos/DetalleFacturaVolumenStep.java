package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.DetalleFacturaVolumenPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.ProcesoBatchPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class DetalleFacturaVolumenStep {

  @Page DetalleFacturaVolumenPage detalleFacturaVolumenPage;

  @Page ProcesoBatchPage procesoBatchPage;

  @Step
  public void ingresarInformacionFactura(String tipoMoneda, String metodoPago) {
    detalleFacturaVolumenPage.seleccionarTipoMoneda(tipoMoneda);
    detalleFacturaVolumenPage.seleccionarMetodoPago(metodoPago);
    detalleFacturaVolumenPage.buscarBeneficiario();
    detalleFacturaVolumenPage.buscarBeneficiarioPago();
  }

  @Step
  public void crearPagoMasivo() {
    detalleFacturaVolumenPage.obtenerNumeroFacturaPagoMasivo();
    detalleFacturaVolumenPage.finalizarPagoMasivo();
    detalleFacturaVolumenPage.enviarPagoMasivo();
  }

  @Step
  public void validarPagoMasivo() {
    detalleFacturaVolumenPage.validarEstadoPagoMasivo();
    detalleFacturaVolumenPage.obtenerNumeroPagoIndividual();
  }
}
