package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import net.thucydides.core.steps.StepInterceptor;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.LoggerFactory;

public class NuevaReclamacionAtrEmpresarialStep {

@Page AsistenteVirtualAtrPage asistenteVirtualAtrPage;
  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);


  public void accederAvisoEmpresa(){
    asistenteVirtualAtrPage.accederHerramientaAvisoEmpresa();
  }

}
