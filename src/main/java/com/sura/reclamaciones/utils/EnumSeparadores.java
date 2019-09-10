package com.sura.reclamaciones.utils;

public enum EnumSeparadores {
  SEPARADOR_COMA(","),
  SEPARADOR_VALORES_CSV(";");

  private String valor;

  private EnumSeparadores(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
