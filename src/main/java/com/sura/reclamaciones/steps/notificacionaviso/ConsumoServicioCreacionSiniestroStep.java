package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
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
            genericStep.getFilasModelo(NombresCsv.PARAMETROS_SINIESTRO, filtroSiniestroCsv));
    lstSiniestroParam = parametroSiniestro.getLstReclamo();
    parametroPersona =
        new PersonaReclamacion(
            genericStep.getFilasModelo(NombresCsv.PARAMETROS_PERSONA, filtroSiniestroCsv));
    lstParametroPersona = parametroPersona.getLstPersonaReclamacion();
  }

  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO);
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
