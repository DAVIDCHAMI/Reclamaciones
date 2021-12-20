# language: es
Característica: Constitución de una línea de reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible realizar ajustes en las reservas
  Para que se pueda cubrir el monto del valor del siniestro

  Antecedentes: Crear poliza
    Dado se tiene una póliza de autos individual con plan Global de vigencia anual con 5 de retroactividad

  @reversionConstitucion
  @claimsAuto
  Esquema del escenario: reversión de constitución
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Entonces se obtiene una reversión de constitución y el deducible es generado por un valor <Deducible>

    Ejemplos:

      | Monto del ajuste | Deducible       | Cobertura           |
      | 990000           | 0         | Perdida total Daños |