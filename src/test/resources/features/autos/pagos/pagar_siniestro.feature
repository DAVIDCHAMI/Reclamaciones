# language: es
Característica: Realizar pago de un siniestro
  Como analista de reclamación
  Quiero efectuar un pago a una reclamación
  Para cancelar al asegurado, tercero y/o proveedor involucrados en el siniestro.

  Antecedentes: Crear poliza
    Dado se tiene una póliza de autos individual con plan Global de vigencia anual con 60 de retroactividad


  @pagoLineaReservaAutos1
  @claimsAuto
  Esquema del escenario: Crear pago del siniestro autos uno
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Tipo y Cobertura>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de Reserva | Tipo de pago | Beneficiario del pago             | Método del pago | ¿Es pago soloSura? | Tipo y Cobertura    |
      | 1ª parteVehículo | Parcial      | CARLOS ARTURO CEBALLOS NUÑÑEZ CQLII| Caja Sura       | No                 | Perdida total Daños |


  @pagoPerdidaTotalAutos
  @claimsAuto
  Esquema del escenario: Crear pago del siniestro autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se genere un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de reserva | Tipo de pago | Beneficiario de pago               | Método de pago | Solo Sura | Cobertura           |
      | 1ª parteVehículo | Parcial      | CARLOS ARTURO CEBALLOS NUÑÑEZ CQLII | Caja Sura      | No        | Perdida total Daños |


  @chequeMultiplesPagosAutos
  @claimsAuto
  Esquema del escenario: Crear cheque con múltiples pagos a diferentes líneas de reserva de un siniestro autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se genere un pago por siniestro de auto <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método de Pago> sobre las líneas de reserva <Línea de reserva 1> cuyo responsable <Pago Solo Sura> es Sura donde existe <Número de vehículos involucrados del tercero en el siniestro> vehículo involucrado del tercero en el siniestro
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de reserva 1                       | Tipo de pago | Beneficiario del pago               | Método de Pago | Cobertura           | Pago Solo Sura |Número de vehículos involucrados del tercero en el siniestro|
      | Perdida total Daños pago por en EFECTIVO | Final        | CARLOS ARTURO CEBALLOS NUÑÑEZ CQLII  | Pago por banco | Perdida total Daños | No             |1                                                           |


  @regresion
  @pagoPrimaPendiente
  @claimsAuto
  Esquema del escenario: Crear pago a un siniestro con prima pendiente.
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de <Origen de siniestro> de autos
    Y se genera un aviso que afecta la cobertura de <Tipo de cobertura>
    Y se declara la reclamación como perdida total
    Y la póliza esta marcada como financiada, con prima pendiente por pagar
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se aplique prima pendiente
    Y se apliquen las siguientes retenciones
      | codigos |
      | 099     |
    Entonces en la transacción del pago deben generarse dos registros, uno con el valor de la prima pendiente
    Y otro con el valor del pago menos la prima pendiente

    Ejemplos:
      | Origen de siniestro | Línea de Reserva                                                                                                         | Tipo de pago | Beneficiario de pago                | Método de pago | ¿Es pago soloSura? | Tipo de cobertura   |
      | Servicio de Maca    | (2) 1ª parteVehículo - AOA009  - JHON FEOR FEOR FEOR; Costo de reclamación/Perdida total Daños pago por en EFECTIVO; COP | Parcial      | CARLOS ARTURO CEBALLOS NUÑÑEZ CQLII | Caja Sura      | No                 | Perdida total Daños |