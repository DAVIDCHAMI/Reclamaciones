package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class InformacionReclamacionStep {
    @Page
    InformacionReclamacionPage InformacionReclamacionPage;

    @Step
    public void informacionIncidente(List<ReclamacionEmpresariales> datosIncidente) {
        datosIncidente.forEach(
                Incidente -> {
                    InformacionReclamacionPage.cerrarReclamosDuplicados();
                   InformacionReclamacionPage.seleccionarCausaSiniestro(Incidente.getCausaDelSiniestro());
                   InformacionReclamacionPage.escribirValorPretension(Incidente.getValorPretension());
                   InformacionReclamacionPage.seleccionarTipoIncidente(Incidente.getTipoIncidente());
                   InformacionReclamacionPage.finalizarSiniestro();
                });
    }
}

