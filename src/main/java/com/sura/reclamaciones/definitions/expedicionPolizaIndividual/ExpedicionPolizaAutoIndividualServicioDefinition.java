package com.sura.reclamaciones.definitions.expedicionPolizaIndividual;

import static com.sura.reclamaciones.utils.EnumVariablesSesion.SESION_SERV_JOB_NUMBER;

import com.sura.reclamaciones.constantes.NombresCsv;
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

  ExpedicionAuto expedicionAuto;

  @Cuando("^Se genere una expedición por servicio de una póliza de auto individual$")
  public void expedicionPolizaAutosIndividual() throws IOException {
    expedicionAuto =
        new ExpedicionAuto(genericsStep.getFilasModelo(NombresCsv.POLIZA, "cotizadorAutos"));
    consumoServicioExpedicionAutoStep.consumirServicioExpedicion(
        expedicionAuto.getLstExpedicion(), 0, "fechaActual");
  }

  @Entonces("^Se debe expedir la póliza correctamente$")
  public void validacionPolizaExpedidaPolicy() {
    String numeroJob = Serenity.sessionVariableCalled(SESION_SERV_JOB_NUMBER.getValor());
    MatcherAssert.assertThat("La póliza no fue expedida", numeroJob.contains("0"));
  }
}
