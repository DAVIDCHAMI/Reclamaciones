package com.sura.reclamaciones.utils;

public enum EnumValoresServicio {
  VALOR_PA_DANOS_TERCEROS_COB("PARCCov"),
  VALOR_PA_DANOS_COB("PADanosCov"),
  VALOR_PA_HURTO_COB("PAHurtoCov"),
  VALOR_PA_ACCIDENTES_COB("PAAccidCondCov"),
  VALOR_PA_ASISTENCIA_COB("PAAsistenciaCov"),
  VALOR_PA_CARRORE_COB("PACarroReCov"),
  VALOR_PA_PERDLLA_COB("PAPerdLLaCov"),
  COB_DANO_TERCERO_LIMITE("PARCLimite"),
  COB_DANO_TERCERO_DEDUCIBLE("PARCDeduciblePorcMin"),
  COB_DANOS_CARRO_PTOTAL("PADanosPTDeduciblePorcMin"),
  COB_DANOS_CARRO_PPARCIAL("PADanosPPDeduciblePorcMin"),
  COB_DANOS_CARRO_GTRANSPORTE("PAGastTransporte"),
  COB_HURTO_CARRO_PTOTAL("PAHurtoPTDeduciblePorcMin"),
  COB_HURTO_CARRO_PPARCIAL("PAHurtoPPDeduciblePorcMin"),
  COB_HURTO_CARRO_GTRANSPORTE("PAGasTransHurto"),
  COB_PERDIDA_LLAVES("PAPerdLlaves"),
  COB_VREEMPLAZO_PERD_PARCIAL("PAPPLimite"),
  COB_VREEMPLAZO_PERD_TOTAL("PAPTLimite"),
  COB_ACCIDENTES_CONDUCTOR("PAAPLimite"),
  COB_ASISTENCIA("PAAsisViaje"),
  PA_DANOS_TERCEROS("PADanosATerceros"),
  PA_DANOS_ALCARROGRP("PADanosAlCarroGrp"),
  PA_HURTO_ALCARROGRP("PAHurtoAlCarroGrp"),
  PA_ACCIDENTES("PAAccidentes"),
  PA_LLAVES("PALlaves"),
  PA_CARRO_DEREEMPLAZO("PACarroDeReemplazo"),
  PA_ASISTENCIA("PAAsistencia");

  private final String Codigo;

  private EnumValoresServicio(String codigo) {
    this.Codigo = codigo;
  }

  public String getValue() {
    return this.Codigo;
  }
}
