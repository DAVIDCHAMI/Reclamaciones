package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.pages.generics.GeneralPage.LOGGER;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.service.cliente.siniestro.CreacionSiniestroAutoCliente;
import com.sura.service.creacionSiniestroAuto.gen.ClaimsAutoRequest;
import com.sura.service.creacionSiniestroAuto.gen.ClaimsAutoResponse;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConsumoServicioCreacionSiniestroAutos {

  int campoDato = 0;
  CreacionSiniestroAutosFactory creacionSiniestroAutosFactory = new CreacionSiniestroAutosFactory();
  CreacionSiniestroAutoCliente creacionSiniestroAutoCliente = new CreacionSiniestroAutoCliente();
  ClaimsAutoResponse response;
  List<ReclamacionAuto> lstSiniestroParam;
  List<PersonaReclamacionAuto> lstPersonaReclamacionAuto;
  List<Vehiculo> lstVehiculoParam;

  @RequestMapping
  public void asignarParametrosRequest(
      List<ReclamacionAuto> lstSiniestroParam,
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto,
      List<Vehiculo> lstVehiculoParam) {
    asignarParametrosSiniestro(lstSiniestroParam);
    asignarParametrosAutor(lstPersonaReclamacionAuto);
    asignarParametrosValorPerdida(lstSiniestroParam);
    asignarParametrosContactoPrincipal(lstPersonaReclamacionAuto);
    asignarParametrosDireccionPrincipal(lstPersonaReclamacionAuto);
    asignarParametrosInformacionSiniestro(lstSiniestroParam);
    asignarParametrosIncidenteVehiculo(lstSiniestroParam);
    asignarParametrosConductorVehiculo(lstPersonaReclamacionAuto);
    asignarParametrosDireccionSiniestro(lstSiniestroParam);
    asignarParametrosVehiculo(lstVehiculoParam);
    asignarParametrosReclamante(lstPersonaReclamacionAuto);
    asignarParametrosDescripcionSiniestro(lstSiniestroParam);
    asignarParametrosIncidenteLesion(lstPersonaReclamacionAuto);
    asignarParametrosLesionado(lstPersonaReclamacionAuto);
    asignarParametrosDetalleParteCuerpo(lstPersonaReclamacionAuto);
    crearRequest();
    obtenerResponse();
  }

  private void asignarParametrosSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setPolicyNumber(lstSiniestroParam.get(campoDato).getNumPoliza());
    creacionSiniestroAutosFactory.setAuthorUser(
        lstSiniestroParam.get(campoDato).getIdentificacionAutor());
    creacionSiniestroAutosFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroAutosFactory.setNotificationDate(
        lstSiniestroParam.get(campoDato).getFechaAvisoSiniestro());
    creacionSiniestroAutosFactory.setLossDate(lstSiniestroParam.get(campoDato).getFechaSiniestro());
    creacionSiniestroAutosFactory.setLossCause(
        lstSiniestroParam.get(campoDato).getCausaSiniestro());
    creacionSiniestroAutosFactory.setMacaNumber(lstSiniestroParam.get(campoDato).getNumeroMaca());
    creacionSiniestroAutosFactory.setFaultRating(
        lstSiniestroParam.get(campoDato).getCodigoCulpabilidad());
    creacionSiniestroAutosFactory.setOriginCause(lstSiniestroParam.get(campoDato).getCausa());
    creacionSiniestroAutosFactory.setSegment(lstSiniestroParam.get(campoDato).getSegmento());
    creacionSiniestroAutosFactory.setAuthorityTransit(
        lstSiniestroParam.get(campoDato).getAutoridadTransito());
  }

  private void asignarParametrosAutor(List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setDocumentType(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDAuthor(
        lstPersonaReclamacionAuto.get(campoDato).getNumDocumento());
    creacionSiniestroAutosFactory.setAuthorName(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerNombre());
  }

  private void asignarParametrosValorPerdida(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setAmountLossEstimate(
        lstSiniestroParam.get(campoDato).getValorPerdidaSiniestro());
    creacionSiniestroAutosFactory.setCurrencyLossEstimate(
        lstSiniestroParam.get(campoDato).getTipoMonedaPoliza());
  }

  private void asignarParametrosContactoPrincipal(
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setDocumentTypeMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getNumDocumento());
    creacionSiniestroAutosFactory.setEmailAddress1MainContact(
        lstPersonaReclamacionAuto.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setCellNumberMaincontact(
        lstPersonaReclamacionAuto.get(campoDato).getCelular());
    creacionSiniestroAutosFactory.setFirstNameMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setMiddleNameMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getSegundoNombre());
    creacionSiniestroAutosFactory.setLastNameMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerApellido());
    creacionSiniestroAutosFactory.setSecondLastNameMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getSegundoApellido());
    creacionSiniestroAutosFactory.setWorkNumberMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getNumeroTrabajo());
    creacionSiniestroAutosFactory.setPolicyRoleMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getPolicyRole());
  }

  private void asignarParametrosDireccionPrincipal(
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setAddressLine1MainContact(
        lstPersonaReclamacionAuto.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setAddressTypeMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDireccion());
    creacionSiniestroAutosFactory.setCityMainContact(
        lstPersonaReclamacionAuto.get(campoDato).getCiudad());
  }

  private void asignarParametrosInformacionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosIncidenteVehiculo(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setDescriptionVehicleIncident(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroAutosFactory.setRepairShopVehicleIncident(
        lstSiniestroParam.get(campoDato).getTallerReparacion());
    creacionSiniestroAutosFactory.setLossPartyVehicleIncident(
        lstSiniestroParam.get(campoDato).getPartePerdida());
    creacionSiniestroAutosFactory.setDriverRelationVehicleIncident(
        lstSiniestroParam.get(campoDato).getRelacionAsegurado());
  }

  private void asignarParametrosConductorVehiculo(
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setFirstNameDriver(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setMiddleNameDriver(
        lstPersonaReclamacionAuto.get(campoDato).getSegundoNombre());
    creacionSiniestroAutosFactory.setLastNameDriver(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerApellido());
    creacionSiniestroAutosFactory.setWorkNumberDriver(
        lstPersonaReclamacionAuto.get(campoDato).getNumeroTrabajo());
    creacionSiniestroAutosFactory.setCellNumberDriver(
        lstPersonaReclamacionAuto.get(campoDato).getCelular());
    creacionSiniestroAutosFactory.setEmailAddress1Driver(
        lstPersonaReclamacionAuto.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setPolicyRoleDriver(
        lstPersonaReclamacionAuto.get(campoDato).getPolicyRole());
    creacionSiniestroAutosFactory.setDocumentTypeDriver(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDDriver(
        lstPersonaReclamacionAuto.get(campoDato).getNumDocumento());
  }

  private void asignarParametrosDireccionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setAddressLine1MainContact(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setAddressTypeMainContact(
        lstSiniestroParam.get(campoDato).getTipoDireccion());
    creacionSiniestroAutosFactory.setCityMainContact(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosVehiculo(List<Vehiculo> lstVehiculoParam) {
    creacionSiniestroAutosFactory.setLicensePlateVehicle(
        lstVehiculoParam.get(campoDato).getPlaca());
    creacionSiniestroAutosFactory.setMakeVehicle(lstVehiculoParam.get(campoDato).getMarca());
    creacionSiniestroAutosFactory.setModelVehicle(lstVehiculoParam.get(campoDato).getModelo());
    creacionSiniestroAutosFactory.setEngineNumberVehicle(
        lstVehiculoParam.get(campoDato).getMotor());
    creacionSiniestroAutosFactory.setYearVehicle(lstVehiculoParam.get(campoDato).getAnio());
    creacionSiniestroAutosFactory.setVehicleType(lstVehiculoParam.get(campoDato).getTipoVehiculo());
    creacionSiniestroAutosFactory.setFasecoldaCode(
        lstVehiculoParam.get(campoDato).getCodigoFasecolda());
    creacionSiniestroAutosFactory.setVinVehicle(lstVehiculoParam.get(campoDato).getChasis());
  }

  private void asignarParametrosReclamante(List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setDocumentTypeAnt(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setContactNameAnt(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setTaxIdAnt(
        lstPersonaReclamacionAuto.get(campoDato).getNumDocumento());
    creacionSiniestroAutosFactory.setEmailAddress1Ant(
        lstPersonaReclamacionAuto.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setCellNumberAnt(
        lstPersonaReclamacionAuto.get(campoDato).getCelular());
  }

  private void asignarParametrosDescripcionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosIncidenteLesion(
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setLossPartyInjuryIncident(
        lstPersonaReclamacionAuto.get(campoDato).getParteLesionada());
    creacionSiniestroAutosFactory.setSeverityInjuryIncident(
        lstPersonaReclamacionAuto.get(campoDato).getGravedadLesion());
    creacionSiniestroAutosFactory.setDescriptionInjuryIncident(
        lstPersonaReclamacionAuto.get(campoDato).getDescripcionLesion());
    creacionSiniestroAutosFactory.setGeneralInjuryType(
        lstPersonaReclamacionAuto.get(campoDato).getLesionGeneral());
    creacionSiniestroAutosFactory.setDetailedInjuryType(
        lstPersonaReclamacionAuto.get(campoDato).getDetalleLesion());
  }

  private void asignarParametrosLesionado(List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setFirstNameInjured(
        lstPersonaReclamacionAuto.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setMiddleNameInjured(
        lstPersonaReclamacionAuto.get(campoDato).getSegundoNombre());
    creacionSiniestroAutosFactory.setSecondLastNameInjured(
        lstPersonaReclamacionAuto.get(campoDato).getSegundoApellido());
    creacionSiniestroAutosFactory.setWorkNumberInjured(
        lstPersonaReclamacionAuto.get(campoDato).getNumeroTrabajo());
    creacionSiniestroAutosFactory.setCellNumberInjured(
        lstPersonaReclamacionAuto.get(campoDato).getCelular());
    creacionSiniestroAutosFactory.setEmailAddress1Injured(
        lstPersonaReclamacionAuto.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setDocumentTypeInjured(
        lstPersonaReclamacionAuto.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDInjured(
        lstPersonaReclamacionAuto.get(campoDato).getNumDocumento());
  }

  private void asignarParametrosDetalleParteCuerpo(
      List<PersonaReclamacionAuto> lstPersonaReclamacionAuto) {
    creacionSiniestroAutosFactory.setPrimaryBodyPart1(
        lstPersonaReclamacionAuto.get(campoDato).getParteCuerpo());
    creacionSiniestroAutosFactory.setDetailedBodyPartType1(
        lstPersonaReclamacionAuto.get(campoDato).getDetalleParteCuerpo());
    creacionSiniestroAutosFactory.setPrimaryBodyPart2(
        lstPersonaReclamacionAuto.get(campoDato).getParteCuerpo());
    creacionSiniestroAutosFactory.setDetailedBodyPartType2(
        lstPersonaReclamacionAuto.get(campoDato).getDetalleParteCuerpo());
  }

  private ClaimsAutoRequest crearRequest() {
    return creacionSiniestroAutosFactory.creacionSiniestroAutoRequestFactory();
  }

  private void obtenerResponse() {
    response = creacionSiniestroAutoCliente.claimsResponse(crearRequest());
    LOGGER.info("Número de siniestro: " + response.getResult().getClaimNumber());
    Serenity.setSessionVariable(ReclamacionConstante.NUMERO_SINIESTRO)
        .to(response.getResult().getClaimNumber());
  }
}
