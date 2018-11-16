package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class ConsumoServicioCreacionSiniestroStep {

  List<ReclamacionEmpresarial>
      lstParametroDescription,
      lstParametroIsPolicyProperty,
      lstParametroPropertyDesc,
      lstSiniestroParam,
      lstParametroLossEstimate,
      lstParametroProperty,
      lstParametroPrimaryAddress,
      lstParametroLossLocation,
      lstParametroCPLine;
  List<Persona> lstParametroAuthor, lstParametroMainContact, lstParametroClaimAnt;
  ReclamacionEmpresarial parametroSiniestro = new ReclamacionEmpresarial();
  Persona parametroPersona = new Persona();

  @Steps GenericStep genericStep = new GenericStep();

  @Page
  ConsumoServicioCreacionSiniestro consumoServicioCreacionSiniestro =
      new ConsumoServicioCreacionSiniestro();

  @Step
  public void siniestrarPolizaEmpresarialAtr() {
    consumoServicioCreacionSiniestro.siniestrarPoliza(
        lstSiniestroParam,
        lstParametroLossEstimate,
        lstParametroProperty,
        lstParametroPrimaryAddress,
        lstParametroLossLocation,
        lstParametroCPLine,
        lstParametroDescription,
        lstParametroIsPolicyProperty,
        lstParametroPropertyDesc,
        lstParametroAuthor,
        lstParametroMainContact,
        lstParametroClaimAnt);
  }

  public void asignarValoresSiniestro(String filtroSiniestroCsv) throws IOException {
    parametroSiniestro =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_SINIESTRO, filtroSiniestroCsv));
    lstSiniestroParam = parametroSiniestro.getLstReclamo();
    lstParametroLossEstimate = parametroSiniestro.getLstReclamo();
    lstParametroProperty = parametroSiniestro.getLstReclamo();
    lstParametroPrimaryAddress = parametroSiniestro.getLstReclamo();
    lstParametroLossLocation = parametroSiniestro.getLstReclamo();
    lstParametroCPLine = parametroSiniestro.getLstReclamo();
    lstParametroDescription = parametroSiniestro.getLstReclamo();
    lstParametroIsPolicyProperty = parametroSiniestro.getLstReclamo();
    lstParametroPropertyDesc = parametroSiniestro.getLstReclamo();
    parametroPersona =
        new Persona(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, filtroSiniestroCsv));
    lstParametroAuthor = parametroPersona.getLstPersona();
    lstParametroMainContact = parametroPersona.getLstPersona();
    lstParametroClaimAnt = parametroPersona.getLstPersona();
  }
}
