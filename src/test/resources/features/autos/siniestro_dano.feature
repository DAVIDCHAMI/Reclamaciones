# language: es
Característica: Notificacion de aviso de una notificacion de autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un afiliado sufra un siniestro

  @claimsAuto
  Esquema del escenario: generacion de reclamacion
    Dado que se tiene una poliza con las coberturas <coberturas>
    Cuando se genere un siniestro por la causa <Causa> y la culpabilidad <culpabilidad>
    Entonces se obtendran exposiciones automaticas, y cada una con su respectiva reserva, según la culpabilidad marcada <culpabilidad>

    Ejemplos:
    |coberturas                                      |Causa                            |culpabilidad          |
    |Hurto;Gastos de transporte;Vehículo de reemplazo|Hurto vehículo                   |Archivo               |
    |Responsabilidad Civil;Daños                     |Colisión con vehículo            |Responsabilidad Civil |
    |Daños                                           |Colisión con bicicleta           |Subrogación           |
    |Responsabilidad Civil                           |Colisión con bicicleta           |Solo RC               |