# language: es
Característica:Recupero de una reclamacion

  Como analista de reclamacion
  Quiero registrar un recupero a partir de una reserva


  @claimsEmpresarial
  Esquema del escenario: recupero
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <causa> con un valor de pretensión de <valor de Pretensión>
    Y un incidente de tipo <tipo de Incidente>
    Cuando se genere un recupero con un código de retención <codigo Retencion>
    Entonces se obtiene un reintegro de dinero al siniestro

    Ejemplos:

      | Tipo y Cobertura                             | causa                        | valor de Pretensión | tipo de Incidente | tipo Recupero  | codigo Retencion |
      | Incendio con cobertura Daños materiales      | Daños por agua               | 3000000             | Contenido         | Salvamento     | 0099             |
      | Multiriesgo corporativo con cobertura básica | Incendio                     | 5000000             | Propiedad         | Subrogación    | 0099             |
      | Hogar con cobertura básica                   | Incendio                     | 4500000             | Propiedad         | Ingreso (otro) | 0099             |
      | PES Emergente Terremoto                      | Terremoto,temblor o erupción | 3000000             | Propiedad         | Subrogación    | 0099             |
      | PES Emergente	Sustraccion                    | Hurto (otros)                | 3600000             | Contenido         | Salvamento     | 0099             |