package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.DetalleFacturaVolumenPage;
import org.fluentlenium.core.annotation.Page;

public class DetalleFacturaVolumenStep
{
    @Page DetalleFacturaVolumenPage detalleFacturaVolumenPage;

    public void consultarBeneficiarioPago()
    {
        detalleFacturaVolumenPage.consultarBeneficiarioPago();
        detalleFacturaVolumenPage.consultarProveedorPago();
    }


}
