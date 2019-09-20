package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import org.fluentlenium.core.annotation.Page;

public class InformacionReclamacionStep {

  @Page InformacionReclamacionPage informacionReclamacionPage;

  public void seleccionarCausalIncidente(String causa, String valorPretension) {
    informacionReclamacionPage.cerrarReclamosDuplicados();
    informacionReclamacionPage.escribirValorPretension(valorPretension);
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
  }

  public void diligenciarInformacionIncidente(String incidente) {
    informacionReclamacionPage.seleccionarTipoIncidente(incidente);
    informacionReclamacionPage.finalizarSiniestro();
  }
}
