package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.UbicacionPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;

public class UbicacionStep {

  @Page UbicacionPage ubicacionPage;

  public void seleccionarUbicacion(List<ReclamacionEmpresarial> datosUbicacion) {
    datosUbicacion.forEach(
        ubicacion -> {
          ubicacionPage.seleccionarPais(ubicacion.getPais());
          ubicacionPage.seleccionarDepartamento(ubicacion.getDepartamento());
          ubicacionPage.seleccionarCiudad(ubicacion.getCiudad());
        });
  }
}
