package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagoEmpresarial {

  private List<PagoEmpresarial> lstPagoEmpresarial = new ArrayList<PagoEmpresarial>();
  private String tipoBeneficiario;
  private String comentario;
  private String numeroFactura;
  private String pais;
  private String departamento;
  private String ciudad;
  private String tipoDireccion;
  private String estado;

  public PagoEmpresarial() {}

  private PagoEmpresarial(Map<String, String> datosPagosEmpresariales) {
    this.tipoBeneficiario = datosPagosEmpresariales.get("tipoBeneficiario");
    this.comentario = datosPagosEmpresariales.get("comentario");
    this.numeroFactura = datosPagosEmpresariales.get("numeroFactura");
    this.pais = datosPagosEmpresariales.get("pais");
    this.departamento = datosPagosEmpresariales.get("departamento");
    this.ciudad = datosPagosEmpresariales.get("ciudad");
    this.tipoDireccion = datosPagosEmpresariales.get("tipoDireccion");
    this.estado=datosPagosEmpresariales.get("estado");
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

  public String getPais() {
    return pais;
  }

  public String getDepartamento() {
    return departamento;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getTipoDireccion() {
    return tipoDireccion;
  }

  public String getEstado() {
    return estado;
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
