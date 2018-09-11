package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reserva {

  private List<Reserva> lstReservaEmp = new ArrayList<>();
  private String numeroReclamacion;
  private String monedaReserva;

  private Reserva(Map<String, String> datosReservaEmp) {
    this.numeroReclamacion = datosReservaEmp.get("numeroReclamacion");
    this.monedaReserva = datosReservaEmp.get("monedaReserva");
  }

  public Reserva(List<Map<String, String>> datosReclamacionesEmp) {
    asignarDatos(datosReclamacionesEmp);
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getMonedaReserva() {
    return monedaReserva;
  }

  public List<Reserva> getLstReclamo() {
    return lstReservaEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosReservaEmp) {
    for (Map<String, String> dato : datosReservaEmp) {
      lstReservaEmp.add(new Reserva(dato));
    }
  }
}
