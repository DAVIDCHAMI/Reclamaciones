# language: es
Característica: Notificacion de aviso de una reclamacion desde ATR

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center, asesor
  quiero que se generen avisos internos de los diferentes productos que tiene la compañía en empresariales
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  @ATR
  Esquema del escenario: aviso
    Dado que tenemos una poliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causa <Causa> con un valor de pretension de <Valor de Pretensión>
    Y se ajusta la reserva de la categoria de costo <Categoria de costo>
    Entonces se obtiene una reclamacion que podrá ser consultada en ClaimCenter

    Ejemplos:
      | Tipo y Cobertura | Causa             | Valor de Pretensión | Categoria de costo |
      | ATR              | Rotura de vidrios | 2000000             | Propiedad          |
