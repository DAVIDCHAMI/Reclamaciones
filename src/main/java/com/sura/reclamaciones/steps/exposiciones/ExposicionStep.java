package com.sura.reclamaciones.steps.exposiciones;

import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ExposicionStep {

  @Page ExposicionPage exposicionPage;

  @Step
  public void validarExposicionEmpresariales(String tipoExposicion) {
    boolean exposicionAutomatica = exposicionPage.validarExposicionEmpresariales(tipoExposicion);
    MatcherAssert.assertThat("El tipo de exposición no es el esperado", exposicionAutomatica);
  }
}
