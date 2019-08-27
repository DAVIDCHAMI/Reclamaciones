package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import org.fluentlenium.core.annotation.Page;

public class InformacionReclamacionStep {

  @Page InformacionReclamacionPage informacionReclamacionPage;

  public void diligenciarInformacionReclamacion(
      String causa, String valorPretension, String tipoIncidente) {
    informacionReclamacionPage.cerrarReclamosDuplicados();
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
    informacionReclamacionPage.escribirValorPretension(valorPretension);
    informacionReclamacionPage.seleccionarTipoIncidente(tipoIncidente);
    informacionReclamacionPage.finalizarSiniestro();
  }
}
