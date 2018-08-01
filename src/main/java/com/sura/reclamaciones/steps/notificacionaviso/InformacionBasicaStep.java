package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionBasicaStep {
  @Page InformacionBasicaPage informacionBasicaPage;

  @Step
  public void informacionPersonal(List<ReclamacionEmpresariales> datosAutor) {
    datosAutor.forEach(
        Autor -> {
          informacionBasicaPage.seleccionarAutorReporte();
          informacionBasicaPage.escribirDetallehechos(Autor.getDetalleHechos());
        });
  }
}
