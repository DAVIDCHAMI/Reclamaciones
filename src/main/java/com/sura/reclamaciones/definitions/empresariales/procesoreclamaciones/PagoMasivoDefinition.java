package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import com.sura.reclamaciones.steps.pagomasivo.FacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoXlsStep;

import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition
{
    @Steps MenuClaimsStep menuClaimsStep;

    @Steps FacturaVolumenStep facturaVolumenStep;

    @Steps CargaArchivoXlsStep cargarArchivoXlsStep;

    @Cuando("^se efectue uno o varios pagos a un mismo proveedor")
    public void crearPagoMasivo()
    {
        menuClaimsStep.ingresarOpcionMenuPagoMasivo(MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
        facturaVolumenStep.generarFacturacionMasiva();
        cargarArchivoXlsStep.seleccionarArchivoXls();
    }
}
