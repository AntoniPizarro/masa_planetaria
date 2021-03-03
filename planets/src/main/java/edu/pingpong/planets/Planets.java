package edu.pingpong.planets;

import edu.pingpong.planets.Valores;

public class Planets {
    public static void main(String[] args) {
		 
        double peso = 175.0; // kg
        
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
