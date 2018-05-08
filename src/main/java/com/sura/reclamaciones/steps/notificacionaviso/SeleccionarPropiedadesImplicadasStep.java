package com.sura.reclamaciones.steps.notificacionaviso;


import com.sura.reclamaciones.pages.notificacionaviso.SeleccionarPropiedadesImplicadasPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SeleccionarPropiedadesImplicadasStep {

    @Page
    SeleccionarPropiedadesImplicadasPage SeleccionarPropiedadesImplicadasPage;

    @Step
    public void seleccionarPropiedadImplicada(){
        SeleccionarPropiedadesImplicadasPage.seleccionarPropiedad();
    }
}
