package edu.pingpong.planets;

import java.util.Scanner;

import edu.pingpong.planets.Valores;

public class Planets {
    public static void main(String[] args) {
		
        while (true) {
            Scanner pedirPeso = new Scanner(System.in);
            System.out.println("=============================");
            System.out.println("Escribe tu peso en la tierra:");

            double peso = pedirPeso.nextDouble();

            for(Valores planeta : Valores.values()){
                System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
            }
            
            System.out.println("\nYour weight only on the terrestrial planets: ");
            for(Valores planeta: Valores.getPlanetasRocosos()){
                System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
            }
            
            System.out.println("\nYour weight only on the gas giant planets: ");
            for(Valores planeta: Valores.getGigantesGaseosos()){
                System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
            }
        }
    }
}
