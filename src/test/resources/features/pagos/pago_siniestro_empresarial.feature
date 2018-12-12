# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamacion
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial
  Esquema del escenario: Pago siniestro empresarial
    Dado que se tiene un siniestro del producto <producto>
    Cuando se realice un pago <tipoPago> a <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | producto        | lineaReserva          | tipoPago | beneficiarioPago                        | metodoPago     | soloSura | codigoRetencion |
      | MRC_01          | (1) 1ª parteContenido | Parcial  | SOLO FAMILIAR LTDA. CQLII               | Pago por banco | Sí       | 0099            |
      | MRC_02          | (1) 1ª partePropiedad | Final    | PISOS Y MAS PISOS LTDA. CQLII           | Pago por banco | No       | 0099            |
      | HOGAR_01        | (1) 1ª parteContenido | Parcial  | AURA JUDITH LOPEZ JULIO CQLII           | Caja Sura      | No       | 0023            |
      | RC_01           | (1) 1ª parteGeneral   | Final    | INDUSTRIALES S.A. CQLII                 | Pago por banco | No       | 0099            |
      | MRC_03          | (1) 1ª parteContenido | Parcial  | CLUB LOS TRIUNFADORES CQLII             | Pago por banco | No       | 0023            |
      | HOGAR_02        | (1) 1ª parteContenido | Final    | NOEMY DEL SOCORRO ROQUEME CASTAÑO CQLII | Caja Sura      | No       | 0099            |
      | MRC_04          | (1) 1ª parteContenido | Final    | REASEGUROS LTDA. CQLII                  | Caja Sura      | No       | 0099            |
      | CUMPLIMIENTO_01 | (1) 1ª parteGeneral   | Parcial  | JUGUETERIAS CQLII                       | Caja Sura      | No       | 0099            |
      | HOGAR_03        | (2) 1ª partePropiedad | Parcial  | JESUS ANTONIO GOMEZ CAÑIZARES CQLII     | Pago por banco | No       | 0099            |
      | HOGAR_04        | (1) 1ª partePropiedad | Final    | EL SOL DE HOY LTDA. CQLII               | Transferencia  | No       | 0023            |