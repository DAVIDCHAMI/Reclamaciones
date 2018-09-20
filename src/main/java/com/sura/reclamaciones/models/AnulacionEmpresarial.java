package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnulacionEmpresarial extends Transacciones {

  private List<AnulacionEmpresarial> lstAnulacionEmpresarial =
      new ArrayList<AnulacionEmpresarial>();
  private String numeroPago;
  private String estadoPrevio;
  private String comentario;

  public AnulacionEmpresarial() {
    super();
  }

  private AnulacionEmpresarial(Map<String, String> datosAnulacionEmpresarial) {
    super(datosAnulacionEmpresarial);
    this.numeroPago = datosAnulacionEmpresarial.get("numeroPago");
    this.estadoPrevio = datosAnulacionEmpresarial.get("estadoPrevio");
    this.comentario = datosAnulacionEmpresarial.get("comentario");

  }

  public String getNumeroPago() {
    return numeroPago;
  }

  public String getEstadoPrevio() {
    return estadoPrevio;
  }

  public String getComentario() { return comentario; }

  public AnulacionEmpresarial(List<Map<String, String>> datosPagosEmpresariales) {
    asignarDatos(datosPagosEmpresariales);
  }

  public List<AnulacionPagoEmpresarial> getLstAnulacionEmpresarial() {
    return lstAnulacionEmpresarial;
  }

  private void asignarDatos(List<Map<String, String>> datosPagosEmpresarial) {
    for (Map<String, String> dato : datosPagosEmpresarial) {
      lstAnulacionEmpresarial.add(new AnulacionEmpresarial(dato));
    }
  }
}
