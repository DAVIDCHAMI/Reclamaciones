package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificadoBD {

  private String numeroTransaccion;
  private String numeroReclamacion;
  private String valorCedidoReaseguradoras;
  private String valorNeto;
  private String valorTransaccion;
  private List<ModeloSimplificadoBD> lstModeloSimplificadoBD = new ArrayList<>();

  public ModeloSimplificadoBD() {}

  private ModeloSimplificadoBD(Map<String, String> datosTablaModeloSimplificado) {
    this.numeroTransaccion = datosTablaModeloSimplificado.get("REFERENCE");
    this.numeroReclamacion = datosTablaModeloSimplificado.get("CLAIMNUMBER");
    this.valorCedidoReaseguradoras = datosTablaModeloSimplificado.get("CEDEDREINSURANCE");
    this.valorNeto = datosTablaModeloSimplificado.get("NETAMOUNT");
    this.valorTransaccion = datosTablaModeloSimplificado.get("AMOUNT");
  }

  public ModeloSimplificadoBD(List<Map<String, String>> datosTablaCuadre) {
    asignarDatos(datosTablaCuadre);
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
  }

  public String getValorTransaccion() {
    return valorTransaccion;
  }

  public String getNumeroTransaccion() {
    return numeroTransaccion;
  }

  public List<ModeloSimplificadoBD> getLstModeloSimplificadoBD() {
    return lstModeloSimplificadoBD;
  }

  private void asignarDatos(List<Map<String, String>> datosTablaModeloSimplificado) {
    for (Map<String, String> dato : datosTablaModeloSimplificado) {
      lstModeloSimplificadoBD.add(new ModeloSimplificadoBD(dato));
    }
  }
}
