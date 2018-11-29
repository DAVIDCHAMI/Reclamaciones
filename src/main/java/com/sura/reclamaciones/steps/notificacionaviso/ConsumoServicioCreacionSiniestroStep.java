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

  List<ReclamacionEmpresarial> lstSiniestroParam;
  List<Persona> lstParametroPersona;
  ReclamacionEmpresarial parametroSiniestro = new ReclamacionEmpresarial();
  Persona parametroPersona = new Persona();

  GenericStep genericStep = new GenericStep();

  ConsumoServicioCreacionSiniestro consumoServicioCreacionSiniestro =
      new ConsumoServicioCreacionSiniestro();

  @Step
  public void siniestrarPolizaEmpresarialAtr() {
    consumoServicioCreacionSiniestro.asignarParametrosSiniestro(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosAutor(lstParametroPersona);
    consumoServicioCreacionSiniestro.asignarParametrosValorPerdida(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosContactoPrincipal(lstParametroPersona);
    consumoServicioCreacionSiniestro.asignarParametrosDireccionPrincipal(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosTipoIncidente(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosInformacionSiniestro(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosDireccionSiniestro(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosReclamante(lstParametroPersona);
    consumoServicioCreacionSiniestro.asignarParametrosDescripcionPropiedad(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosDescripcionSiniestro(lstSiniestroParam);
    consumoServicioCreacionSiniestro.asignarParametrosLocalizacionPropiedad(lstSiniestroParam);
    consumoServicioCreacionSiniestro.crearRequest();
    consumoServicioCreacionSiniestro.obtenerResponse();
  }

  @Step
  public void asignarValoresSiniestro(String filtroSiniestroCsv) throws IOException {
    parametroSiniestro =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_SINIESTRO, filtroSiniestroCsv));
    lstSiniestroParam = parametroSiniestro.getLstReclamo();
    parametroPersona =
        new Persona(
            genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_PERSONA, filtroSiniestroCsv));
    lstParametroPersona = parametroPersona.getLstPersona();
  }

  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO);
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
