package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"extraInformationToRate", "vehicles", "drivers", "vehicleCoverages"})
public class PersonalAuto implements Serializable {
  @JsonProperty("extraInformationToRate")
  private InformacionAdicionalAsegurado informacionAdicionalAsegurado;

  @JsonProperty("vehicles")
  private List<Vehicle> vehicles = null;

  @JsonProperty("drivers")
  private List<Driver> drivers = null;

  @JsonProperty("vehicleCoverages")
  private List<VehicleCoverage> vehicleCoverages = null;

  private static final long serialVersionUID = 7106716436388382251L;

  public InformacionAdicionalAsegurado getInformacionAdicionalAsegurado() {
    return informacionAdicionalAsegurado;
  }

  public void setInformacionAdicionalAsegurado(
      InformacionAdicionalAsegurado informacionAdicionalAsegurado) {
    this.informacionAdicionalAsegurado = informacionAdicionalAsegurado;
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public List<Driver> getDrivers() {
    return drivers;
  }

  public void setDrivers(List<Driver> drivers) {
    this.drivers = drivers;
  }

  public List<VehicleCoverage> getVehicleCoverages() {
    return vehicleCoverages;
  }

  public void setVehicleCoverages(List<VehicleCoverage> vehicleCoverages) {
    this.vehicleCoverages = vehicleCoverages;
  }
}
