package com.sura.reclamaciones.utils;

public enum Constantes {
  PAGO("Pago"),
  RECLAMACION_MENU("Re"),
  NUEVA_RECLAMACION_MENU("Nueva"),
  RESERVA("Reserva"),
  DATOS_FINANCIEROS("Datos financieros"),
  TRANSACCIONES("Transacciones"),
  NUEVAS_RESERVAS_DISPONIBLES("Nuevas reservas disponibles"),
  REVERSION_CONSTITUCION("reversionConstitucion"),
  CANTIDAD("Cantidad"),
  COMODIN("COMODIN"),
  LABORATORIO("uat"),
  DESARROLLO("dllo"),
  ANALISTA_RECLAMACION_AUTO("analistaReclamacionAuto"),
  ANALISTA_RECLAMACION_EMPRESARIAL("analistaReclamacionEmp"),
  SI("si"),
  NO("no"),
  NIT("98630089"),
  PARAMETROS_SINIESTRO("parametros_siniestro"),
  PARAMETROS_PERSONA("parametros_persona"),
  CODIGO_RETENCION("Código de retención"),
  NUMERO_TRANSACCION("Número de transacción"),
  TIPO_TRANSACCION("Recuperaciones"),
  FECHA_HOY("Hoy"),
  EXPOSICIONES("Exposiciones"),
  VALIDADOR_NUEVA_RECLAMACION("Nueva reclamación guardada"),
  NUMERO_SINIESTRO("NumeroSiniestro"),
  VERIFICADOR_NUMERO_SINIESTRO("9180000"),
  PAGOS("Pagos"),
  TRANSFERENCIA_ELECTRONICA("Transferencia"),
  TIPO_PAGO("Parcial"),
  CUENTA(""),
  SELECCIONAR("Seleccionar"),
  NUMERO_PAGO("Número de pago"),
  COP("COP"),
  USD("USD"),
  PORCENTAJE("0.20"),
  INGLES("English (US)"),
  ESPANOL("Spanish (CO)"),
  US("(US)"),
  ACTIVIDADES("Actividades"),
  ACTIVIDADES_INGLES("Activities"),
  REASEGURO_DETALLADO("Reaseguro detallado"),
  VALOR_REASEGURADO("Valor reasegurado"),
  NUMERO_DISTRIBUCION("Número distribución"),
  NUMERO_CONTRATO("Número del contrato"),
  NOMBRE_REASEGURADOR("Nombre del reasegurador"),
  IDENTIFICACION_REASEGURADOR("Identificación del reasegurador"),
  PORCENTAJE_PARTICIPACION_REASEGURADOR("% Participación"),
  CANTIDAD_PARTICIPACION_REASEGURADOR("$ Participación"),
  RECUPERO("Recupero"),
  ESTADO_ANULACION("Anulado"),
  PORCIENTO("100"),
  RETENCION_PURA("10"),
  RETENCION_PURA_ENCABEZADO("Retención pura"),
  SURA("0000");

  private String valor;

  private Constantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
