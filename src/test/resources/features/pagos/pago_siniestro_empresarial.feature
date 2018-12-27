# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamacion
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial

  Esquema del escenario: Pago siniestro empresarial
    Dado que se tiene una poliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretension de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando se realice un pago <tipoPago> a <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | lineaReserva          | tipoPago | beneficiarioPago          | metodoPago     | soloSura | codigoRetencion | Tipo y Cobertura                        | Causa          | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª parteContenido | Parcial  | SOLO FAMILIAR LTDA. CQLII | Pago por banco | Sí       | 0099            | Incendio con cobertura Daños materiales | Daños por agua | 3000000             | Contenido         |
