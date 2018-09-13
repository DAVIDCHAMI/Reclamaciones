package com.sura.reclamaciones.pages.anulacionpago;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class DetallePagoPage extends GeneralPage {

    @FindBy(xpath ="//span[@id='ClaimFinancialsChecksDetail:ClaimFinancialsChecksDetailScreen:ClaimFinancialsChecksDetail_VoidStopButton-btnInnerEl']")
    private WebElementFacade btnAnularDetener;

    @FindBy(xpath = "//span[@id='VoidStopCheck:VoidStopCheckScreen:VoidStopCheck_VoidButton-btnInnerEl']")
    private WebElementFacade btnAnularCheque;

    @FindBy(xpath = "//div[@class='x-window x-message-box x-layer x-window-default x-closable x-window-closable x-window-default-closable x-border-box']//div//span[@class='x-btn-inner x-btn-inner-center'][contains(text(),'Aceptar')]")
    private WebElementFacade btnAceptar;

    public DetallePagoPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void realizarAnulacionPago() {
        if (btnAnularDetener.isSelected()){
            btnAnularDetener.click();
            btnAnularCheque.waitUntilClickable();
            btnAnularCheque.click();
            btnAceptar.waitUntilClickable();
            btnAceptar.click();
        }
        else {
            LOGGER.info("El boton de anulación no se encuentra activo");
            System.exit(1);
        }
                }

    public void ingresarAnulacionPago(String strNumeroPago) {

        List<WebElement> lstPago = obtenerFilaTabla(PagoConstante.PAGOS_RECUPEROS, strNumeroPago);
        for (WebElement aLstPago : lstPago) {
            if (aLstPago.getText().equals(strNumeroPago)) {
                aLstPago.click();
                aLstPago.findElement(By.xpath("//a[@class='g-actionable']")).click();
                break;
            }
        }
    }
}
