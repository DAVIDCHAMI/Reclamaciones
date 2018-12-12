package com.sura.reclamaciones.services;

import com.sura.service.creacionSiniestroAuto.gen.*;
import java.util.ArrayList;
import java.util.List;

public class CreacionSiniestroAutoFactory {
  private static final String ID_SERVICIO_CLAIM = "6";
  private static final String METHOD_CREATE_CLAIM = "createClaim";
  private static final String LOSS_TYPE_AUTOS = "AUTO";
  private static final String JSONRPC_2 = "2.0";

  private String policyNumber;
  private String description;
  private String lossDate;
  private String notificationDate;
  private String lossCause;
  private String policySystemId;
  private String descriptionLoss;
  private String authorUser;
  private String authorName;
  private String macaNumber;
  private String faultRating;
  private String originCause;
  private String segment;
  private String authorityTransit;
  private String documentType;
  private String taxID;
  private int amount;
  private String currency;
  private String documentTypeMainContact;
  private String taxIDMainContact;
  private String emailAddress1;
  private String cellNumberMainContact;
  private String firstNameContactName;
  private String middleNameMainContact;
  private String lastNameMainContact;
  private String secondLastNameMainContact;
  private String workNumberMainContact;
  private String policyRoleMainContact;
  private String addressLine1PrimaryAdress__;
  private String addressTypePrimaryAdress__;
  private String cityPrimaryAdress__;
  private String descripcionVehicleIncident;
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
  private String addressLine1PrimaryAdress;
  private String addressTypePrimaryAdress;
  private String cityPrimaryAdress;
  private String licensePlate;
  private String makeVehicle;
  private String modelVehicle;
  private String engineNumberVehicle;
  private int yearVehicle;
  private String colorVehicle;
  private String vehicleType;
  private String fasecoldaCode;
  private String vinVehicle;
  private String lossPartyInjuryIncident;
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
  private String addressLine1PrimaryAdress_;
  private String addressTypePrimaryAdress_;
  private String cityPrimaryAdress_;
  private String countryLossLocation;
  private String addressLine1LossLocation;
  private String cityLossLocation;
  private String stateMainContact;
  private String addressLine1MainContact;
  private String cityMainContact;
  private String contactNameMainContact;
  private String stateAnt;
  private String addressLine1Ant;
  private String cityAnt;
  private String documentTypeAnt;
  private String contactNameAnt;
  private String taxIdAnt;
  private String emailAddress1Ant;
  private String cellNumberAnt;

  public static String getIdServicioClaim() {
    return ID_SERVICIO_CLAIM;
  }

  public static String getMethodCreateClaim() {
    return METHOD_CREATE_CLAIM;
  }

  public static String getLossTypeAutos() {
    return LOSS_TYPE_AUTOS;
  }

  public static String getJsonrpc2() {
    return JSONRPC_2;
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

  public String getLossDate() {
    return lossDate;
  }

  public void setLossDate(String lossDate) {
    this.lossDate = lossDate;
  }

  public String getNotificationDate() {
    return notificationDate;
  }

  public void setNotificationDate(String notificationDate) {
    this.notificationDate = notificationDate;
  }

  public String getLossCause() {
    return lossCause;
  }

  public void setLossCause(String lossCause) {
    this.lossCause = lossCause;
  }

  public String getPolicySystemId() {
    return policySystemId;
  }

  public void setPolicySystemId(String policySystemId) {
    this.policySystemId = policySystemId;
  }

  public String getDescriptionLoss() {
    return descriptionLoss;
  }

  public void setDescriptionLoss(String descriptionLoss) {
    this.descriptionLoss = descriptionLoss;
  }

  public String getAuthorUser() {
    return authorUser;
  }

  public void setAuthorUser(String authorUser) {
    this.authorUser = authorUser;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
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

  public String getTaxID() {
    return taxID;
  }

  public void setTaxID(String taxID) {
    this.taxID = taxID;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
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

  public String getEmailAddress1() {
    return emailAddress1;
  }

  public void setEmailAddress1(String emailAddress1) {
    this.emailAddress1 = emailAddress1;
  }

  public String getCellNumberMainContact() {
    return cellNumberMainContact;
  }

  public void setCellNumberMainContact(String cellNumberMainContact) {
    this.cellNumberMainContact = cellNumberMainContact;
  }

  public String getFirstNameContactName() {
    return firstNameContactName;
  }

  public void setFirstNameContactName(String firstNameContactName) {
    this.firstNameContactName = firstNameContactName;
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

  public String getAddressLine1PrimaryAdress__() {
    return addressLine1PrimaryAdress__;
  }

  public void setAddressLine1PrimaryAdress__(String addressLine1PrimaryAdress__) {
    this.addressLine1PrimaryAdress__ = addressLine1PrimaryAdress__;
  }

  public String getAddressTypePrimaryAdress__() {
    return addressTypePrimaryAdress__;
  }

  public void setAddressTypePrimaryAdress__(String addressTypePrimaryAdress__) {
    this.addressTypePrimaryAdress__ = addressTypePrimaryAdress__;
  }

  public String getCityPrimaryAdress__() {
    return cityPrimaryAdress__;
  }

  public void setCityPrimaryAdress__(String cityPrimaryAdress__) {
    this.cityPrimaryAdress__ = cityPrimaryAdress__;
  }

  public String getDescripcionVehicleIncident() {
    return descripcionVehicleIncident;
  }

  public void setDescripcionVehicleIncident(String descripcionVehicleIncident) {
    this.descripcionVehicleIncident = descripcionVehicleIncident;
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

  public String getAddressLine1PrimaryAdress() {
    return addressLine1PrimaryAdress;
  }

  public void setAddressLine1PrimaryAdress(String addressLine1PrimaryAdress) {
    this.addressLine1PrimaryAdress = addressLine1PrimaryAdress;
  }

  public String getAddressTypePrimaryAdress() {
    return addressTypePrimaryAdress;
  }

  public void setAddressTypePrimaryAdress(String addressTypePrimaryAdress) {
    this.addressTypePrimaryAdress = addressTypePrimaryAdress;
  }

  public String getCityPrimaryAdress() {
    return cityPrimaryAdress;
  }

  public void setCityPrimaryAdress(String cityPrimaryAdress) {
    this.cityPrimaryAdress = cityPrimaryAdress;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
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

  public String getAddressLine1PrimaryAdress_() {
    return addressLine1PrimaryAdress_;
  }

  public void setAddressLine1PrimaryAdress_(String addressLine1PrimaryAdress_) {
    this.addressLine1PrimaryAdress_ = addressLine1PrimaryAdress_;
  }

  public String getAddressTypePrimaryAdress_() {
    return addressTypePrimaryAdress_;
  }

  public void setAddressTypePrimaryAdress_(String addressTypePrimaryAdress_) {
    this.addressTypePrimaryAdress_ = addressTypePrimaryAdress_;
  }

  public String getCityPrimaryAdress_() {
    return cityPrimaryAdress_;
  }

  public void setCityPrimaryAdress_(String cityPrimaryAdress_) {
    this.cityPrimaryAdress_ = cityPrimaryAdress_;
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

  public String getStateMainContact() {
    return stateMainContact;
  }

  public void setStateMainContact(String stateMainContact) {
    this.stateMainContact = stateMainContact;
  }

  public String getAddressLine1MainContact() {
    return addressLine1MainContact;
  }

  public void setAddressLine1MainContact(String addressLine1MainContact) {
    this.addressLine1MainContact = addressLine1MainContact;
  }

  public String getCityMainContact() {
    return cityMainContact;
  }

  public void setCityMainContact(String cityMainContact) {
    this.cityMainContact = cityMainContact;
  }

  public String getContactNameMainContact() {
    return contactNameMainContact;
  }

  public void setContactNameMainContact(String contactNameMainContact) {
    this.contactNameMainContact = contactNameMainContact;
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
    listParams.add(policyNumber);
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
    author.setTaxID(getTaxID());
    return author;
  }

  LossEstimate lossEstimateFactory() {
    LossEstimate lossEstimate = new LossEstimate();
    lossEstimate.setAmount(getAmount());
    lossEstimate.setCurrency(getCurrency());
    return lossEstimate;
  }

  MainContact mainContanctFactory() {
    MainContact mainContact = new MainContact();
    mainContact.setDocumentType(getDocumentTypeMainContact());
    mainContact.setTaxID(getTaxIDMainContact());
    mainContact.setEmailAddress1(getEmailAddress1());
    mainContact.setCellNumber(getCellNumberMainContact());
    mainContact.setPrimaryAddress(primaryAddress__Factory());
    mainContact.setFirstName(getFirstNameContactName());
    mainContact.setMiddleName(getMiddleNameMainContact());
    mainContact.setLastName(getLastNameMainContact());
    mainContact.setSecondLastName(getSecondLastNameMainContact());
    mainContact.setWorkNumber(getWorkNumberMainContact());
    mainContact.setPolicyRole(getPolicyRoleMainContact());
    return mainContact;
  }

  PrimaryAddress__ primaryAddress__Factory() {
    PrimaryAddress__ primaryAddress__ = new PrimaryAddress__();
    primaryAddress__.setAddressLine1(getAddressLine1PrimaryAdress__());
    primaryAddress__.setAddressType(getAddressTypePrimaryAdress__());
    primaryAddress__.setCity(getCityPrimaryAdress__());
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
    vehicleIncident.setDescription(getDescripcionVehicleIncident());
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
    primaryAddress.setAddressLine1(getAddressLine1PrimaryAdress());
    primaryAddress.setAddressType(getAddressTypePrimaryAdress());
    primaryAddress.setCity(getCityPrimaryAdress());
    return primaryAddress;
  }

  Vehicle vehicleFactory() {
    Vehicle vehicle = new Vehicle();
    vehicle.setLicensePlate(getLicensePlate());
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
    primaryAddress_.setAddressLine1(getAddressLine1PrimaryAdress_());
    primaryAddress_.setAddressType(getAddressTypePrimaryAdress_());
    primaryAddress_.setCity(getCityPrimaryAdress_());
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
