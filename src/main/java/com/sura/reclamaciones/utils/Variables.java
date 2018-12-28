package com.sura.reclamaciones.utils;

public enum Variables {
  COLUMNA_FILTRO_CSV("idFiltro"),
  FORMATEAR_MONTOS("[+$.,()éA-Za-z ]"),
  VALOR_RESERVA("valorReserva"),
  NUMERO_PAGINA("numeroPagina"),
  TIPO_ANULACION("tipoAnulacion"),
  TIPO_PRODUCTO_EMPRESARIAL("tipoProductoEmpresarial");

  private String valor;

  private Variables(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
