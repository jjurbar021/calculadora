package com.josemanuel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SuperCalculadoraTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    //Test de prueba para probar la operacion de suma:
    @Test
    @DisplayName("Test entrada a Menú de Aritmética, opción A")
    public void testCasoMenuAritmetica() {
       
        //Comandos para acceder, ejecutar , introducir valores y salir de la aplicacion:
        provideInput("A\n1\n13\n33\nX\nX");
        
        SuperCalculadora.main(new String[0]);
        assertThat(getOutput(), containsString("Resultado: 46") ); //<----- El resultado esperado
        
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }



}
