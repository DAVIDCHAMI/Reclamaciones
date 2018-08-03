package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionReclamacionStep {
  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Step
  public void informacionIncidente(List<ReclamacionEmpresariales> datosIncidente) {
    datosIncidente.forEach(
        incidente -> {
          informacionReclamacionPage.cerrarReclamosDuplicados();
          informacionReclamacionPage.seleccionarCausaSiniestro(incidente.getCausaDelSiniestro());
          informacionReclamacionPage.escribirValorPretension(incidente.getValorPretension());
          informacionReclamacionPage.seleccionarTipoIncidente(incidente.getTipoIncidente());
          informacionReclamacionPage.finalizarSiniestro();
          informacionReclamacionPage.resumenReclamacion();
        });
  }
}
