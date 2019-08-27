package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
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
