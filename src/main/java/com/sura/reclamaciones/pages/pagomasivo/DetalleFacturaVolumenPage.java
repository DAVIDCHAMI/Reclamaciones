package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleFacturaVolumenPage extends GeneralPage
{
  @FindBy(id = "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:PayeeMenuIcon")
  private WebElementFacade btnBuscarBeneficiario;

  @FindBy(id = "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:MenuItem_Search-textEl")
  private WebElementFacade btnBuscarBeneficiarioPago;

  @FindBy(id = "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:PaymentMethodInputSet:PaymentMethod_option0-boxLabelEl")
  private WebElementFacade rbtMetodoPagoUno;

  @FindBy(id = "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:PaymentMethodInputSet:PaymentMethod_option1-boxLabelEl")
  private WebElementFacade rbtMetodoPagoDos;

  public DetalleFacturaVolumenPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void buscarBeneficiario ()
  {
    btnBuscarBeneficiario.waitUntilClickable();
    btnBuscarBeneficiario.click();
  }

  public void buscarBeneficiarioPago ()
  {
    btnBuscarBeneficiarioPago.waitUntilPresent();
    btnBuscarBeneficiarioPago.click();
  }

  public void seleccionarMetodoPago (String metodoPago)
  {
    String metodoPagoUno = rbtMetodoPagoUno.waitUntilPresent().getText();
    String metodoPagoDos = rbtMetodoPagoDos.waitUntilPresent().getText();

    if (metodoPagoUno.equals(metodoPago))
    {
      rbtMetodoPagoUno.click();
    }
    else
      if(metodoPagoDos.equals(metodoPago))
      {
        rbtMetodoPagoDos.click();
      }
  }



}


