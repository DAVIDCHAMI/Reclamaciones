# language: es
Característica: Notificacion de aviso de una reclamacion

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center
  quiero que se generen avisos internos de autos
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  Esquema del escenario: : Consumo servicio creacion Siniestro autos
    Dado que se tiene una póliza <poliza> de autos
    Cuando se genera un aviso
    Entonces se le brindara al reclamante el numero de reclamacion

    Ejemplos:
      |poliza|
      |creacionAvisoWS|