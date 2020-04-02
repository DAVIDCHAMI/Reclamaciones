package com.sura.reclamaciones.pages.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.enums.Tablas;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreacionServicioPage extends GeneralPage {

  @FindBy(id = "OtherServiceRequestPopup:NewServiceRequestDV:concesionarios")
  private WebElementFacade tblProveedores;

  public CreacionServicioPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarProveedor(String nombreProveedor) {
    WebElement btnSeleccionar =
        obtenerElementoLista(
            tblProveedores, Tablas.CABECERAS_CC, Tablas.REGISTROS_CC, nombreProveedor, "");
    btnSeleccionar.findElement(By.tagName("a")).click();
    realizarEsperaCarga();
  }
}
