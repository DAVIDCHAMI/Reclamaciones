package com.sura.reclamaciones.constantes;

public enum NombresCsv {
  ANULACION_EMPRESARIAL("anulacion_empresarial"),
  CONTRATO("contrato"),
  PAGO_SINIESTRO("pago_siniestro"),
  RECUPERO_SINIESTRO("recupero_siniestro");

  private String valor;

  NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
