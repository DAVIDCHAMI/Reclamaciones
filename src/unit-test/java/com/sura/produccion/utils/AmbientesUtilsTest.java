package com.sura.produccion.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class AmbientesUtilsTest {
  @Test
  public void getAmbienteDebeRetornarUnLocalPorDefectoSiNoEncuentraVariableEntorno() {
    AmbientesUtils utils = Mockito.spy(new AmbientesUtils());
    Mockito.when(utils.ambientesValidos(Mockito.anyString())).thenReturn("local");

    String resultado = utils.getAmbiente();

    assertThat(resultado, equalTo("local"));
  }

  @Test
  public void getAmbienteDebeRetornarElValorEnLaVariableDeEntorno() {
    String valorEnv = "Test";
    AmbientesUtils utils = Mockito.spy(new AmbientesUtils());
    Mockito.when(utils.ambientesValidos(valorEnv)).thenReturn(valorEnv);
    Mockito.when(utils.getEnv()).thenReturn(valorEnv);

    String resultado = utils.getAmbiente();

    assertThat(resultado, equalTo(valorEnv));
  }

  @Test
  public void ambientesValidosDebeRetornarLocalSiSeIngresaAmbienteInvalido() {
    String valorEnv = "Invalido";
    AmbientesUtils utils = new AmbientesUtils();

    String resultado = utils.ambientesValidos(valorEnv);

    assertThat(resultado, equalTo("local"));
  }

  @Test
  public void ambientesValidosDebeRetornarElAmbienteEnviadoSiSeIngresaAmbienteValido() {
    List<String> valorEnvs = new ArrayList<String>(Arrays.asList("local", "dllo", "lab", "pdn"));
    AmbientesUtils utils = new AmbientesUtils();

    for (String valorEnv : valorEnvs) {
      String resultado = utils.ambientesValidos(valorEnv);

      assertThat(resultado, equalTo(valorEnv));
    }
  }
}
