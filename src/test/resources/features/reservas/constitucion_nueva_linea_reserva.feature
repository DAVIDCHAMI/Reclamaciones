# language: es
Característica: Reversión de constitución o ajuste manual de la reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible realizar ajustes en las reservas
  Para que se pueda cubrir el monto del valor del siniestro

  @claimsEmpresarial
  Esquema del escenario: creación de nueva línea de reserva
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se crea una nueva Línea de reserva por la Exposición de <Exposición> por <Categoría de costo> de <Tipo de costo> por un valor de <Valor de Pretensión>
    Entonces se genera una nueva Línea de reserva de <Categoría de costo> con un deducible de <Deducible>
    Ejemplos:

      | Tipo y Cobertura                                    | causa         | Tipo de incidente | Exposición                                     | Categoría de costo  | Tipo de costo                | Valor de Pretensión | Deducible |
      | Sustracción con cobertura Sustracción con violencia | Causas varias | Contenido         | (1) 1ª parteContenido - CUATRO TEMPORADAS S.A. CQLII | Gastos de siniestro | Gasto - A&O (ajuste y otros) | 4000000             | 0         |
