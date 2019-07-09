# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamación
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial
  Esquema del escenario: Pago siniestro empresarial a un Riesgo Consultable
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Y el asegurado o algún tercero de la póliza tiene marca de riesgo consultable
    Cuando se crea una nueva línea de reserva por la Exposición de <Exposición> por <Categoría> con un tipo de costo <Tipo costo> por un valor de <Valor de Pretensión>
    Y se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de reserva                                                                                   | Tipo de pago | Beneficiario de pago              | Método de pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                                     | Causa                      | Valor de Pretensión | Tipo de incidente | Exposición                                                | Categoría           | Tipo costo                   | ¿Genera orden de pago? |
      | (1) 1ª parteGeneral - TODO EN VERDE CQLII; Gasto - A&O (ajuste y otros)/Gastos de siniestro; COP   | Parcial      | TODO EN VERDE CQLII               | Pago por banco | No                 | 0023                | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento             | 3000000             | General           | (1) 1ª parteGeneral - TODO EN VERDE CQLII                 | Gastos de siniestro | Gasto - A&O (ajuste y otros) | Si                     |
      | (1) 1ª parteContenido - JUAN CARLOS PALACIO RAMIREZ CQLII; Costo de reclamación/Avería gruesa; COP | Parcial      | JUAN CARLOS PALACIO RAMIREZ CQLII | Pago por banco | No                 | 0023                | Transportes automáticos de mercancía Incendio        | Acc vehiculo transportador | 4000000             | Contenido         | (1) 1ª parteContenido - JUAN CARLOS PALACIO RAMIREZ CQLII | Avería gruesa       | Costo de reclamación         | Si                     |


  @pagoReservaSiniestroEmpresarial
  @claimsEmpresarial
  Esquema del escenario: Pago siniestro empresarial
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                                     | Causa          | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | No                 | 0099                | Incendio con cobertura Daños materiales              | Daños por agua | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Final        | AURA JUDITH LOPEZ JULIO CQLII   | Caja Sura       | No                 | 0099                | Hogar con cobertura básica                           | Incendio       | 2000000             | Propiedad         |
      | (1) 1ª parteGeneral   | Final        | TODO EN VERDE CQLII             | Caja Sura       | No                 | 0099                | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | 3000000             | General           |


  @pagoMultiplesLineasReservas
  @claimsAuto
  Esquema del escenario: Crear cheque con múltiples pagos a diferentes líneas de reserva de un siniestro autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se genere un pago por siniestro de auto <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método de Pago> sobre las líneas de reserva <Línea de reserva 1> y <Línea de Reserva 2> afectando la cobertura de <Pago Solo Sura> es Sura con una retención de <Código de retención pago>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de reserva 1                       | Línea de Reserva 2   | Tipo de pago | Beneficiario del pago | Método de Pago | Código de retención pago | Cobertura           | Pago Solo Sura |
      | Perdida total Daños pago por en EFECTIVO | Gastos de Transporte | Final        | SOFIA JARAMILLO       | Pago por banco | 0099                     | Perdida total Daños | No             |


  @pagoReservaAutos
  @claimsAuto
  Esquema del escenario: Crear pago del siniestro autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se genere un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de reserva | Tipo de pago | Beneficiario de pago | Método de pago | Código de retención pago | Solo Sura | Cobertura           |
      | 1ª parteVehículo | Parcial      | SOFIA JARAMILLO      | Caja Sura      | 0099                     | No        | Perdida total Daños |


  @Ignore
  @PruebaAuditoria

  Esquema del escenario: Crear Pago a con proceso de auditoría
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando <¿Requiere auditoría?> se notifique el proceso al área de auditoría
    Y se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Entonces <¿genera factura?> se debe generar factura de pago al asegurado


    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                             | Causa          | Valor de Pretensión | Tipo de incidente | ¿Requiere auditoría? | ¿genera factura? |
      | (1) 1ª partePropiedad | Final        | CLUB LOS TRIUNFADORES CQLII     | Pago por banco  | No                 | 0099                | Multiriesgo corporativo con cobertura básica | Incendio       | 2000000             | Propiedad         | No                   | Si               |
      | (1) 1ª partePropiedad | Final        | CLUB LOS TRIUNFADORES CQLII     | Pago por banco  | No                 | 0099                | Multiriesgo corporativo con cobertura básica | Incendio       | 2000000             | Propiedad         | Si                   | No               |
      | (1) 1ª partePropiedad | Final        | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | No                 | 0099                | Incendio con cobertura Daños materiales      | Daños por agua | 5000000             | Propiedad         | No                   | Si               |
      | (1) 1ª partePropiedad | Final        | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | No                 | 0099                | Incendio con cobertura Daños materiales      | Daños por agua | 5000000             | Propiedad         | Si                   | No               |


  @pagoPrimaPendiente
  @claimsAuto
  Esquema del escenario: Crear pago a un siniestro con prima pendiente.
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de <Origen de siniestro> de autos
    Y se genera un aviso que afecta la cobertura de <Tipo de cobertura>
    Y se declara la reclamación como perdida total
    Y la póliza esta marcada como financiada, con prima pendiente por pagar
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Y se genera una orden de pago para que le sea entregado al usuario
    Entonces en la transacción del pago deben generarse dos registros, uno con el valor de la prima pendiente
    Y otro con el valor del pago menos la prima pendiente

    Ejemplos:
      | Origen de siniestro | Línea de Reserva                                                                                                         | Tipo de pago | Beneficiario de pago | Método de pago | Código de Retención | ¿Es pago soloSura? | Tipo de cobertura   |
      | Servicio de Maca    | (2) 1ª parteVehículo - OSO222  - MARIA JOSE MORALES; Costo de reclamación/Perdida total Daños pago por en EFECTIVO; COP | Parcial      | MARIA JOSE MORALES   | Caja Sura      | 0099                | No                 | Perdida total Daños |