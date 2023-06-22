package Pratica.Semana1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CamelCaseTest {

    @Test
    public void inicialMinuscula() {

        List<String> entrada = CamelCase.converterCamelCase("nome");

        assertEquals("nome", entrada.get(0));

    }

    @Test
    public void inicialMaiuscula() {

        List<String> entrada = CamelCase.converterCamelCase("Nome");

        assertEquals("nome", entrada.get(0));

    }

    @Test
    public void inicialMinusculaSegundaParteMaiuscula() {

        List<String> entrada = CamelCase.converterCamelCase("nomeComposto");

        assertEquals("nome", entrada.get(0));
        assertEquals("composto", entrada.get(1));

    }

    @Test
    public void inicialMaisculaSegundaParteMaiuscula() {

        List<String> entrada = CamelCase.converterCamelCase("NomeComposto");

        assertEquals("nome", entrada.get(0));
        assertEquals("composto", entrada.get(1));

    }

    @Test
    public void testeParaVerAceitacaoDoCpf() {

        List<String> entrada = CamelCase.converterCamelCase("CPF");

        assertEquals("CPF", entrada.get(0));

    }

    @Test
    public void testeComInicialMinusculaJuntoComNumero() {

        List<String> entrada = CamelCase.converterCamelCase("zap10Zap");

        assertEquals("zap", entrada.get(0));
        assertEquals("10", entrada.get(1));
        assertEquals("zap", entrada.get(2));

    }

    @Test
    public void testeStringInvalida() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> entrada = CamelCase.converterCamelCase("10zapzap");
            List<String> entrada2 = CamelCase.converterCamelCase("nome#Composto");
        });

    }

}
