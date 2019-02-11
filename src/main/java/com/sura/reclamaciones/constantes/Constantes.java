package com.sura.reclamaciones.constantes;

public enum Constantes {
  ACTIVIDADES("Actividades"),
  ACTIVITIES("Activities"),
  ANULACION("Anulacion"),
  CANTIDAD("Cantidad"),
  CLAVE("cor3sur4"),
  CODIGO_RETENCION("Código de retención"),
  COMODIN("COMODIN"),
  COP("COP"),
  CUENTA(""),
  DATOS_FINANCIEROS("Datos financieros"),
  DRIVER("oracle.jdbc.driver.OracleDriver"),
  ENGLISH("English (US)"),
  ESTADO_ANULACION("Anulado"),
  EXPOSICIONES("Exposiciones"),
  FECHA_HOY("Hoy"),
  ITERACIONES_ANULACION("20"),
  ITERACIONES_PAGO("10"),
  ITERACIONES_RECUPERO("3"),
  NUMERO_PAGO("Número de pago"),
  NUMERO_TRANSACCION("Número de transacción"),
  PAGO("Pago"),
  PAGOS("Pagos"),
  PORCENTAJE("0.20"),
  PORCIENTO("100"),
  REASEGURO_DETALLADO("Reaseguro detallado"),
  RECUPERO("Recupero"),
  LINEA_RESERVA_LESIONES_CORPORALES("(1) 3ª parteLesiones corporales"),
  RESERVA("Reserva"),
  RETENCION_PURA("10"),
  SELECCIONAR("Seleccionar"),
  TIPO_PAGO("Parcial"),
  TIPO_TRANSACCION("Recuperaciones"),
  TRANSFERENCIA_ELECTRONICA("Transferencia"),
  UBICACION_ESTADO_PAGO("5"),
  UBICACION_ESTADO_RECUPERO("9"),
  URL("jdbc:oracle:thin:@clustercsl01:1537/labgwcc"),
  USD("USD"),
  USUARIO("GW_CONF"),
  ESTADO_LEGAL("Rematricula a nombre de Suramericana"),
  VALIDADOR_NUEVA_RECLAMACION("Nueva reclamación guardada");

  private String valor;

  Constantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
