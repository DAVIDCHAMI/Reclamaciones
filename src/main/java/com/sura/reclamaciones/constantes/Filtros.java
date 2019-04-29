package com.sura.reclamaciones.constantes;

public enum Filtros {
  PERSONA_LESIONADA("persona lesionada"),
  CREACION_AVISO_AUTOS_WS("Servicio de Maca"),
  PERSONA_CONDUCTOR("persona conductor");

  private String valor;

  Filtros(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
