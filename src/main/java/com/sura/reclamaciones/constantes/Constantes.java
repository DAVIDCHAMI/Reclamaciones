package com.sura.reclamaciones.constantes;

public enum Constantes {
  ACTIVIDADES("Actividades"),
  ACTIVIDADES_INGLES("Activities"),
  ANALISTA_RECLAMACION_AUTO("analistaReclamacionAuto"),
  ANALISTA_RECLAMACION_EMPRESARIAL("analistaReclamacionEmp"),
  CANTIDAD("Cantidad"),
  CANTIDAD_PARTICIPACION_REASEGURADOR("$ Participación"),
  CLAVE("cor3sur4"),
  CODIGO_RETENCION("Código de retención"),
  COMODIN("COMODIN"),
  COP("COP"),
  CUENTA(""),
  DATOS_FINANCIEROS("Datos financieros"),
  DESARROLLO("dllo"),
  DRIVER("oracle.jdbc.driver.OracleDriver"),
  ENGLISH("English (US)"),
  ESPANOL("Spanish (CO)"),
  ESTADO_ANULACION("Anulado"),
  EXPOSICIONES("Exposiciones"),
  FECHA_HOY("Hoy"),
  IDENTIFICACION_REASEGURADOR("Identificación del reasegurador"),
  INGLES("English (US)"),
  ITERACIONES_ANULACION("20"),
  ITERACIONES_PAGO("10"),
  ITERACIONES_RECUPERO("3"),
  LABORATORIO("uat"),
  NIT("98630089"),
  NO("no"),
  NOMBRE_REASEGURADOR("Nombre del reasegurador"),
  NUEVAS_RESERVAS_DISPONIBLES("Nuevas reservas disponibles"),
  NUEVA_RECLAMACION_MENU("Nueva"),
  NUMERO_CONTRATO("Número del contrato"),
  NUMERO_DISTRIBUCION("Número distribución"),
  NUMERO_PAGO("Número de pago"),
  NUMERO_SINIESTRO("NumeroSiniestro"),
  NUMERO_TRANSACCION("Número de transacción"),
  PAGO("Pago"),
  PAGOS("Pagos"),
  PARAMETROS_PERSONA("parametros_persona"),
  PARAMETROS_SINIESTRO("parametros_siniestro"),
  PORCENTAJE("0.20"),
  PORCENTAJE_PARTICIPACION_REASEGURADOR("% Participación"),
  PORCIENTO("100"),
  REASEGURO_DETALLADO("Reaseguro detallado"),
  RECLAMACION_MENU("Re"),
  RECUPERO("Recupero"),
  RESERVA("Reserva"),
  RETENCION_PURA("10"),
  RETENCION_PURA_ENCABEZADO("Retención pura"),
  REVERSION_CONSTITUCION("reversionConstitucion"),
  SELECCIONAR("Seleccionar"),
  SI("si"),
  SURA("0000"),
  TIPO_PAGO("Parcial"),
  TIPO_TRANSACCION("Recuperaciones"),
  TRANSACCIONES("Transacciones"),
  TRANSFERENCIA_ELECTRONICA("Transferencia"),
  UBICACION_ESTADO_PAGO("5"),
  URL("jdbc:oracle:thin:@clustercsl01:1537/labgwcc"),
  US("(US)"),
  USD("USD"),
  USUARIO("GW_CONF"),
  VALIDADOR_NUEVA_RECLAMACION("Nueva reclamación guardada"),
  VALOR_REASEGURADO("Valor reasegurado"),
  VERIFICADOR_NUMERO_SINIESTRO("9180000");

  private String valor;

  private Constantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
