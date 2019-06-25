package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.sura.reclamaciones.constantes.Constantes.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS;

import java.util.List;

public class DetalleSiniestroPage extends GeneralPage
{
    public DetalleSiniestroPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(
            xpath =
                    ".//div[contains(@id,'ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:EditableVehicleIncidentsLV') and @class='x-panel x-panel-default x-grid']"
    )
    private WebElementFacade tblPlacasVehiculosInvolucrados;

    @FindBy(
            xpath =
                    ".//div[contains(@id,'ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:ClaimNumber-inputEl') and @class='x-form-display-field']"
    )
    private WebElementFacade lblNumeroSiniestro;

    public void consultarNumneroPlacaPartesImplicadas()
    {
        final String PLACA = "Placa";
        List<WebElement> elementoEncontrado = obtenerElementoTablaDatoDesconocido(tblPlacasVehiculosInvolucrados, PLACA, Integer.parseInt(POSICION_FILA.getValor()));
        int tamanoLista = elementoEncontrado.size();

        Serenity.setSessionVariable(SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS.getValor()).to(tamanoLista);

        for (int i=0; i <= tamanoLista-1; i++)
        {
            System.out.println(elementoEncontrado.get(i).getText());
        }
    }

    public void consultarNumeroSiniestro()
    {
        lblNumeroSiniestro.waitUntilClickable();
        lblNumeroSiniestro.getText();
    }
}
