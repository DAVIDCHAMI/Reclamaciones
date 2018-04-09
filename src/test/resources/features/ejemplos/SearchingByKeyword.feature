# language: es
Característica: Searching by keyword

  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

  Escenario: Should list items related to a specified keyword
    Dado I want to buy a wool scarf
    Cuando I search for items containing 'wool'
    Entonces I should only see items related to 'wool'
    Y agrego el siguiente vehiculo
    | placa  | modelo | fasecolda | clase | marca | linea | ciudadCirculacion | tipoServicio | motor | chasis | uso      |  remolque |  combustible |  importado |  ceroKM |
    | ABC123 | 2008   | fasecolda | clase | marca | linea | ciudadCirculacion | tipoServicio | motor | chasis | familiar |  false    |  true        |  false     |  false  |