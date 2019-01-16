package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.PersonaReclamacion;
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

  @Page AsistenteVirtualAtrPage asistenteVirtualAtrPage;

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page InformacionBasicaPage informacionBasicaPage;

  @Page InformacionReclamacionPage informacionReclamacionPage;

  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  @Step
  public void accederAvisoAtr() {
    asistenteVirtualAtrPage.accederAsistenteVirtual();
    asistenteVirtualAtrPage.accederAvisoEmpresa();
  }

  @Step
  public void diligenciarInformacionAsegurado(List<PersonaReclamacion> datosPersona) {
    asistenteVirtualAtrPage.seleccionarPlanListaProducto();
    datosPersona.forEach(
        asegurado -> {
          buscarPolizaPage.consultarDocumentoAtr(
              asegurado.getTipoDocumento(), asegurado.getNumDocumento());
        });
  }

  @Step
  public void diligenciarInformacionReclamacion(String causaSiniestro, String detalleHechos) {
    informacionBasicaPage.seleccionarFechaAviso("2018/Nov/20" /*To do*/);
    informacionReclamacionPage.seleccionarCausaSiniestroAtr(causaSiniestro);
    informacionReclamacionPage.diligenciarDetalleHechosAtr(detalleHechos);
    informacionReclamacionPage.seleccionarCiudadSiniestro();
  }

  @Step
  public void consultarPolizaAtr() {
    buscarPolizaPage.consultarPolizaAseguradoAtr();
    buscarPolizaPage.seleccionarPolizaAtr();
    buscarPolizaPage.seleccionarRiegoPolizaAtr();
  }

  @Step
  public void diligenciarValorPretension(String valorPretension) {
    informacionReclamacionPage.ingresarValorPretensionAtr(valorPretension);
    informacionReclamacionPage.enviarReclamacion();
  }

  @Step
  public void verificarSiniestroAtr() {
    String numeroSiniestro = informacionReclamacionPage.obtenerNumeroSiniestroAtr();
    //To Do
  }
}
