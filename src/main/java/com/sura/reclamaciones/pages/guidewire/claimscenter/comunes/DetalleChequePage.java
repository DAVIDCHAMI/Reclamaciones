package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.ITERACIONES_ANULACION;

import com.sura.reclamaciones.pages.general.GeneralPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetalleChequePage extends GeneralPage {

  private Boolean response = true;

  public DetalleChequePage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean realizarAnulacionCheque() {
    int contador = 0;
    while (btnAnular.containsElements(
        By.xpath(
            "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//ancestor::a[contains(@class,'disabled')]"))) {
      realizarEsperaCarga();
      driver.navigate().refresh();
      if (contador >= Integer.parseInt(ITERACIONES_ANULACION.getValor())) {
        response = false;
        break;
      }
      contador++;
    }
    anularTransaccion();
    return response;
  }
}
