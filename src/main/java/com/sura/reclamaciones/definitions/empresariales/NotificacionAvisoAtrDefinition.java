package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoAtrDefinition {

  @Steps
  NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;

    @Dado("^que tenemos una poliza de (.*)$")
    public void NotificacionAvisoAtrDefinition(String cobertura) {
      nuevaReclamacionAtrEmpresarialStep.accederAvisoEmpresa();
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretension de (.*)$")
  public void seGenereUnSiniestroPorCausaCausaConUnValorDePretensionDeValorDePretensión(){


  }

  @Y("^se ajusta la reserva de la categoria de costo (.*)$")
  public void seAjustaLaReservaDeLaCategoriaDeCostoCategoriaDeCosto()  {


  }

  @Entonces("^se obtiene una reclamacion que podrá ser consultada en ClaimCenter$")
  public void seObtieneUnaReclamacionQuePodráSerConsultadaEnClaimCenter()  {


  }
}
