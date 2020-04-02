package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_PERSONA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_SINIESTRO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestro;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.GenericStep;
import com.sura.reclamaciones.utils.constantes.ReclamacionConstante;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionSiniestroStep {

  List<ReclamacionEmpresarial> lstSiniestroParam;
  List<PersonaReclamacion> lstParametroPersona;
  ReclamacionEmpresarial parametroSiniestro = new ReclamacionEmpresarial();
  PersonaReclamacion parametroPersona;

  GenericStep genericStep = new GenericStep();

  ConsumoServicioCreacionSiniestro consumoServicioCreacionSiniestro =
      new ConsumoServicioCreacionSiniestro();

  @Step
  public void siniestrarPolizaEmpresarialAtr() {
    consumoServicioCreacionSiniestro.asignarParametrosRequest(
        lstSiniestroParam, lstParametroPersona);
  }

  @Step
  public void asignarValoresSiniestro(String filtroSiniestroCsv) throws IOException {
    parametroSiniestro =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(PARAMETROS_SINIESTRO.getValor(), filtroSiniestroCsv));
    lstSiniestroParam = parametroSiniestro.getLstReclamo();
    parametroPersona =
        new PersonaReclamacion(
            genericStep.getFilasModelo(PARAMETROS_PERSONA.getValor(), filtroSiniestroCsv));
    lstParametroPersona = parametroPersona.getLstPersonaReclamacion();
  }

  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor());
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
