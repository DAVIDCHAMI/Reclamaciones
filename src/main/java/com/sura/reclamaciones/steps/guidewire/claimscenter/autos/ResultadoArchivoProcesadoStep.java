package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.ResultadoArchivoProcesadoPage;
import org.fluentlenium.core.annotation.Page;

public class ResultadoArchivoProcesadoStep {
  @Page ResultadoArchivoProcesadoPage resultadoArchivoProcesadoPage;

  @Page GeneralPage generalPage;

  public void consultarResultadoArchivoProcesado() {
    resultadoArchivoProcesadoPage.consultarResultadoArchivoProcesado();
    generalPage.continuarSiguientePantalla();
  }
}
