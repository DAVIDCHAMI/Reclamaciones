package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static com.sura.reclamaciones.constantes.Constantes.POSICION_FILA;

public class ProcesoBatchPage extends GeneralPage
{

    public ProcesoBatchPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(id = "QuickJump-inputEl")
    public WebElementFacade txtBuscarClaim;

    @FindBy(id = "BatchProcessInfo:BatchProcessScreen:BatchProcessesLV"
    )
    private WebElementFacade tblNombreProcesoBatch;

    @FindBy(id = "ServerTools:InternalToolsMenuActions")
    public WebElementFacade mnuAcciones;

    public void ejecutarBatch() {
        String LETRA_T = "T";
        String comando = Keys.chord(Keys.ALT, Keys.SHIFT, LETRA_T);
        txtBuscarClaim.sendKeys(comando);
        realizarEsperaCarga();
    }

    public void ejecutarProcesoBatch(String nombreProcesoBatch) {
        List<String> nombresProcesoBatch = new ArrayList<String>();
        final String NOMBRE_BATCH = "Proceso por lotes";
        List<WebElement> elementoEncontrado =
                obtenerElementoTablaDatoDesconocido(
                        tblNombreProcesoBatch, NOMBRE_BATCH, Integer.parseInt(POSICION_FILA.getValor()));
        int tamanoLista = elementoEncontrado.size();
        for (int i = 0; i <= tamanoLista - 1; i++)
        {
            nombresProcesoBatch.add(i, elementoEncontrado.get(i).getText());
            if (nombresProcesoBatch.get(i).equals(nombreProcesoBatch)) {
                tblNombreProcesoBatch.waitUntilPresent();
                tblNombreProcesoBatch.findBy("//tr[@data-recordindex='" + i + "']//a")
                        .click();
                realizarEsperaCarga();
                break;
            }
        }
    }

    public void seleccionarOpcionMenuAccion()
    {
        mnuAcciones.waitUntilPresent();
        mnuAcciones.click();
    }



}
