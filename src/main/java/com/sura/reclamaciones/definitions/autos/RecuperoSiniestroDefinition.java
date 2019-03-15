package com.sura.reclamaciones.definitions.autos;

import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_PRODUCTO_AUTOS;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition
{
    @Steps RecuperoStep recuperoStep;

    @Steps GenericStep genericStep;

    Recupero recupero;

    @Cuando("^se cree el recupero por el tipo de (.*) con un código de retención (.*)$")
    public void crearRecuperoAutos(String tipoRecupero, String codigoRetencion) throws Exception
    {
        recupero =
                new Recupero(
                        genericStep.getFilasModelo(
                                RECUPERO_SINIESTRO.getValor(),
                                Serenity.sessionVariableCalled(SESION_CC_PRODUCTO_AUTOS.getValor())));
        recuperoStep.seleccionarRecupero();
        recuperoStep.diligenciarCreacionRecupero(recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
    }

    @Entonces("^se obtiene un ingreso de dinero sobre el siniestro$")
    public void verificarRecuperoAutos()
    {
        recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
    }

/*
    @Cuando("^se genere un recupero de tipo (.*) con un código de retención (.*)$")
    public void diligenciarRecupero(String tipoRecupero, String codigoRetencion) throws IOException {
        recupero =
                new Recupero(
                        genericStep.getFilasModelo(
                                RECUPERO_SINIESTRO.getValor(),
                                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor())));
        recuperoStep.seleccionarNumeroReclamacion();
        recuperoStep.seleccionarRecupero();
        recuperoStep.diligenciarCreacionRecupero(
                recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
    }

    @Entonces("^se obtiene un reintegro de dinero al siniestro$")
    public void verificarRecupero() {
        recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
    }
    */
}
