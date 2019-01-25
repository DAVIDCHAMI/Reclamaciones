package com.sura.reclamaciones.definitions.expedicionpolizaindividual;

import static com.sura.reclamaciones.constantes.EnumVariablesSesion.SESION_SERV_JOB_NUMBER;
import static com.sura.reclamaciones.constantes.NombresCsv.*;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.poliza.ConsumoServicioExpedicionAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.MatcherAssert;

public class ExpedicionPolizaAutoIndividualServicioDefinition {

  @Steps GenericStep genericsStep;

  @Steps ConsumoServicioExpedicionAutoStep consumoServicioExpedicionAutoStep;

  @Cuando(
      "^Se genere una expedición por servicio de una (.*) individual con (.*) días faltantes para el vencimiento$")
  public void expedicionPolizaAutosIndividual(String tipoPoliza, int diasFaltantesVencimiento)
      throws IOException {
    ExpedicionAuto expedicionAuto =
        new ExpedicionAuto(genericsStep.getFilasModelo(EXPEDICION_AUTOS.getValor(), tipoPoliza));
    consumoServicioExpedicionAutoStep.consumirServicioExpedicion(
        expedicionAuto.getLstExpedicion(), diasFaltantesVencimiento, ConstanteGlobal.FECHA_ACTUAL);
  }

  @Entonces("^Se debe expedir la póliza correctamente$")
  public void validacionPolizaExpedidaPolicy() {
    String numeroJob = Serenity.sessionVariableCalled(SESION_SERV_JOB_NUMBER.getValor());
    MatcherAssert.assertThat(
        "La póliza no fue expedida", numeroJob.contains((ConstanteGlobal.VALOR_CERO)));
  }
}
