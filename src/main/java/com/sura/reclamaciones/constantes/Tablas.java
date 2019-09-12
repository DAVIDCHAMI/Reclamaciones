package com.sura.reclamaciones.constantes;

public enum Tablas {
  CABECERAS_CC(
      ".//div[contains(@id,'rowcheckcolumn') or contains(@class,'g-header-sort') or contains(@class,'x-column-header-first') or contains(@class,'x-column-header-inner x-column-header-inner-empty')or contains(@class,'x-column-header-inner')]//span"),
  REGISTROS_CC(
      ".//div[contains(@class,'x-grid-body')]//table/tbody/tr[contains(@class,'x-grid-data-row')]"),
  REGISTROS_PAGOS_CC(
      ".//div[contains(@class,'x-grid-body')]//table/tbody[contains(@id, 'gridview')]"),

  PIE_PC_BC(".//table/tfoot/tr");

  private String xpath;

  Tablas(String xpath) {
    this.xpath = xpath;
  }

  public String getXpath() {
    return xpath;
  }
}
