package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoEmpresarial extends Transacciones {

  private List<PagoEmpresarial> lstPagoEmpresarial = new ArrayList<PagoEmpresarial>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;
  private String tipoDireccion;

  public PagoEmpresarial() {
    super();
  }

  private PagoEmpresarial(Map<String, String> datosPagosEmpresariales) {
    super(datosPagosEmpresariales);
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
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

  public String getTipoDireccion() {
    return tipoDireccion;
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
