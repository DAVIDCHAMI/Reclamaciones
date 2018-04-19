# language: es
Característica: Entrando a varias paginas

      Como Tester
      Quiero probar la entrada a varias apps
      Para probar el flujo completo
@Before
  Escenario: debe ingresar a 2 paginas diferentes
    Dado I want to buy a wool scarf
    Dado necesito Sopa
    Cuando agrego el articulo Sopa
    Entonces el articulo Sopa, debe ser agregado a mi lista de TODO