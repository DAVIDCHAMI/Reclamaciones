package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition
{

    @Steps MenuClaimsStep menuClaimsStep;

    @Cuando("^se efectue uno o varios pagos a un mismo proveedor")
    public void crearPagoMasivo()
    {
        menuClaimsStep.ingresarOpcionMenuPagoMasivo();
    }
}
