package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevaReclamacionAtrEmpresarialStep {

  @Page AsistenteVirtualAtrPage asistenteVirtualAtrPage;

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page InformacionBasicaPage informacionBasicaPage;

  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  @Step
  public void accederAvisoAtr() {
    asistenteVirtualAtrPage.accederAsistenteVirtual();
    asistenteVirtualAtrPage.accederAvisoEmpresa();
  }

  @Step
  public void diligenciarInformacionAsegurado(List<Persona> datosPersona) {
    asistenteVirtualAtrPage.seleccionarPlanListaProducto();
    datosPersona.forEach(
        asegurado ->
            buscarPolizaPage.consultarDocumentoAtr(
                asegurado.getTipoDocumento(), asegurado.getNumDocumento()));
  }

  @Step
  public void diligenciarInformacionReclamacion(
      String causaSiniestro, List<ReclamacionEmpresarial> datosSiniestro) {
    datosSiniestro.forEach(
        datos -> informacionBasicaPage.seleccionarFechaAviso(datos.getFechaSiniestro()));
    informacionReclamacionPage.seleccionarCausaSiniestroAtr(causaSiniestro);
    datosSiniestro.forEach(
        datos -> informacionReclamacionPage.diligenciarDetalleHechosAtr(datos.getDetalleHechos()));
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
  public String verificarSiniestroAtr() {
    return informacionReclamacionPage.obtenerNumeroSiniestroAtr();
  }

  @Step
  public void consultarSiniestro(String numeroReclamacion) {
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
  }
}
