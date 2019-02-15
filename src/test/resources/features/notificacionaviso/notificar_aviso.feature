# language: es
Característica: Notificación de aviso de una reclamación

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center
  quiero que se generen avisos internos de los diferentes productos que tiene la compañía en empresariales
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  @claimsEmpresarial
  Esquema del escenario: Notificación Aviso de Siniestro
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Entonces se obtiene una reclamación que <¿Genera exposición?> genera exposición
    Y que <¿Genera reserva?> genera reserva con un monto <Monto de la reserva>, envía correo y se asigna a un analista

    Ejemplos:
      | Tipo y Cobertura                                     | Causa                         | Valor de Pretensión | Tipo de incidente | ¿Genera exposición? | ¿Genera reserva? | Monto de la reserva |
      | Multiriesgo corporativo con cobertura básica         | Rotura de vidrios             | 2000000             | Propiedad         | si                  | si               | 1218758             |
      | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento                | 200000              |                   | si                  | si               | 200000              |
      | Plan Empresario Sura con Amit                        | Amit/ huelga, conmoción civil | 4000000             | Contenido         | si                  | si               | 3600000             |
      | Incendio con cobertura Daños materiales              | Daños por agua                | 3000000             | Contenido         | si                  | si               | 1437516             |
      |PES Emergente Incendio	                             | Incendio                      | 3000000             | Contenido         | si                  | si               | 300000              |
      |PES Emergente Amit                                    | Amit/ huelga, conmoción civil | 4000000             | Contenido         | si                  | si               | 3600000             |
