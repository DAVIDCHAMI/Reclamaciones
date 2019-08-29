package com.sura.reclamaciones.steps.exposiciones;

import static com.sura.reclamaciones.constantes.Constantes.TIPO;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

import com.sura.reclamaciones.pages.exposiciones.ExposicionPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ExposicionStep {

  @Page ExposicionPage exposicionPage;

  @Page GeneralPage generalPage;

  private boolean tipoExposicionEmpresarial;

  @Step
  public void validarExposicionEmpresariales(String tipoExposicion) {
    String valorTipoExposicion =
        generalPage.obtenerDatoTablaCabecera(
            TIPO.getValor(), Integer.parseInt(POSICION_FILA.getValor()));
    if (!valorTipoExposicion.equals(tipoExposicion)) {
      tipoExposicionEmpresarial = false;
    } else {
      tipoExposicionEmpresarial = true;
    }
    MatcherAssert.assertThat("El tipo de exposición no es la esperada", tipoExposicionEmpresarial);
  }
}
