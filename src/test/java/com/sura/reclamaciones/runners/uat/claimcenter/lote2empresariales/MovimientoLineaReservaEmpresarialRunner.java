package com.sura.reclamaciones.runners.uat.claimcenter.lote2empresariales;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/reservas/movimiento_linea_reserva_empresarial.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class MovimientoLineaReservaEmpresarialRunner {}
