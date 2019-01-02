# language: es

Característica: Distribución del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribución que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

 @claimsEmpresarial
  Esquema del escenario: Reaseguro de Constitución de reserva - creación reserva
    Cuando se genere una reclamación de un contrato tipo <Tipo Contrato Póliza>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo Contrato Póliza  | Tipo Transacción    |
      | primeraTxProporcional | constitucionReserva |
      | MRC_01                | constitucionReserva |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reserva de liberación - Pago y liberación de reserva
  Dado se genere una reclamación de un contrato tipo <Tipo Contrato Póliza>
  Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Método Pago> el cual cuenta con una linea de reserva <Línea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retención>
  Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

  Ejemplos:
    | Tipo Contrato Póliza |  Línea Reserva          | Tipo Pago | Beneficiario Pago                   | Método Pago | ¿Solo Sura?  | Código Retención  |Tipo Transacción   |
    | MRC_01               | (1) 1ª parteContenido   | Final     |  SOLO FAMILIAR LTDA. CQLII          | Caja Sura   | No           | 0099              | reservaLiberacion |


