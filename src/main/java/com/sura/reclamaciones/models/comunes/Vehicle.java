package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
  "vehicleNumber",
  "planCode",
  "vin",
  "make",
  "model",
  "year",
  "license",
  "licenseState",
  "fasecoldaCode",
  "engine",
  "chasis",
  "vehicleType",
  "vehicleServiceCode",
  "vehicleZeroKm",
  "concessionaire",
  "transportsFuel",
  "trailer",
  "imported",
  "foreignEnrollment",
  "armoredVehicle",
  "deviceOff",
  "zoneCode",
  "cityCirculationCode",
  "valueAccessories",
  "specialValueAccessories",
  "costNew",
  "transportFuel",
  "stateValue",
  "rateGroup",
  "inspection",
  "modifiers",
  "lobs",
  "brandCode",
  "Potency",
  "CylinderCapacity",
  "GearboxType",
  "NumberAirBag",
  "Passengers",
  "NumberDriveShaft",
  "FuelType",
  "primaryUseCode",
  "isConcessionaire",
  "isPlateChange",
  "keyCode1",
  "keyCode3",
  "keyCode4",
  "keyCode7"
})
public class Vehicle implements Serializable {

  @JsonProperty("vehicleNumber")
  private Integer vehicleNumber;

  @JsonProperty("planCode")
  private String planCode;

  @JsonProperty("vin")
  private String vin;

  @JsonProperty("make")
  private String make;

  @JsonProperty("model")
  private String model;

  @JsonProperty("year")
  private String year;

  @JsonProperty("license")
  private String license;

  @JsonProperty("licenseState")
  private Object licenseState;

  @JsonProperty("fasecoldaCode")
  private String fasecoldaCode;

  @JsonProperty("engine")
  private String engine;

  @JsonProperty("chasis")
  private String chasis;

  @JsonProperty("vehicleType")
  private String vehicleType;

  @JsonProperty("vehicleServiceCode")
  private String vehicleServiceCode;

  @JsonProperty("vehicleZeroKm")
  private Boolean vehicleZeroKm;

  @JsonProperty("concessionaire")
  private Object concessionaire;

  @JsonProperty("transportsFuel")
  private Boolean transportsFuel;

  @JsonProperty("trailer")
  private Boolean trailer;

  @JsonProperty("imported")
  private Boolean imported;

  @JsonProperty("foreignEnrollment")
  private Boolean foreignEnrollment;

  @JsonProperty("armoredVehicle")
  private Boolean armoredVehicle;

  @JsonProperty("deviceOff")
  private Object deviceOff;

  @JsonProperty("zoneCode")
  private String zoneCode;

  @JsonProperty("cityCirculationCode")
  private String cityCirculationCode;

  @JsonProperty("valueAccessories")
  private ValueAccessories valueAccessories;

  @JsonProperty("specialValueAccessories")
  private SpecialValueAccessories specialValueAccessories;

  @JsonProperty("costNew")
  private CostNew costNew;

  @JsonProperty("transportFuel")
  private Boolean transportFuel;

  @JsonProperty("stateValue")
  private StateValue stateValue;

  @JsonProperty("rateGroup")
  private String rateGroup;

  @JsonProperty("inspection")
  private Boolean inspection;

  @JsonProperty("modifiers")
  private List<Modifier> modifiers = null;

  @JsonProperty("lobs")
  private Lobs lobs;

  @JsonProperty("brandCode")
  private String brandCode;

  @JsonProperty("Potency")
  private String potency;

  @JsonProperty("CylinderCapacity")
  private String cylinderCapacity;

  @JsonProperty("GearboxType")
  private String gearboxType;

  @JsonProperty("NumberAirBag")
  private String numberAirBag;

  @JsonProperty("Passengers")
  private String passengers;

  @JsonProperty("NumberDriveShaft")
  private String numberDriveShaft;

  @JsonProperty("FuelType")
  private String fuelType;

  @JsonProperty("primaryUseCode")
  private Object primaryUseCode;

  @JsonProperty("isConcessionaire")
  private Object isConcessionaire;

  @JsonProperty("isPlateChange")
  private Object isPlateChange;

  @JsonProperty("keyCode1")
  private String keyCode1;

  @JsonProperty("keyCode3")
  private String keyCode3;

  @JsonProperty("keyCode4")
  private String keyCode4;

  @JsonProperty("keyCode7")
  private String keyCode7;

  private static final long serialVersionUID = -3460085803239088011L;

  public Vehicle() {
    // constructor
  }

  @JsonProperty("vehicleNumber")
  public Integer getVehicleNumber() {
    return this.vehicleNumber;
  }

  @JsonProperty("vehicleNumber")
  public void setVehicleNumber(Integer vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  @JsonProperty("planCode")
  public String getPlanCode() {
    return this.planCode;
  }

  @JsonProperty("planCode")
  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  @JsonProperty("vin")
  public String getVin() {
    return this.vin;
  }

  @JsonProperty("vin")
  public void setVin(String vin) {
    this.vin = vin;
  }

  @JsonProperty("make")
  public String getMake() {
    return this.make;
  }

  @JsonProperty("make")
  public void setMake(String make) {
    this.make = make;
  }

  @JsonProperty("model")
  public String getModel() {
    return this.model;
  }

  @JsonProperty("model")
  public void setModel(String model) {
    this.model = model;
  }

  @JsonProperty("year")
  public String getYear() {
    return this.year;
  }

  @JsonProperty("year")
  public void setYear(String year) {
    this.year = year;
  }

  @JsonProperty("license")
  public String getLicense() {
    return this.license;
  }

  @JsonProperty("license")
  public void setLicense(String license) {
    this.license = license;
  }

  @JsonProperty("licenseState")
  public Object getLicenseState() {
    return this.licenseState;
  }

  @JsonProperty("licenseState")
  public void setLicenseState(Object licenseState) {
    this.licenseState = licenseState;
  }

  @JsonProperty("fasecoldaCode")
  public String getFasecoldaCode() {
    return this.fasecoldaCode;
  }

  @JsonProperty("fasecoldaCode")
  public void setFasecoldaCode(String fasecoldaCode) {
    this.fasecoldaCode = fasecoldaCode;
  }

  @JsonProperty("engine")
  public String getEngine() {
    return this.engine;
  }

  @JsonProperty("engine")
  public void setEngine(String engine) {
    this.engine = engine;
  }

  @JsonProperty("chasis")
  public String getChasis() {
    return this.chasis;
  }

  @JsonProperty("chasis")
  public void setChasis(String chasis) {
    this.chasis = chasis;
  }

  @JsonProperty("vehicleType")
  public String getVehicleType() {
    return this.vehicleType;
  }

  @JsonProperty("vehicleType")
  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  @JsonProperty("vehicleServiceCode")
  public String getVehicleServiceCode() {
    return this.vehicleServiceCode;
  }

  @JsonProperty("vehicleServiceCode")
  public void setVehicleServiceCode(String vehicleServiceCode) {
    this.vehicleServiceCode = vehicleServiceCode;
  }

  @JsonProperty("vehicleZeroKm")
  public Boolean getVehicleZeroKm() {
    return this.vehicleZeroKm;
  }

  @JsonProperty("vehicleZeroKm")
  public void setVehicleZeroKm(Boolean vehicleZeroKm) {
    this.vehicleZeroKm = vehicleZeroKm;
  }

  @JsonProperty("concessionaire")
  public Object getConcessionaire() {
    return this.concessionaire;
  }

  @JsonProperty("concessionaire")
  public void setConcessionaire(Object concessionaire) {
    this.concessionaire = concessionaire;
  }

  @JsonProperty("transportsFuel")
  public Boolean getTransportsFuel() {
    return this.transportsFuel;
  }

  @JsonProperty("transportsFuel")
  public void setTransportsFuel(Boolean transportsFuel) {
    this.transportsFuel = transportsFuel;
  }

  @JsonProperty("trailer")
  public Boolean getTrailer() {
    return this.trailer;
  }

  @JsonProperty("trailer")
  public void setTrailer(Boolean trailer) {
    this.trailer = trailer;
  }

  @JsonProperty("imported")
  public Boolean getImported() {
    return this.imported;
  }

  @JsonProperty("imported")
  public void setImported(Boolean imported) {
    this.imported = imported;
  }

  @JsonProperty("foreignEnrollment")
  public Boolean getForeignEnrollment() {
    return this.foreignEnrollment;
  }

  @JsonProperty("foreignEnrollment")
  public void setForeignEnrollment(Boolean foreignEnrollment) {
    this.foreignEnrollment = foreignEnrollment;
  }

  @JsonProperty("armoredVehicle")
  public Boolean getArmoredVehicle() {
    return this.armoredVehicle;
  }

  @JsonProperty("armoredVehicle")
  public void setArmoredVehicle(Boolean armoredVehicle) {
    this.armoredVehicle = armoredVehicle;
  }

  @JsonProperty("deviceOff")
  public Object getDeviceOff() {
    return this.deviceOff;
  }

  @JsonProperty("deviceOff")
  public void setDeviceOff(Object deviceOff) {
    this.deviceOff = deviceOff;
  }

  @JsonProperty("zoneCode")
  public String getZoneCode() {
    return this.zoneCode;
  }

  @JsonProperty("zoneCode")
  public void setZoneCode(String zoneCode) {
    this.zoneCode = zoneCode;
  }

  @JsonProperty("cityCirculationCode")
  public String getCityCirculationCode() {
    return this.cityCirculationCode;
  }

  @JsonProperty("cityCirculationCode")
  public void setCityCirculationCode(String cityCirculationCode) {
    this.cityCirculationCode = cityCirculationCode;
  }

  @JsonProperty("valueAccessories")
  public ValueAccessories getValueAccessories() {
    return this.valueAccessories;
  }

  @JsonProperty("valueAccessories")
  public void setValueAccessories(ValueAccessories valueAccessories) {
    this.valueAccessories = valueAccessories;
  }

  @JsonProperty("specialValueAccessories")
  public SpecialValueAccessories getSpecialValueAccessories() {
    return this.specialValueAccessories;
  }

  @JsonProperty("specialValueAccessories")
  public void setSpecialValueAccessories(SpecialValueAccessories specialValueAccessories) {
    this.specialValueAccessories = specialValueAccessories;
  }

  @JsonProperty("costNew")
  public CostNew getCostNew() {
    return this.costNew;
  }

  @JsonProperty("costNew")
  public void setCostNew(CostNew costNew) {
    this.costNew = costNew;
  }

  @JsonProperty("transportFuel")
  public Boolean getTransportFuel() {
    return this.transportFuel;
  }

  @JsonProperty("transportFuel")
  public void setTransportFuel(Boolean transportFuel) {
    this.transportFuel = transportFuel;
  }

  @JsonProperty("stateValue")
  public StateValue getStateValue() {
    return this.stateValue;
  }

  @JsonProperty("stateValue")
  public void setStateValue(StateValue stateValue) {
    this.stateValue = stateValue;
  }

  @JsonProperty("rateGroup")
  public String getRateGroup() {
    return this.rateGroup;
  }

  @JsonProperty("rateGroup")
  public void setRateGroup(String rateGroup) {
    this.rateGroup = rateGroup;
  }

  @JsonProperty("inspection")
  public Boolean getInspection() {
    return this.inspection;
  }

  @JsonProperty("inspection")
  public void setInspection(Boolean inspection) {
    this.inspection = inspection;
  }

  @JsonProperty("modifiers")
  public List<Modifier> getModifiers() {
    return this.modifiers;
  }

  @JsonProperty("modifiers")
  public void setModifiers(List<Modifier> modifiers) {
    this.modifiers = modifiers;
  }

  @JsonProperty("lobs")
  public Lobs getLobs() {
    return this.lobs;
  }

  @JsonProperty("lobs")
  public void setLobs(Lobs lobs) {
    this.lobs = lobs;
  }

  @JsonProperty("brandCode")
  public String getBrandCode() {
    return this.brandCode;
  }

  @JsonProperty("brandCode")
  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode;
  }

  @JsonProperty("Potency")
  public String getPotency() {
    return potency;
  }

  @JsonProperty("Potency")
  public void setPotency(String potency) {
    this.potency = potency;
  }

  @JsonProperty("CylinderCapacity")
  public String getCylinderCapacity() {
    return cylinderCapacity;
  }

  @JsonProperty("CylinderCapacity")
  public void setCylinderCapacity(String cylinderCapacity) {
    this.cylinderCapacity = cylinderCapacity;
  }

  @JsonProperty("GearboxType")
  public String getGearboxType() {
    return gearboxType;
  }

  @JsonProperty("GearboxType")
  public void setGearboxType(String gearboxType) {
    this.gearboxType = gearboxType;
  }

  @JsonProperty("NumberAirBag")
  public String getNumberAirBag() {
    return numberAirBag;
  }

  @JsonProperty("NumberAirBag")
  public void setNumberAirBag(String numberAirBag) {
    this.numberAirBag = numberAirBag;
  }

  @JsonProperty("Passengers")
  public String getPassengers() {
    return passengers;
  }

  @JsonProperty("Passengers")
  public void setPassengers(String passengers) {
    this.passengers = passengers;
  }

  @JsonProperty("NumberDriveShaft")
  public String getNumberDriveShaft() {
    return numberDriveShaft;
  }

  @JsonProperty("NumberDriveShaft")
  public void setNumberDriveShaft(String numberDriveShaft) {
    this.numberDriveShaft = numberDriveShaft;
  }

  @JsonProperty("FuelType")
  public String getFuelType() {
    return fuelType;
  }

  @JsonProperty("FuelType")
  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  @JsonProperty("primaryUseCode")
  public Object getPrimaryUseCode() {
    return this.primaryUseCode;
  }

  @JsonProperty("primaryUseCode")
  public void setPrimaryUseCode(Object primaryUseCode) {
    this.primaryUseCode = primaryUseCode;
  }

  @JsonProperty("isConcessionaire")
  public Object getIsConcessionaire() {
    return this.isConcessionaire;
  }

  @JsonProperty("isConcessionaire")
  public void setIsConcessionaire(Object isConcessionaire) {
    this.isConcessionaire = isConcessionaire;
  }

  @JsonProperty("isPlateChange")
  public Object getIsPlateChange() {
    return this.isPlateChange;
  }

  @JsonProperty("isPlateChange")
  public void setIsPlateChange(Object isPlateChange) {
    this.isPlateChange = isPlateChange;
  }

  @JsonProperty("keyCode1")
  public String getKeyCode1() {
    return this.keyCode1;
  }

  @JsonProperty("keyCode1")
  public void setKeyCode1(String keyCode1) {
    this.keyCode1 = keyCode1;
  }

  @JsonProperty("keyCode3")
  public String getKeyCode3() {
    return this.keyCode3;
  }

  @JsonProperty("keyCode3")
  public void setKeyCode3(String keyCode3) {
    this.keyCode3 = keyCode3;
  }

  @JsonProperty("keyCode4")
  public String getKeyCode4() {
    return this.keyCode4;
  }

  @JsonProperty("keyCode4")
  public void setKeyCode4(String keyCode4) {
    this.keyCode4 = keyCode4;
  }

  @JsonProperty("keyCode7")
  public String getKeyCode7() {
    return this.keyCode7;
  }

  @JsonProperty("keyCode7")
  public void setKeyCode7(String keyCode7) {
    this.keyCode7 = keyCode7;
  }
}
