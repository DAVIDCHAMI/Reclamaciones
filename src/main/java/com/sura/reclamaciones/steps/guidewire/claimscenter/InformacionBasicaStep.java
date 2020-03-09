package com.sura.reclamaciones.steps.guidewire.claimscenter;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.guidewire.claimscenter.InformacionBasicaPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;

public class InformacionBasicaStep {

  @Page InformacionBasicaPage informacionBasicaPage;

  public void diligenciarInformacionBasica(List<ReclamacionEmpresarial> datosAutor) {
    datosAutor.forEach(
        autor -> {
          informacionBasicaPage.seleccionarAutorReporte();
          informacionBasicaPage.escribirDetalleHechos(autor.getDetalleHechos());
        });
  }
}
