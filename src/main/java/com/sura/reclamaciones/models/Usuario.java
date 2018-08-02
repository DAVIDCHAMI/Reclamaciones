package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {

  private String usuario;
  private String contrasena;
  private List<Usuario> usuarios = new ArrayList<>();

  public Usuario() {}

  private Usuario(Map<String, String> datosUsuario) {
    this.usuario = datosUsuario.get("usuario");
    this.contrasena = datosUsuario.get("contrasena");
  }

  public Usuario(List<Map<String, String>> datosUsuario) {
    asignarDatos(datosUsuario);
  }

  public String getUsuario() {
    return usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void asignarDatos(List<Map<String, String>> datosUsuario) {
    for (Map<String, String> dato : datosUsuario) {
      usuarios.add(new Usuario(dato));
    }
  }
}
