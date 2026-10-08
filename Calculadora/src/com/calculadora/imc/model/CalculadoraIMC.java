package com.calculadora.imc.model;

/**
 *
 * @author Angel Luis Sánchez Pérez
 */
public class CalculadoraIMC {

    public double calcular(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso y altura deben ser mayores que 0");
        }
        return peso / (altura * altura);
    }

    public String clasificar(double imc) {
        if (imc < 18.5) {
            return "Bajo Peso";
        }
        if (imc < 25.0) {
            return "Peso Normal";
        }
        if (imc < 30.0) {
            return "Sobrepeso";
        }
        return "Obesidad";
    }
}
