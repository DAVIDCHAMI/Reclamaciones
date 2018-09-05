package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CredencialBD {

  private String usuario;
  private String contrasena;
  private String URL;
  private String driver;
  private List<CredencialBD> credenciales = new ArrayList<>();

  public CredencialBD() {}

  private CredencialBD(Map<String, String> datosUsuario) {
    this.usuario = datosUsuario.get("usuario");
    this.contrasena = datosUsuario.get("contrasena");
    this.URL = datosUsuario.get("URL");
    this.driver = datosUsuario.get("driver");
  }

  public CredencialBD(List<Map<String, String>> datosUsuario) {
    asignarDatos(datosUsuario);
  }

  public String getUsuario() {
    return usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public String getURL() {
    return URL;
  }

  public String getDriver() {
    return driver;
  }

  public List<CredencialBD> getCredenciales() {
    return credenciales;
  }

  public void asignarDatos(List<Map<String, String>> datosUsuario) {
    for (Map<String, String> dato : datosUsuario) {
      credenciales.add(new CredencialBD(dato));
    }
  }
}