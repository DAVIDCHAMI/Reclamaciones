package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.pages.generics.GeneralPage.LOGGER;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.service.cliente.siniestro.CreacionSiniestroCliente;
import com.sura.service.creacionSiniestro.gen.ClaimsRequest;
import com.sura.service.creacionSiniestro.gen.ClaimsResponse;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConsumoServicioCreacionSiniestro {

  @RequestMapping
  public void siniestrarPoliza(
      List<ReclamacionEmpresarial> lstSiniestroParam,
      List<ReclamacionEmpresarial> lstParametroLossEstimate,
      List<ReclamacionEmpresarial> lstParametroProperty,
      List<ReclamacionEmpresarial> lstParametroPrimaryAddress,
      List<ReclamacionEmpresarial> lstParametroLossLocation,
      List<ReclamacionEmpresarial> lstParametroCPLine,
      List<ReclamacionEmpresarial> lstParametroDescription,
      List<ReclamacionEmpresarial> lstParametroIsPolicyProperty,
      List<ReclamacionEmpresarial> lstParametroPropertyDesc,
      List<Persona> lstParametroAuthor,
      List<Persona> lstParametroMainContact,
      List<Persona> lstParametroClaimAnt) {

    ClaimsResponse response;
    CreacionSiniestroCliente creacionSiniestroCliente = new CreacionSiniestroCliente();
    CreacionSiniestroFactory creacionSiniestroFactory = new CreacionSiniestroFactory();

    for (int i = 0; i < lstSiniestroParam.size(); i++) {
      creacionSiniestroFactory.setPolicyNumber(lstSiniestroParam.get(i).getNumPoliza());
      creacionSiniestroFactory.setDescriptionLoss(lstSiniestroParam.get(i).getDescripcionHechos());
      creacionSiniestroFactory.setNotificationDate(lstSiniestroParam.get(i).getFechaAviso());
      creacionSiniestroFactory.setLossDate(lstSiniestroParam.get(i).getFechaSiniestro());
      creacionSiniestroFactory.setAuthorUser(lstSiniestroParam.get(i).getIdAutor());
      creacionSiniestroFactory.setLossCause(lstSiniestroParam.get(i).getCausaPerdida());

      creacionSiniestroFactory.setDocumentTypeAuthor(lstParametroAuthor.get(i).getTipoDocumento());
      creacionSiniestroFactory.setTaxIdAuthor(lstParametroAuthor.get(i).getNumDocumento());
      creacionSiniestroFactory.setNameAuthor(lstParametroAuthor.get(i).getPrimerNombre());

      creacionSiniestroFactory.setAmountLossEstimate(lstParametroLossEstimate.get(i).getAmount());
      creacionSiniestroFactory.setCurrencyLossEstimate(
          lstParametroLossEstimate.get(i).getCurrency());

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

      creacionSiniestroFactory.setStateMainContact(lstParametroPrimaryAddress.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1MainContact(
          lstParametroPrimaryAddress.get(i).getDireccion());
      creacionSiniestroFactory.setCityMainContact(lstParametroPrimaryAddress.get(i).getCiudad());

      creacionSiniestroFactory.setPolicySystemId(lstParametroCPLine.get(i).getPolicySystemId());

      creacionSiniestroFactory.setDescription(
          lstParametroDescription.get(i).getDescripcionHechos());
      creacionSiniestroFactory.setIsPolicyProperty(
          lstParametroIsPolicyProperty.get(i).getIsPolicyProperty());

      creacionSiniestroFactory.setStateProperty(lstParametroProperty.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Property(lstParametroProperty.get(i).getDireccion());
      creacionSiniestroFactory.setCityProperty(lstParametroProperty.get(i).getCiudad());

      creacionSiniestroFactory.setDocumentTypeAnt(lstParametroClaimAnt.get(i).getTipoDocumento());
      creacionSiniestroFactory.setContactNameAnt(lstParametroClaimAnt.get(i).getPrimerNombre());
      creacionSiniestroFactory.setTaxIdAnt(lstParametroClaimAnt.get(i).getNumDocumento());
      creacionSiniestroFactory.setEmailAddress1Ant(
          lstParametroClaimAnt.get(i).getCorreoElectronico());
      creacionSiniestroFactory.setCellNumberAnt(lstParametroClaimAnt.get(i).getCelular());

      creacionSiniestroFactory.setStateAnt(lstParametroPrimaryAddress.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1Ant(lstParametroPrimaryAddress.get(i).getDireccion());
      creacionSiniestroFactory.setCityAnt(lstParametroPrimaryAddress.get(i).getCiudad());

      creacionSiniestroFactory.setPropertyDesc(
          lstParametroPropertyDesc.get(i).getDescripcionHechos());

      creacionSiniestroFactory.setDescription(
          lstParametroDescription.get(i).getDescripcionHechos());

      creacionSiniestroFactory.setStateLossLocation(lstParametroLossLocation.get(i).getPais());
      creacionSiniestroFactory.setAddressLine1LossLocation(
          lstParametroLossLocation.get(i).getDireccion());
      creacionSiniestroFactory.setCityLossLocation(lstParametroLossLocation.get(i).getCiudad());

      ClaimsRequest parametro = creacionSiniestroFactory.creacionSiniestroRequestFactory();
      response = creacionSiniestroCliente.claimsResponse(parametro);

      LOGGER.info("Número de siniestro: " + response.getResult().getClaimNumber());
      GenericStep genericStep = new GenericStep();
      genericStep.generarRegistro(
          response.getResult().getClaimNumber(), ConstanteGlobal.EMPRESARIALES);
      Serenity.setSessionVariable(ReclamacionConstante.NUMERO_SINIESTRO)
          .to(response.getResult().getClaimNumber());
    }
  }
}
