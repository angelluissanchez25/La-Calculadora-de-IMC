package com.calculadora.imc.controller;

/**
 *
 * @author Angel Luis Sánchez Pérez
 */

import com.calculadora.imc.model.CalculadoraIMC;
import com.calculadora.imc.view.CalculadoraView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCController {

    private final CalculadoraView vista;
    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    public IMCController(CalculadoraView vista) {
        this.vista = vista;
        this.vista.addCalcularListener(new CalcularListener());
    }

    private class CalcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String strPeso = vista.getPeso().trim().replace(',', '.');
            String strAltura = vista.getAltura().trim().replace(',', '.');

            double peso;
            double altura;

            try {
                peso = Double.parseDouble(strPeso);
                altura = Double.parseDouble(strAltura);
            } catch (NumberFormatException ex) {
                vista.mostrarError("Error: Datos inválidos");
                return;
            }

            try {
                double imc = calculadora.calcular(peso, altura);
                String clasificacion = calculadora.clasificar(imc);

                vista.mostrarResultado(imc, clasificacion);
            } catch (IllegalArgumentException ex) {
                vista.mostrarError("Error: " + ex.getMessage());
            }
        }
    }
}