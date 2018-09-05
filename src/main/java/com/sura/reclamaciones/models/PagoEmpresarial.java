package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoEmpresarial {

  private List<PagoEmpresarial> lstPagoEmpresarial = new ArrayList<PagoEmpresarial>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;

  public PagoEmpresarial() {}

  private PagoEmpresarial(Map<String, String> datosPagosEmpresariales) {
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
  }

  public PagoEmpresarial(List<Map<String, String>> datosPagosEmpresariales) {
    asignarDatos(datosPagosEmpresariales);
  }

  public String getTipoBeneficiario() {
    return tipoBeneficiario;
  }

  public String getComentario() {
    return comentario;
  }

  public String getNumeroFactura() {
    return numeroFactura;
  }

  public List<PagoEmpresarial> getLstPago() {
    return lstPagoEmpresarial;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstPagoEmpresarial.add(new PagoEmpresarial(dato));
    }
  }
}
