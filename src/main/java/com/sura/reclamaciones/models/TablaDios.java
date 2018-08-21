package com.sura.reclamaciones.models;

public class TablaDios {
    private String cdPoliza;
    private String cdMovimiento;
    private String dsResultadoValidacion;
    private String feMensajeCore;
    private String feMensajeSAP;
    private String feContabilizacion;

    public String getCdPoliza() {
        return cdPoliza;
    }

    public String getCdMovimiento() {
        return cdMovimiento;
    }

    public String getDsResultadoValidacion() {
        return dsResultadoValidacion;
    }

    public String getFeMensajeCore() {
        return feMensajeCore;
    }

    public String getFeMensajeSAP() {
        return feMensajeSAP;
    }

    public String getFeContabilizacion() {
        return feContabilizacion;
    }

    public void setCdPoliza(String cdPoliza) {
        this.cdPoliza = cdPoliza;
    }

    public void setCdMovimiento(String cdMovimiento) {
        this.cdMovimiento = cdMovimiento;
    }

    public void setDsResultadoValidacion(String dsResultadoValidacion) {
        this.dsResultadoValidacion = dsResultadoValidacion;
    }

    public void setFeMensajeCore(String feMensajeCore) {
        this.feMensajeCore = feMensajeCore;
    }

    public void setFeMensajeSAP(String feMensajeSAP) {
        this.feMensajeSAP = feMensajeSAP;
    }

    public void setFeContabilizacion(String feContabilizacion) {
        this.feContabilizacion = feContabilizacion;
    }
}