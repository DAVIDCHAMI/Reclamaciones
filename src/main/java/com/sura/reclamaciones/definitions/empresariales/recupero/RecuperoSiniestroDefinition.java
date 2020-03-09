package com.sura.reclamaciones.definitions.empresariales.recupero;

import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.guidewire.claimscenter.GenericStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition {

  @Steps RecuperoStep recuperoStep;

  @Steps GenericStep genericStep;

  Recupero recupero;

  @Cuando("^se genere un recupero con un código de retención (.*)$")
  public void diligenciarRecupero(String codigoRetencion) throws IOException {
    recupero =
        new Recupero(
            genericStep.getFilasModelo(
                RECUPERO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor())));
    recuperoStep.seleccionarNumeroReclamacion();
    recuperoStep.diligenciarCreacionRecupero(recupero.getLstRecupero(), codigoRetencion);
  }

  @Entonces("^se obtiene un reintegro de dinero al siniestro$")
  public void verificarRecupero() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}
