package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.ResultadoValidacionArchivoPage;
import org.fluentlenium.core.annotation.Page;

public class ResultadoValidacionArchivoStep {

  @Page ResultadoValidacionArchivoPage resultadoValidacionArchivoPage;

  public void validarNumeroRegistrosArchivo() {
    resultadoValidacionArchivoPage.capturarNumeroRegistrosPantalla();
    resultadoValidacionArchivoPage.validarNumeroRegistrosArchivoXls();
    resultadoValidacionArchivoPage.continuarSiguientePantalla();
  }
}
