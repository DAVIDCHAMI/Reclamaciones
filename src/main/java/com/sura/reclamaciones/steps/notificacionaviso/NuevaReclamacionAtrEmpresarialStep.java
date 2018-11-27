package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
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
  @Page
  InformacionReclamacionPage informacionReclamacionPage;
  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);


@Step
  public void accederAvisoEmpresa() {
    asistenteVirtualAtrPage.accederHerramientaAvisoEmpresa();
    asistenteVirtualAtrPage.seleccionarPlanListaProducto();
  }

@Step
  public void buscarAseguradoAtr(List<Persona> datosPersona) {
    datosPersona.forEach(
        asegurado -> {
          buscarPolizaPage.consultarDocumentoAtr(asegurado.getTipoDocumento(), asegurado.getNumDocumento());
        });
  }

  @Step
  public void diligenciarFechaAtr(){
    informacionBasicaPage.seleccionarFechaAviso("2016/Ene/09");
  }

  @Step
  public void diligenciarInformacionSiniestro(String causaSiniestro, String detalleHechos){
informacionReclamacionPage.seleccionarCausaSiniestroAtr(causaSiniestro);
informacionReclamacionPage.diligenciarDetalleHechosAtr(detalleHechos);
  }

}

