package com.sura.reclamaciones.utils;

public enum NombresCsv {
  CONTRATO("contrato"),
  PAGO_SINIESTRO("pago_empresarial"),
  RECUPERO("recupero");

  private String valor;

  private NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
