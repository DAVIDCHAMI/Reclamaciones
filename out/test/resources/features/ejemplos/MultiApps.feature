Feature: Entrando a varias paginas

      Como Tester
      Quiero probar la entrada a varias apps
      Para probar el flujo completo

  Scenario: debe ingresar a 2 paginas diferentes
    Given I want to buy a wool scarf
    Given necesito Sopa
    When agrego el articulo Sopa
    Then el articulo Sopa, debe ser agregado a mi lista de TODO