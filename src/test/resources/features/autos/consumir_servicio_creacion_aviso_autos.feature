# language: es
Característica: Notificacion de aviso de una reclamacion

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center
  quiero que se generen avisos internos de autos
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  Escenario: : Consumo servicio creación Siniestro autos
    Dado que se tiene una póliza Servicio de Maca de autos
    Cuando se genera un aviso
    Entonces se le brindará al reclamante el número de reclamación
