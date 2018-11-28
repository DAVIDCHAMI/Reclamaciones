package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionSiniestroStep {

  List<ReclamacionEmpresarial> lstParametroDescription;
  List<ReclamacionEmpresarial> lstParametroIsPolicyProperty;
  List<ReclamacionEmpresarial> lstParametroPropertyDesc;
  List<ReclamacionEmpresarial> lstSiniestroParam;
  List<ReclamacionEmpresarial> lstParametroLossEstimate;
  List<ReclamacionEmpresarial> lstParametroProperty;
  List<ReclamacionEmpresarial> lstParametroPrimaryAddress;
  List<ReclamacionEmpresarial> lstParametroLossLocation;
  List<ReclamacionEmpresarial> lstParametroCPLine;
  List<Persona> lstParametroAuthor;
  List<Persona> lstParametroMainContact;
  List<Persona> lstParametroClaimAnt;
  ReclamacionEmpresarial parametroSiniestro = new ReclamacionEmpresarial();
  Persona parametroPersona = new Persona();

  GenericStep genericStep = new GenericStep();

  ConsumoServicioCreacionSiniestro consumoServicioCreacionSiniestro =
      new ConsumoServicioCreacionSiniestro();

  @Step
  public void siniestrarPolizaEmpresarialAtr()
  {
    consumoServicioCreacionSiniestro.asignarParametrosSiniestro(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosAutor(lstParametroAuthor);
    consumoServicioCreacionSiniestro.asignarParametrosValorPerdida(lstParametroLossEstimate);
    consumoServicioCreacionSiniestro.asignarParametrosContactoPrincipal(lstParametroMainContact);
    consumoServicioCreacionSiniestro.asignarParametrosDireccionPrincipal(lstParametroPrimaryAddress);
    consumoServicioCreacionSiniestro.asignarParametrosTipoIncidente(lstParametroCPLine);
    consumoServicioCreacionSiniestro.asignarParametrosInformacionSiniestro(lstParametroDescription,lstParametroIsPolicyProperty);
    consumoServicioCreacionSiniestro.asignarParametrosDireccionSiniestro(lstParametroProperty);

  }
  //lstParametroLossEstimate,
  //lstParametroProperty,
  //lstParametroPrimaryAddress,
  //lstParametroLossLocation,
  //lstParametroCPLine,
  //lstParametroDescription,
  //lstParametroIsPolicyProperty,
  //lstParametroPropertyDesc,
  //lstParametroAuthor,
  //lstParametroMainContact,
  //lstParametroClaimAnt
  @Step
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

  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO);
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
