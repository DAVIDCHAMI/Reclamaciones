package com.sura.reclamaciones.utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CodigoNombreCoberturaAutos {
  RESPONSABILIDAD_CIVIL("Responsabilidad Civil", "PARCCov"),
  DANOS("Daños", "PADanosCov"),
  HURTO("Hurto", "PAHurtoCov"),
  VEHICULO_REEMPLAZO("Vehículo de Reemplazo", "PACarroReCov"),
  ACCIDENTES_CONDUCTOR("Accidentes al Conductor", "PAAccidCondCov"),
  PERDIDA_LLAVES("Pérdida de Llaves", "PAPerdLLaCov"),
  ASISTENCIA_VIAJE("Asistencia en Viaje", "PAAsistenciaCov");

  private String nombreCobertura;
  private String codigoNombre;
  private static final Map<String, String> mMap = Collections.unmodifiableMap(initializeMapping());

  CodigoNombreCoberturaAutos(String nombreCobertura, String codigoNombre) {
    this.nombreCobertura = nombreCobertura;
    this.codigoNombre = codigoNombre;
  }

  public String getNombreCobertura() {
    return nombreCobertura;
  }

  public String getCodigoNombre() {
    return codigoNombre;
  }

  public static String obtenerCodigoNombre(String nombreCobertura) {
    if (mMap.containsKey(nombreCobertura)) {
      return mMap.get(nombreCobertura);
    }
    return null;
  }

  private static Map<String, String> initializeMapping() {
    Map<String, String> mMap = new HashMap<>();
    for (CodigoNombreCoberturaAutos s : CodigoNombreCoberturaAutos.values()) {
      mMap.put(s.nombreCobertura, s.codigoNombre);
    }
    return mMap;
  }
}
