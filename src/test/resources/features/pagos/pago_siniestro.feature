# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamación
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial
  Esquema del escenario: Pago siniestro empresarial
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago             | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                                     | Causa                               | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII   | Pago por banco  | No                 | 0099                | Incendio con cobertura Daños materiales              | Daños por agua                      | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Final        | AURA JUDITH LOPEZ JULIO CQLII     | Caja Sura       | No                 | 0099                | Hogar con cobertura básica                           | Incendio                            | 2000000             | Propiedad         |
      | (1) 1ª parteGeneral   | Final        | TODO EN VERDE CQLII               | Caja Sura       | No                 | 0099                | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento                      | 3000000             | General           |
      | (1) 1ª parteGeneral   | Parcial      | HERMANOS LTDA. CQLII              | Pago por banco  | No                 | 0023                | Responsabilidad Civil Predios y operaciones          | Responsabilidad civil del asegurado | 3000000             | General           |
      | (1) 1ª parteContenido | Parcial      | JUAN CARLOS PALACIO RAMIREZ CQLII | Pago por banco  | No                 | 0023                | Transportes automáticos de mercancía                 | Amit/ huelga, conmoción civil       | 4000000             | Contenido         |
      | (1) 1ª parteContenido | Final        | CUATRO TEMPORADAS S.A. CQLII      | Pago por banco  | No                 | 0023                | Sustracción con cobertura Sustracción con violencia  | Causas varias                       | 4000000             | Contenido         |
      | (1) 1ª partePropiedad | Final        | MARTHA ENID ROJAS MARIACA CQLII   | Pago por banco  | No                 | 0023                | Incendio con cobertura Daños materiales              | Daños por agua                      | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Parcial      | CARMEN CECILIA DIAZ SALGADO CQLII | Caja Sura       | No                 | 0028                | PES Emergente Incendio                               | Incendio                            | 5000000             | Propiedad         |
      | (1) 1ª parteContenido | Final        | LUCAS VELEZ                       | Pago por banco  | No                 | 0099                | PES Emergente Amit                                   | Amit/ huelga, conmoción civil       | 2500000             | Contenido         |


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


  @pagoMultiplesLineasReservas
  @claimsAuto
  Escenario: Crear cheque con múltiples pagos a diferentes líneas de reserva de un siniestro autos
    Dado que se tiene una póliza creacionAvisoMACA de autos
    Y se genera un aviso


  @pagoReservaAutos
  @claimsAuto
  Escenario: Crear pago del siniestro autos
    Dado que se tiene una póliza creacionAvisoMACA de autos
    Y se genera un aviso