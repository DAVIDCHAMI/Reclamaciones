package com.sura.reclamaciones.steps;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagomasivo.ResultadoArchivoProcesadoPage;
import org.fluentlenium.core.annotation.Page;

public class ResultadoArchivoProcesadoStep {
  @Page ResultadoArchivoProcesadoPage resultadoArchivoProcesadoPage;

  @Page GeneralPage generalPage;

  public void consultarResultadoArchivoProcesado() {
    resultadoArchivoProcesadoPage.consultarResultadoArchivoProcesado();
    generalPage.continuarSiguientePantalla();
  }
}
