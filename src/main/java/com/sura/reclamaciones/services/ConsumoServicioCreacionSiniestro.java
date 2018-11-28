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

  public void asignarParametrosAutor(List<Persona> lstParametroAuthor) {
    for (int i = 0; i < lstParametroAuthor.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeAuthor(lstParametroAuthor.get(i).getTipoDocumento());
      creacionSiniestroFactory.setTaxIdAuthor(lstParametroAuthor.get(i).getNumDocumento());
      creacionSiniestroFactory.setNameAuthor(lstParametroAuthor.get(i).getPrimerNombre());
    }
  }

  public void asignarParametrosValorPerdida(List<ReclamacionEmpresarial> lstParametroLossEstimate) {
    for (int i = 0; i < lstParametroLossEstimate.size(); i++) {
      creacionSiniestroFactory.setAmountLossEstimate(
          lstParametroLossEstimate.get(i).getValorPerdidaSiniestro());
      creacionSiniestroFactory.setCurrencyLossEstimate(
          lstParametroLossEstimate.get(i).getTipoMonedaPoliza());
    }
  }

  public void asignarParametrosContactoPrincipal(List<Persona> lstParametroMainContact) {
    for (int i = 0; i < lstParametroMainContact.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeMainContact(
          lstParametroMainContact.get(i).getTipoDocumento());
      creacionSiniestroFactory.setContactNameMainContact(
          lstParametroMainContact.get(i).getPrimerNombre());
      creacionSiniestroFactory.setTaxIdMainContact(
          lstParametroMainContact.get(i).getNumDocumento());
      creacionSiniestroFactory.setEmailAddress1MainContact(
          lstParametroMainContact.get(i).getCorreoElectronico());
      creacionSiniestroFactory.setCellNumberMainContact(
          lstParametroMainContact.get(i).getCelular());
    }
  }

  public void asignarParametrosDireccionPrincipal(
      List<ReclamacionEmpresarial> lstParametroPrimaryAddress) {
    for (int i = 0; i < lstParametroPrimaryAddress.size(); i++) {
      creacionSiniestroFactory.setStateMainContact(lstParametroPrimaryAddress.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1MainContact(
          lstParametroPrimaryAddress.get(i).getDireccion());
      creacionSiniestroFactory.setCityMainContact(lstParametroPrimaryAddress.get(i).getCiudad());
      creacionSiniestroFactory.setStateAnt(lstParametroPrimaryAddress.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Ant(lstParametroPrimaryAddress.get(i).getDireccion());
      creacionSiniestroFactory.setCityAnt(lstParametroPrimaryAddress.get(i).getCiudad());
    }
  }

  public void asignarParametrosTipoIncidente(List<ReclamacionEmpresarial> lstParametroCPLine) {
    for (int i = 0; i < lstParametroCPLine.size(); i++) {
      creacionSiniestroFactory.setPolicySystemId(
          lstParametroCPLine.get(i).getIdentificadorRiesgo());
      creacionSiniestroFactory.setFixedPropertyIncident(
          lstParametroCPLine.get(i).getIncidentePropiedad());
      creacionSiniestroFactory.setPropertyContentsIncident(
          lstParametroCPLine.get(i).getIncidenteContenido());
    }
  }

  public void asignarParametrosInformacionSiniestro(
      List<ReclamacionEmpresarial> lstParametroDescription,
      List<ReclamacionEmpresarial> lstParametroIsPolicyProperty) {
    for (int i = 0; i < lstParametroDescription.size(); i++) {
      creacionSiniestroFactory.setDescription(
          lstParametroDescription.get(i).getDescripcionHechosSiniestro());
      creacionSiniestroFactory.setIsPolicyProperty(
          lstParametroIsPolicyProperty.get(i).getEsPolizaPropiedad());
    }
  }

  public void asignarParametrosDireccionSiniestro(
      List<ReclamacionEmpresarial> lstParametroProperty) {
    for (int i = 0; i < lstParametroProperty.size(); i++) {
      creacionSiniestroFactory.setStateProperty(lstParametroProperty.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Property(lstParametroProperty.get(i).getDireccion());
      creacionSiniestroFactory.setCityProperty(lstParametroProperty.get(i).getCiudad());
    }
  }

  public void asignarParametrosReclamante(List<Persona> lstParametroClaimAnt) {
    for (int i = 0; i < lstParametroClaimAnt.size(); i++) {
      creacionSiniestroFactory.setDocumentTypeAnt(lstParametroClaimAnt.get(i).getTipoDocumento());
      creacionSiniestroFactory.setContactNameAnt(lstParametroClaimAnt.get(i).getPrimerNombre());
      creacionSiniestroFactory.setTaxIdAnt(lstParametroClaimAnt.get(i).getNumDocumento());
      creacionSiniestroFactory.setEmailAddress1Ant(
          lstParametroClaimAnt.get(i).getCorreoElectronico());
      creacionSiniestroFactory.setCellNumberAnt(lstParametroClaimAnt.get(i).getCelular());
    }
  }

  public void asignarParametrosDescripcionPropiedad(
      List<ReclamacionEmpresarial> lstParametroPropertyDesc) {
    for (int i = 0; i < lstParametroPropertyDesc.size(); i++) {
      creacionSiniestroFactory.setPropertyDesc(
          lstParametroPropertyDesc.get(i).getDescripcionHechosSiniestro());
    }
  }

  public void asignarParametrosDescripcionSiniestro(
      List<ReclamacionEmpresarial> lstParametroDescription) {
    for (int i = 0; i < lstParametroDescription.size(); i++) {
      creacionSiniestroFactory.setDescription(
          lstParametroDescription.get(i).getDescripcionHechosSiniestro());
    }
  }

  public void asignarParametrosLocalizacionPropiedad(
      List<ReclamacionEmpresarial> lstParametroLossLocation) {
    for (int i = 0; i < lstParametroLossLocation.size(); i++) {
      creacionSiniestroFactory.setStateLossLocation(lstParametroLossLocation.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1LossLocation(
          lstParametroLossLocation.get(i).getDireccion());
      creacionSiniestroFactory.setCityLossLocation(lstParametroLossLocation.get(i).getCiudad());
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


