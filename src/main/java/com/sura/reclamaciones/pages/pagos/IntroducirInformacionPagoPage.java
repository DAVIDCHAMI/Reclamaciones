package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class IntroducirInformacionPagoPage  extends GeneralPage {

    public IntroducirInformacionPagoPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:ReserveLineInputSet:ReserveLine-inputEl']")
    private WebElementFacade cmbLineaReserva;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Payment_PaymentType-inputEl']")
    private WebElementFacade cmbTipoPago;

    @FindBy(xpath = "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Transaction_AvailableReserves-inputEl']")
    private WebElementFacade txtValorReserva;


    public void seleccionarLineaReserva(String strLineaReserva) {
        strLineaReserva  = "linea reserva";
        cmbLineaReserva.selectByValue(strLineaReserva);
    }


    public void seleccionarTipoPago(String strTipoPago) {
        strTipoPago  = "parcial";
        cmbTipoPago.selectByValue(strTipoPago);
        if (strTipoPago=="parcial"){

            

        }
        else {

        }
    }

    public void obtenerValorPagoReserva (){
        String strValorReserva;
        strValorReserva = txtValorReserva.getTextValue();
    }



}
