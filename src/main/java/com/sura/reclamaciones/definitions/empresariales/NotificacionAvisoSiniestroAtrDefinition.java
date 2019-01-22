package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.NombresCsv.*;

import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAtrDefinition {

  @Steps NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;

  @Steps GenericStep genericStep;

  @Dado("^que tenemos una póliza de (.*)$")
  public void diligenciarInformacionAsegurado(String cobertura) throws IOException {
    PersonaReclamacion aseguradoAtr =
        new PersonaReclamacion(
            genericStep.getFilasModelo(PARAMETROS_PERSONA.getValor(), cobertura));
    nuevaReclamacionAtrEmpresarialStep.accederAvisoAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionAsegurado(
        aseguradoAtr.getLstPersonaReclamacion());
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretensión de (.*)$")
  public void diligenciarInformacionSiniestro(String causaSiniestro, String valorPretension) {
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionReclamacion(causaSiniestro, "prueba");
    nuevaReclamacionAtrEmpresarialStep.consultarPolizaAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarValorPretension(valorPretension);
  }

  @Entonces("^se obtiene una reclamación que podrá ser consultada en ClaimCenter$")
  public void consultarSiniestro() {
    nuevaReclamacionAtrEmpresarialStep.verificarSiniestroAtr();
    //To Do
  }
}
