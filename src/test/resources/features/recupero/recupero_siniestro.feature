# language: es
Característica:Recupero de una reclamacion

  Como analista de reclamacion
  Quiero registrar un recupero a partir de una reserva


  @claimsEmpresarial
  Esquema del escenario: recupero
    Dado que se tiene una poliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <causa> con un valor de pretension de <valor de Pretensión>
    Y un incidente de tipo <tipo de Incidente>
    Cuando se genere un recupero de tipo <tipo Recupero> con un código de retención <codigo Retencion>
    Entonces se obtiene un reintegro de dinero al siniestro

    Ejemplos:

  | Tipo y Cobertura                       | causa          | valor de Pretensión | tipo de Incidente | tipo Recupero  |codigo Retencion|
  | Incendio con cobertura Daños materiales| Daños por agua | 3000000             | Contenido         | Salvamento     |0099           |