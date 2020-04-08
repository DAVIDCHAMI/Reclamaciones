package com.sura.reclamaciones.utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CodigoTerminoCoberturaAutos {
  LIMITE_RESPONSABILIDAD_CIVIL("Responsabilidad Civil->Límite", "PARCLimite"),
  DEDUCIBLE_RESPONSABILIDAD_CIVIL("Responsabilidad Civil->Deducible", "PARCDeduciblePorcMin"),
  PERDIDA_TOTAL_DANOS("Daños->Pérdida Total", "PADanosPTDeduciblePorcMin"),
  PERDIDA_PARCIAL_DANOS("Daños->Pérdida Parcial", "PADanosPPDeduciblePorcMin"),
  NUEVO_NUEVO_DANOS("Daños->Nuevo de Nuevo", "PASNDDeducible"),
  GASTOS_TRANSPORTE_DANOS("Daños->Gastos de Transporte", "PAGastTransporte"),
  PERDIDA_TOTAL_HURTO("Hurto->Pérdida Total", "PAHurtoPTDeduciblePorcMin"),
  PERDIDA_PARCIAL_HURTO("Hurto->Pérdida Parcial", "PAHurtoPPDeduciblePorcMin"),
  GASTOS_TRANSPORTE_HURTO("Hurto->Gastos de Transporte", "PAGasTransHurto"),
  PERDIDA_PARCIAL_VEHICULO_REEMPLAZO("Vehículo de Reemplazo->Pérdida Parcial", "PAPPLimite"),
  PERDIDA_TOTAL_VEHICULO_REEMPLAZO("Vehículo de Reemplazo->Pérdida Total", "PAPTLimite"),
  ACCIDENTES_CONDUCTOR("Accidentes al Conductor->Accidentes al Conductor", "PAAPLimite"),
  PERDIDA_LLAVES("Pérdida de Llaves->Pérdida de Llaves", "PAPerdLlaves"),
  ASISTENCIA_VIAJE("Asistencia en Viaje->Asistencia", "PAAsisViaje");

  private String terminoCobertura;
  private String codigoTermino;
  private static final Map<String, String> mMap = Collections.unmodifiableMap(initializeMapping());

  CodigoTerminoCoberturaAutos(String terminoCobertura, String codigoTermino) {
    this.terminoCobertura = terminoCobertura;
    this.codigoTermino = codigoTermino;
  }

  public String getTerminoCobertura() {
    return terminoCobertura;
  }

  public String getCodigoTermino() {
    return codigoTermino;
  }

  public static String obtenerCodigoTermino(String terminoCobertura) {
    if (mMap.containsKey(terminoCobertura)) {
      return mMap.get(terminoCobertura);
    }
    return null;
  }

  private static Map<String, String> initializeMapping() {
    Map<String, String> mMap = new HashMap<>();
    for (CodigoTerminoCoberturaAutos s : CodigoTerminoCoberturaAutos.values()) {
      mMap.put(s.terminoCobertura, s.codigoTermino);
    }
    return mMap;
  }
}
