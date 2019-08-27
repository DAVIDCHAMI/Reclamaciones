package com.sura.reclamaciones.utils;

public enum EnumSeparadores {
  SEPARADOR_FLECHA("->"),
  SEPARADOR_DOS_PUNTOS(":"),
  SEPARADOR_GUION("-"),
  SEPARADOR_COMA(","),
  SEPARADOR_PUNTO_COMA(";"),
  SEPARADOR_VIRGULILLA("~"),
  SEPARADOR_ESPACIO(" ");

  private String valor;

  private EnumSeparadores(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
