package com.sura.reclamaciones.utils;

public enum VariablesSesion {
  SESION_CC_NUMERO_SINIESTRO("NumeroSiniestro"),
  SESION_CC_NUMERO_TRANSACCION("Número de transacción"),
  SESION_CC_VALOR_RECUPERO("ValorRecupero"),
  SESION_CC_VALOR_RESERVA("ValorReserva");

  private String valor;

  private VariablesSesion(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
