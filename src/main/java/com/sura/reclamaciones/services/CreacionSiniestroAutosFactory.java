package com.sura.reclamaciones.services;

import com.sura.service.creacionSiniestroAuto.gen.Author;
import com.sura.service.creacionSiniestroAuto.gen.BodyPartDetail;
import com.sura.service.creacionSiniestroAuto.gen.ClaimsAutoRequest;
import com.sura.service.creacionSiniestroAuto.gen.Driver;
import com.sura.service.creacionSiniestroAuto.gen.Injured;
import com.sura.service.creacionSiniestroAuto.gen.InjuryIncident;
import com.sura.service.creacionSiniestroAuto.gen.Lobs;
import com.sura.service.creacionSiniestroAuto.gen.LossEstimate;
import com.sura.service.creacionSiniestroAuto.gen.LossLocation;
import com.sura.service.creacionSiniestroAuto.gen.MainContact;
import com.sura.service.creacionSiniestroAuto.gen.Parametros;
import com.sura.service.creacionSiniestroAuto.gen.PersonalAuto;
import com.sura.service.creacionSiniestroAuto.gen.PrimaryAddress;
import com.sura.service.creacionSiniestroAuto.gen.PrimaryAddress_;
import com.sura.service.creacionSiniestroAuto.gen.PrimaryAddress__;
import com.sura.service.creacionSiniestroAuto.gen.Vehicle;
import com.sura.service.creacionSiniestroAuto.gen.VehicleIncident;
import java.util.ArrayList;
import java.util.List;

public class CreacionSiniestroAutosFactory {

  private static final String ID_SERVICIO_CLAIM = "6";
  private static final String METHOD_CREATE_CLAIM = "createClaim";
  private static final String LOSS_TYPE_AUTOS = "AUTO";
  private static final String JSONRPC_2 = "2.0";

  private String policyNumber;
  private String description;
  private String notificationDate;
  private String lossDate;
  private String authorUser;
  private String lossCause;
  private String macaNumber;
  private String faultRating;
  private String originCause;
  private String segment;
  private String authorityTransit;
  private String documentType;
  private String taxIDAuthor;
  private String authorName;
  private int amountLossEstimate;
  private String currencyLossEstimate;
  private String documentTypeMainContact;
  private String taxIDMainContact;
  private String emailAddress1MainContact;
  private String cellNumberMaincontact;
  private String firstNameMainContact;
  private String middleNameMainContact;
  private String lastNameMainContact;
  private String secondLastNameMainContact;
  private String workNumberMainContact;
  private String policyRoleMainContact;
  private String addressLine1MainContact;
  private String addressTypeMainContact;
  private String cityMainContact;
  private String descriptionVehicleIncident;
  private String repairShopVehicleIncident;
  private String lossPartyVehicleIncident;
  private String driverRelationVehicleIncident;
  private String firstNameDriver;
  private String middleNameDriver;
  private String lastNameDriver;
  private String workNumberDriver;
  private String cellNumberDriver;
  private String emailAddress1Driver;
  private String policyRoleDriver;
  private String documentTypeDriver;
  private String taxIDDriver;
  private String addressLine1Driver;
  private String addressTypeDriver;
  private String cityDriver;
  private String licensePlateVehicle;
  private String makeVehicle;
  private String modelVehicle;
  private String engineNumberVehicle;
  private int yearVehicle;
  private String colorVehicle;
  private String vehicleType;
  private String fasecoldaCode;
  private String vinVehicle;
  private String lossPartyInjuryIncident;
  private String injuredInjuryIncident;
  private String severityInjuryIncident;
  private String descriptionInjuryIncident;
  private String generalInjuryType;
  private String detailedInjuryType;
  private String firstNameInjured;
  private String middleNameInjured;
  private String secondLastNameInjured;
  private String workNumberInjured;
  private String cellNumberInjured;
  private String emailAddress1Injured;
  private String documentTypeInjured;
  private String taxIDInjured;
  private String primaryBodyPart1;
  private String detailedBodyPartType1;
  private String primaryBodyPart2;
  private String detailedBodyPartType2;
  private String addressLine1Injured;
  private String addressTypeInjured;
  private String cityInjured;
  private String countryLossLocation;
  private String addressLine1LossLocation;
  private String cityLossLocation;
  private String stateMainContact;
  private String documentTypeAnt;
  private String contactNameAnt;
  private String taxIdAnt;
  private String emailAddress1Ant;
  private String cellNumberAnt;
  private String stateAnt;
  private String addressLine1Ant;
  private String cityAnt;

  public String getStateMainContact() {
    return stateMainContact;
  }

  public void setStateMainContact(String stateMainContact) {
    this.stateMainContact = stateMainContact;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNotificationDate() {
    return notificationDate;
  }

  public void setNotificationDate(String notificationDate) {
    this.notificationDate = notificationDate;
  }

  public String getLossDate() {
    return lossDate;
  }

  public void setLossDate(String lossDate) {
    this.lossDate = lossDate;
  }

  public String getAuthorUser() {
    return authorUser;
  }

  public void setAuthorUser(String authorUser) {
    this.authorUser = authorUser;
  }

  public String getLossCause() {
    return lossCause;
  }

  public void setLossCause(String lossCause) {
    this.lossCause = lossCause;
  }

  public String getMacaNumber() {
    return macaNumber;
  }

  public void setMacaNumber(String macaNumber) {
    this.macaNumber = macaNumber;
  }

  public String getFaultRating() {
    return faultRating;
  }

  public void setFaultRating(String faultRating) {
    this.faultRating = faultRating;
  }

  public String getOriginCause() {
    return originCause;
  }

  public void setOriginCause(String originCause) {
    this.originCause = originCause;
  }

  public String getSegment() {
    return segment;
  }

  public void setSegment(String segment) {
    this.segment = segment;
  }

  public String getAuthorityTransit() {
    return authorityTransit;
  }

  public void setAuthorityTransit(String authorityTransit) {
    this.authorityTransit = authorityTransit;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getTaxIDAuthor() {
    return taxIDAuthor;
  }

  public void setTaxIDAuthor(String taxIDAuthor) {
    this.taxIDAuthor = taxIDAuthor;
  }

  public int getAmountLossEstimate() {
    return amountLossEstimate;
  }

  public void setAmountLossEstimate(int amountLossEstimate) {
    this.amountLossEstimate = amountLossEstimate;
  }

  public String getCurrencyLossEstimate() {
    return currencyLossEstimate;
  }

  public void setCurrencyLossEstimate(String currencyLossEstimate) {
    this.currencyLossEstimate = currencyLossEstimate;
  }

  public String getDocumentTypeMainContact() {
    return documentTypeMainContact;
  }

  public void setDocumentTypeMainContact(String documentTypeMainContact) {
    this.documentTypeMainContact = documentTypeMainContact;
  }

  public String getTaxIDMainContact() {
    return taxIDMainContact;
  }

  public void setTaxIDMainContact(String taxIDMainContact) {
    this.taxIDMainContact = taxIDMainContact;
  }

  public String getEmailAddress1MainContact() {
    return emailAddress1MainContact;
  }

  public void setEmailAddress1MainContact(String emailAddress1MainContact) {
    this.emailAddress1MainContact = emailAddress1MainContact;
  }

  public String getCellNumberMaincontact() {
    return cellNumberMaincontact;
  }

  public void setCellNumberMaincontact(String cellNumberMaincontact) {
    this.cellNumberMaincontact = cellNumberMaincontact;
  }

  public String getFirstNameMainContact() {
    return firstNameMainContact;
  }

  public void setFirstNameMainContact(String firstNameMainContact) {
    this.firstNameMainContact = firstNameMainContact;
  }

  public String getMiddleNameMainContact() {
    return middleNameMainContact;
  }

  public void setMiddleNameMainContact(String middleNameMainContact) {
    this.middleNameMainContact = middleNameMainContact;
  }

  public String getLastNameMainContact() {
    return lastNameMainContact;
  }

  public void setLastNameMainContact(String lastNameMainContact) {
    this.lastNameMainContact = lastNameMainContact;
  }

  public String getSecondLastNameMainContact() {
    return secondLastNameMainContact;
  }

  public void setSecondLastNameMainContact(String secondLastNameMainContact) {
    this.secondLastNameMainContact = secondLastNameMainContact;
  }

  public String getWorkNumberMainContact() {
    return workNumberMainContact;
  }

  public void setWorkNumberMainContact(String workNumberMainContact) {
    this.workNumberMainContact = workNumberMainContact;
  }

  public String getPolicyRoleMainContact() {
    return policyRoleMainContact;
  }

  public void setPolicyRoleMainContact(String policyRoleMainContact) {
    this.policyRoleMainContact = policyRoleMainContact;
  }

  public String getAddressLine1MainContact() {
    return addressLine1MainContact;
  }

  public void setAddressLine1MainContact(String addressLine1MainContact) {
    this.addressLine1MainContact = addressLine1MainContact;
  }

  public String getAddressTypeMainContact() {
    return addressTypeMainContact;
  }

  public void setAddressTypeMainContact(String addressTypeMainContact) {
    this.addressTypeMainContact = addressTypeMainContact;
  }

  public String getCityMainContact() {
    return cityMainContact;
  }

  public void setCityMainContact(String cityMainContact) {
    this.cityMainContact = cityMainContact;
  }

  public String getDescriptionVehicleIncident() {
    return descriptionVehicleIncident;
  }

  public void setDescriptionVehicleIncident(String descriptionVehicleIncident) {
    this.descriptionVehicleIncident = descriptionVehicleIncident;
  }

  public String getRepairShopVehicleIncident() {
    return repairShopVehicleIncident;
  }

  public void setRepairShopVehicleIncident(String repairShopVehicleIncident) {
    this.repairShopVehicleIncident = repairShopVehicleIncident;
  }

  public String getLossPartyVehicleIncident() {
    return lossPartyVehicleIncident;
  }

  public void setLossPartyVehicleIncident(String lossPartyVehicleIncident) {
    this.lossPartyVehicleIncident = lossPartyVehicleIncident;
  }

  public String getDriverRelationVehicleIncident() {
    return driverRelationVehicleIncident;
  }

  public void setDriverRelationVehicleIncident(String driverRelationVehicleIncident) {
    this.driverRelationVehicleIncident = driverRelationVehicleIncident;
  }

  public String getFirstNameDriver() {
    return firstNameDriver;
  }

  public void setFirstNameDriver(String firstNameDriver) {
    this.firstNameDriver = firstNameDriver;
  }

  public String getMiddleNameDriver() {
    return middleNameDriver;
  }

  public void setMiddleNameDriver(String middleNameDriver) {
    this.middleNameDriver = middleNameDriver;
  }

  public String getLastNameDriver() {
    return lastNameDriver;
  }

  public void setLastNameDriver(String lastNameDriver) {
    this.lastNameDriver = lastNameDriver;
  }

  public String getWorkNumberDriver() {
    return workNumberDriver;
  }

  public void setWorkNumberDriver(String workNumberDriver) {
    this.workNumberDriver = workNumberDriver;
  }

  public String getCellNumberDriver() {
    return cellNumberDriver;
  }

  public void setCellNumberDriver(String cellNumberDriver) {
    this.cellNumberDriver = cellNumberDriver;
  }

  public String getEmailAddress1Driver() {
    return emailAddress1Driver;
  }

  public void setEmailAddress1Driver(String emailAddress1Driver) {
    this.emailAddress1Driver = emailAddress1Driver;
  }

  public String getPolicyRoleDriver() {
    return policyRoleDriver;
  }

  public void setPolicyRoleDriver(String policyRoleDriver) {
    this.policyRoleDriver = policyRoleDriver;
  }

  public String getDocumentTypeDriver() {
    return documentTypeDriver;
  }

  public void setDocumentTypeDriver(String documentTypeDriver) {
    this.documentTypeDriver = documentTypeDriver;
  }

  public String getTaxIDDriver() {
    return taxIDDriver;
  }

  public void setTaxIDDriver(String taxIDDriver) {
    this.taxIDDriver = taxIDDriver;
  }

  public String getAddressLine1Driver() {
    return addressLine1Driver;
  }

  public void setAddressLine1Driver(String addressLine1Driver) {
    this.addressLine1Driver = addressLine1Driver;
  }

  public String getAddressTypeDriver() {
    return addressTypeDriver;
  }

  public void setAddressTypeDriver(String addressTypeDriver) {
    this.addressTypeDriver = addressTypeDriver;
  }

  public String getCityDriver() {
    return cityDriver;
  }

  public void setCityDriver(String cityDriver) {
    this.cityDriver = cityDriver;
  }

  public String getLicensePlateVehicle() {
    return licensePlateVehicle;
  }

  public void setLicensePlateVehicle(String licensePlateVehicle) {
    this.licensePlateVehicle = licensePlateVehicle;
  }

  public String getMakeVehicle() {
    return makeVehicle;
  }

  public void setMakeVehicle(String makeVehicle) {
    this.makeVehicle = makeVehicle;
  }

  public String getModelVehicle() {
    return modelVehicle;
  }

  public void setModelVehicle(String modelVehicle) {
    this.modelVehicle = modelVehicle;
  }

  public String getEngineNumberVehicle() {
    return engineNumberVehicle;
  }

  public void setEngineNumberVehicle(String engineNumberVehicle) {
    this.engineNumberVehicle = engineNumberVehicle;
  }

  public int getYearVehicle() {
    return yearVehicle;
  }

  public void setYearVehicle(int yearVehicle) {
    this.yearVehicle = yearVehicle;
  }

  public String getColorVehicle() {
    return colorVehicle;
  }

  public void setColorVehicle(String colorVehicle) {
    this.colorVehicle = colorVehicle;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getFasecoldaCode() {
    return fasecoldaCode;
  }

  public void setFasecoldaCode(String fasecoldaCode) {
    this.fasecoldaCode = fasecoldaCode;
  }

  public String getVinVehicle() {
    return vinVehicle;
  }

  public void setVinVehicle(String vinVehicle) {
    this.vinVehicle = vinVehicle;
  }

  public String getLossPartyInjuryIncident() {
    return lossPartyInjuryIncident;
  }

  public void setLossPartyInjuryIncident(String lossPartyInjuryIncident) {
    this.lossPartyInjuryIncident = lossPartyInjuryIncident;
  }

  public String getInjuredInjuryIncident() {
    return injuredInjuryIncident;
  }

  public void setInjuredInjuryIncident(String injuredInjuryIncident) {
    this.injuredInjuryIncident = injuredInjuryIncident;
  }

  public String getSeverityInjuryIncident() {
    return severityInjuryIncident;
  }

  public void setSeverityInjuryIncident(String severityInjuryIncident) {
    this.severityInjuryIncident = severityInjuryIncident;
  }

  public String getDescriptionInjuryIncident() {
    return descriptionInjuryIncident;
  }

  public void setDescriptionInjuryIncident(String descriptionInjuryIncident) {
    this.descriptionInjuryIncident = descriptionInjuryIncident;
  }

  public String getGeneralInjuryType() {
    return generalInjuryType;
  }

  public void setGeneralInjuryType(String generalInjuryType) {
    this.generalInjuryType = generalInjuryType;
  }

  public String getDetailedInjuryType() {
    return detailedInjuryType;
  }

  public void setDetailedInjuryType(String detailedInjuryType) {
    this.detailedInjuryType = detailedInjuryType;
  }

  public String getFirstNameInjured() {
    return firstNameInjured;
  }

  public void setFirstNameInjured(String firstNameInjured) {
    this.firstNameInjured = firstNameInjured;
  }

  public String getMiddleNameInjured() {
    return middleNameInjured;
  }

  public void setMiddleNameInjured(String middleNameInjured) {
    this.middleNameInjured = middleNameInjured;
  }

  public String getSecondLastNameInjured() {
    return secondLastNameInjured;
  }

  public void setSecondLastNameInjured(String secondLastNameInjured) {
    this.secondLastNameInjured = secondLastNameInjured;
  }

  public String getWorkNumberInjured() {
    return workNumberInjured;
  }

  public void setWorkNumberInjured(String workNumberInjured) {
    this.workNumberInjured = workNumberInjured;
  }

  public String getCellNumberInjured() {
    return cellNumberInjured;
  }

  public void setCellNumberInjured(String cellNumberInjured) {
    this.cellNumberInjured = cellNumberInjured;
  }

  public String getEmailAddress1Injured() {
    return emailAddress1Injured;
  }

  public void setEmailAddress1Injured(String emailAddress1Injured) {
    this.emailAddress1Injured = emailAddress1Injured;
  }

  public String getDocumentTypeInjured() {
    return documentTypeInjured;
  }

  public void setDocumentTypeInjured(String documentTypeInjured) {
    this.documentTypeInjured = documentTypeInjured;
  }

  public String getTaxIDInjured() {
    return taxIDInjured;
  }

  public void setTaxIDInjured(String taxIDInjured) {
    this.taxIDInjured = taxIDInjured;
  }

  public String getPrimaryBodyPart1() {
    return primaryBodyPart1;
  }

  public void setPrimaryBodyPart1(String primaryBodyPart1) {
    this.primaryBodyPart1 = primaryBodyPart1;
  }

  public String getDetailedBodyPartType1() {
    return detailedBodyPartType1;
  }

  public void setDetailedBodyPartType1(String detailedBodyPartType1) {
    this.detailedBodyPartType1 = detailedBodyPartType1;
  }

  public String getPrimaryBodyPart2() {
    return primaryBodyPart2;
  }

  public void setPrimaryBodyPart2(String primaryBodyPart2) {
    this.primaryBodyPart2 = primaryBodyPart2;
  }

  public String getDetailedBodyPartType2() {
    return detailedBodyPartType2;
  }

  public void setDetailedBodyPartType2(String detailedBodyPartType2) {
    this.detailedBodyPartType2 = detailedBodyPartType2;
  }

  public String getAddressLine1Injured() {
    return addressLine1Injured;
  }

  public void setAddressLine1Injured(String addressLine1Injured) {
    this.addressLine1Injured = addressLine1Injured;
  }

  public String getAddressTypeInjured() {
    return addressTypeInjured;
  }

  public void setAddressTypeInjured(String addressTypeInjured) {
    this.addressTypeInjured = addressTypeInjured;
  }

  public String getCityInjured() {
    return cityInjured;
  }

  public void setCityInjured(String cityInjured) {
    this.cityInjured = cityInjured;
  }

  public String getCountryLossLocation() {
    return countryLossLocation;
  }

  public void setCountryLossLocation(String countryLossLocation) {
    this.countryLossLocation = countryLossLocation;
  }

  public String getAddressLine1LossLocation() {
    return addressLine1LossLocation;
  }

  public void setAddressLine1LossLocation(String addressLine1LossLocation) {
    this.addressLine1LossLocation = addressLine1LossLocation;
  }

  public String getCityLossLocation() {
    return cityLossLocation;
  }

  public void setCityLossLocation(String cityLossLocation) {
    this.cityLossLocation = cityLossLocation;
  }

  public String getAuthorName() {
    return cityLossLocation;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getDocumentTypeAnt() {
    return documentTypeAnt;
  }

  public void setDocumentTypeAnt(String documentTypeAnt) {
    this.documentTypeAnt = documentTypeAnt;
  }

  public String getContactNameAnt() {
    return contactNameAnt;
  }

  public void setContactNameAnt(String contactNameAnt) {
    this.contactNameAnt = contactNameAnt;
  }

  public String getTaxIdAnt() {
    return taxIdAnt;
  }

  public void setTaxIdAnt(String taxIdAnt) {
    this.taxIdAnt = taxIdAnt;
  }

  public String getEmailAddress1Ant() {
    return emailAddress1Ant;
  }

  public void setEmailAddress1Ant(String emailAddress1Ant) {
    this.emailAddress1Ant = emailAddress1Ant;
  }

  public String getCellNumberAnt() {
    return cellNumberAnt;
  }

  public void setCellNumberAnt(String cellNumberAnt) {
    this.cellNumberAnt = cellNumberAnt;
  }

  public String getStateAnt() {
    return stateAnt;
  }

  public void setStateAnt(String stateAnt) {
    this.stateAnt = stateAnt;
  }

  public String getAddressLine1Ant() {
    return addressLine1Ant;
  }

  public void setAddressLine1Ant(String addressLine1Ant) {
    this.addressLine1Ant = addressLine1Ant;
  }

  public String getCityAnt() {
    return cityAnt;
  }

  public void setCityAnt(String cityAnt) {
    this.cityAnt = cityAnt;
  }

  ClaimsAutoRequest creacionSiniestroAutoRequestFactory() {
    ClaimsAutoRequest crearSiniestroAutoRequest = new ClaimsAutoRequest();
    crearSiniestroAutoRequest.setId(ID_SERVICIO_CLAIM);
    crearSiniestroAutoRequest.setMethod(METHOD_CREATE_CLAIM);
    crearSiniestroAutoRequest.setParams(listParamFactory());
    crearSiniestroAutoRequest.setJsonrpc(JSONRPC_2);
    return crearSiniestroAutoRequest;
  }

  ClaimsAutoRequest creacionSiniestroAutoBadRequestFactory() {
    ClaimsAutoRequest claimsAutoRequest = new ClaimsAutoRequest();
    claimsAutoRequest.setId(ID_SERVICIO_CLAIM);
    claimsAutoRequest.setMethod(METHOD_CREATE_CLAIM);
    claimsAutoRequest.setParams(listBadParamFactory());
    claimsAutoRequest.setJsonrpc(JSONRPC_2);
    return claimsAutoRequest;
  }

  public List<Object> listParamFactory() {
    List<Object> listParams = new ArrayList<Object>();
    Parametros parametro = paramAutoFactory();
    listParams.add(getPolicyNumber());
    listParams.add(parametro);
    return listParams;
  }

  public List<Object> listBadParamFactory() {
    List<java.lang.Object> listParams = new ArrayList<java.lang.Object>();
    Parametros parametro = paramAutoFactory();
    listParams.add(parametro);
    return listParams;
  }

  Parametros paramAutoFactory() {
    Parametros parametro = new Parametros();
    parametro.setAuthor(authorFactory());
    parametro.setLossEstimate(lossEstimateFactory());
    parametro.setMainContact(mainContanctFactory());
    parametro.setLossType(LOSS_TYPE_AUTOS);
    parametro.setLobs(lobsFactory());
    parametro.setDescription(getDescription());
    parametro.setNotificationDate(getNotificationDate());
    parametro.setLossDate(getLossDate());
    parametro.setAuthorUser(getAuthorUser());
    parametro.setLossCause(getLossCause());
    parametro.setLossLocation(lossLocationFactory());
    parametro.setMacaNumber(getMacaNumber());
    parametro.setFaultRating(getFaultRating());
    parametro.setIsSuspect(false);
    parametro.setSuspectDesc("");
    parametro.setOriginCause(getOriginCause());
    parametro.setSegment(getSegment());
    parametro.setAuthorityTransit(getAuthorityTransit());
    return parametro;
  }

  Author authorFactory() {
    Author author = new Author();
    author.setDocumentType(getDocumentType());
    author.setTaxID(getTaxIDAuthor());
    return author;
  }

  LossEstimate lossEstimateFactory() {
    LossEstimate lossEstimate = new LossEstimate();
    lossEstimate.setAmount(getAmountLossEstimate());
    lossEstimate.setCurrency(getCurrencyLossEstimate());
    return lossEstimate;
  }

  MainContact mainContanctFactory() {
    MainContact mainContact = new MainContact();
    mainContact.setDocumentType(getDocumentTypeMainContact());
    mainContact.setTaxID(getTaxIDMainContact());
    mainContact.setEmailAddress1(getEmailAddress1MainContact());
    mainContact.setCellNumber(getCellNumberMaincontact());
    mainContact.setPrimaryAddress(primaryAddress__Factory());
    mainContact.setFirstName(getFirstNameMainContact());
    mainContact.setMiddleName(getMiddleNameMainContact());
    mainContact.setLastName(getLastNameMainContact());
    mainContact.setSecondLastName(getSecondLastNameMainContact());
    mainContact.setWorkNumber(getWorkNumberMainContact());
    mainContact.setPolicyRole(getPolicyRoleMainContact());
    return mainContact;
  }

  PrimaryAddress__ primaryAddress__Factory() {
    PrimaryAddress__ primaryAddress__ = new PrimaryAddress__();
    primaryAddress__.setAddressLine1(getAddressLine1MainContact());
    primaryAddress__.setAddressType(getAddressTypeMainContact());
    primaryAddress__.setCity(getCityMainContact());
    return primaryAddress__;
  }

  Lobs lobsFactory() {
    Lobs lobs = new Lobs();
    lobs.setPersonalAuto(personalAutoFactory());
    return lobs;
  }

  PersonalAuto personalAutoFactory() {
    PersonalAuto personalAuto = new PersonalAuto();
    personalAuto.setVehicleIncidents(listVehicleIncidentsFactory());
    personalAuto.setInjuryIncident(listInjuryIncidentFactory());
    return personalAuto;
  }

  public List<VehicleIncident> listVehicleIncidentsFactory() {
    List<VehicleIncident> listVehicleIncident = new ArrayList<VehicleIncident>();
    VehicleIncident vehicleIncident = vehicleIncidentFactory();
    listVehicleIncident.add(vehicleIncident);
    return listVehicleIncident;
  }

  VehicleIncident vehicleIncidentFactory() {
    VehicleIncident vehicleIncident = new VehicleIncident();
    vehicleIncident.setDescription(getDescriptionVehicleIncident());
    vehicleIncident.setRepairShop(getRepairShopVehicleIncident());
    vehicleIncident.setLossParty(getLossPartyVehicleIncident());
    vehicleIncident.setMovePermission(false);
    vehicleIncident.setCollision(true);
    vehicleIncident.setDriverRelation(getDriverRelationVehicleIncident());
    vehicleIncident.setDriver(driverFactory());
    vehicleIncident.setVehicle(vehicleFactory());
    return vehicleIncident;
  }

  Driver driverFactory() {
    Driver driver = new Driver();
    driver.setFirstName(getFirstNameDriver());
    driver.setMiddleName(getMiddleNameDriver());
    driver.setLastName(getLastNameDriver());
    driver.setWorkNumber(getWorkNumberDriver());
    driver.setCellNumber(getCellNumberDriver());
    driver.setEmailAddress1(getEmailAddress1Driver());
    driver.setPolicyRole(getPolicyRoleDriver());
    driver.setDocumentType(getDocumentTypeDriver());
    driver.setTaxID(getTaxIDDriver());
    driver.setPrimaryAddress(primaryAddressFactory());
    return driver;
  }

  PrimaryAddress primaryAddressFactory() {
    PrimaryAddress primaryAddress = new PrimaryAddress();
    primaryAddress.setAddressLine1(getAddressLine1Driver());
    primaryAddress.setAddressType(getAddressTypeDriver());
    primaryAddress.setCity(getCityDriver());
    return primaryAddress;
  }

  Vehicle vehicleFactory() {
    Vehicle vehicle = new Vehicle();
    vehicle.setLicensePlate(getLicensePlateVehicle());
    vehicle.setMake(getMakeVehicle());
    vehicle.setModel(getModelVehicle());
    vehicle.setEngineNumber(getEngineNumberVehicle());
    vehicle.setYear(getYearVehicle());
    vehicle.setColor(getColorVehicle());
    vehicle.setVehicleType(getVehicleType());
    vehicle.setFasecoldaCode(getFasecoldaCode());
    vehicle.setVin(getVinVehicle());
    return vehicle;
  }

  public List<InjuryIncident> listInjuryIncidentFactory() {
    List<InjuryIncident> listInjuryIncident = new ArrayList<InjuryIncident>();
    InjuryIncident injuryIncident = injuryIncidentFactory();
    listInjuryIncident.add(injuryIncident);
    return listInjuryIncident;
  }

  InjuryIncident injuryIncidentFactory() {
    InjuryIncident injuryIncident = new InjuryIncident();
    injuryIncident.setLossParty(getLossPartyInjuryIncident());
    injuryIncident.setInjured(injuredFactory());
    injuryIncident.setSeverity(getSeverityInjuryIncident());
    injuryIncident.setDescription(getDescriptionInjuryIncident());
    injuryIncident.setGeneralInjuryType(getGeneralInjuryType());
    injuryIncident.setDetailedInjuryType(getDetailedInjuryType());
    injuryIncident.setBodyPartDetails(listBodyPartDetailFactory());
    return injuryIncident;
  }

  Injured injuredFactory() {
    Injured injured = new Injured();
    injured.setFirstName(getFirstNameInjured());
    injured.setMiddleName(getMiddleNameInjured());
    injured.setSecondLastName(getSecondLastNameInjured());
    injured.setWorkNumber(getWorkNumberInjured());
    injured.setCellNumber(getCellNumberInjured());
    injured.setEmailAddress1(getEmailAddress1Injured());
    injured.setDocumentType(getDocumentTypeInjured());
    injured.setTaxID(getTaxIDInjured());
    injured.setPrimaryAddress(primaryAddress_Factory());
    return injured;
  }

  public List<BodyPartDetail> listBodyPartDetailFactory() {
    List<BodyPartDetail> listBodyPartDetail = new ArrayList<BodyPartDetail>();
    listBodyPartDetail.add(bodyPartDetail1Factory());
    listBodyPartDetail.add(bodyPartDetail2Factory());
    return listBodyPartDetail;
  }

  BodyPartDetail bodyPartDetail1Factory() {
    BodyPartDetail bodyPartDetail = new BodyPartDetail();
    bodyPartDetail.setPrimaryBodyPart(getPrimaryBodyPart1());
    bodyPartDetail.setDetailedBodyPartType(getDetailedBodyPartType1());
    return bodyPartDetail;
  }

  BodyPartDetail bodyPartDetail2Factory() {
    BodyPartDetail bodyPartDetail = new BodyPartDetail();
    bodyPartDetail.setPrimaryBodyPart(getPrimaryBodyPart2());
    bodyPartDetail.setDetailedBodyPartType(getDetailedBodyPartType2());
    return bodyPartDetail;
  }

  PrimaryAddress_ primaryAddress_Factory() {
    PrimaryAddress_ primaryAddress_ = new PrimaryAddress_();
    primaryAddress_.setAddressLine1(getAddressLine1Injured());
    primaryAddress_.setAddressType(getAddressTypeInjured());
    primaryAddress_.setCity(getCityInjured());
    return primaryAddress_;
  }

  LossLocation lossLocationFactory() {
    LossLocation lossLocation = new LossLocation();
    lossLocation.setCountry(getCountryLossLocation());
    lossLocation.setAddressLine1(getAddressLine1LossLocation());
    lossLocation.setCity(getCityLossLocation());
    return lossLocation;
  }
}
