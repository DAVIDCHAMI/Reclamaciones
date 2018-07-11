package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CrearServicioPage extends GeneralPage {

    public CrearServicioPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(id = "OtherServiceRequestPopup:NewServiceRequestDV:btnSearchProvider-btnInnerEl")
    private WebElementFacade btnBuscarProveedor;

    
}
