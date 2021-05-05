package com.sura.reclamaciones.utils.enums;

public enum Constantes {
  ACTIVIDADES("Actividades"),
  ACTIVITIES("Activities"),
  ANALISTA_RECLAMACION_ATR("analistaReclamacionEmpAtr"),
  ANALISTA_RECLAMACION_AUTO("analistaReclamacionAuto"),
  ANALISTA_RECLAMACION_EMPRESARIAL("analistaReclamacionEmp"),
  ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO("superUsuario"),
  ANULACION_PAGO("Anulación Pago"),
  CANTIDAD("Cantidad"),
  CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA("Nuevas reservas disponibles"),
  CC_POSICION_VALOR_RESERVA_EMPRESARIALES("-1"),
  CLAVE("cor3sur4"),
  CODIGO_RETENCION("Código de retención"),
  COMODIN("COMODIN"),
  COP("COP"),
  CUENTA(""),
  DATOS_FINANCIEROS("Datos financieros"),
  DESARROLLO("dllo"),
  DRIVER("oracle.jdbc.driver.OracleDriver"),
  ENGLISH("English (US)"),
  ESTADO_ANULACION("Anulado"),
  ESTADO_LEGAL("Rematricula a nombre de Suramericana"),
  EXPEDIENTE_CREADO_EXITOSAMENTE("Expediente creado con éxito"),
  EXPOSICIONES("Exposiciones"),
  ITERACIONES_ANULACION("80"),
  ITERACIONES_PAGO("20"),
  ITERACIONES_RECUPERO("3"),
  LABORATORIO("uat"),
  LINEA_RESERVA_LESIONES_CORPORALES("(1) 3ª parteLesiones corporales"),
  NIT("98630089"),
  NO("no"),
  NUMERO_INTENTOS_ESPERA_ELEMENTO("180"),
  NUMERO_PAGO("Número de pago"),
  NUMERO_TRANSACCION("Número de transacción"),
  NUMERO_TRANSACCION_REASEGURO("Número transacción"),
  OPCION_MENU("opcionMenu"),
  PAGOS("Pagos"),
  PLACA("PLACA"),
  PORCENTAJE("0.20"),
  PORCIENTO("100"),
  REASEGURO_DETALLADO("Reaseguro detallado"),
  RECLAMANTE_CONDUCTOR_AFECTADO("Conductor de otro vehículo"),
  RESERVA("Reserva"),
  RETENCION_PURA("10"),
  RUTA_LOG_EMPRESARIAL("C:\\Log\\RegistrosEmpresarial.txt"),
  SELECCIONAR("Seleccionar"),
  SI("si"),
  TIPO("Tipo"),
  TIPO_PAGO("Parcial"),
  TIPO_TRANSACCION("Recuperaciones"),
  TRANSFERENCIA_ELECTRONICA("Transferencia"),
  TRUE("true"),
  UBICACION_ESTADO_PAGO("5"),
  UBICACION_ESTADO_RECUPERO("9"),
  URL("jdbc:oracle:thin:@clustercsl01:1537/labgwcc"),
  USD("USD"),
  USUARIO("GW_CONF"),
  VALIDADOR_NUEVA_RECLAMACION("Nueva reclamación guardada"),
  VALOR_CERO("0");

  private String valor;

  Constantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
