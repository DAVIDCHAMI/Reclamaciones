package com.sura.reclamaciones.utils.enums;

public enum EnumFormatos {
  FORMATO_FECHA_DDMMYYYY("dd/MM/yyyy"),
  FORMATO_FECHA_YYYYMMDD("yyyy-MM-dd");

  private final String valor;

  EnumFormatos(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
