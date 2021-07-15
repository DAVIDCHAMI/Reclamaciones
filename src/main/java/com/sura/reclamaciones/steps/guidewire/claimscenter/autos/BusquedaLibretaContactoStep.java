package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.BusquedaLibretaContactoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BusquedaLibretaContactoStep {
  @Page BusquedaLibretaContactoPage busquedaLibretaContactoPage;

  @Step
  public void buscarContactoPagoMasivo(String tipoContacto, String nombreContacto) {
    busquedaLibretaContactoPage.seleccionarTipoContacto(tipoContacto);
    busquedaLibretaContactoPage.ingresarNombreContacto(nombreContacto);
    busquedaLibretaContactoPage.buscarContacto();
    busquedaLibretaContactoPage.seleccionarContactoPagoMasivo(nombreContacto);
  }
}
