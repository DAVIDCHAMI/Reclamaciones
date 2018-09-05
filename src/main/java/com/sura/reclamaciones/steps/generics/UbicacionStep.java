package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.UbicacionPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;

public class UbicacionStep {

  @Page UbicacionPage ubicacionPage;

  public void seleccionarUbicacion(List<ReclamacionEmpresarial> datosUbicacion) {
    datosUbicacion.forEach(
        ubicacion -> {
          ubicacionPage.seleccionarUbicacion("Country-inputEl", ubicacion.getPais());
          ubicacionPage.seleccionarPais(ubicacion.getPais());
          ubicacionPage.seleccionarDepartamento(ubicacion.getDepartamento());
          ubicacionPage.seleccionarCiudad(ubicacion.getCiudad());
        });
  }
}
