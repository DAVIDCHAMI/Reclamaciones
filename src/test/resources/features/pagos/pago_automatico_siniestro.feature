# language: es
Característica: Generación de pago automático en un siniestro

  Como analista de reclamación
  Quiero realizar una reclamación con los parámetros requeridos para pago automático
  Para verificar la generación de éste.

  @PagoAutomatico
  @claimsEmpresarial
  Esquema del escenario: Crear Pago automático
    Dado que se tiene una póliza del producto <producto>
    Cuando se realiza un siniestro por causa <Causa> con valor de pretensión <Valor de Pretensión> e incidente <Tipo de incidente>
    Entonces se genera una exposición automática, una reserva automática y un pago automático

    Ejemplos:
      | producto                                  | Causa    | Valor de Pretensión | Tipo de incidente |
      | Multiriesgo Corporativo pago automático 1 | Incendio | 4000000             | Propiedad         |