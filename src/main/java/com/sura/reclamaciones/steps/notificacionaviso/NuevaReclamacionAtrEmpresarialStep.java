package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import java.util.List;
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

  slbProducto

  OTROS PRODUCTOS


  images/Bot_Aceptar.jpg


  public void accederAvisoEmpresa() {
    asistenteVirtualAtrPage.accederHerramientaAvisoEmpresa();
  }

  public void buscarPolizaAtr(List<ReclamacionEmpresarial> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          buscarPolizaPage.consultarPolizaAtr(poliza.getNumPoliza(), poliza.getRamoPolizaAtr());
          buscarPolizaPage.seleccionarRiesgoAtr();
        });
  }

  public void diligenciarFechaAtr(){
    informacionBasicaPage.seleccionarFechaAviso("2018/11/01");
  }

}

