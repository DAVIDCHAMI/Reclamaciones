package com.sura.reclamaciones.sentenciasSQL;

import java.util.HashMap;
import java.util.Map;

public class ConsultarCondicionesPoliza {

  public Map<String, String> obtenerSentenciaSql(String claimNumber) {
    Map<String, String> sentenciaSql = new HashMap<String, String>();
    sentenciaSql.put(
        "Datos Poliza",
        "SELECT DISTINCT CS.L_ES_CO cobertura, cov.l_es_co, cte.numericvalue --e.*, CS.L_ES_CO cobertura, CT.L_ES_Co subtipo, cte.numericvalue, i.totalloss\n"
            + "FROM ADM_GWCC.CC_CLAIM C\n"
            + "INNER JOIN  ADM_GWCC.CC_EXPOSURE E\n"
            + "ON E.CLAIMID = C.ID\n"
            + "INNER JOIN ADM_GWCC.CC_INCIDENT I\n"
            + "ON E.INCIDENTID = I.ID\n"
            + "INNER JOIN ADM_GWCC.CC_COVERAGE CO\n"
            + "ON CO.ID = E.COVERAGEID\n"
            + "INNER JOIN ADM_GWCC.CC_COVERAGETERMS CTE\n"
            + "ON CTE.COVERAGEID = CO.ID\n"
            + "INNER JOIN ADM_GWCC.cctl_covtermpattern COV \n"
            + "ON COV.ID = cte.covtermpattern\n"
            + "INNER JOIN ADM_GWCC.CCTL_COVERAGESUBTYPE CS\n"
            + "ON CS.ID = E.COVERAGESUBTYPE\n"
            + "INNER JOIN ADM_GWCC.CCTL_COVERAGETYPE CT\n"
            + "ON CT.ID = CO.TYPE\n"
            + "WHERE C.CLAIMNUMBER = '"
            + claimNumber
            + "'");

    return sentenciaSql;
  }
}
