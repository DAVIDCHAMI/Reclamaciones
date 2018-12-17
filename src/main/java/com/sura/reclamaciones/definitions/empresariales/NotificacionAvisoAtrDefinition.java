package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoAtrDefinition {

  @Steps NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;

  @Steps GenericStep genericStep;

  @Dado("^que tenemos una poliza de (.*)$")
  public void diligenciarInformacionContacto(String cobertura) throws Throwable {
    Persona aseguradoAtr =
        new Persona(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, cobertura));
    nuevaReclamacionAtrEmpresarialStep.accederAvisoEmpresa();
    nuevaReclamacionAtrEmpresarialStep.buscarAseguradoAtr(aseguradoAtr.getLstPersona());
    nuevaReclamacionAtrEmpresarialStep.diligenciarFechaAtr();
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretension de (.*)$")
  public void diligenciarInformacionSiniestro(String causaSiniestro, String valorPretension) {
    nuevaReclamacionAtrEmpresarialStep.diligenciarInformacionSiniestro(causaSiniestro, "Prueba");
    nuevaReclamacionAtrEmpresarialStep.consultarPolizaAtr();
    nuevaReclamacionAtrEmpresarialStep.diligenciarValorPretension(valorPretension);
    nuevaReclamacionAtrEmpresarialStep.verificarSiniestroAtr();
  }

  @Y("^se ajusta la reserva de la categoria de costo (.*)$")
  public void seAjustaLaReservaDeLaCategoriaDeCostoCategoriaDeCosto() {
    //To Do
  }

  @Entonces("^se obtiene una reclamacion que podrá ser consultada en ClaimCenter$")
  public void seObtieneUnaReclamacionQuePodráSerConsultadaEnClaimCenter() {
    //To Do
  }
}
