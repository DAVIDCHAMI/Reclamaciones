package com.sura.reclamaciones.definitions.autos.recuperos;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.NombresCsv.RECUPERO_SINIESTRO;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition {

  @Steps RecuperoStep recuperoStep;

  Recupero recupero;

  @Cuando("^se cree el recupero con un código de retención (.*) a una cobertura (.*)$")
  public void crearRecuperoReclamacionAutos(String codigoRetencion, String cobertura)
      throws IOException {
    recupero = new Recupero((obtenerDatosPrueba(RECUPERO_SINIESTRO.getValor(), cobertura)));
    recuperoStep.diligenciarCreacionRecupero(recupero.getLstRecupero(), codigoRetencion);
  }

  @Entonces("^se obtiene un ingreso de dinero sobre el siniestro$")
  public void verificarRecuperoAutos() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}
