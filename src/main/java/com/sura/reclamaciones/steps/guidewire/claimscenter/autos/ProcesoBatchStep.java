package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.VOLVER_CLAIMCENTER_MENU;
import static com.sura.reclamaciones.utils.enums.NombreProcesoBatch.*;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.ProcesoBatchPage;
import org.fluentlenium.core.annotation.Page;

public class ProcesoBatchStep {

  @Page ProcesoBatchPage procesoBatchPage;

  public void ejecutarProcesoBatch() {
    procesoBatchPage.ejecutarBatch();
    procesoBatchPage.ejecutarProcesoBatch(ENVIO_FACTURA_VOLUMEN.getValor());
    procesoBatchPage.ejecutarProcesoBatch(MONITOR_FLUJO_TRABAJO_FACTURA_VOLUMEN.getValor());
    procesoBatchPage.ejecutarProcesoBatch(TRANSFERENCIA_FACTURA_VOLUMEN.getValor());
    procesoBatchPage.seleccionarOpcionMenuAccion();
    procesoBatchPage.seleccionarOpcionMenuAccionesPrimerNivel(VOLVER_CLAIMCENTER_MENU);
  }
}
