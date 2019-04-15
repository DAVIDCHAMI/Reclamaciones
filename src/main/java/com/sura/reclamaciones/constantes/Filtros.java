package com.sura.reclamaciones.constantes;

public enum Filtros {
  PERSONA_LESIONADA("persona lesionada"),
  PERSONA_CONDUCTOR("persona conductor");

  private String valor;

  Filtros(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
