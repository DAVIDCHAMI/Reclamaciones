package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;

public class MenuClaimsStep {

    @Page
    GeneralPage generalPage;

    @Page
    MenuClaimPage menuClaimPage;

        public void consultarNumeroReclamacion(String numReclamacion) {
        menuClaimPage.buscarReclamacion(MenuConstante.RECLAMACION_MENU, numReclamacion);
    }
}
