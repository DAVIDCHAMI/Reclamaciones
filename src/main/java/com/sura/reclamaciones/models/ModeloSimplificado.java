package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificado {

  private String transaccion;
  private String valorTransaccion;
  private String valorCedidoReaseguradoras;
  private String valorNeto;
  private List<ModeloSimplificado> lstModeloSimplificado = new ArrayList<>();

  public ModeloSimplificado(Map<String, String> datosModeloSimplificado) {
    super();
    this.transaccion= datosModeloSimplificado.get("numeroTransaccion");
    this.valorTransaccion= datosModeloSimplificado.get("valorTransaccion");
    this.valorCedidoReaseguradoras= datosModeloSimplificado.get("valorCedidoReaseguradoras");
    this.valorNeto= datosModeloSimplificado.get("valorNeto");
  }

  public ModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
    asignarDatos(datosModeloSimplificado);
  }

  public String getTransaccion() {
    return transaccion; }

  public void setTransaccion(String transaccion) {
    this.transaccion = transaccion;
  }

  public String getValorTransaccion() {
    return valorTransaccion;
  }

  public void setValorTransaccion(String valorTransaccion) {
    this.valorTransaccion = valorTransaccion;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public void setValorCedidoReaseguradoras(String valorCedidoReaseguradoras) {
    this.valorCedidoReaseguradoras = valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
  }

  public void setValorNeto(String valorNeto) {
    this.valorNeto = valorNeto;
  }

  public List<ModeloSimplificado> getlstModeloSimplificado() {
    return lstModeloSimplificado;
  }

  private void asignarDatos(List<Map<String, String>> datosModeloSimplificado) {
    for (Map<String, String> dato : datosModeloSimplificado) {
      lstModeloSimplificado.add(new ModeloSimplificado(dato));
    }
  }
}
