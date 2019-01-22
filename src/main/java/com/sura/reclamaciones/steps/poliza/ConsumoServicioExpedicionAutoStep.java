package com.sura.reclamaciones.steps.poliza;

import static com.sura.reclamaciones.utils.EnumVariablesSesion.SESION_SERV_JOB_NUMBER;

import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.pages.generics.MenuPolicyPage;
import com.sura.reclamaciones.services.ConsumoServicioExpedicionIndividualAuto;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ConsumoServicioExpedicionAutoStep {

  @Page
  ConsumoServicioExpedicionIndividualAuto expedicionAutoPage =
      new ConsumoServicioExpedicionIndividualAuto();

  @Page MenuPolicyPage menuPolicyPage;

  @Step
  public void invocarServicioExpedicionAutos() {
    expedicionAutoPage.invocarServicioExpedicion();
  }

  @Step
  public void consumirServicioExpedicion(
      List<ExpedicionAuto> lstParametros, int diasFaltantesVencimiento, String estadoPoliza) {
    expedicionAutoPage.capturarDatosResultado(
        expedicionAutoPage.ejecutarExpedicion(
            lstParametros, diasFaltantesVencimiento, estadoPoliza));
  }

  @Step
  public void buscarJobNumber() {
    String jobNumber = Serenity.sessionVariableCalled(SESION_SERV_JOB_NUMBER.getValor());
    menuPolicyPage.buscarJobNumber(jobNumber);
  }
}
