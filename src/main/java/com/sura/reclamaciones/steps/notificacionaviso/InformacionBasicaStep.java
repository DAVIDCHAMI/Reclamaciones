package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class InformacionBasicaStep {

    @Page
    InformacionBasicaPage informacionBasicaPage;

    public void diligenciarInformacionPersonal(List<ReclamacionEmpresarial> datosAutor) {
        datosAutor.forEach(
                autor -> {
                    informacionBasicaPage.seleccionarAutorReporte();
                    informacionBasicaPage.escribirDetalleHechos(autor.getDetalleHechos());
                });
    }
}
