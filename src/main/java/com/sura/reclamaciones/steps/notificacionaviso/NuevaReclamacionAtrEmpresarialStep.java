package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepInterceptor;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.LoggerFactory;

public class NuevaReclamacionAtrEmpresarialStep {

  @Page
  AsistenteVirtualAtrPage asistenteVirtualAtrPage;
  @Page
  BuscarPolizaPage buscarPolizaPage;
  @Page
  InformacionBasicaPage informacionBasicaPage;
  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);


@Step
  public void accederAvisoEmpresa() {
    asistenteVirtualAtrPage.accederHerramientaAvisoEmpresa();
    asistenteVirtualAtrPage.seleccionarPlanListaProducto();
  }

@Step
  public void buscarPolizaAtr(List<Persona> datosPersona) {
    datosPersona.forEach(
        asegurado -> {
          buscarPolizaPage.consultarDocumentoAtr(asegurado.getTipoDocumento(), asegurado.getNumDocumento());
        });
  }

  public void diligenciarFechaAtr(){
    informacionBasicaPage.seleccionarFechaAviso("2018/11/01");
  }

}

