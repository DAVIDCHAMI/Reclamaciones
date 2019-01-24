package com.sura.reclamaciones.utils;

public enum VariablesSesion {
  SESION_CC_NUMERO_SINIESTRO("NumeroSiniestro"),
  SESION_CC_NUMERO_TRANSACCION("Número de transacción"),
  SESION_CC_TIPO_PRODUCTO_EMPRESARIAL("tipoProductoEmpresarial"),
  SESION_CC_TIPO_RESERVA("tipoReserva"),
  SESION_CC_VALOR_RECUPERO("ValorRecupero"),
  SESION_CC_VALOR_RESERVA("valorReserva");

  private String valor;

  VariablesSesion(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
