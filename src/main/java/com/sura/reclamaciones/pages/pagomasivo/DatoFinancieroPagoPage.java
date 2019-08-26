package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;

public class DatoFinancieroPagoPage extends GeneralPage
{
    @Page DetalleFacturaVolumenPage detalleFacturaVolumenPage;



    public DatoFinancieroPagoPage(WebDriver wdriver) {
        super(wdriver);
    }


}




