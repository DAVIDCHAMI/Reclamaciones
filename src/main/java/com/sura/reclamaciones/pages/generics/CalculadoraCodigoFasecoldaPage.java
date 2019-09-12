package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.models.CodigoFasecolda;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CalculadoraCodigoFasecoldaPage extends GeneralPage {

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_VehicleType-inputEl")
    private WebElementFacade cmbClaseVehiculo;

    @FindBy(xpath = "//ul[@class='x-list-plain']")
    private WebElementFacade lstClaseVehiculo;

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Year-inputEl")
    private WebElementFacade cmbModelo;

    @FindBy(xpath = "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box x-boundlist-above']//ul")
    private WebElementFacade lstModelo;

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Make-inputEl")
    private WebElementFacade cmbMarca;

    @FindBy(xpath = "//ul[@class='x-list-plain']")
    private WebElementFacade lstMarca;

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Model-inputEl")
    private WebElementFacade cmbLinea;

    @FindBy(xpath = "//ul[@class='x-list-plain']")
    private WebElementFacade lstLinea;

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:ClaimPolicyGeneral_CancelPolicy")
    private WebElementFacade btnValidarCodigoFasecolda;

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Update")
    private WebElementFacade btnAceptar;

    public CalculadoraCodigoFasecoldaPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void seleccionarClaseVehiculo(String claseVehiculo) {
        cmbClaseVehiculo.click();
        lstClaseVehiculo
                .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + claseVehiculo + "')]"))
                .click();
    }

    public void seleccionarModeloVehiculo(String modeloVehiculo) {
  /*  cmbModelo.clear();
    cmbModelo.sendKeys(modeloVehiculo);*/
        cmbModelo.click();
        lstModelo.findElement(By.xpath("//li[contains(.," + modeloVehiculo + ")]")).click();
        //.findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + modeloVehiculo + "')]")).click();
    }

    public void seleccionarMarcaVehiculo(String marcaVehiculo) {
        cmbModelo.click();
        lstMarca.findElement(org.openqa.selenium.By.xpath("//li[contains(.,'" + marcaVehiculo + "')]")).click();
    }

    public void seleccionarLineaVehiculo(String lineaVehiculo) {
        cmbLinea.click();
        lstLinea.findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + lineaVehiculo + "')]")).click();
    }

    public void generarCodigoFasecolda() {
        btnValidarCodigoFasecolda.waitUntilClickable();
        btnValidarCodigoFasecolda.click();
        realizarEsperaCarga();
    }
}
