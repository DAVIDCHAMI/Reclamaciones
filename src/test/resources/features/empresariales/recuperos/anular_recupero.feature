# language: es
Característica: Anulacion de recuperos

  Como analista de reclamaciones
  Quiero generar una anulación de un recupero
  Para verificar que el proceso de recuperación sea suspendido y no sea efectuado.

  @Empresarial
  @claimsEmpresarial
  Esquema del escenario: anulación de un recupero de empresariales.
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión> y un incidente de tipo <Tipo de incidente>
    Y se genere un recupero con un código de retención <Código de retención recupero>
    Y se obtiene un reintegro de dinero al siniestro
    Cuando se realice la anulación del recupero
    Entonces se debe obtener la anulación del recupero, quedando en estado anulado

    Ejemplos:
      | Tipo y Cobertura                                     | Causa          | Valor de Pretensión | Tipo de incidente | Tipo de recupero | Código de retención recupero |
      | Hogar con cobertura básica                           | Incendio       | 2000000             | Propiedad         | Ingreso (otro)   | 0099                         |
      | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | 3000000             | General           | Subrogación      | 0099                         |