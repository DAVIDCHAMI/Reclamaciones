package com.sura.reclamaciones.definitions.empresariales.creacionreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.*;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.definitions.comunes.SeleccionAmbiente;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.guidewire.claimscenter.GenericStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAtrDefinition {

  @Steps NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;

  @Steps GenericStep genericStep;

  @Steps SeleccionAmbiente seleccionAmbiente;

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
  public void diligenciarInformacionSiniestro(String causaSiniestro, String valorPretension)
      throws IOException {
    ReclamacionEmpresarial informacionSiniestro =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(
                ReclamacionConstante.RECLAMACION_EMPRESARIAL, ReclamacionConstante.ATR));
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionReclamacion(
        causaSiniestro, informacionSiniestro.getLstReclamo());
    nuevaReclamacionAtrEmpresarialStep.consultarPolizaAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarValorPretension(valorPretension);
  }

  @Entonces("^se obtiene una reclamación que podrá ser consultada en ClaimCenter$")
  public void consultarSiniestro() throws IOException {
    String numeroReclamacion = nuevaReclamacionAtrEmpresarialStep.verificarSiniestroCreadoAtr();
    seleccionAmbiente.seleccionarAmbienteEmpresarial();
    nuevaReclamacionAtrEmpresarialStep.consultarSiniestro(numeroReclamacion);
  }
}
