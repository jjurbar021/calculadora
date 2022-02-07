package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

public class FuncionSuma implements Function<Scanner, Void>{

    @Override
    public Void apply(Scanner sc) {
        
        System.out.println("\nOperación seleccionada suma:\n");
        System.out.println("A + B\n");
        
        //Pasamos el valor A:
        System.out.println("Introduzca A:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        //Pasamos el valor B:
        System.out.println("Introduzca B:");
        String bStr = sc.next();
        BigDecimal bBD = new BigDecimal(bStr);

        System.out.println("\nResultado: " + aBD.add(bBD).toString() + "\n");

        return null;
    }

}
