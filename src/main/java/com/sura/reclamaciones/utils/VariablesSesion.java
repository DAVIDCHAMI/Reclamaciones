package com.sura.reclamaciones.utils;

public enum VariablesSesion {
  SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO("conductor_afectado_siniestro"),
  SESION_CC_FECHA_FIN_VIGENCIA("fecha_fin_vigencia"),
  SESION_CC_FECHA_INICIO_VIGENCIA("fecha_inicio_vigencia"),
  SESION_CC_FECHA_MODIFICACION_POLIZA("fecha_modificacion_poliza"),
  SESION_CC_FECHA_SINIESTRO("fecha_siniestro"),
  SESION_CC_NRO_RECLAMACION("nro_reclamacion"),
  SESION_CC_NUMERO_FACTURA_PAGO_MASIVO("NumeroFacturaPagoMasivo"),
  SESION_CC_NUMERO_PAGO_INDIVIDUAL("NumeroPagoIndividual"),
  SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS("NumeroPlacaPartesInvolucradas"),
  SESION_CC_NUMERO_SINIESTRO("NumeroSiniestro"),
  SESION_CC_NUMERO_TRANSACCION("Número de transacción"),
  SESION_CC_PRODUCTO_AUTOS("ProductoAutos"),
  SESION_CC_TIPO_COBERTURA_AFECTADA("tipoCoberturaAfectada"),
  SESION_CC_TIPO_PRODUCTO_EMPRESARIAL("tipoProductoEmpresarial"),
  SESION_CC_TIPO_RESERVA("tipoReserva"),
  SESION_CC_TOTAL_PAGO_RESERVAS("0"),
  SESION_CC_VALOR_RECUPERO("ValorRecupero"),
  SESION_CC_VALOR_RESERVA("valorReserva"),
  SESION_CC_VALOR_RESERVA_CONSTITUCION("valorReservaConstitución"),
  SESION_COT_NUMERO_COTIZACION("nro_cotizacion"),
  SESION_FECHA_EFECTIVA_MODIFICACION("fecha_efectiva_modificacion"),
  SESION_GC_CODIGO_RIESGO("nro_poliza_riesgo"),
  SESION_GC_ESTADO_OPERACION("estado_operacion"),
  SESION_GC_NRO_COTIZACION("nro_cotizacion"),
  SESION_GC_NRO_POLIZA_MASTER("nro_poliza_master"),
  SESION_GC_PLACA("placa"),
  SESION_GC_PROCESO("proceso"),
  SESION_NRO_TRANSACCION("nro_transaccion"),
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
