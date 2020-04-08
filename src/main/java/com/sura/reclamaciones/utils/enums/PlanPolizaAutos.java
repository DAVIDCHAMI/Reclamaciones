package com.sura.reclamaciones.utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum PlanPolizaAutos {
  PLAN_AUTOS_BASICO("Basico", "1"),
  PLAN_AUTOS_CLASICO("Clasico", "2"),
  PLAN_AUTOS_GLOBAL("Global", "3"),
  PLAN_CONDUCE_MEJOR("Conduce Mejor", "5"),
  PLAN_MOTOS("Motos", "7"),
  PLAN_UTILITARIOS_Y_PESADOS("Utilitarios y Pesados", "8");

  private String descripcionPlan;
  private String codigoPlan;
  private static final Map<String, String> mMap = Collections.unmodifiableMap(initializeMapping());

  private PlanPolizaAutos(String descripcionPlan, String codigoPlan) {
    this.descripcionPlan = descripcionPlan;
    this.codigoPlan = codigoPlan;
  }

  public String getDescripcionPlan() {
    return descripcionPlan;
  }

  public String getCodigoPlan() {
    return codigoPlan;
  }

  public static String obtenerCodigoPlan(String descripcionPlan) {
    if (mMap.containsKey(descripcionPlan)) {
      return mMap.get(descripcionPlan);
    }
    return null;
  }

  private static Map<String, String> initializeMapping() {
    Map<String, String> mMap = new HashMap<>();
    for (PlanPolizaAutos s : PlanPolizaAutos.values()) {
      mMap.put(s.descripcionPlan, s.codigoPlan);
    }
    return mMap;
  }
}
