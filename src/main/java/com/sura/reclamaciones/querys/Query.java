package com.sura.reclamaciones.querys;

public enum Query {
  SqlModeloSimplificadoReserva(
      "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT from ADM_GWCC.CCX_RESERVEDENORM_EXT where REFERENCE in ?"),
  SqlModeloSimplificadoRecupero(
      "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT  from ADM_GWCC.CCX_RECOVERYDENORM_EXT where REFERENCE in ?"),
  SqlModeloSimplificadoPago(
      "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT,AMOUNT from ADM_GWCC.CCX_CHECKDENORM_EXT where reference in ?"),
  SqlModeloSimplificadoAnulacionPago(
      "select REFERENCE, CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT  from ADM_GWCC.CCX_CHECKDENORM_EXT where ANNULMENT= 'S' AND reference in ?");

  private String consultaSql;

  Query(String consultaSql) {
    this.consultaSql = consultaSql;
  }

  public String getConsultaSql() {
    return consultaSql;
  }

  public void setConsultaSql(String consultaSql) {
    this.consultaSql = consultaSql;
  }
}
