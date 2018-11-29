# language: es
Característica: Notificacion de aviso de una reclamacion

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center
  quiero que se generen avisos internos de los diferentes productos que tiene la compañía en empresariales
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  Esquema del escenario: : Consumo servicio creacion Siniestro
    Dado que se tiene una póliza <poliza> de empresariales
    Cuando se genera un siniestro
    Entonces se le brindara al reportante un numero de reclamacion

    Ejemplos:
      | poliza |
      | poliza |