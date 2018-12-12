package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.pages.generics.GeneralPage.LOGGER;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.service.cliente.siniestro.CreacionSiniestroAutoCliente;
import com.sura.service.creacionSiniestroAuto.gen.ClaimsAutoRequest;
import com.sura.service.creacionSiniestroAuto.gen.ClaimsAutoResponse;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConsumoServicioCreacionSiniestroAutos {

  int campoDato = 0;
  CreacionSiniestroAutoFactory creacionSiniestroAutoFactory = new CreacionSiniestroAutoFactory();
  CreacionSiniestroAutoCliente creacionSiniestroAutoCliente = new CreacionSiniestroAutoCliente();
  ClaimsAutoResponse response;
  List<ReclamacionAuto> lstSiniestroParam;
  List<Persona> lstParametroPersona;

  @RequestMapping
  public void asignarParametrosRequest(
      List<ReclamacionAuto> lstSiniestroParam, List<Persona> lstParametroPersona) {
    asignarParametrosSiniestro(lstSiniestroParam);
    asignarParametrosAutor(lstParametroPersona);
    asignarParametrosValorPerdida(lstSiniestroParam);
    asignarParametrosContactoPrincipal(lstParametroPersona);
    asignarParametrosDireccionPrincipal(lstSiniestroParam);
    asignarParametrosInformacionSiniestro(lstSiniestroParam);
    asignarParametrosDireccionSiniestro(lstSiniestroParam);
    asignarParametrosReclamante(lstParametroPersona);
    crearRequest();
    obtenerResponse();
  }

  private void asignarParametrosSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setPolicyNumber(lstSiniestroParam.get(campoDato).getNumPoliza());
    creacionSiniestroAutoFactory.setDescriptionLoss(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroAutoFactory.setNotificationDate(
        lstSiniestroParam.get(campoDato).getFechaAvisoSiniestro());
    creacionSiniestroAutoFactory.setLossDate(lstSiniestroParam.get(campoDato).getFechaSiniestro());
    creacionSiniestroAutoFactory.setAuthorUser(
        lstSiniestroParam.get(campoDato).getIdentificacionAutor());
    creacionSiniestroAutoFactory.setLossCause(lstSiniestroParam.get(campoDato).getCausaSiniestro());
  }

  private void asignarParametrosAutor(List<Persona> lstParametroPersona) {
    creacionSiniestroAutoFactory.setDocumentType(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroAutoFactory.setTaxID(lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroAutoFactory.setAuthorName(
        lstParametroPersona.get(campoDato).getPrimerNombre());
  }

  private void asignarParametrosValorPerdida(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setAmount(
        lstSiniestroParam.get(campoDato).getValorPerdidaSiniestro());
    creacionSiniestroAutoFactory.setCurrency(
        lstSiniestroParam.get(campoDato).getTipoMonedaPoliza());
  }

  private void asignarParametrosContactoPrincipal(List<Persona> lstParametroPersona) {
    creacionSiniestroAutoFactory.setDocumentTypeMainContact(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroAutoFactory.setFirstNameContactName(
        lstParametroPersona.get(campoDato).getPrimerNombre());
    creacionSiniestroAutoFactory.setTaxIDMainContact(
        lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroAutoFactory.setEmailAddress1(
        lstParametroPersona.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutoFactory.setCellNumberMainContact(
        lstParametroPersona.get(campoDato).getCelular());
  }

  private void asignarParametrosDireccionPrincipal(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setStateMainContact(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroAutoFactory.setAddressLine1MainContact(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutoFactory.setCityMainContact(lstSiniestroParam.get(campoDato).getCiudad());
    creacionSiniestroAutoFactory.setStateAnt(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroAutoFactory.setAddressLine1Ant(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutoFactory.setCityAnt(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosInformacionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosDireccionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setCountryLossLocation(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroAutoFactory.setAddressLine1LossLocation(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroAutoFactory.setCityLossLocation(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosReclamante(List<Persona> lstParametroPersona) {
    creacionSiniestroAutoFactory.setDocumentTypeAnt(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroAutoFactory.setContactNameAnt(
        lstParametroPersona.get(campoDato).getPrimerNombre());
    creacionSiniestroAutoFactory.setTaxIdAnt(lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroAutoFactory.setEmailAddress1Ant(
        lstParametroPersona.get(campoDato).getCorreoElectronico());
    creacionSiniestroAutoFactory.setCellNumberAnt(lstParametroPersona.get(campoDato).getCelular());
  }

  private void asignarParametrosDescripcionSiniestro(List<ReclamacionAuto> lstSiniestroParam) {
    creacionSiniestroAutoFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosConductorVehiculo(List<ReclamacionAuto> lstSiniestroParam) {}

  private ClaimsAutoRequest crearRequest() {
    return creacionSiniestroAutoFactory.creacionSiniestroAutoRequestFactory();
  }

  private void obtenerResponse() {
    response = creacionSiniestroAutoCliente.claimsResponse(crearRequest());
    LOGGER.info("Número de siniestro: " + response.getResult().getClaimNumber());
    Serenity.setSessionVariable(ReclamacionConstante.NUMERO_SINIESTRO)
        .to(response.getResult().getClaimNumber());
  }
}
