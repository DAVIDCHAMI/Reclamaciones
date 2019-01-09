package com.sura.reclamaciones.utils;

public enum NombresCsv {
  PAGO_EMPRESARIAL("pago_empresarial"),
  CONTRATO("contrato"),
  RECUPERO("recupero");

  private String valor;

  private NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
