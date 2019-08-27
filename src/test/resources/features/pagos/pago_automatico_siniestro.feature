# language: es
Característica: Generación de pago automático en un siniestro

  Como analista de reclamación
  Quiero realizar una reclamación con los parámetros requeridos para pago automático
  Para verificar la generación de éste.

  @PagoAutomatico
  @claimsEmpresarial
  Esquema del escenario: Crear Pago automático
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Entonces se genera una exposición automática, una reserva automática y un pago automático

    Ejemplos:
      | Tipo y Cobertura                           | Causa    | Valor de Pretensión | Tipo de incidente |
      | MRC con Daños materiales pago automático 1 | Incendio | 4000000             | Propiedad         |