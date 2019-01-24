package com.sura.reclamaciones.steps.poliza;

import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.pages.generics.MenuPolicyPage;
import com.sura.reclamaciones.services.ConsumoServicioExpedicionIndividualAuto;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ConsumoServicioExpedicionAutoStep {

  @Page
  ConsumoServicioExpedicionIndividualAuto expedicionAutoPage =
      new ConsumoServicioExpedicionIndividualAuto();

  @Page MenuPolicyPage menuPolicyPage;

  @Step
  public void consumirServicioExpedicion(
      List<ExpedicionAuto> lstParametros, int diasFaltantesVencimiento, String estadoPoliza) {
    expedicionAutoPage.capturarDatosResultado(
        expedicionAutoPage.ejecutarExpedicion(
            lstParametros, diasFaltantesVencimiento, estadoPoliza));
  }
}
