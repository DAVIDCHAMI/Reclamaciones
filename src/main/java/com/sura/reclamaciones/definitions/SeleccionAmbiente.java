package com.sura.reclamaciones.definitions;

import static com.sura.reclamaciones.constantes.Constantes.ANALISTA_RECLAMACION_ATR;
import static com.sura.reclamaciones.constantes.Constantes.ANALISTA_RECLAMACION_AUTO;
import static com.sura.reclamaciones.constantes.Constantes.ANALISTA_RECLAMACION_EMPRESARIAL;
import static com.sura.reclamaciones.constantes.Constantes.DESARROLLO;
import static com.sura.reclamaciones.constantes.Constantes.LABORATORIO;

import com.sura.reclamaciones.steps.login.LoginAtrStep;
import com.sura.reclamaciones.steps.login.LoginClaimStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import cucumber.api.java.Before;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class SeleccionAmbiente {

  @Steps LoginClaimStep loginClaimStep;

  @Steps LoginAtrStep loginAtrStep;

  AmbientesUtil ambientesUtil = new AmbientesUtil();

  @Before("@claimsEmpresarial")
  public void seleccionarAmbienteEmpresarial() throws IOException {
    if (LABORATORIO.getValor().equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ANALISTA_RECLAMACION_EMPRESARIAL.getValor());
    } else if (DESARROLLO.getValor().equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@claimsAuto")
  public void seleccionarAmbienteAuto() throws IOException {
    if (LABORATORIO.getValor().equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ANALISTA_RECLAMACION_AUTO.getValor());
    } else if (DESARROLLO.getValor().equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@ATR")
  public void seleccionarAmbienteATR() throws IOException {
    if (LABORATORIO.getValor().equals(ambientesUtil.getAmbiente())) {
      loginAtrStep.obtenerCredenciales(ANALISTA_RECLAMACION_ATR.getValor());
    }
  }
}
