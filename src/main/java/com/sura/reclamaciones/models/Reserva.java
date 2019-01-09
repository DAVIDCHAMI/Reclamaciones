package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reserva {

  private List<Reserva> lstReserva = new ArrayList<>();
  private String numeroReclamacion;
  private String monedaReserva;
  private String lineaReserva;
  private String valorReserva;
  private String datoDevolverTablaDatosFinancieros;
  private String valorDeducible;

  public Reserva(Map<String, String> datosReserva) {
    this.numeroReclamacion = datosReserva.get("numeroReclamacion");
    this.monedaReserva = datosReserva.get("monedaReserva");
    this.lineaReserva = datosReserva.get("lineaReserva");
    this.valorReserva = datosReserva.get("valorReserva");
    this.datoDevolverTablaDatosFinancieros = datosReserva.get("datoDevolver");
    this.valorDeducible = datosReserva.get("valorDeducible");
  }

  public Reserva(List<Map<String, String>> datosReclamaciones) {
    asignarDatos(datosReclamaciones);
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getMonedaReserva() {
    return monedaReserva;
  }

  public List<Reserva> getLstReserva() {
    return lstReserva;
  }

  public String getValorDeducible() {
    return valorDeducible;
  }

  public String getLineaReserva() {
    return lineaReserva;
  }

  public String getValorReserva() {
    return valorReserva;
  }

  public String getDatoDevolverTablaDatosFinancieros() {
    return datoDevolverTablaDatosFinancieros;
  }

  private void asignarDatos(List<Map<String, String>> datosReserva) {
    for (Map<String, String> dato : datosReserva) {
      lstReserva.add(new Reserva(dato));
    }
  }
}
