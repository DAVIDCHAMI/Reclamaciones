package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleFacturaVolumenPage extends GeneralPage {
  @FindBy(
    id =
        "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:PayeeMenuIcon"
  )
  private WebElementFacade btnBuscarBeneficiarioPago;

  @FindBy(
    id =
        "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:MenuItem_Search-itemEl"
  )
  private WebElementFacade cmbBuscar;

  public DetalleFacturaVolumenPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void consultarBeneficiarioPago() {
    btnBuscarBeneficiarioPago.waitUntilClickable();
    btnBuscarBeneficiarioPago.click();
  }

  public void consultarProveedorPago() {
    cmbBuscar.waitUntilClickable();
    cmbBuscar.click();
  }
}
