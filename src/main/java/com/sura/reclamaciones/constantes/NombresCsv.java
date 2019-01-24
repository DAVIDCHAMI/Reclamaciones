package com.sura.reclamaciones.constantes;

public enum NombresCsv {
  ANULACION_EMPRESARIAL("anulacion_empresarial"),
  CONTRATO("contrato"),
  PAGO_SINIESTRO("pago_siniestro"),
  EXPEDICION_AUTOS("expedicion_autos"),
  RECUPERO_SINIESTRO("recupero_siniestro"),
  RECLAMACION_EMPRESARIAL("reclamacion_empresarial"),
  CREDENCIAL("Credencial");

  private String valor;

  NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
