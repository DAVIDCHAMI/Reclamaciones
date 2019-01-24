package com.sura.reclamaciones.constantes;

public enum EnumConfiguraciones {
  CANTIDAD_LETRAS(4),
  CANTIDAD_NUMEROS(3);

  private int valor;

  private EnumConfiguraciones(int valor) {
    this.valor = valor;
  }

  public int getValor() {
    return valor;
  }
}
