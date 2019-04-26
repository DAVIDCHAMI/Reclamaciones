package com.sura.reclamaciones.utils;

public enum VariablesSesion {
  SESION_CC_NRO_RECLAMACION("nro_reclamacion"),
  SESION_CC_NUMERO_SINIESTRO("NumeroSiniestro"),
  SESION_CC_NUMERO_TRANSACCION("Número de transacción"),
  SESION_CC_TIPO_PRODUCTO_EMPRESARIAL("tipoProductoEmpresarial"),
  SESION_CC_TIPO_RESERVA("tipoReserva"),
  SESION_CC_VALOR_RECUPERO("ValorRecupero"),
  SESION_CC_VALOR_RESERVA("valorReserva"),
  SESION_CC_VALOR_RESERVA_CONSTITUCION("valorReservaConstitución"),
  SESION_COT_NUMERO_COTIZACION("nro_cotizacion"),
  SESION_FECHA_EFECTIVA_MODIFICACION("fecha_efectiva_modificacion"),
  SESION_FECHA_FIN_VIGENCIA("fecha_fin_vigencia"),
  SESION_FECHA_INICIO_VIGENCIA("fecha_inicio_vigencia"),
  SESION_FECHA_MODIFICACION_POLIZA("fecha_modificacion_poliza"),
  SESION_FECHA_SINIESTRO("fecha_siniestro"),
  SESION_GC_CODIGO_RIESGO("nro_poliza_riesgo"),
  SESION_GC_ESTADO_OPERACION("estado_operacion"),
  SESION_GC_NRO_COTIZACION("nro_cotizacion"),
  SESION_GC_NRO_POLIZA_MASTER("nro_poliza_master"),
  SESION_GC_PLACA("placa"),
  SESION_GC_PROCESO("proceso"),
  SESION_NRO_TRANSACCION("nro_transaccion"),
  SESION_PC_NRO_POLIZA("nro_poliza"),
  SESION_SERV_JOB_NUMBER("job_number"),
  SESION_SERV_NRO_PLACA("nro_placa"),
  SESION_SERV_NRO_POLIZA("nro_poliza"),
  SESION_VALOR_IVA("valor_iva"),
  SESION_VALOR_PRIMA("valor_prima");

  private String valor;

  VariablesSesion(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
