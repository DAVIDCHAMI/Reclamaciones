package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.ResultadoValidacionArchivoPage;
import org.fluentlenium.core.annotation.Page;

public class ResultadoValidacionArchivoStep {

  @Page ResultadoValidacionArchivoPage resultadoValidacionArchivoPage;

  public void validarNumeroRegistrosArchivo() {
    resultadoValidacionArchivoPage.capturarNumeroRegistrosPantalla();
    resultadoValidacionArchivoPage.validarNumeroRegistrosArchivoXls();
    resultadoValidacionArchivoPage.continuarSiguientePantalla();
  }
}
