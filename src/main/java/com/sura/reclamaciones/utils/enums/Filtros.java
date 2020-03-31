package com.sura.reclamaciones.utils.enums;

public enum Filtros {
  CLASE_VEHICULO("Automoviles"),
  COBERTURA_DANOS_TOTALES("Perdida total Daños"),
  CREACION_AVISO_AUTOS_WS("creacionAvisoMACA"),
  DIRECCION_EXPOSICION_LESIONES("direccionExposicionLesiones"),
  DIRECCION_EXPOSICION_VEHICULAR("direccionExposicionVehicular"),
  EXPOSICIONES_ARCHIVO("exposicionesArchivo"),
  EXPOSICIONES_RESPONSABILIDAD_CIVIL("exposicionesRC"),
  EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL("exposicionesSoloRC"),
  EXPOSICION_MANUAL_VEHICULAR("nuevaExposicionVehicular"),
  EXPOSICION_VEHICULAR_TERCERO("conductor daños vehículo"),
  LINEA_RESERVA_ARCHIVO("archivoSubrogacion"),
  PERSONA_CONDUCTOR("persona conductor"),
  PERSONA_LESIONADA("persona lesionada"),
  RECLAMACION_ARCHIVO("archivo"),
  RECLAMACION_RESPONSABILIDAD_CIVIL("responsabilidadCivil"),
  RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL("soloRC"),
  RECLAMACION_SUBROGACION("subrogacion");

  private String valor;

  Filtros(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
