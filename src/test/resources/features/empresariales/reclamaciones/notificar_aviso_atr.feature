# language: es
Característica: Notificacion de aviso de una reclamación desde ATR

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center, asesor
  quiero que se generen avisos internos de los diferentes productos que tiene la compañía en empresariales
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  @ATR
  Esquema del escenario: aviso
    Dado que tenemos una póliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causa <Causa> con un valor de pretensión de <Valor de Pretensión>
    Entonces se obtiene una reclamación que podrá ser consultada en ClaimCenter

    Ejemplos:
      | Tipo y Cobertura | Causa                         | Valor de Pretensión |
      | AseguradoATR     | Amit/ huelga, conmoción civil | 2000000             |
