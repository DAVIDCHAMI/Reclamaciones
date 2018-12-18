package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.pages.generics.GeneralPage.LOGGER;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaConductorAuto;
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

  @RequestMapping
  public void asignarParametrosRequest(
      List<ReclamacionAuto> lstSiniestroParam,
      List<PersonaReclamacionAuto> lstPersonaLesionada,
      List<PersonaConductorAuto> lstConductor,
      List<Vehiculo> lstVehiculoParam) {
    asignarParametrosSiniestro(lstSiniestroParam);
    asignarParametrosAutor(lstConductor);
    asignarParametrosValorPerdida(lstSiniestroParam);
    asignarParametrosContactoPrincipal(lstConductor);
    asignarParametrosDireccionPrincipal(lstConductor);
    asignarParametrosInformacionSiniestro(lstSiniestroParam);
    asignarParametrosIncidenteVehiculo(lstSiniestroParam);
    asignarParametrosConductorVehiculo(lstConductor);
    asignarParametrosDireccionConductor(lstConductor);
    asignarParametrosDireccionContactoPrincipal(lstSiniestroParam);
    asignarParametrosVehiculo(lstVehiculoParam);
    asignarParametrosReclamante(lstConductor);
    asignarParametrosDescripcionSiniestro(lstSiniestroParam);
    asignarParametrosIncidenteLesion(lstPersonaLesionada);
    asignarParametrosLesionado(lstPersonaLesionada);
    agregarDireccionLesionado(lstSiniestroParam);
    asignarParametrosDetalleParteCuerpo(lstPersonaLesionada);
    asignarParametrosDireccionSiniestro(lstSiniestroParam);
    crearRequest();
    obtenerResponse();
  }

  private void asignarParametrosSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setPolicyNumber(lstSiniestroParam.get(campoDato).getNumPoliza());
    creacionSiniestroAutosFactory.setLossDate(lstSiniestroParam.get(campoDato).getFechaSiniestro());
    creacionSiniestroAutosFactory.setNotificationDate(
        lstSiniestroParam.get(campoDato).getFechaNotificacionSiniestro());
    creacionSiniestroAutosFactory.setLossType(lstSiniestroParam.get(campoDato).getTipoPerdida());
    creacionSiniestroAutosFactory.setLossCause(
        lstSiniestroParam.get(campoDato).getCausaSiniestro());
    creacionSiniestroAutosFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroAutosFactory.setMacaNumber(lstSiniestroParam.get(campoDato).getNumeroMaca());
    creacionSiniestroAutosFactory.setFaultRating(
        lstSiniestroParam.get(campoDato).getCodigoCulpabilidad());
    creacionSiniestroAutosFactory.setAuthorUser(
        lstSiniestroParam.get(campoDato).getIdentificacionAutor());
    creacionSiniestroAutosFactory.setIsSuspect(lstSiniestroParam.get(campoDato).getSospechoso());
    creacionSiniestroAutosFactory.setSuspectDesc(
        lstSiniestroParam.get(campoDato).getDescripcionSospecha());
    creacionSiniestroAutosFactory.setOriginCause(lstSiniestroParam.get(campoDato).getOrigenCausa());
    creacionSiniestroAutosFactory.setSegment(lstSiniestroParam.get(campoDato).getSegmento());
    creacionSiniestroAutosFactory.setAuthorityTransit(
        lstSiniestroParam.get(campoDato).getAutoridadTransito());
  }

  private void asignarParametrosAutor(List<PersonaConductorAuto> lstConductor) {
    creacionSiniestroAutosFactory.setDocumentType(lstConductor.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDAuthor(lstConductor.get(campoDato).getNumDocumento());
  }

  private void asignarParametrosValorPerdida(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setAmountLossEstimate(
        lstSiniestroParam.get(campoDato).getValorPerdidaSiniestro());
    creacionSiniestroAutosFactory.setCurrencyLossEstimate(
        lstSiniestroParam.get(campoDato).getTipoMonedaPoliza());
  }

  private void asignarParametrosContactoPrincipal(
      List<PersonaConductorAuto> lstPersonaReclamacionAuto) {
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

  private void asignarParametrosDireccionPrincipal(List<PersonaConductorAuto> lstConductor) {
    creacionSiniestroAutosFactory.setAddressLine1MainContact(
        lstConductor.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setAddressTypeMainContact(
        lstConductor.get(campoDato).getTipoDireccion());
    creacionSiniestroAutosFactory.setCityMainContact(lstConductor.get(campoDato).getCiudad());
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

  private void asignarParametrosConductorVehiculo(List<PersonaConductorAuto> lstConductor) {
    creacionSiniestroAutosFactory.setFirstNameDriver(lstConductor.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setMiddleNameDriver(
        lstConductor.get(campoDato).getSegundoNombre());
    creacionSiniestroAutosFactory.setLastNameDriver(
        lstConductor.get(campoDato).getPrimerApellido());
    creacionSiniestroAutosFactory.setSecondLastNameDriver(
        lstConductor.get(campoDato).getSegundoApellido());
    creacionSiniestroAutosFactory.setWorkNumberDriver(
        lstConductor.get(campoDato).getNumeroTrabajo());
    creacionSiniestroAutosFactory.setCellNumberDriver(lstConductor.get(campoDato).getCelular());
    creacionSiniestroAutosFactory.setEmailAddress1Driver(
        lstConductor.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setPolicyRoleDriver(lstConductor.get(campoDato).getPolicyRole());
    creacionSiniestroAutosFactory.setDocumentTypeDriver(
        lstConductor.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDDriver(lstConductor.get(campoDato).getNumDocumento());
  }

  private void asignarParametrosDireccionConductor(List<PersonaConductorAuto> lstConductor) {
    creacionSiniestroAutosFactory.setAddressLine1Driver(lstConductor.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setAddressTypeDriver(
        lstConductor.get(campoDato).getTipoDireccion());
    creacionSiniestroAutosFactory.setCityDriver(lstConductor.get(campoDato).getCiudad());
  }

  private void asignarParametrosDireccionContactoPrincipal(
      List<ReclamacionAuto> lstSiniestroParam) {
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
    creacionSiniestroAutosFactory.setColorVehicle(lstVehiculoParam.get(campoDato).getColor());
    creacionSiniestroAutosFactory.setVehicleType(lstVehiculoParam.get(campoDato).getTipoVehiculo());
    creacionSiniestroAutosFactory.setFasecoldaCode(
        lstVehiculoParam.get(campoDato).getCodigoFasecolda());
    creacionSiniestroAutosFactory.setVinVehicle(lstVehiculoParam.get(campoDato).getChasis());
  }

  private void asignarParametrosReclamante(List<PersonaConductorAuto> lstConductor) {
    creacionSiniestroAutosFactory.setDocumentTypeAnt(
        lstConductor.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setContactNameAnt(lstConductor.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setTaxIdAnt(lstConductor.get(campoDato).getNumDocumento());
    creacionSiniestroAutosFactory.setEmailAddress1Ant(
        lstConductor.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setCellNumberAnt(lstConductor.get(campoDato).getCelular());
  }

  private void asignarParametrosDescripcionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosIncidenteLesion(List<PersonaReclamacionAuto> lstPersonaLesionada) {
    creacionSiniestroAutosFactory.setLossPartyInjuryIncident(
        lstPersonaLesionada.get(campoDato).getParteLesionada());
    creacionSiniestroAutosFactory.setSeverityInjuryIncident(
        lstPersonaLesionada.get(campoDato).getGravedadLesion());
    creacionSiniestroAutosFactory.setDescriptionInjuryIncident(
        lstPersonaLesionada.get(campoDato).getDescripcionLesion());
    creacionSiniestroAutosFactory.setGeneralInjuryType(
        lstPersonaLesionada.get(campoDato).getLesionGeneral());
    creacionSiniestroAutosFactory.setDetailedInjuryType(
        lstPersonaLesionada.get(campoDato).getDetalleLesion());
  }

  private void asignarParametrosLesionado(List<PersonaReclamacionAuto> lstPersonaLesionada) {
    creacionSiniestroAutosFactory.setFirstNameInjured(
        lstPersonaLesionada.get(campoDato).getPrimerNombre());
    creacionSiniestroAutosFactory.setMiddleNameInjured(
        lstPersonaLesionada.get(campoDato).getSegundoNombre());
    creacionSiniestroAutosFactory.setLastNameInjured(
        lstPersonaLesionada.get(campoDato).getPrimerApellido());
    creacionSiniestroAutosFactory.setSecondLastNameInjured(
        lstPersonaLesionada.get(campoDato).getSegundoApellido());
    creacionSiniestroAutosFactory.setWorkNumberInjured(
        lstPersonaLesionada.get(campoDato).getNumeroTrabajo());
    creacionSiniestroAutosFactory.setCellNumberInjured(
        lstPersonaLesionada.get(campoDato).getCelular());
    creacionSiniestroAutosFactory.setEmailAddress1Injured(
        lstPersonaLesionada.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutosFactory.setDocumentTypeInjured(
        lstPersonaLesionada.get(campoDato).getTipoDocumento());
    creacionSiniestroAutosFactory.setTaxIDInjured(
        lstPersonaLesionada.get(campoDato).getNumDocumento());
  }

  private void agregarDireccionLesionado(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setAddressLine1Injured(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setAddressTypeInjured(
        lstSiniestroParam.get(campoDato).getTipoDireccion());
    creacionSiniestroAutosFactory.setCityInjured(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosDetalleParteCuerpo(
      List<PersonaReclamacionAuto> lstPersonaLesionada) {
    creacionSiniestroAutosFactory.setPrimaryBodyPart1(
        lstPersonaLesionada.get(campoDato).getParteCuerpo());
    creacionSiniestroAutosFactory.setDetailedBodyPartType1(
        lstPersonaLesionada.get(campoDato).getDetalleParteCuerpo());
    creacionSiniestroAutosFactory.setPrimaryBodyPart2(
        lstPersonaLesionada.get(campoDato).getParteCuerpo());
    creacionSiniestroAutosFactory.setDetailedBodyPartType2(
        lstPersonaLesionada.get(campoDato).getDetalleParteCuerpo());
  }

  private void asignarParametrosDireccionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutosFactory.setCountryLossLocation(
        lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroAutosFactory.setAddressLine1LossLocation(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutosFactory.setCityLossLocation(lstSiniestroParam.get(campoDato).getCiudad());
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
