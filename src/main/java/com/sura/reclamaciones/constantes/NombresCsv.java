package com.sura.reclamaciones.constantes;

public enum NombresCsv {
  ANULACION_EMPRESARIAL("anulacion_empresarial"),
  CODIGO_FASECOLDA("codigo_fasecolda"),
  PAGO_MASIVO("pago_masivo"),
  CONTRATO("contrato"),
  CREDENCIAL("Credencial"),
  EXPEDICION_AUTOS("expedicion_autos"),
  PAGO_SINIESTRO("pago_siniestro"),
  PARAMETROS_DIRECCION_SINIESTRO("direccion_reclamacion"),
  PARAMETROS_EXPOSICION_AUTOMATICA("exposicion_automatica"),
  PARAMETROS_NAVEGACION_MENU_ACCIONES("navegacion_menu_acciones"),
  PARAMETROS_PERSONA("parametros_persona"),
  PARAMETROS_RECLAMACION("reclamacion_auto"),
  PARAMETROS_RECLAMACION_PERSONA_AUTO("parametros_persona_reclamacion_auto"),
  PARAMETROS_SINIESTRO("parametros_siniestro"),
  PARAMETROS_SINIESTRO_AUTOS("parametros_siniestro_autos"),
  PARAMETROS_VEHICULO("vehiculo"),
  PARAMETRO_LINEA_RESERVA("linea_reserva"),
  PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES("responsabilidad_civil_lesiones"),
  PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO("responsabilidad_civil_vehiculo"),
  RECLAMACION_EMPRESARIAL("reclamacion_empresarial"),
  RECUPERO_SINIESTRO("recupero_siniestro");

  private String valor;

  NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
