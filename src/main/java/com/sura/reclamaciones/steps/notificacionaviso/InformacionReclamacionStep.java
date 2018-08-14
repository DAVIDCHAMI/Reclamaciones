package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class InformacionReclamacionStep {

  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Step
  public void informacionIncidente(
      List<ReclamacionEmpresariales> datosIncidente, String incidente) {
    datosIncidente.forEach(
        datos -> {
          informacionReclamacionPage.cerrarReclamosDuplicados();
          informacionReclamacionPage.seleccionarTipoIncidente(incidente);
          informacionReclamacionPage.finalizarSiniestro();
        });
  }

  @Step
  public void causalIncidente(String causa, String valorPretension) {
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
    informacionReclamacionPage.escribirValorPretension(valorPretension);
  }

  @Step
  public void validarReclamacion(List<ReclamacionEmpresariales> datosValidacion) {
    datosValidacion.forEach(
        datos -> {
          String verificar;
          verificar = informacionReclamacionPage.validarReclamacionGenerada();
          MatcherAssert.assertThat(
              "No se ha obtenido el número de reclamación",
              verificar.equals(datos.getValidarNumeroReclamacion()));
        });
  }
}
