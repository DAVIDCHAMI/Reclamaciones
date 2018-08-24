package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificado {

  private String numeroTransaccion;
  private String valorTransaccion;
  private String valorCedidoReaseguradoras;
  private String valorNeto;
  private List<ModeloSimplificado> lstModeloSimplificado = new ArrayList<>();

  public ModeloSimplificado(Map<String, String> datosModeloSimplificado) {
    super();
    this.numeroTransaccion = datosModeloSimplificado.get("numeroTransaccion");
    this.valorTransaccion = datosModeloSimplificado.get("valorTransaccion");
    this.valorCedidoReaseguradoras = datosModeloSimplificado.get("valorCedidoReaseguradoras");
    this.valorNeto = datosModeloSimplificado.get("valorNeto");
  }

  public ModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
    asignarDatos(datosModeloSimplificado);
  }

  public ModeloSimplificado() {}

  public String getTransaccion() {
    return numeroTransaccion;
  }

  public String getValorTransaccion() {
    return valorTransaccion;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
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
