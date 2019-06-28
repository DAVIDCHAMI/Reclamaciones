package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagomasivo.DetalleFacturaVolumenPage;
import org.fluentlenium.core.annotation.Page;

public class DetalleFacturaVolumenStep {
  @Page DetalleFacturaVolumenPage detalleFacturaVolumenPage;

  @Page GeneralPage generalPage;

  public void buscarBeneficiarioPago ()
  {
    detalleFacturaVolumenPage.buscarBeneficiario();
    detalleFacturaVolumenPage.buscarBeneficiarioPago();
  }

  public void ingresarInformacionFactura(String tipoMoneda, String metodoPago)
  {

    generalPage.seleccionarOpcionLista(tipoMoneda);
    detalleFacturaVolumenPage.seleccionarMetodoPago(metodoPago);
  }
}
