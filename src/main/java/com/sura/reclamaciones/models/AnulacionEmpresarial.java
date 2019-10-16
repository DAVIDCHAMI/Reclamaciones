package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnulacionEmpresarial extends Transacciones {

  private List<AnulacionEmpresarial> lstAnulacionEmpresarial =
      new ArrayList<>();

  private String lineaReserva;
  private String beneficiarioPago;
  private String metodoPago;
  private String soloSura;
  private String tipoPago;

  public AnulacionEmpresarial() {
    super();
  }

  public AnulacionEmpresarial(List<Map<String, String>> datosPagosEmpresariales) {
    asignarDatos(datosPagosEmpresariales);
  }

  private AnulacionEmpresarial(Map<String, String> datosAnulacionEmpresarial) {
    super(datosAnulacionEmpresarial);

    this.lineaReserva = datosAnulacionEmpresarial.get("lineaReserva");
    this.beneficiarioPago = datosAnulacionEmpresarial.get("beneficiarioPago");
    this.metodoPago = datosAnulacionEmpresarial.get("metodoPago");
    this.soloSura = datosAnulacionEmpresarial.get("soloSura");
    this.tipoPago = datosAnulacionEmpresarial.get("tipoPago");
  }

  public String getTipoPago() {
    return tipoPago;
  }

  public String getLineaReserva() {
    return lineaReserva;
  }

  public String getBeneficiarioPago() {
    return beneficiarioPago;
  }

  public String getMetodoPago() {
    return metodoPago;
  }

  public String getSoloSura() {
    return soloSura;
  }

  public List<AnulacionEmpresarial> getLstAnulacionEmpresarial() {
    return lstAnulacionEmpresarial;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstAnulacionEmpresarial.add(new AnulacionEmpresarial(dato));
    }
  }
}
