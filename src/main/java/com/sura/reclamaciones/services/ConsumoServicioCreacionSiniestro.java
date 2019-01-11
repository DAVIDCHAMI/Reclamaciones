package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.service.cliente.siniestro.CreacionSiniestroCliente;
import com.sura.service.creacionSiniestro.gen.ClaimsRequest;
import com.sura.service.creacionSiniestro.gen.ClaimsResponse;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConsumoServicioCreacionSiniestro {
  int campoDato = 0;
  CreacionSiniestroFactory creacionSiniestroFactory = new CreacionSiniestroFactory();
  CreacionSiniestroCliente creacionSiniestroCliente = new CreacionSiniestroCliente();
  ClaimsResponse response;

  @RequestMapping
  public void asignarParametrosRequest(
      List<ReclamacionEmpresarial> lstSiniestroParam, List<Persona> lstParametroPersona) {
    asignarParametrosSiniestro(lstSiniestroParam);
    asignarParametrosAutor(lstParametroPersona);
    asignarParametrosValorPerdida(lstSiniestroParam);
    asignarParametrosContactoPrincipal(lstParametroPersona);
    asignarParametrosDireccionPrincipal(lstSiniestroParam);
    asignarParametrosTipoIncidente(lstSiniestroParam);
    asignarParametrosInformacionSiniestro(lstSiniestroParam);
    asignarParametrosDireccionSiniestro(lstSiniestroParam);
    asignarParametrosReclamante(lstParametroPersona);
    asignarParametrosDescripcionPropiedad(lstSiniestroParam);
    asignarParametrosDescripcionSiniestro(lstSiniestroParam);
    asignarParametrosLocalizacionPropiedad(lstSiniestroParam);
    crearRequest();
    obtenerResponse();
  }

  private void asignarParametrosSiniestro(List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setPolicyNumber(lstSiniestroParam.get(campoDato).getNumPoliza());
    creacionSiniestroFactory.setDescriptionLoss(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroFactory.setNotificationDate(
        lstSiniestroParam.get(campoDato).getFechaAvisoSiniestro());
    creacionSiniestroFactory.setLossDate(lstSiniestroParam.get(campoDato).getFechaSiniestro());
    creacionSiniestroFactory.setAuthorUser(
        lstSiniestroParam.get(campoDato).getIdentificacionAutor());
    creacionSiniestroFactory.setLossCause(lstSiniestroParam.get(campoDato).getCausaPerdida());
  }

  private void asignarParametrosAutor(List<Persona> lstParametroPersona) {
    creacionSiniestroFactory.setDocumentTypeAuthor(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroFactory.setTaxIdAuthor(lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroFactory.setNameAuthor(lstParametroPersona.get(campoDato).getPrimerNombre());
  }

  private void asignarParametrosValorPerdida(List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setAmountLossEstimate(
        lstSiniestroParam.get(campoDato).getValorPerdidaSiniestro());
    creacionSiniestroFactory.setCurrencyLossEstimate(
        lstSiniestroParam.get(campoDato).getTipoMonedaPoliza());
  }

  private void asignarParametrosContactoPrincipal(List<Persona> lstParametroPersona) {
    creacionSiniestroFactory.setDocumentTypeMainContact(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroFactory.setContactNameMainContact(
        lstParametroPersona.get(campoDato).getPrimerNombre());
    creacionSiniestroFactory.setTaxIdMainContact(
        lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroFactory.setEmailAddress1MainContact(
        lstParametroPersona.get(campoDato).getCorreoElectronico());
    creacionSiniestroFactory.setCellNumberMainContact(
        lstParametroPersona.get(campoDato).getCelular());
  }

  private void asignarParametrosDireccionPrincipal(List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setStateMainContact(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroFactory.setAddressLine1MainContact(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroFactory.setCityMainContact(lstSiniestroParam.get(campoDato).getCiudad());
    creacionSiniestroFactory.setStateAnt(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroFactory.setAddressLine1Ant(lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroFactory.setCityAnt(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosTipoIncidente(List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setPolicySystemId(
        lstSiniestroParam.get(campoDato).getIdentificadorRiesgo());
    creacionSiniestroFactory.setFixedPropertyIncident(
        lstSiniestroParam.get(campoDato).getIncidentePropiedad());
    creacionSiniestroFactory.setPropertyContentsIncident(
        lstSiniestroParam.get(campoDato).getIncidenteContenido());
  }

  private void asignarParametrosInformacionSiniestro(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
    creacionSiniestroFactory.setIsPolicyProperty(
        lstSiniestroParam.get(campoDato).getEsPolizaPropiedad());
  }

  private void asignarParametrosDireccionSiniestro(List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setStateProperty(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroFactory.setAddressLine1Property(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroFactory.setCityProperty(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private void asignarParametrosReclamante(List<Persona> lstParametroPersona) {
    creacionSiniestroFactory.setDocumentTypeAnt(
        lstParametroPersona.get(campoDato).getTipoDocumento());
    creacionSiniestroFactory.setContactNameAnt(
        lstParametroPersona.get(campoDato).getPrimerNombre());
    creacionSiniestroFactory.setTaxIdAnt(lstParametroPersona.get(campoDato).getNumDocumento());
    creacionSiniestroFactory.setEmailAddress1Ant(
        lstParametroPersona.get(campoDato).getCorreoElectronico());
    creacionSiniestroFactory.setCellNumberAnt(lstParametroPersona.get(campoDato).getCelular());
  }

  private void asignarParametrosDescripcionPropiedad(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setPropertyDesc(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosDescripcionSiniestro(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setDescription(
        lstSiniestroParam.get(campoDato).getDescripcionHechosSiniestro());
  }

  private void asignarParametrosLocalizacionPropiedad(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    creacionSiniestroFactory.setStateLossLocation(lstSiniestroParam.get(campoDato).getPais());
    creacionSiniestroFactory.setAddressLine1LossLocation(
        lstSiniestroParam.get(campoDato).getDireccion());
    creacionSiniestroFactory.setCityLossLocation(lstSiniestroParam.get(campoDato).getCiudad());
  }

  private ClaimsRequest crearRequest() {
    return creacionSiniestroFactory.creacionSiniestroRequestFactory();
  }

  private void obtenerResponse() {
    response = creacionSiniestroCliente.claimsResponse(crearRequest());
    Utilidades.getLogger().info("Número de siniestro: " + response.getResult().getClaimNumber());
    Serenity.setSessionVariable(SESION_CC_NUMERO_SINIESTRO.getValor())
        .to(response.getResult().getClaimNumber());
  }
}
