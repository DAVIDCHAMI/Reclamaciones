package com.sura.reclamaciones.pages.reservas;

import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.constantes.ReservaConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class TransaccionDatoFinancieroPage extends GeneralPage {


  public TransaccionDatoFinancieroPage(WebDriver driver) {
    super(driver);
  }

  public void verificarRe(){
  verificarBotonUltimaPaginaVisible();
  realizarEsperaCarga();
    String fecha = obtenerNumeroTransaccion(ReservaConstante.FECHA);
    realizarEsperaCarga();
  }

}
