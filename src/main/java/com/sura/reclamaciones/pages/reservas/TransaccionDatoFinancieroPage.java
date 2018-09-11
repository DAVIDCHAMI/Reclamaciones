package com.sura.reclamaciones.pages.reservas;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class TransaccionDatoFinancieroPage extends GeneralPage {

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  WebElementFacade btnUltimaPaginaTransaccion;


  public TransaccionDatoFinancieroPage(WebDriver driver) {
    super(driver);
  }

  public void irUltimaPaginaTransaccion(){
    if (btnUltimaPaginaTransaccion.isVisible()){
      btnUltimaPaginaTransaccion.click();
      realizarEsperaCarga();
    }


  }

}
