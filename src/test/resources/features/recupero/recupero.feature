# language: es
Característica:Recupero de una reclamacion

  Como analista de reclamacion
  Quiero registrar un recupero a partir de una reserva


  @claimsEmpresarial
  Esquema del escenario: recupero
    Dado que se tiene una poliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretension de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando se genere un recupero de tipo <tipo recupero> con un código de retención <codigoRetencion>
    Entonces se obtiene un reintegro de dinero al siniestro

    Ejemplos:

  | Tipo y Cobertura                       | Causa          | Valor de Pretensión | Tipo de incidente |   tipo recupero  |codigoRetencion|
  | Incendio con cobertura Daños materiales| Daños por agua | 3000000             | Contenido         |Salvamento     |0099           |