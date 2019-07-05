package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS;

public class ProcesoBatchPage extends GeneralPage
{
    public ProcesoBatchPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(id = "QuickJump-inputEl")
    public WebElementFacade txtBuscarClaim;

    @FindBy(id = "BatchProcessInfo:BatchProcessScreen:BatchProcessesLV"
    )
    private WebElementFacade lblNombreProcesoBatch;

    public void ejecutarProcesoBatch() {
        String LETRA_T = "T";
        String comando = Keys.chord(Keys.ALT, Keys.SHIFT, LETRA_T);
        txtBuscarClaim.sendKeys(comando);
        realizarEsperaCarga();
    }

    public void buscarProcesoBatch() {
        List<String> nombreBatches = new ArrayList<String>();
        final String NOMBRE_BATCH = "Proceso por lotes";
        List<WebElement> elementoEncontrado =
                obtenerElementoTablaDatoDesconocido(
                        lblNombreProcesoBatch, NOMBRE_BATCH, Integer.parseInt(POSICION_FILA.getValor()));
        int tamanoLista = elementoEncontrado.size();
        //Serenity.setSessionVariable(SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS.getValor()).to(tamanoLista);

        for (int i = 0; i <= tamanoLista - 1; i++)
        {

            nombreBatches.add(i, elementoEncontrado.get(i).getText());
        }
    }
}
