package edu.pingpong.planets;

import java.lang.Math;

public enum Valores {

    MERCURY (3.303e+23, 2.4397e6, true),
    VENUS   (4.869e+24, 6.0518e6, true),
    EARTH   (5.976e+24, 6.37814e6, true),
    MARS    (6.421e+23, 3.3972e6, true),
    JUPITER (1.9e+27,   7.1492e7, false),
    SATURN  (5.688e+26, 6.0268e7, false),
    URANUS  (8.686e+25, 2.5559e7, false),
    NEPTUNE (1.024e+26, 2.4746e7, false);

    private final double masa;
    private final double radio;
    private final boolean rocoso;
    public static final double G = 6.67300E-11;

    Valores(double masa, double radio, boolean rocoso) {
        this.masa = masa;
        this.radio = radio;
        this.rocoso = rocoso;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRadio() {
        return this.radio;
    }
    
    public boolean getRocoso() {
        return this.rocoso;
    }

    public double pesoSuperficie(double masaHumano) {
        double pesoSuperficie = (masaHumano / gravedadTierra()) * gravedadSuperficie();
        return pesoSuperficie;
    }

    private double gravedadSuperficie() {
        double gravedad = (G * (this.masa / Math.pow(this.radio, 2)));
        return gravedad;
    }

    private double gravedadTierra() {
        double gravedad = (G * Valores.EARTH.masa) / Math.pow(Valores.EARTH.radio, 2);
        return gravedad;
    }

    public static Valores[] getPlanetasRocosos() {
        Valores[] out = new Valores[4];
        int i = 0;
        for (Valores planeta : Valores.values()) {
            if (planeta.rocoso == true) {
                out[i] = planeta;
                i++;
            }
        }
        return out;
    }

    public static Valores[] getGigantesGaseosos() {
        Valores[] out = new Valores[4];
        int i = 0;
        for (Valores planeta : Valores.values()) {
            if (planeta.rocoso == false) {
                out[i] = planeta;
                i++;
            }
        }
        return out;
    }

}