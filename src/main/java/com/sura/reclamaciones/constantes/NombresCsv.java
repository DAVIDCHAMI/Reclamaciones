package com.sura.reclamaciones.constantes;

public enum NombresCsv {
  ANULACION_EMPRESARIAL("anulacion_empresarial"),
  CONTRATO("contrato"),
  PAGO_SINIESTRO("pago_siniestro"),
  PARAMETROS_SINIESTRO("parametros_siniestro"),
  EXPEDICION_AUTOS("expedicion_autos"),
  RECUPERO_SINIESTRO("recupero_siniestro"),
  PARAMETROS_PERSONA("parametros_persona"),
  PARAMETROS_RECLAMACION_PERSONA("persona_reclamacion_auto"),
  PARAMETROS_RECLAMACION("reclamacion_auto"),
  PARAMETROS_VEHICULO("vehiculo"),
  PARAMETRO_PERSONA_LESIONADA("lesionado"),
  PARAMETRO_PERSONA_CONDUCTOR("conductor"),
  PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO("responsabilidad_civil_vehiculo"),
  PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES("responsabilidad_civil_lesiones"),
  PARAMETROS_SINIESTRO_AUTOS("parametros_siniestro_autos"),
  PARAMETROS_EXPOSICION_AUTOMATICA("exposicion_automatica"),
  PARAMETRO_LINEA_RESERVA("linea_reserva"),
  PARAMETROS_DIRECCION_SINIESTRO("direccion_reclamacion"),
  PARAMETRO_CREACION_AVISO_AUTOS_WS("creacionAvisoWS"),
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
