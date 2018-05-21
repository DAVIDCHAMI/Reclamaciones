# language: es
Característica: Notificacion de aviso de una notificacion de autos

  Como analista de reclamacion de autos
  Quiero registrar los datos de un afectado en un siniestro
  Para generar un registro de reclamacion por daños

  @claims
  Escenario:
    Dado que se recibe auto con causa de siniestro por danos
    Cuando se toman los datos del siniestro
    Entonces se le brindara al reclamante un numero de reclamacion
    Y se valida el encabezado en STAR
