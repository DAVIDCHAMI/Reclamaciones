package com.sura.reclamaciones.utils;

public enum Variables {
  COLUMNA_FILTRO_CSV("idFiltro"),
  FORMATEAR_MONTOS("[+$.,()éA-Za-z ]"),
  VALOR_RESERVA("");

  private String valor;

  private Variables(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
