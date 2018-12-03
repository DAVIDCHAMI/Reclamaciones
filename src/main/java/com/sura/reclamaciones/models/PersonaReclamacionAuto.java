package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaReclamacionAuto{

  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private String tipoDocumento;
  private String numeroDocumento;

  public String getPrimerNombre() {
    return primerNombre;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  private List<PersonaReclamacionAuto> lstPersonaReclamacionAuto = new ArrayList<>();

  public PersonaReclamacionAuto() {
    super();
  }

  public PersonaReclamacionAuto(List<Map<String, String>> datosPersonaReclamacionAuto) {
    super();
    asignarDatos(datosPersonaReclamacionAuto);
  }

  private PersonaReclamacionAuto(Map<String, String> datosPersonaReclamacionAuto) {
    this.primerNombre = datosPersonaReclamacionAuto.get("primerNombre");
    this.segundoNombre = datosPersonaReclamacionAuto.get("segundoNombre");
    this.primerApellido = datosPersonaReclamacionAuto.get("primerApellido");
    this.segundoApellido = datosPersonaReclamacionAuto.get("segundoApellido");
    this.tipoDocumento = datosPersonaReclamacionAuto.get("tipoDocumento");
    this.numeroDocumento = datosPersonaReclamacionAuto.get("numeroDocumento");
  }

  private void asignarDatos(List<Map<String, String>> datosPersonaReclamacionAuto) {
    for (Map<String, String> dato : datosPersonaReclamacionAuto) {
      lstPersonaReclamacionAuto.add(new PersonaReclamacionAuto(dato));
    }
  }

  public List<PersonaReclamacionAuto> getLstPersonaReclamacionAuto() {
    return lstPersonaReclamacionAuto;
  }
}
