package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class BusquedaLibretaContactoPage extends GeneralPage
{
    @FindBy(id = "boundlist-2946-listEl")
    private WebElementFacade cmbTipoContacto;

    @FindBy(id = "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:NameInputSet:GlobalContactNameInputSet:Name-inputEl")
    private WebElementFacade txtNombreContacto;

    @FindBy(id = "AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search")
    private WebElementFacade btnBuscarContacto;

    public BusquedaLibretaContactoPage(WebDriver wdriver)
    {
        super(wdriver);
    }

    public void seleccionarTipoContacto(String tipoContacto)
    {
        cmbTipoContacto.waitUntilClickable().click();
        seleccionarOpcionCombobox(tipoContacto);
        realizarEsperaCarga();
    }

    public void ingresarContacto (String contacto)
    {
        txtNombreContacto.waitUntilPresent();
        txtNombreContacto.sendKeys(contacto);
    }

    public void buscarContacto()
    {
        btnBuscarContacto.waitUntilClickable();
        btnBuscarContacto.click();
    }
}


