package com.sura.reclamaciones.constantes;

public enum Posiciones {
  POSICION_COLUMNA_DOS("2"),
  POSICION_COLUMNA_MENOS_DOS("-2"),
  POSICION_FILA("1");

  private String valor;

  Posiciones(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
