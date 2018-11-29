package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.pages.generics.GeneralPage.LOGGER;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.service.cliente.siniestro.CreacionSiniestroCliente;
import com.sura.service.creacionSiniestro.gen.ClaimsRequest;
import com.sura.service.creacionSiniestro.gen.ClaimsResponse;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConsumoServicioCreacionSiniestro {

  CreacionSiniestroFactory creacionSiniestroFactory = new CreacionSiniestroFactory();
  CreacionSiniestroCliente creacionSiniestroCliente = new CreacionSiniestroCliente();
  ClaimsResponse response;

  @RequestMapping
  public void asignarParametrosSiniestro(List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setPolicyNumber(lstSiniestroParam.get(i).getNumPoliza());
      creacionSiniestroFactory.setDescriptionLoss(
          lstSiniestroParam.get(i).getDescripcionHechosSiniestro());
      creacionSiniestroFactory.setNotificationDate(
          lstSiniestroParam.get(i).getFechaAvisoSiniestro());
      creacionSiniestroFactory.setLossDate(lstSiniestroParam.get(i).getFechaSiniestro());
      creacionSiniestroFactory.setAuthorUser(lstSiniestroParam.get(i).getIdentificacionAutor());
      creacionSiniestroFactory.setLossCause(lstSiniestroParam.get(i).getCausaSiniestro());
    }
  }

  public void asignarParametrosAutor(List<Persona> lstParametroPersona) {
    for (int i = 0; i < lstParametroPersona.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeAuthor(lstParametroPersona.get(i).getTipoDocumento());
      creacionSiniestroFactory.setTaxIdAuthor(lstParametroPersona.get(i).getNumDocumento());
      creacionSiniestroFactory.setNameAuthor(lstParametroPersona.get(i).getPrimerNombre());
    }
  }

  public void asignarParametrosValorPerdida(List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setAmountLossEstimate(
          lstSiniestroParam.get(i).getValorPerdidaSiniestro());
      creacionSiniestroFactory.setCurrencyLossEstimate(
          lstSiniestroParam.get(i).getTipoMonedaPoliza());
    }
  }

  public void asignarParametrosContactoPrincipal(List<Persona> lstParametroPersona) {
    for (int i = 0; i < lstParametroPersona.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeMainContact(
          lstParametroPersona.get(i).getTipoDocumento());
      creacionSiniestroFactory.setContactNameMainContact(
          lstParametroPersona.get(i).getPrimerNombre());
      creacionSiniestroFactory.setTaxIdMainContact(lstParametroPersona.get(i).getNumDocumento());
      creacionSiniestroFactory.setEmailAddress1MainContact(
          lstParametroPersona.get(i).getCorreoElectronico());
      creacionSiniestroFactory.setCellNumberMainContact(lstParametroPersona.get(i).getCelular());
    }
  }

  public void asignarParametrosDireccionPrincipal(List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setStateMainContact(lstSiniestroParam.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1MainContact(lstSiniestroParam.get(i).getDireccion());
      creacionSiniestroFactory.setCityMainContact(lstSiniestroParam.get(i).getCiudad());
      creacionSiniestroFactory.setStateAnt(lstSiniestroParam.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Ant(lstSiniestroParam.get(i).getDireccion());
      creacionSiniestroFactory.setCityAnt(lstSiniestroParam.get(i).getCiudad());
    }
  }

  public void asignarParametrosTipoIncidente(List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setPolicySystemId(lstSiniestroParam.get(i).getIdentificadorRiesgo());
      creacionSiniestroFactory.setFixedPropertyIncident(
          lstSiniestroParam.get(i).getIncidentePropiedad());
      creacionSiniestroFactory.setPropertyContentsIncident(
          lstSiniestroParam.get(i).getIncidenteContenido());
    }
  }

  public void asignarParametrosInformacionSiniestro(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setDescription(
          lstSiniestroParam.get(i).getDescripcionHechosSiniestro());
      creacionSiniestroFactory.setIsPolicyProperty(lstSiniestroParam.get(i).getEsPolizaPropiedad());
    }
  }

  public void asignarParametrosDireccionSiniestro(List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setStateProperty(lstSiniestroParam.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Property(lstSiniestroParam.get(i).getDireccion());
      creacionSiniestroFactory.setCityProperty(lstSiniestroParam.get(i).getCiudad());
    }
  }

  public void asignarParametrosReclamante(List<Persona> lstParametroPersona) {
    for (int i = 0; i < lstParametroPersona.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeAnt(lstParametroPersona.get(i).getTipoDocumento());
      creacionSiniestroFactory.setContactNameAnt(lstParametroPersona.get(i).getPrimerNombre());
      creacionSiniestroFactory.setTaxIdAnt(lstParametroPersona.get(i).getNumDocumento());
      creacionSiniestroFactory.setEmailAddress1Ant(
          lstParametroPersona.get(i).getCorreoElectronico());
      creacionSiniestroFactory.setCellNumberAnt(lstParametroPersona.get(i).getCelular());
    }
  }

  public void asignarParametrosDescripcionPropiedad(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setPropertyDesc(
          lstSiniestroParam.get(i).getDescripcionHechosSiniestro());
    }
  }

  public void asignarParametrosDescripcionSiniestro(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setDescription(
          lstSiniestroParam.get(i).getDescripcionHechosSiniestro());
    }
  }

  public void asignarParametrosLocalizacionPropiedad(
      List<ReclamacionEmpresarial> lstSiniestroParam) {
    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setStateLossLocation(lstSiniestroParam.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1LossLocation(lstSiniestroParam.get(i).getDireccion());
      creacionSiniestroFactory.setCityLossLocation(lstSiniestroParam.get(i).getCiudad());
    }
  }

  public ClaimsRequest crearRequest() {
    return creacionSiniestroFactory.creacionSiniestroRequestFactory();
  }

  public void obtenerResponse() {
    response = creacionSiniestroCliente.claimsResponse(crearRequest());
    LOGGER.info("Número de siniestro: " + response.getResult().getClaimNumber());
    Serenity.setSessionVariable(ReclamacionConstante.NUMERO_SINIESTRO)
        .to(response.getResult().getClaimNumber());
  }
}
