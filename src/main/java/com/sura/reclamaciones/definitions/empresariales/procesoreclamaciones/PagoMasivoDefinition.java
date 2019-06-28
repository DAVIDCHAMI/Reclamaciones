package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {
  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Cuando("^se crea uno o varios pagos a un mismo proveedor")
  public void crearPagoMasivo() {
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
  }
}
