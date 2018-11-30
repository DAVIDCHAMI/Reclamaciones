package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaReclamacionAuto extends Persona {

  private List<PersonaReclamacionAuto> lstPersonaReclamacionAuto = new ArrayList<>();

  public PersonaReclamacionAuto() {
    super();
  }

  public PersonaReclamacionAuto(List<Map<String, String>> datosPersonaReclamacionAuto) {
    super();
    asignarDatos(datosPersonaReclamacionAuto);
  }

  private PersonaReclamacionAuto(Map<String, String> datosPersonaReclamacionAuto) {
    super(datosPersonaReclamacionAuto);
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
