# language: es
Característica: Generación avisos de siniestros autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un afiliado sufra un siniestro

  @claimsAuto
  @pruebaRegresion
  Escenario: generación de reclamacion de tipo Archivo
    Dado que se tiene una póliza con las coberturas para Daños
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Amit, Disturbios o desorden civil|archivo|
    Entonces se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo

  @claimsAuto
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

  @claimsAuto
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Solo Responsabilidad Civil
    Dado que se tiene una póliza con las coberturas para Solo Responsabilidad Civil
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad SoloRC con Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo
      |Causa|Culpabilidad|Responsabilidad_civil_daños_persona|Responsabilidad_civil_daños_vehículo|
      |Colisión con vehículo|solo_RC|peaton_daños_persona|conductor_daños_vehículo|
    Entonces se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva

  @claimsAuto
  @pruebaRegresion
  Escenario: generación de reclamacion de tipo Responsabilidad Civil
    Dado que se tiene una póliza con las coberturas
      |coberturas|
      |Daños     |
      |Vehículo de reemplazo|
      |responsabilidadCivil                     |
    Cuando se genere un siniestro por la causa y la culpabilidad Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo
      |Causa|Culpabilidad|Responsabilidad_civil_daños_persona|Responsabilidad_civil_daños_vehículo|
      |Colisión con vehículo|responsabilidad_Civil|peaton_daños_persona|conductor_daños_vehículo|
    Entonces se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil


