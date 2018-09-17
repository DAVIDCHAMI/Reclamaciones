package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificado {

  public String numeroMovimientoFinanciero;
  public String numeroReclamacion;
  public String valorCedidoReaseguradoras;
  public String valorNeto;
  public String valorMovimientoFinanciero;
  private List<ModeloSimplificado> lstModeloSimplificado = new ArrayList<>();

  private ModeloSimplificado(Map<String, String> datosModeloSimplificado) {
    this.numeroReclamacion = datosModeloSimplificado.get("numeroReclamacion");
    this.numeroMovimientoFinanciero = datosModeloSimplificado.get("numeroMovimientoFinanciero");
    this.valorMovimientoFinanciero = datosModeloSimplificado.get("valorMovimientoFinanciero");
    this.valorCedidoReaseguradoras = datosModeloSimplificado.get("valorCedidoReaseguradoras");
    this.valorNeto = datosModeloSimplificado.get("valorNeto");
  }

  public ModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
    asignarDatos(datosModeloSimplificado);
  }

  public ModeloSimplificado() {}

  public String getTransaccion() {
    return numeroMovimientoFinanciero;
  }

  public String getValorMovimientoFinanciero() {
    return valorMovimientoFinanciero;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public List<ModeloSimplificado> getlstModeloSimplificado() {
    return lstModeloSimplificado;
  }

  public void asignarDatos(List<Map<String, String>> datosModeloSimplificado) {
    for (Map<String, String> dato : datosModeloSimplificado) {
      lstModeloSimplificado.add(new ModeloSimplificado(dato));
    }
  }
}
