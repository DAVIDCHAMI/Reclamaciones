# language: es
Característica: Generación avisos de siniestros autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un asegurado tenga un siniestro

  Antecedentes: Crear poliza
    Dado se tiene una póliza de autos individual con plan Global de vigencia anual con 5 de retroactividad

  @claimsAut
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Responsabilidad Civil
    Dado que se tiene una póliza con las coberturas
      |coberturas|
      |Daños     |
      |Vehículo de reemplazo|
      |responsabilidadCivil                     |
    Cuando se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo
      |Causa|Culpabilidad|Responsabilidad civil daños persona|Responsabilidad civil daños vehículo|
      |Colisión con vehículo|responsabilidad Civil|peaton daños persona|conductor daños vehículo|
    Entonces se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil

  @claimsAut
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Archivo
    Dado que se tiene una póliza con las coberturas para Daños
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Amit, Disturbios o desorden civil|archivo|
    Entonces se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo

  @claimsAut
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Subrogación
    Dado que se tiene una póliza con las coberturas para Subrogación
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Colisión con vehículo|subrogación|
    Entonces se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo

  @claimsAut
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Solo Responsabilidad Civil
    Dado que se tiene una póliza con las coberturas para Solo Responsabilidad Civil
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo
      |Causa|Culpabilidad|Responsabilidad civil daños persona|Responsabilidad civil daños vehículo|
      |Colisión con vehículo|solo RC|peaton daños persona|conductor daños vehículo|
    Entonces se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva


  @avisoServicioMac
  @claimsAut
  Escenario: Consumo servicio maca, para la creación de Siniestro autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Cuando se genera un aviso que afecta la cobertura de Responsabilidad civil
    Entonces se le brindará al reclamante el número de reclamación