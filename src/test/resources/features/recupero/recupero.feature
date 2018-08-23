# language: es
Característica:Recupero de una reclamacion

  Como analista de reclamacion
  Quiero registrar un recupero a partir de una reserva


  @claims
  Esquema del escenario: recupero
    Dado que <condicionReserva> se cuenta con una reserva de <tipoReserva>
    Cuando se genere un recupero de categoria <categoriaRecupero>, con un codigo de retencion <codigoRetencion>
    Entonces se obtiene un recupero en estado <estadoRecupero>

    Ejemplos:

   |condicionReserva | tipoReserva | categoriaRecupero | codigoRetencion| estadoRecupero  |
   |si               | Propiedad   | Salvamento        | 0001           |  Solicitado     |