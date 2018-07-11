package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionBasicaStep {
  @Page InformacionBasicaPage InformacionBasicaPage;

  @Step
  public void informacionPersonal(List<ReclamacionEmpresariales> datosAutor) {
    datosAutor.forEach(
        Autor -> {
          InformacionBasicaPage.seleccionarAutorDelReporte();
          InformacionBasicaPage.escribirDetallehechos(Autor.getDetalleHechos());
        });
  }
}
