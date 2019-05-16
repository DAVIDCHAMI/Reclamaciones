package com.sura.reclamaciones.constantes;

public enum Filtros {
  PERSONA_LESIONADA("persona lesionada"),
  CREACION_AVISO_AUTOS_WS("creacionAvisoMACA"),
  COBERTURA_DANOS_TOTALES("Perdida total Daños"),
  EXPOSICION_MANUAL_VEHICULAR("nuevaExposicionVehicular"),
  EXPOSICION_VEHICULAR_TERCERO("conductor daños vehículo"),
  DIRECCION_EXPOSICION_VEHICULAR("direccionExposicionVehicular"),
  DIRECCION_EXPOSICION_LESIONES("direccionExposicionLesiones"),
  EXPOSICIONES_RESPONSABILIDAD_CIVIL("exposicionesRC"),
  EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL("exposicionesSoloRC"),
  RECLAMACION_RESPONSABILIDAD_CIVIL("responsabilidadCivil"),
  RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL("soloRC"),
  RECLAMACION_ARCHIVO("archivo"),
  RECLAMACION_SUBROGACION("subrogacion"),
  EXPOSICIONES_ARCHIVO("exposicionesArchivo"),
  LINEA_RESERVA_ARCHIVO("archivoSubrogacion"),
  PERSONA_CONDUCTOR("persona conductor");

  private String valor;

  Filtros(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
