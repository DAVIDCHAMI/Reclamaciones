package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.ProcesoBatchPage;
import com.sura.reclamaciones.pages.pagomasivo.DetalleFacturaVolumenPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class DetalleFacturaVolumenStep
{

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
    detalleFacturaVolumenPage.finalizarPagoMasivo();
    detalleFacturaVolumenPage.enviarPagoMasivo();
  }
}
