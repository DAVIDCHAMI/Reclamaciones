package com.sura.reclamaciones.steps.exposiciones;

import static com.sura.reclamaciones.constantes.Constantes.TIPO;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.constantes.ReclamacionConstante.EXPOSICIONES;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ExposicionStep {

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

  private boolean tipoExposicionEmpresarial;

  @Step
  public void validarExposicionEmpresariales(String tipoExposicion) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES);
    String valorTipoExposicion =
        generalPage.obtenerDatoTablaCabecera(
            TIPO.getValor(), Integer.parseInt(POSICION_FILA.getValor()));
    if (!valorTipoExposicion.equals(tipoExposicion)) {
      tipoExposicionEmpresarial = false;
    } else {
      tipoExposicionEmpresarial = true;
    }
  }
}
