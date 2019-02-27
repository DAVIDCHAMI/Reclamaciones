package com.sura.reclamaciones.constantes;

public enum Configuraciones {
  CANTIDAD_LETRAS(4),
  CANTIDAD_NUMEROS(3);

  private int valor;

  private Configuraciones(int valor) {
    this.valor = valor;
  }

  public int getValor() {
    return valor;
  }
}
