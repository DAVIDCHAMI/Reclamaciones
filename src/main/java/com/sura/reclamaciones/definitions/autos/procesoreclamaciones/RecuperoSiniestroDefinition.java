package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition {

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps RecuperoStep recuperoStep;

  @Steps GenericStep genericStep;

  Recupero recupero;


  @Cuando(
      "^se cree el recupero por el tipo de (.*) con un código de retención (.*) a una cobertura (.*)$")
  public void crearRecuperoReclamacionAutos(
      String tipoRecupero, String codigoRetencion, String cobertura) throws IOException {
    recupero = new Recupero((genericStep.getFilasModelo(RECUPERO_SINIESTRO.getValor(), cobertura)));
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un ingreso de dinero sobre el siniestro$")
  public void verificarRecuperoAutos() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}
