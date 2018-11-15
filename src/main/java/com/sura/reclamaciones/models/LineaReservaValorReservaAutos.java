package com.sura.reclamaciones.models;

import java.util.List;
import java.util.Map;

public class LineaReservaAutos {

    private String lineaReservaDaños;
    private String lineaReservaDañosVehRC;
    private String lineaReservaLesionesCorpRC;
    private String lineaReservaVehiculoReempPT;
    private String lineaReservaVehiculoReempPP;
    private String lineaReservaPTHurto;
    private String lineaReservaGastosTransp;
    private String valorReservaDaños;
    private String valorReservaDañosVehRC;
    private String valorReservaLesionesCorpRC;
    private String valorReservaVehiculoReempPT;
    private String valorReservaVehiculoReempPP;
    private String valorReservaPTHurto;
    private String valorReservaGastosTransp;

    public String getLineaReservaDaños() {
        return lineaReservaDaños;
    }

    public String getLineaReservaDañosVehRC() {
        return lineaReservaDañosVehRC;
    }

    public String getLineaReservaLesionesCorpRC() {
        return lineaReservaLesionesCorpRC;
    }

    public String getLineaReservaVehiculoReempPT() {
        return lineaReservaVehiculoReempPT;
    }

    public String getLineaReservaVehiculoReempPP() {
        return lineaReservaVehiculoReempPP;
    }

    public String getLineaReservaPTHurto() {
        return lineaReservaPTHurto;
    }

    public String getLineaReservaGastosTransp() {
        return lineaReservaGastosTransp;
    }

    public String getValorReservaDaños() {
        return valorReservaDaños;
    }

    public String getValorReservaDañosVehRC() {
        return valorReservaDañosVehRC;
    }

    public String getValorReservaLesionesCorpRC() {
        return valorReservaLesionesCorpRC;
    }

    public String getValorReservaVehiculoReempPT() {
        return valorReservaVehiculoReempPT;
    }

    public String getValorReservaVehiculoReempPP() {
        return valorReservaVehiculoReempPP;
    }

    public String getValorReservaPTHurto() {
        return valorReservaPTHurto;
    }

    public String getValorReservaGastosTransp() {
        return valorReservaGastosTransp;
    }

  public LineaReservaAutos(){super();}

  private LineaReservaAutos(Map<String,String> datosReservaAutos ){
        this.lineaReservaDaños = datosReservaAutos.get("lineaReservaDaños");
        this.lineaReservaDañosVehRC = datosReservaAutos.get("lineaReservaDañosVehRC");
        this.lineaReservaLesionesCorpRC = datosReservaAutos.get("lineaReservaLesionesCorpRC");
        this.lineaReservaVehiculoReempPT = datosReservaAutos.get("lineaReservaVehiculoReempPT");
        this.lineaReservaVehiculoReempPP = datosReservaAutos.get("lineaReservaVehiculoReempPP");
  }

}
