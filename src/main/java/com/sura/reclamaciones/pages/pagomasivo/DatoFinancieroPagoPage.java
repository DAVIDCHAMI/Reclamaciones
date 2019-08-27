package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CANTIDAD_PAGO_INDIVIDUAL;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_PAGO_INDIVIDUAL;

public class DatoFinancieroPagoPage extends GeneralPage
{
    @Page DetalleFacturaVolumenPage detalleFacturaVolumenPage;

    @FindBy(xpath = ".//div[@class='x-panel x-panel-default x-grid']")
    private WebElementFacade tblPagoIndividual;

    public DatoFinancieroPagoPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void validarPagosIndividualesSiniestro() {
        List<Integer> numeroPagoIndividualMasivo = new ArrayList<Integer>();
        List<Integer> numeroPagoIndividualSiniestro = new ArrayList<Integer>();
        final String RESULTADO_PAGO_INDIVIDUAL = "Número de pago";
        List<WebElement> elementoEncontrado = obtenerElementoTablaDatoDesconocido(tblPagoIndividual, RESULTADO_PAGO_INDIVIDUAL, Integer.parseInt(POSICION_FILA.getValor()));
        int contadorPagoIndividual = Integer.parseInt(Serenity.sessionVariableCalled(SESION_CC_NUMERO_PAGO_INDIVIDUAL.getValor()).toString());
        int tamanoLista = Integer.parseInt(Serenity.sessionVariableCalled(SESION_CC_CANTIDAD_PAGO_INDIVIDUAL.getValor()).toString());
        for (int i = 0; i <= elementoEncontrado.size() - 1; i++) {
            numeroPagoIndividualSiniestro.add(i, Integer.parseInt(elementoEncontrado.get(i).getText()));
        }
        Collections.sort(numeroPagoIndividualSiniestro);
        for (int i = 0; i <= tamanoLista - 1; i++) {
            numeroPagoIndividualMasivo.add(i, contadorPagoIndividual);
            contadorPagoIndividual = contadorPagoIndividual + 1;
        }
        Collections.sort(numeroPagoIndividualMasivo);
        for (int i = 0; i <= elementoEncontrado.size() - 1; i++)
        {
            MatcherAssert.assertThat(
                    "El número del pago individual generado en el pago masivo no se encuentra en la consulta de pagos del siniestro",
                    (numeroPagoIndividualSiniestro.get(i).equals(numeroPagoIndividualMasivo.get(i))));
        }
    }
}




