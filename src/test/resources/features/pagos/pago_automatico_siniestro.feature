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
    Entonces se genera una reclamación con exposición automática <Tipo de Exposición>
    Y una reserva automática con un monto de <Valor Reserva>
    Y un pago automático con un monto de <Valor Pago>

    Ejemplos:
      | producto                                  | Causa    | Valor de Pretensión | Tipo de incidente | Tipo de Exposición | Valor Reserva | Valor Pago |
      | Multiriesgo Corporativo pago automático 1 | Incendio | 4000000             | Propiedad         | Contenido          | $4.000.000    | $2.343.768 |