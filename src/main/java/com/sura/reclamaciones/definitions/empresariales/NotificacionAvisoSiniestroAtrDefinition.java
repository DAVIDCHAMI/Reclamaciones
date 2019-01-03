package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.definitions.SetupStory;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.login.LoginClaimStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAtrDefinition {

  @Steps NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;

  @Steps GenericStep genericStep;

  @Steps LoginClaimStep loginClaimStep;

  @Steps SetupStory setupStory;

  @Dado("^que tenemos una póliza de (.*)$")
  public void diligenciarInformacionAsegurado(String cobertura) throws IOException {
    Persona aseguradoAtr =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, cobertura));
    nuevaReclamacionAtrEmpresarialStep.accederAvisoAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionAsegurado(
        aseguradoAtr.getLstPersona());
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretensión de (.*)$")
  public void diligenciarInformacionSiniestro(String causaSiniestro, String valorPretension)
      throws Throwable {
    ReclamacionEmpresarial informacionSiniestro =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(ReclamacionConstante.RECLAMACION_EMPRESARIAL, "ATR"));
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionReclamacion(
        causaSiniestro, informacionSiniestro.getLstReclamo());
    nuevaReclamacionAtrEmpresarialStep.consultarPolizaAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarValorPretension(valorPretension);
  }

  @Entonces("^se obtiene una reclamación que podrá ser consultada en ClaimCenter$")
  public void consultarSiniestro() throws IOException {
    String numeroReclamacion = nuevaReclamacionAtrEmpresarialStep.verificarSiniestroAtr();
    setupStory.seleccionarAmbienteEmpresarial();
    //loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_EMPRESARIAL);
    nuevaReclamacionAtrEmpresarialStep.consultarReclamo(numeroReclamacion);
  }
}
