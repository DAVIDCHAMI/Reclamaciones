package com.sura.reclamaciones.utils.consultasbd;

import java.util.HashMap;
import java.util.Map;

public class ConsultarTransaccionModeloSimplificado {

  public String obtenerSentenciaSql(String movimientoFinanciero) {
    Map<String, String> sentenciaSql = new HashMap<String, String>();
    sentenciaSql.put(
        "Reserva",
        "select REFERENCE AS numeroMovimientoFinanciero, CLAIMNUMBER AS numeroReclamacion, CEDEDREINSURANCE AS valorCedidoReaseguradoras,NETAMOUNT AS valorNeto, AMOUNT AS valorMovimientoFinanciero, '0' AS estadoMovimientoFinanciero  from ADM_GWCC.CCX_RESERVEDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "Recupero",
        "select REFERENCE AS numeroMovimientoFinanciero, CLAIMNUMBER AS numeroReclamacion, CEDEDREINSURANCE AS valorCedidoReaseguradoras,NETAMOUNT AS valorNeto, AMOUNT AS valorMovimientoFinanciero, ANNULMENT AS estadoMovimientoFinanciero from ADM_GWCC.CCX_RECOVERYDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "Pago",
        "select REFERENCE AS numeroMovimientoFinanciero, CLAIMNUMBER AS numeroReclamacion, CEDEDREINSURANCE AS valorCedidoReaseguradoras,NETAMOUNT AS valorNeto, AMOUNT AS valorMovimientoFinanciero, ANNULMENT AS estadoMovimientoFinanciero from ADM_GWCC.CCX_CHECKDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "AnulacionPago",
        "select REFERENCE AS numeroMovimientoFinanciero, CLAIMNUMBER AS numeroReclamacion, CEDEDREINSURANCE AS valorCedidoReaseguradoras,NETAMOUNT AS valorNeto, AMOUNT AS valorMovimientoFinanciero, ANNULMENT AS estadoMovimientoFinanciero from ADM_GWCC.CCX_CHECKDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "AnulacionRecupero",
        "select REFERENCE AS numeroMovimientoFinanciero, CLAIMNUMBER AS numeroReclamacion, CEDEDREINSURANCE AS valorCedidoReaseguradoras,NETAMOUNT AS valorNeto, AMOUNT AS valorMovimientoFinanciero, ANNULMENT AS estadoMovimientoFinanciero  from ADM_GWCC.CCX_RECOVERYDENORM_EXT where REFERENCE in ?");
    return sentenciaSql.get(movimientoFinanciero);
  }
}
