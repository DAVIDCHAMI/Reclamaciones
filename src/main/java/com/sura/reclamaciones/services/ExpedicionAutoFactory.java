package com.sura.reclamaciones.services;

import com.sura.reclamaciones.constantes.EnumValoresServicio;
import com.sura.service.expedicionIndividual.gen.Account;
import com.sura.service.expedicionIndividual.gen.Address;
import com.sura.service.expedicionIndividual.gen.BillingData;
import com.sura.service.expedicionIndividual.gen.CostNew;
import com.sura.service.expedicionIndividual.gen.Coverage;
import com.sura.service.expedicionIndividual.gen.Driver;
import com.sura.service.expedicionIndividual.gen.ExpedicionAutosParametros;
import com.sura.service.expedicionIndividual.gen.Lobs;
import com.sura.service.expedicionIndividual.gen.Modifier;
import com.sura.service.expedicionIndividual.gen.Param;
import com.sura.service.expedicionIndividual.gen.Person;
import com.sura.service.expedicionIndividual.gen.PersonalAuto;
import com.sura.service.expedicionIndividual.gen.PrimaryInsured;
import com.sura.service.expedicionIndividual.gen.SpecialValueAccessories;
import com.sura.service.expedicionIndividual.gen.StateValue;
import com.sura.service.expedicionIndividual.gen.Term;
import com.sura.service.expedicionIndividual.gen.ValueAccessories;
import com.sura.service.expedicionIndividual.gen.Vehicle;
import com.sura.service.expedicionIndividual.gen.VehicleCoverage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import org.joda.time.DateTime;

@SuppressWarnings("unchecked")
public class ExpedicionAutoFactory {
  private String method;
  private String planCode;
  private String jsonrpc;
  private String fechaInicioVigencia;
  private DateTime fechaFinVigencia;
  private String amount;
  private String idCustom;
  private String license;
  private String fasecoldaCode;
  private String year;
  private String cityCirculationCode;
  private String descuentoPoliza;
  private String descuentoRiesgo;
  private String accesorios;
  private boolean ceroKms;
  private String bonificacionComercial;
  private String bonificacionTecnica;
  private String recargo;
  private String suavizacion;
  private String descuentoxUso;
  private String tipoVehiculo;
  private String valorLimiteDanoTercero;
  private String valorDeducibleDanoTercero;
  private String valorPerdidaTotalDanosCarro;
  private String valorPerdidaParcialDanosCarro;
  private String valorGastoTransporteDanosCarro;
  private String valorHurtoTotal;
  private String valorHurtoParcial;
  private String valorHurtoGasTrans;
  private String valorPerdidaParcialCarroReemplazo;
  private String valorPerdidaTotalCarroReemplazo;
  private String valorAccidentesConductor;
  private String valorPerdidaLlaves;
  private String valorAsistencia;

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPlanCode() {
    return planCode;
  }

  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  public String getJsonrpc() {
    return jsonrpc;
  }

  public void setJsonrpc(String jsonrpc) {
    this.jsonrpc = jsonrpc;
  }

  public String getFechaInicioVigencia() {
    return fechaInicioVigencia;
  }

  public void setFechaInicioVigencia(String fechaInicioVigencia) {
    this.fechaInicioVigencia = fechaInicioVigencia;
  }

  public DateTime getFechaFinVigencia() {
    return fechaFinVigencia;
  }

  public void setFechaFinVigencia(DateTime fechaFinVigencia) {
    this.fechaFinVigencia = fechaFinVigencia;
  }

  public String getFasecoldaCode() {
    return this.fasecoldaCode;
  }

  public void setFasecoldaCode(String fasecoldaCode) {
    this.fasecoldaCode = fasecoldaCode;
  }

  public String getYear() {
    return this.year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getcityCirculationCode() {
    return this.cityCirculationCode;
  }

  public void setcityCirculationCode(String cityCirculationCode) {
    this.cityCirculationCode = cityCirculationCode;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public void setIdCustom(String idCustom) {
    this.idCustom = idCustom;
  }

  public String getIdCustom() {
    return this.idCustom;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getDescuentoPoliza() {
    return this.descuentoPoliza;
  }

  public void setDescuentoPoliza(String descuento) {
    this.descuentoPoliza = descuento;
  }

  public String getDescuentoRiesgo() {
    return this.descuentoRiesgo;
  }

  public void setDescuentoRiesgo(String descuento) {
    this.descuentoRiesgo = descuento;
  }

  public String getBonificacionTecnica() {
    return this.bonificacionTecnica;
  }

  public void setBonificacionTecnica(String bonificacion) {
    this.bonificacionTecnica = bonificacion;
  }

  public String getBonificacionComercial() {
    return this.bonificacionComercial;
  }

  public void setBonificacionComercial(String bonificacion) {
    this.bonificacionComercial = bonificacion;
  }

  public String getAccesorios() {
    return this.accesorios;
  }

  public void setAccesorios(String value) {
    this.accesorios = value;
  }

  public String getRecargo() {
    return this.recargo;
  }

  public void setRecargo(String value) {
    this.recargo = value;
  }

  public String getSuavizacion() {
    return this.suavizacion;
  }

  public void setSuavizacion(String value) {
    this.suavizacion = value;
  }

  public String getDescuentoxUso() {
    return this.descuentoxUso;
  }

  public void setDescuentoxUso(String value) {
    this.descuentoxUso = value;
  }

  public boolean getCeroKms() {
    return this.ceroKms;
  }

  public void setCeroKms(Boolean value) {
    this.ceroKms = value;
  }

  public String getTipoVehiculo() {
    return this.tipoVehiculo;
  }

  public void setTipoVehiculo(String value) {
    this.tipoVehiculo = value;
  }

  public String getValorLimiteDanoTercero() {
    return valorLimiteDanoTercero;
  }

  public void setValorLimiteDanoTercero(String valorLimiteDanoTercero) {
    this.valorLimiteDanoTercero = valorLimiteDanoTercero;
  }

  public String getValorDeducibleDanoTercero() {
    return valorDeducibleDanoTercero;
  }

  public void setValorDeducibleDanoTercero(String valorDeducibleDanoTercero) {
    this.valorDeducibleDanoTercero = valorDeducibleDanoTercero;
  }

  public String getValorPerdidaTotalDanosCarro() {
    return valorPerdidaTotalDanosCarro;
  }

  public void setValorPerdidaTotalDanosCarro(String valorPerdidaTotalDanosCarro) {
    this.valorPerdidaTotalDanosCarro = valorPerdidaTotalDanosCarro;
  }

  public String getValorPerdidaParcialDanosCarro() {
    return valorPerdidaParcialDanosCarro;
  }

  public void setValorPerdidaParcialDanosCarro(String valorPerdidaParcialDanosCarro) {
    this.valorPerdidaParcialDanosCarro = valorPerdidaParcialDanosCarro;
  }

  public String getValorGastoTransporteDanosCarro() {
    return valorGastoTransporteDanosCarro;
  }

  public void setValorGastoTransporteDanosCarro(String valorGastoTransporteDanosCarro) {
    this.valorGastoTransporteDanosCarro = valorGastoTransporteDanosCarro;
  }

  public String getValorHurtoTotal() {
    return valorHurtoTotal;
  }

  public void setValorHurtoTotal(String valorHurtoTotal) {
    this.valorHurtoTotal = valorHurtoTotal;
  }

  public String getValorHurtoParcial() {
    return valorHurtoParcial;
  }

  public void setValorHurtoParcial(String valorHurtoParcial) {
    this.valorHurtoParcial = valorHurtoParcial;
  }

  public String getValorHurtoGasTrans() {
    return valorHurtoGasTrans;
  }

  public void setValorHurtoGasTrans(String valorHurtoGasTrans) {
    this.valorHurtoGasTrans = valorHurtoGasTrans;
  }

  public String getValorPerdidaParcialCarroReemplazo() {
    return valorPerdidaParcialCarroReemplazo;
  }

  public void setValorPerdidaParcialCarroReemplazo(String valorPerdidaParcialCarroReemplazo) {
    this.valorPerdidaParcialCarroReemplazo = valorPerdidaParcialCarroReemplazo;
  }

  public String getValorPerdidaTotalCarroReemplazo() {
    return valorPerdidaTotalCarroReemplazo;
  }

  public void setValorPerdidaTotalCarroReemplazo(String valorPerdidaTotalCarroReemplazo) {
    this.valorPerdidaTotalCarroReemplazo = valorPerdidaTotalCarroReemplazo;
  }

  public String getValorAccidentesConductor() {
    return valorAccidentesConductor;
  }

  public void setValorAccidentesConductor(String valorAccidentesConductor) {
    this.valorAccidentesConductor = valorAccidentesConductor;
  }

  public String getValorPerdidaLlaves() {
    return valorPerdidaLlaves;
  }

  public void setValorPerdidaLlaves(String valorPerdidaLlaves) {
    this.valorPerdidaLlaves = valorPerdidaLlaves;
  }

  public String getValorAsistencia() {
    return valorAsistencia;
  }

  public void setValorAsistencia(String valorAsistencia) {
    this.valorAsistencia = valorAsistencia;
  }

  public ExpedicionAutosParametros expedicionAutosParametrosFactory() {
    ExpedicionAutosParametros parametros = new ExpedicionAutosParametros();
    parametros.setMethod(getMethod());
    parametros.setJsonrpc(getJsonrpc());
    parametros.setParams(listParamFactory());
    return parametros;
  }

  public List<Param> listParamFactory() {
    List<Param> listParams = new ArrayList<Param>();
    Param param = paramFactory();
    listParams.add(param);
    return listParams;
  }

  private Param paramFactory() {
    fechaFinVigencia = new DateTime();
    fechaFinVigencia = fechaFinVigencia.plusYears(1);
    Param param = new Param();
    param.setPeriodStartDate(this.fechaInicioVigencia);
    param.setPeriodEnd(fechaFinVigencia.toString());
    param.setBillingData(billingDataFactory());
    param.setPolicyTerm("Closed");
    param.setIdCustom(this.idCustom);
    param.setSalesOrganizationCode("Sura");
    param.setSalesPolicyCode("PPAutos");
    param.setSaleMethodCode("1");
    param.setRateOfDate(this.fechaInicioVigencia);
    param.setProducerCode("78");
    param.setSalesChannelCode("TraditionalChannel");
    param.setPolicyType("IndividualPolicy");
    param.setOrigin("01");
    param.setProductLine("PersonalAutoLine");
    param.setAdditionalInterest(additionalInterestFactory());
    param.setOfficeCode("2602");
    param.setAccount(accountFactory());
    param.setJobNumber("");
    param.setOfficeCode("2602");
    param.setParticipationPercentage(100);
    param.setPolicyCommissions(policyComissionsFactory());
    param.setLobs(lobsFactory());
    param.setDescription("prueba cliente expedicion");
    return param;
  }

  private List<Object> policyComissionsFactory() {
    return new ArrayList<>();
  }

  private List<Object> additionalInterestFactory() {
    return new ArrayList<>();
  }

  private BillingData billingDataFactory() {
    BillingData billingData = new BillingData();
    billingData.setSelectedPaymentPlan("paymentPlan:2");
    billingData.setFinancingIntention(false);
    billingData.setCustomBilling(true);
    billingData.setAutomatic(false);
    return billingData;
  }

  private Lobs lobsFactory() {
    Lobs lobs = new Lobs();
    lobs.setPersonalAuto(personalAutoLobFactory());
    return lobs;
  }

  private Lobs lobsFactory2() {
    Lobs lobs = new Lobs();
    lobs.setPersonalAuto(personalAutoLobFactory2());
    return lobs;
  }

  private PersonalAuto personalAutoLobFactory() {
    PersonalAuto personalAuto = new PersonalAuto();
    personalAuto.setVehicles(vehiclesFactory());
    personalAuto.setDrivers(driversFactory());
    return personalAuto;
  }

  private PersonalAuto personalAutoLobFactory2() {
    PersonalAuto personalAuto = new PersonalAuto();
    personalAuto.setVehicleCoverages(vehiclesCoveragesFactory());
    return personalAuto;
  }

  private List<VehicleCoverage> vehiclesCoveragesFactory() {
    List<VehicleCoverage> vehicleCoverages = new ArrayList<>();
    List<Pair<String, String>> termsNamesPar =
        Arrays.asList(
            new Pair<>(
                EnumValoresServicio.COB_DANO_TERCERO_LIMITE.getValue(),
                getValorLimiteDanoTercero()),
            new Pair<>(
                EnumValoresServicio.COB_DANO_TERCERO_DEDUCIBLE.getValue(),
                getValorDeducibleDanoTercero()));
    List<Pair<String, String>> termsNamesDanos =
        Arrays.asList(
            new Pair<>(
                EnumValoresServicio.COB_DANOS_CARRO_PTOTAL.getValue(),
                getValorPerdidaTotalDanosCarro()),
            new Pair<>(
                EnumValoresServicio.COB_DANOS_CARRO_PPARCIAL.getValue(),
                getValorPerdidaParcialDanosCarro()),
            new Pair<>(
                EnumValoresServicio.COB_DANOS_CARRO_GTRANSPORTE.getValue(),
                getValorGastoTransporteDanosCarro()));
    List<Pair<String, String>> termsNamesHurto =
        Arrays.asList(
            new Pair<>(EnumValoresServicio.COB_HURTO_CARRO_PTOTAL.getValue(), getValorHurtoTotal()),
            new Pair<>(
                EnumValoresServicio.COB_HURTO_CARRO_PPARCIAL.getValue(), getValorHurtoParcial()),
            new Pair<>(
                EnumValoresServicio.COB_HURTO_CARRO_GTRANSPORTE.getValue(),
                getValorHurtoGasTrans()));
    List<Pair<String, String>> termsNamesLlaves =
        Arrays.asList(
            new Pair<>(EnumValoresServicio.COB_PERDIDA_LLAVES.getValue(), getValorPerdidaLlaves()),
            new Pair<>(
                EnumValoresServicio.COB_VREEMPLAZO_PERD_TOTAL.getValue(),
                getValorPerdidaTotalCarroReemplazo()));
    List<Pair<String, String>> termsNamesReemplazo =
        Arrays.asList(
            new Pair<>(
                EnumValoresServicio.COB_VREEMPLAZO_PERD_PARCIAL.getValue(),
                getValorPerdidaParcialCarroReemplazo()));
    List<Pair<String, String>> termsNamesAsistencia =
        Arrays.asList(
            new Pair<>(EnumValoresServicio.COB_ASISTENCIA.getValue(), getValorAsistencia()));
    VehicleCoverage coveragePar =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_DANOS_TERCEROS.getValue(),
            EnumValoresServicio.VALOR_PA_DANOS_TERCEROS_COB.getValue(),
            termsNamesPar);
    VehicleCoverage coverageDanos =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_DANOS_ALCARROGRP.getValue(),
            EnumValoresServicio.VALOR_PA_DANOS_COB.getValue(),
            termsNamesDanos);
    VehicleCoverage coverageHurto =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_HURTO_ALCARROGRP.getValue(),
            EnumValoresServicio.VALOR_PA_HURTO_COB.getValue(),
            termsNamesHurto);
    VehicleCoverage coverageAccidentes =
        vehicleCoverageAccidentesFactory(
            EnumValoresServicio.PA_ACCIDENTES.getValue(),
            EnumValoresServicio.VALOR_PA_ACCIDENTES_COB.getValue());
    VehicleCoverage coverageLlaves =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_LLAVES.getValue(),
            EnumValoresServicio.VALOR_PA_PERDLLA_COB.getValue(),
            termsNamesLlaves);
    VehicleCoverage coverageReemplazo =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_CARRO_DEREEMPLAZO.getValue(),
            EnumValoresServicio.VALOR_PA_CARRORE_COB.getValue(),
            termsNamesReemplazo);
    VehicleCoverage coverageAsistencia =
        vehicleCoverageFactory(
            EnumValoresServicio.PA_ASISTENCIA.getValue(),
            EnumValoresServicio.VALOR_PA_ASISTENCIA_COB.getValue(),
            termsNamesAsistencia);
    vehicleCoverages.add(coveragePar);
    vehicleCoverages.add(coverageDanos);
    vehicleCoverages.add(coverageHurto);
    vehicleCoverages.add(coverageAccidentes);
    vehicleCoverages.add(coverageLlaves);
    vehicleCoverages.add(coverageReemplazo);
    vehicleCoverages.add(coverageAsistencia);
    return vehicleCoverages;
  }

  private VehicleCoverage vehicleCoverageFactory(
      String category, String coverageID, List<Pair<String, String>> termsName) {
    VehicleCoverage vehicleCoverage = new VehicleCoverage();
    vehicleCoverage.setCoverageCategory(category);
    vehicleCoverage.setCoverages(coverageFactory(coverageID, termsName));
    return vehicleCoverage;
  }

  private VehicleCoverage vehicleCoverageAccidentesFactory(String category, String coverageID) {
    VehicleCoverage vehicleCoverage = new VehicleCoverage();
    vehicleCoverage.setCoverageCategory(category);
    vehicleCoverage.setCoverages(coverageAccidentesFactory(coverageID));
    return vehicleCoverage;
  }

  private void coverageSelectId(String coverageId) {
    Coverage coverage = new Coverage();
    coverage.setPublicID(coverageId);
    coverage.setSelected(true);
    coverage.setUpdated(true);
  }

  private List<Coverage> coverageAccidentesFactory(String coverageID) {
    Coverage coverage = new Coverage();
    coverageSelectId(coverageID);
    List<Term> terms =
        Arrays.asList(
            termFactory(
                new Pair<String, String>(
                    EnumValoresServicio.COB_ACCIDENTES_CONDUCTOR.getValue(),
                    getValorAccidentesConductor())));
    coverage.setTerms(terms);
    List<Coverage> coverages = new ArrayList<>();
    coverages.add(coverage);
    return coverages;
  }

  private List<Coverage> coverageFactory(String coverageID, List<Pair<String, String>> termsName) {
    Coverage coverage = new Coverage();
    coverageSelectId(coverageID);
    coverage.setTerms(termsFactory(termsName));
    List<Coverage> coverages = new ArrayList<>();
    coverages.add(coverage);
    return coverages;
  }

  private List<Term> termsFactory(List<Pair<String, String>> termsName) {
    List<Term> terms = new ArrayList<>();
    for (Pair termName : termsName) {
      Term term = termFactory(termName);
      terms.add(term);
    }
    return terms;
  }

  private Term termFactory(Pair<String, String> termName) {
    Term term = new Term();
    term.setPatternCode(termName.getKey());
    term.setChosenTerm(termName.getValue());
    term.setRequired(true);
    term.setUpdated(true);
    return term;
  }

  private List<Vehicle> vehiclesFactory() {
    List<Vehicle> list = new ArrayList<>();
    list.add(vehicleFactory());
    return list;
  }

  private Vehicle vehicleFactory() {
    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleNumber(1);
    vehicle.setPlanCode("3");
    vehicle.setVin(this.license);
    vehicle.setMake("CHEVROLET");
    vehicle.setModel("SAIL LS - MT 1400CC 4P A");
    vehicle.setYear("2018");
    vehicle.setLicense(this.license);
    vehicle.getLicenseState();
    vehicle.setFasecoldaCode("01601312");
    vehicle.setEngine("DADSADSA");
    vehicle.setChasis("DSAJDLSADA");
    vehicle.setVehicleType("1");
    vehicle.setVehicleServiceCode("Particular");
    vehicle.setVehicleZeroKm(true);
    vehicle.setConcessionaire(null);
    vehicle.setTransportsFuel(false);
    vehicle.setTrailer(false);
    vehicle.setImported(false);
    vehicle.setForeignEnrollment(false);
    vehicle.setArmoredVehicle(false);
    vehicle.setZoneCode("1");
    vehicle.setCityCirculationCode("11001000");
    vehicle.setValueAccessories(valueAccessoriesFactory());
    vehicle.setSpecialValueAccessories(specialValueAccessoriesFactory());
    vehicle.setCostNew(costNewFactory());
    vehicle.setTransportFuel(false);
    vehicle.setStateValue(stateValueFactory());
    vehicle.setRateGroup("1");
    vehicle.setInspection(false);
    vehicle.setModifiers(modifiersFactory());
    vehicle.setLobs(lobsFactory2());
    vehicle.setBrandCode("12-1-32");
    vehicle.setPrimaryUseCode("Familiar");
    vehicle.setLicenseState(null);
    vehicle.setConcessionaire(null);
    vehicle.setIsPlateChange(null);
    vehicle.setDeviceOff(null);
    return vehicle;
  }

  private List<Modifier> modifiersFactory() {
    List<Modifier> modifiers = new ArrayList<>();
    Modifier modifierPABlindado = modifierBooleanFactory("PABlindado", false);
    Modifier modifierPABoniComercial =
        modifierBigDecimalFactory("PABoniComercial", Integer.parseInt(getBonificacionComercial()));
    Modifier modifierPABoniTecnica =
        modifierBigDecimalFactory("PABoniTecnica", Integer.parseInt(getBonificacionTecnica()));
    modifiers.add(modifierPABlindado);
    modifiers.add(modifierPABoniComercial);
    modifiers.add(modifierPABoniTecnica);
    return modifiers;
  }

  public void modifierValue(String nombre, boolean valor) {
    Modifier modifier = new Modifier();
    modifier.setCodeModifier(nombre);
    modifier.setTypeModifier("BO");
    modifier.setBooleanValue(valor);
  }

  private Modifier modifierBigDecimalFactory(String nombre, Integer valor) {
    Modifier modifier = new Modifier();
    modifierValue(nombre, false);
    modifier.setBigDecimalValue(valor);
    return modifier;
  }

  private Modifier modifierBooleanFactory(String nombre, boolean valor) {
    Modifier modifier = new Modifier();
    modifierValue(nombre, valor);
    return modifier;
  }

  private StateValue stateValueFactory() {
    StateValue stateValue = new StateValue();
    stateValue.setAmount(35700000);
    stateValue.setCurrency("cop");
    return stateValue;
  }

  private CostNew costNewFactory() {
    CostNew costNew = new CostNew();
    costNew.setAmount(35700000);
    costNew.setCurrency("cop");
    return costNew;
  }

  private SpecialValueAccessories specialValueAccessoriesFactory() {
    SpecialValueAccessories specialValueAccessories = new SpecialValueAccessories();
    specialValueAccessories.setAmount(0);
    specialValueAccessories.setCurrency("cop");
    return specialValueAccessories;
  }

  private ValueAccessories valueAccessoriesFactory() {
    ValueAccessories valueAccessories = new ValueAccessories();
    valueAccessories.setAmount(0);
    valueAccessories.setCurrency("cop");
    return valueAccessories;
  }

  private List<Driver> driversFactory() {
    List<Driver> list = new ArrayList<>();
    Driver driver = new Driver();
    driver.setPerson(personFactory());
    driver.setAccount(accountFactory());
    list.add(driver);
    return list;
  }

  private Account accountFactory() {
    Account account = new Account();
    account.setProducerCode("78");
    account.setPrimaryInsured(primaryInsuredFactory());
    return account;
  }

  private PrimaryInsured primaryInsuredFactory() {
    PrimaryInsured primaryInsured = new PrimaryInsured();
    primaryInsured.setPerson(personFactory());
    return primaryInsured;
  }

  private Address addressFactory() {
    Address address = new Address();
    address.setAddressLine1("CALLE6-9-1");
    address.setCountry("CO");
    address.setState("CO05");
    address.setCity("05001000");
    address.setAddressType("other");
    return address;
  }

  private Person personFactory() {
    Person person = new Person();
    person.setDocumentNumber("1018723029");
    person.setDocumentType("C");
    person.setDateOfBirth("1972-08-10T00:00:00.000-05:00");
    person.setFirstName("BATMAN");
    person.setMiddleName("ROBIN");
    person.setLastName("AND");
    person.setSecondLastName("SUPERMAN");
    person.setPrefixType(null);
    person.setSuffixType(null);
    person.setPrimaryPhoneType("work");
    person.setHomeNumber("5642122");
    person.setMaritalStatusCode(null);
    person.setProfession("B06");
    person.setGenderCode("M");
    person.setEmailAddress1("nckdsnj@gmail.com");
    person.setEmailAddress2("nckdsnj@gmail.com");
    person.setOfficialID(null);
    person.setOfficialIDType(null);
    person.setPreferredCurrency("cop");
    person.setWorkNumber("5642122");
    person.setCellNumber("3242424161");
    person.setHomeNumber("5642122");
    person.setAddress(addressFactory());
    return person;
  }
}
