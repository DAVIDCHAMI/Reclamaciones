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
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII   | Pago por banco  | No                 | 0010                | Incendio con cobertura Daños materiales              | Daños por agua                      | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Final        | AURA JUDITH LOPEZ JULIO CQLII     | Caja Sura       | No                 | 0023                | Hogar con cobertura básica                           | Incendio                            | 2000000             | Propiedad         |
      | (1) 1ª parteGeneral   | Parcial      | TODO EN VERDE CQLII               | Caja Sura       | No                 | 0023                | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento                      | 3000000             | General           |
      | (1) 1ª parteGeneral   | Final        | HERMANOS LTDA. CQLII              | Pago por banco  | No                 | 0023                | Responsabilidad Civil Predios y operaciones          | Responsabilidad civil del asegurado | 3000000             | General           |
      | (1) 1ª parteContenido | Final        | JUAN CARLOS PALACIO RAMIREZ CQLII | Pago por banco  | No                 | 0099                | Transportes automáticos de mercancía                 | Amit/ huelga, conmoción civil       | 4000000             | Contenido         |


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

  @claimsAuto
  Esquema del escenario: Crear pago del siniestro autos
    Dado que se tiene un siniestro de <Origen> con un tipo de cobertura de <Tipo de cobertura>
    Cuando se genere un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la linea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Entonces se obtiene el pago del beneficiario

    Ejemplos:
      | Origen          | Línea de reserva                | Tipo de pago | Beneficiario de pago             | Método de pago | Código de retención pago | Solo Sura | Tipo de cobertura   |
      | creacionAvisoWS | (1) 3ª parteLesiones corporales | Parcial      | JHON FEOR FEOR FEOR              | Pago por banco | 0099                     | No        | RC Lesión a Persona |
      | creacionAvisoWS | (2) 1ª parteVehículo            | Parcial      | LEONARDO JESUS OSPINO DIAZ CQLII | Caja Sura      | 0099                     | No        | Perdida total Daños |
      | creacionAvisoWS | (2) 1ª parteVehículo            | Final        | LEONARDO JESUS OSPINO DIAZ CQLII | Caja Sura      | 0099                     | No        | Perdida total Daños |
