package com.sura.reclamaciones.utils;

public enum Variables {
  PRIMA("Prima"),
  IVA("Iva"),
  DESCRIPCION_OPERACION("Descripción de la operación"),
  TASA_COMISION("Tasa de comisión"),
  DETALLE_COMISIONES_ASESOR("Detalle de comisiones del asesor"),
  COLUMNA_FILTRO_CSV("idFiltro"),
  FORMATEAR_MONTOS("[$.()A-Z ]"),
  POLIZA("Póliza"),
  NO_COINCIDE_CON_EL_ESPERADO(" no coincide con el esperado: "),
  SEGUROS_GENERALES_SURAMERICANA("SEGUROS GENERALES SURAMERICANA S.A."),
  NOMBRE_REASEGURADOR("Nombre del reasegurador"),
  PORCENTAJE_DE_CESION("Porcentaje de cesión (%)"),
  PRIMA_BRUTA_CEDIDA("Prima bruta cedida"),
  LIMITE_INFERIOR("Límite inferior"),
  RIESGO_CEDIDO("Riesgo cedido"),
  DEPOSITO_RETENIDO("Depósito retenido"),
  PARTICIPACION("Participación (%)"),
  PROPORCION("Proporción (%)"),
  IMPUESTO_BOMBEROS("Impuesto bomberos"),
  PORCENTAJE_COASEGURO("porcentajeCoaseguro"),
  TIPO_COASEGURO("tipoCoaseguro"),
  CEDIDO("Cedido"),
  ACEPTADO("Aceptado"),
  VALOR_RETEFUENTE("Valor retefuente"),
  RETEFUENTE("Retefuente (%)"),
  COMISION("Comisión"),
  LIMITE("Límite"),
  TIPO("Tipo"),
  CUOTA_PARTE("Cuota parte"),
  LIMITE_CUOTA_PARTE_FRAUDE("$150.000.000 (COP)"),
  PORCENTAJE_RETENCION("100,000000%"),
  CERO_PESOS("$0 (COP)"),
  VALOR_CIEN("100"),
  VALOR_CERO("0"),
  REASEGURO("Reaseguro"),
  NUMERO_POLIZA("numeroPoliza"),
  VALOR_ASEGURADO_RIESGO("valorAseguradoRiesgo"),
  VALOR("Valor");

  private String valor;

  Variables(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
