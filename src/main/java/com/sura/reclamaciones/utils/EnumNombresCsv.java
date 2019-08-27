package com.sura.reclamaciones.utils;

public enum EnumNombresCsv {
  ARTICULOS_EMPRESARIALES("articulo_empresariales");

  private String valor;

  private EnumNombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
