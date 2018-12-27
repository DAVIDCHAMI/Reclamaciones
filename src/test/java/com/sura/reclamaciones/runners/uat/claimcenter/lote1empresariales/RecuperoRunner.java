package com.sura.reclamaciones.runners.uat.claimcenter.lote1empresariales;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = //{"src/test/resources/features/notificacionaviso/notificaraviso.feature"},
        "src/test/resources/features/recupero/recupero.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class RecuperoRunner {}
