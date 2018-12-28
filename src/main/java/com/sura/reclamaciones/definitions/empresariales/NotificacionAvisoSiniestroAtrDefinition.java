package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.models.Persona;
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

  @Dado("^que tenemos una poliza de (.*)$")
  public void diligenciarInformacionAsegurado(String cobertura) throws IOException {
    Persona aseguradoAtr =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, cobertura));
    nuevaReclamacionAtrEmpresarialStep.accederAvisoAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionAsegurado(
        aseguradoAtr.getLstPersona());
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretension de (.*)$")
  public void diligenciarInformacionSiniestro(String causaSiniestro, String valorPretension) {
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionReclamacion(causaSiniestro, "prueba");
    nuevaReclamacionAtrEmpresarialStep.consultarPolizaAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarValorPretension(valorPretension);
  }

  @Entonces("^se obtiene una reclamacion que podrá ser consultada en ClaimCenter$")
  public void consultarSiniestro() {
    nuevaReclamacionAtrEmpresarialStep.verificarSiniestroAtr();
    //To Do
  }
}
