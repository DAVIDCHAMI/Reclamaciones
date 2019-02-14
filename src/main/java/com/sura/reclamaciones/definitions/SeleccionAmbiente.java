package com.sura.reclamaciones.definitions;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
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
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_EMPRESARIAL);
    } else if (ConstanteGlobal.DESARROLLO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@claimsEmpresarialSuperUsuario")
  public void seleccionarAmbienteEmpresarialSuperUsuario() throws IOException {
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO);
    } else if (ConstanteGlobal.DESARROLLO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@claimsAuto")
  public void seleccionarAmbienteAuto() throws IOException {
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_AUTO);
    } else if (ConstanteGlobal.DESARROLLO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@ATR")
  public void seleccionarAmbienteATR() throws IOException {
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginAtrStep.obtenerCredenciales(ConstanteGlobal.ANALISTA_RECLAMACION_ATR);
    }
  }
}
