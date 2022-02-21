package com.sura.reclamaciones.services;

import com.sura.reclamaciones.models.Asegurado;
import com.sura.reclamaciones.models.CoberturaVehiculo;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.Tomador;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.models.comunes.*;
import com.sura.reclamaciones.models.comunes.Account;
import com.sura.reclamaciones.models.comunes.Address;
import com.sura.reclamaciones.models.comunes.BillingData;
import com.sura.reclamaciones.models.comunes.CostNew;
import com.sura.reclamaciones.models.comunes.CoverageRequest;
import com.sura.reclamaciones.models.comunes.Driver;
import com.sura.reclamaciones.models.comunes.ExpedicionAutosIndividualRequest;
import com.sura.reclamaciones.models.comunes.Lobs;
import com.sura.reclamaciones.models.comunes.Modifier;
import com.sura.reclamaciones.models.comunes.Param;
import com.sura.reclamaciones.models.comunes.Person;
import com.sura.reclamaciones.models.comunes.PersonalAuto;
import com.sura.reclamaciones.models.comunes.PrimaryInsured;
import com.sura.reclamaciones.models.comunes.SpecialValueAccessories;
import com.sura.reclamaciones.models.comunes.StateValue;
import com.sura.reclamaciones.models.comunes.TermRequest;
import com.sura.reclamaciones.models.comunes.ValueAccessories;
import com.sura.reclamaciones.models.comunes.Vehicle;
import com.sura.reclamaciones.models.comunes.VehicleCoverage;
import com.sura.reclamaciones.utils.Fecha;
import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpedicionAutosIndividualFactory {

  private static final String METHOD_EXPEDICION = "saveAndIssue";
  private static final String JSONRPC_EXPEDICION = "2.0";
  private static final String CODIGO_BONIFICACION_COMERCIAL = "PABoniComercial";
  private static final String CODIGO_BONIFICACION_TECNICA = "PABoniTecnica";
  private static final String CODIGO_DISPOSITIVO_SEGURIDAD = "PAAntiTheft";
  private static final String CODIGO_VEHICULO_BLINDADO = "PABlindado";
  private static final String CODIGO_BIG_DECIMAL = "BD";
  private static final String CODIGO_STRING = "ST";
  private static final String CODIGO_BOOLEAN = "BO";
  private static final Boolean TRUE = true;
  private static final String DANOS_TERCEROS = "Daños a Terceros";
  private static final String DANOS_CARRO = "Daños al Carro";
  private static final String HURTO_CARRO = "Hurto al Carro";
  private static final String CARRO_REEMPLAZO = "Carro de Reemplazo";
  private static final String ACCIDENTES = "Accidentes";
  private static final String LLAVES = "Llaves";
  private static final String ASISTENCIA = "Asistencia";

  private String fechaInicioVigencia;
  private String fechaFinVigencia;
  private String planPagos;
  private Boolean intencionFinanciacion;
  private Boolean facturacionPersonalizada;
  private Boolean pagoAutomatico;
  private Boolean inclusionPoliza;
  private String terminoPoliza;
  private String idCustom;
  private String codigoOrganizacionVenta;
  private String codigoPolizaVenta;
  private String codigoMetodoVenta;
  private String fechaTarifa;
  private String codigoAsesor;
  private String codigoCanalVenta;
  private String tipoPoliza;
  private String origenExpedicion;
  private String lineaProducto;
  private List<Object> interesAdicional;
  private String codigoOficina;
  private Tomador tomador;
  private Asegurado asegurado;
  private String moneda;
  private String jobNumber;
  private Integer porcentajeParticipacion;
  private List<Object> comisionPoliza;
  private Vehiculo vehiculo;
  private List<CoberturaVehiculo> lstCoberturasVehiculo;
  private String tipoFinanciacionSufi;
  private String tipoFinanciacionLeasing;
  private String tipoFinanciacionRenting;
  private String tipoFinanciacionGmac;
  private String descripcion;
  private Long fechaActualizacion;

  public ExpedicionAutosIndividualFactory() {

    planPagos = "paymentPlan:2";
    intencionFinanciacion = false;
    facturacionPersonalizada = true;
    pagoAutomatico = false;
    inclusionPoliza = false;
    terminoPoliza = "Closed";
    idCustom = Utilidades.generarAleatoriosNumeros(4);
    codigoOrganizacionVenta = "Sura";
    codigoPolizaVenta = "PPAutos";
    codigoMetodoVenta = "1";
    codigoAsesor = "10107";
    codigoCanalVenta = "TraditionalChannel";
    tipoPoliza = "IndividualPolicy";
    origenExpedicion = "01";
    lineaProducto = "PersonalAutoLine";
    interesAdicional = new ArrayList<>();
    codigoOficina = "4029";
    moneda = "COP";
    jobNumber = "";
    porcentajeParticipacion = 100;
    comisionPoliza = new ArrayList<>();
    tipoFinanciacionSufi = "24";
    tipoFinanciacionLeasing = "17";
    tipoFinanciacionRenting = "3";
    tipoFinanciacionGmac = "9";
    descripcion = "";
  }

  public void setFechaInicioVigencia(String fechaInicioVigencia) {
    this.fechaInicioVigencia = fechaInicioVigencia;
  }

  public void setFechaFinVigencia(String fechaFinVigencia) {
    this.fechaFinVigencia = fechaFinVigencia;
  }

  public void setFechaTarifa(String fechaTarifa) {
    this.fechaTarifa = fechaTarifa;
  }

  public void setTomador(Tomador tomador) {
    this.tomador = tomador;
  }

  public void setAsegurado(Asegurado asegurado) {
    this.asegurado = asegurado;
  }

  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }

  public void setLstCoberturasVehiculo(List<CoberturaVehiculo> lstCoberturasVehiculo) {
    this.lstCoberturasVehiculo = lstCoberturasVehiculo;
  }

  public void setFechaActualizacion(Long fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

  public ExpedicionAutosIndividualRequest construirRequestExpedicion() {
    ExpedicionAutosIndividualRequest parametros = new ExpedicionAutosIndividualRequest();
    parametros.setMethod(METHOD_EXPEDICION);
    parametros.setParams(lstParamFactory());
    parametros.setJsonrpc(JSONRPC_EXPEDICION);
    return parametros;
  }

  private List<Param> lstParamFactory() {
    List<Param> lstParams = new ArrayList<>();
    lstParams.add(paramFactory());
    return lstParams;
  }

  private Param paramFactory() {
    Param param = new Param();
    param.setPeriodStartDate(fechaInicioVigencia);
    param.setPeriodEnd(fechaFinVigencia);
    param.setBillingData(billingDataFactory());
    param.setIsInclusion(inclusionPoliza);
    param.setPolicyTerm(terminoPoliza);
    param.setIdCustom(idCustom);
    param.setSalesOrganizationCode(codigoOrganizacionVenta);
    param.setSalesPolicyCode(codigoPolizaVenta);
    param.setSaleMethodCode(codigoMetodoVenta);
    param.setRateOfDate(fechaTarifa);
    param.setProducerCode(codigoAsesor);
    param.setSalesChannelCode(codigoCanalVenta);
    param.setPolicyType(tipoPoliza);
    param.setOrigin(origenExpedicion);
    param.setProductLine(lineaProducto);
    param.setAdditionalInterest(interesAdicional);
    param.setOfficeCode(codigoOficina);
    param.setAccount(accountFactory(tomador));
    param.setJobNumber(jobNumber);
    param.setParticipationPercentage(porcentajeParticipacion);
    param.setPolicyCommissions(comisionPoliza);
    param.setLobs(lobsFactory());
    param.setDescription(descripcion);
    param.setDateUpdate(fechaActualizacion);
    return param;
  }

  private BillingData billingDataFactory() {
    BillingData billingData = new BillingData();
    billingData.setSelectedPaymentPlan(planPagos);
    billingData.setFinancingIntention(intencionFinanciacion);
    billingData.setCustomBilling(facturacionPersonalizada);
    billingData.setAutomatic(pagoAutomatico);
    return billingData;
  }

  private Lobs lobsFactory() {
    Lobs lobs = new Lobs();
    lobs.setPersonalAuto(personalAutoLobFactory());
    return lobs;
  }

  private PersonalAuto personalAutoLobFactory() {
    PersonalAuto personalAuto = new PersonalAuto();
    personalAuto.setInformacionAdicionalAsegurado(informacionAdicionalAseguradoFactory());
    personalAuto.setVehicles(lstVehiclesFactory());
    personalAuto.setDrivers(lstDriversFactory());
    return personalAuto;
  }

  private List<Vehicle> lstVehiclesFactory() {
    List<Vehicle> lstVehicles = new ArrayList<>();
    lstVehicles.add(vehicleFactory(vehiculo));
    return lstVehicles;
  }

  private Vehicle vehicleFactory(Vehiculo vehiculo) {
    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleNumber(vehiculo.getNumeroVehiculo());
    vehicle.setPlanCode(vehiculo.getCodigoPlan());
    vehicle.setVin(vehiculo.getPlaca());
    vehicle.setMake(vehiculo.getMarca());
    vehicle.setModel(vehiculo.getLinea());
    vehicle.setYear(vehiculo.getModelo());
    vehicle.setLicense(vehiculo.getPlaca());
    vehicle.setFasecoldaCode(vehiculo.getCodigoFasecolda());
    vehicle.setEngine(vehiculo.getMotor());
    vehicle.setChasis(vehiculo.getChasis());
    vehicle.setVehicleType(vehiculo.getCodigoClaseVehiculo());
    vehicle.setVehicleServiceCode(vehiculo.getTipoServicio());
    vehicle.setVehicleZeroKm(vehiculo.getEsCeroKms());
    vehicle.setTransportsFuel(vehiculo.getTransportaCombustible());
    vehicle.setTrailer(vehiculo.getTieneTrailer());
    vehicle.setImported(vehiculo.getEsImportado());
    vehicle.setForeignEnrollment(vehiculo.getTieneInscripcionExtranjera());
    vehicle.setArmoredVehicle(vehiculo.getEsBlindado());
    vehicle.setZoneCode(vehiculo.getCodigoZonaCirculacion());
    vehicle.setCityCirculationCode(vehiculo.getCiudadCirculacion());
    vehicle.setValueAccessories(valueAccessoriesFactory(vehiculo.getValorAccesorios()));
    vehicle.setSpecialValueAccessories(
        specialValueAccessoriesFactory(vehiculo.getValorAccesoriosEspeciales()));
    vehicle.setCostNew(costNewFactory(vehiculo.getValorAsegurado()));
    vehicle.setTransportFuel(vehiculo.getTransportaCombustible());
    vehicle.setStateValue(stateValueFactory(vehiculo.getValorAsegurado()));
    vehicle.setRateGroup(vehiculo.getGrupoTarifa());
    vehicle.setInspection(vehiculo.getRequiereInspeccion());
    vehicle.setModifiers(lstModifiersFactory(vehiculo));
    vehicle.setLobs(lobsVehicleFactory());
    vehicle.setBrandCode(vehiculo.getMarcaLinea());
    vehicle.setPotency(vehiculo.getPotencia());
    vehicle.setCylinderCapacity(vehiculo.getCapacidadCilindro());
    vehicle.setGearboxType(vehiculo.getTipoCajaCambios());
    vehicle.setNumberAirBag(vehiculo.getNumeroBolsasAire());
    vehicle.setPassengers(vehiculo.getPasajeros());
    vehicle.setNumberDriveShaft(vehiculo.getNumeroEjeTransmision());
    vehicle.setFuelType(vehiculo.getTipoCombustible());
    vehicle.setKeyCode1(tipoFinanciacionSufi);
    vehicle.setKeyCode3(tipoFinanciacionLeasing);
    vehicle.setKeyCode4(tipoFinanciacionRenting);
    vehicle.setKeyCode7(tipoFinanciacionGmac);
    return vehicle;
  }

  private ValueAccessories valueAccessoriesFactory(int valorAccesorios) {
    ValueAccessories valueAccessories = new ValueAccessories();
    valueAccessories.setAmount(valorAccesorios);
    valueAccessories.setCurrency(moneda);
    return valueAccessories;
  }

  private SpecialValueAccessories specialValueAccessoriesFactory(int valorAccesoriosEspeciales) {
    SpecialValueAccessories specialValueAccessories = new SpecialValueAccessories();
    specialValueAccessories.setAmountSpecial(valorAccesoriosEspeciales);
    specialValueAccessories.setCurrencySpecial(moneda);
    return specialValueAccessories;
  }

  private CostNew costNewFactory(int valorVehiculo) {
    CostNew costNew = new CostNew();
    costNew.setAmountCost(valorVehiculo);
    costNew.setCurrencyCost(moneda.toLowerCase());
    return costNew;
  }

  private StateValue stateValueFactory(int valorVehiculo) {
    StateValue stateValue = new StateValue();
    stateValue.setAmountState(valorVehiculo);
    stateValue.setCurrencyState(moneda.toLowerCase());
    return stateValue;
  }

  private List<Modifier> lstModifiersFactory(Vehiculo vehiculo) {
    List<Modifier> lstModifiers = new ArrayList<>();
    Modifier modifierPABoniComercial =
        modifierBigDecimalFactory(
            CODIGO_BONIFICACION_COMERCIAL, vehiculo.getBonificacionComercial());
    Modifier modifierPABoniTecnica =
        modifierBigDecimalFactory(CODIGO_BONIFICACION_TECNICA, vehiculo.getBonificacionTecnica());
    Modifier modifierPABoniDispositivo = modifierStringFactory(vehiculo.getDispositivoSeguridad());
    Modifier modifierPABlindado = modifierBooleanFactory(vehiculo.getEsBlindado());
    lstModifiers.add(modifierPABoniComercial);
    lstModifiers.add(modifierPABoniTecnica);
    if (modifierPABoniDispositivo != null) {
      lstModifiers.add(modifierPABoniDispositivo);
    }
    lstModifiers.add(modifierPABlindado);
    return lstModifiers;
  }

  private Modifier modifierBigDecimalFactory(String codigoModificador, Integer valor) {
    Modifier modifier = new Modifier();
    modifier.setCodeModifier(codigoModificador);
    modifier.setTypeModifier(CODIGO_BIG_DECIMAL);
    modifier.setBigDecimalValue(valor);
    return modifier;
  }

  private Modifier modifierStringFactory(String valor) {
    if (valor != null) {
      Modifier modifier = new Modifier();
      modifier.setCodeModifier(CODIGO_DISPOSITIVO_SEGURIDAD);
      modifier.setTypeModifier(CODIGO_STRING);
      modifier.setStringValue(valor);
      return modifier;
    } else {
      return null;
    }
  }

  private Modifier modifierBooleanFactory(Boolean valor) {
    Modifier modifier = new Modifier();
    modifier.setCodeModifier(CODIGO_VEHICULO_BLINDADO);
    modifier.setTypeModifier(CODIGO_BOOLEAN);
    modifier.setBooleanValue(valor);
    return modifier;
  }

  private Lobs lobsVehicleFactory() {
    Lobs lobs = new Lobs();
    lobs.setPersonalAuto(personalAutoVehicleFactory());
    return lobs;
  }

  private PersonalAuto personalAutoVehicleFactory() {
    PersonalAuto personalAuto = new PersonalAuto();
    personalAuto.setVehicleCoverages(lstVehicleCoveragesFactory(lstCoberturasVehiculo));
    return personalAuto;
  }

  private List<VehicleCoverage> lstVehicleCoveragesFactory(
      List<CoberturaVehiculo> lstCoberturasVehiculo) {
    List<VehicleCoverage> lstVehicleCoverages = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasResponsabilidadCivil = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasDanos = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasHurto = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasVehiculoReemplazo = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasAccidentesConductor = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasPerdidaLlaves = new ArrayList<>();
    List<CoberturaVehiculo> lstCoberturasAsistenciaViaje = new ArrayList<>();
    for (CoberturaVehiculo coberturaVehiculo : lstCoberturasVehiculo) {
      switch (coberturaVehiculo.getCategoria()) {
        case DANOS_TERCEROS:
          lstCoberturasResponsabilidadCivil.add(coberturaVehiculo);
          break;
        case DANOS_CARRO:
          lstCoberturasDanos.add(coberturaVehiculo);
          break;
        case HURTO_CARRO:
          lstCoberturasHurto.add(coberturaVehiculo);
          break;
        case CARRO_REEMPLAZO:
          lstCoberturasVehiculoReemplazo.add(coberturaVehiculo);
          break;
        case ACCIDENTES:
          lstCoberturasAccidentesConductor.add(coberturaVehiculo);
          break;
        case LLAVES:
          lstCoberturasPerdidaLlaves.add(coberturaVehiculo);
          break;
        case ASISTENCIA:
          lstCoberturasAsistenciaViaje.add(coberturaVehiculo);
          break;
        default:
          throw new IllegalArgumentException(
              String.format("Dato %s no encontrado", coberturaVehiculo.getCategoria()));
      }
    }
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasResponsabilidadCivil));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasDanos));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasHurto));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasVehiculoReemplazo));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasAccidentesConductor));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasPerdidaLlaves));
    lstVehicleCoverages.add(vehicleCoverageFactory(lstCoberturasAsistenciaViaje));
    lstVehicleCoverages.removeAll(Collections.singletonList(null));
    return lstVehicleCoverages;
  }

  private VehicleCoverage vehicleCoverageFactory(List<CoberturaVehiculo> lstCoberturasVehiculo) {
    if (!lstCoberturasVehiculo.isEmpty()) {
      VehicleCoverage vehicleCoverage = new VehicleCoverage();
      vehicleCoverage.setCoverageCategory(lstCoberturasVehiculo.get(0).getCodigoCategoria());
      vehicleCoverage.setCoverages(lstCoveragesFactory(lstCoberturasVehiculo));
      return vehicleCoverage;
    } else {
      return null;
    }
  }

  private List<CoverageRequest> lstCoveragesFactory(List<CoberturaVehiculo> lstCoberturasVehiculo) {
    List<CoverageRequest> lstCoveragesRequest = new ArrayList<>();
    lstCoveragesRequest.add(coverageRequestFactory(lstCoberturasVehiculo));
    return lstCoveragesRequest;
  }

  private CoverageRequest coverageRequestFactory(List<CoberturaVehiculo> lstCoberturasVehiculo) {
    CoverageRequest coverageRequest = new CoverageRequest();
    coverageRequest.setUpdated(TRUE);
    coverageRequest.setSelected(TRUE);
    coverageRequest.setPublicID(lstCoberturasVehiculo.get(0).getCodigoNombre());
    coverageRequest.setTerms(lstTermsRequestFactory(lstCoberturasVehiculo));
    return coverageRequest;
  }

  private List<TermRequest> lstTermsRequestFactory(List<CoberturaVehiculo> lstCoberturasVehiculo) {
    List<TermRequest> lstTermsRequest = new ArrayList<>();
    for (CoberturaVehiculo coberturaVehiculo : lstCoberturasVehiculo) {
      TermRequest termRequest = termRequestFactory(coberturaVehiculo);
      lstTermsRequest.add(termRequest);
    }
    return lstTermsRequest;
  }

  private TermRequest termRequestFactory(CoberturaVehiculo coberturaVehiculo) {
    TermRequest termRequest = new TermRequest();
    termRequest.setPatternCode(coberturaVehiculo.getCodigoTermino());
    termRequest.setChosenTerm(coberturaVehiculo.getCodigoOpcion());
    termRequest.setRequired(TRUE);
    termRequest.setUpdated(TRUE);
    return termRequest;
  }

  private List<Driver> lstDriversFactory() {
    List<Driver> lstDrivers = new ArrayList<>();
    lstDrivers.add(driverFactory());
    return lstDrivers;
  }

  private Driver driverFactory() {
    Driver driver = new Driver();
    driver.setPerson(personFactory(asegurado));
    driver.setAccount(accountFactory(asegurado));
    return driver;
  }

  private InformacionAdicionalAsegurado informacionAdicionalAseguradoFactory() {
    InformacionAdicionalAsegurado informacionAdicionalAsegurado =
        new InformacionAdicionalAsegurado();
    informacionAdicionalAsegurado.setDocumentNumber(asegurado.getNumDocumento());
    informacionAdicionalAsegurado.setDocumentType(asegurado.getTipoDocumento());
    informacionAdicionalAsegurado.setDateOfBirth(
        Fecha.obtenerFechaFormatoISO(asegurado.getFechaNacimiento()));
    informacionAdicionalAsegurado.setDateOfEntry(
        Fecha.obtenerFechaFormatoISO(asegurado.getFechaIngresoSura()));
    return informacionAdicionalAsegurado;
  }

  private Account accountFactory(Persona persona) {
    Account account = new Account();
    account.setProducerCode(codigoAsesor);
    account.setPrimaryInsured(primaryInsuredFactory(persona));
    return account;
  }

  private PrimaryInsured primaryInsuredFactory(Persona persona) {
    PrimaryInsured primaryInsured = new PrimaryInsured();
    primaryInsured.setPerson(personFactory(persona));
    return primaryInsured;
  }

  private Person personFactory(Persona persona) {
    Person person = new Person();
    person.setDocumentType(persona.getTipoDocumento());
    person.setDocumentNumber(persona.getNumDocumento());
    person.setDateOfBirth(Fecha.obtenerFechaFormatoISO(persona.getFechaNacimiento()));

    person.setFirstName(persona.getPrimerNombre());
    person.setMiddleName(persona.getSegundoNombre());
    person.setLastName(persona.getPrimerApellido());
    person.setSecondLastName(persona.getSegundoApellido());
    person.setPrimaryPhoneType(persona.getTipoTelefono());
    if ("home".equals(persona.getTipoTelefono())) {
      person.setHomeNumber(persona.getTelefonoPrincipal());
    } else if ("work".equals(persona.getTipoTelefono())) {
      person.setWorkNumber(persona.getTelefonoPrincipal());
    }
    person.setWorkNumber(persona.getTelefonoPrincipal());
    person.setCellNumber(persona.getCelular());
    person.setProfession(persona.getProfesion());
    person.setGenderCode(persona.getGenero());
    person.setEmailAddress1(persona.getCorreoElectronico());
    person.setEmailAddress2(persona.getCorreoElectronicoDos());
    person.setPreferredCurrency(moneda);
    person.setStablishmentCountry_Ext(persona.getNacionalidad());
    person.setDocumentIssueQote_Ext(
        Fecha.obtenerFechaFormatoISO(persona.getFechaExpedicionDocumento()));
    person.setAddress(addressPersonFactory(persona));
    return person;
  }

  private Address addressPersonFactory(Persona persona) {
    Address address = new Address();
    address.setAddressLine1(persona.getDireccion());
    address.setCountry(persona.getCodigoPais());
    address.setState(persona.getCodigoDepartamento());
    address.setCity(persona.getCiudad());
    address.setAddressType(persona.getTipoDireccion());
    return address;
  }
}
