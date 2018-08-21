package com.sura.reclamaciones.querys;

public enum Query {
  SqlModeloSimplificadoReserva ("select CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT from ADM_GWCC.CCX_RESERVEDENORM_EXT where reference = ?"),
  SqlModeloSimplificadoRecupero ("select CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT  from ADM_GWCC.CCX_RECOVERYDENORM_EXT where reference = ?"),
  SqlModeloSimplificadoPago ("select CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT,AMOUNT from ADM_GWCC.CCX_CHECKDENORM_EXT where reference = ?");

private String consultaSql;

  Query(String consultaSql) {
    this.consultaSql= consultaSql;
  }

  public String getConsultaSql() {
    return consultaSql;
  }

  public void setConsultaSql(String consultaSql) {
    this.consultaSql = consultaSql;
  }
}
