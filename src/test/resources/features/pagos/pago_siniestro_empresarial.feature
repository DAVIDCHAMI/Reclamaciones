# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamación
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial

  Esquema del escenario: Pago siniestro empresarial
    Dado que se tiene una poliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretension de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando se realice un pago <Tipo de pago> a <Beneficiario del pago> por medio de <Método del pago> el cual cuenta con una linea de reserva <Linea de Reserva> donde el responsable <¿Es pago soloSura?> es Sura por una retención de <Código de Retención>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Linea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                        | Causa          | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | Sí                 | 0099                | Incendio con cobertura Daños materiales | Daños por agua | 5000000             | Propiedad         |
