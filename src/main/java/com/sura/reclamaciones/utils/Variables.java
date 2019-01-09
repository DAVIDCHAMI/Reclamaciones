package com.sura.reclamaciones.utils;

public enum Variables {
  COLUMNA_FILTRO_CSV("idFiltro"),
  FORMATEAR_MONTOS("[+$.,()óéA-Za-z ]"),
  VALOR_RESERVA("valorReserva"),
  NUMERO_PAGINA("numeroPagina"),
  TIPO_ANULACION("tipoAnulacion"),
  TIPO_CONTRATO_POLIZA("tipoContratoPoliza"),
  VALOR_RECUPERO("valorRecupero");

  private String valor;

  private Variables(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
