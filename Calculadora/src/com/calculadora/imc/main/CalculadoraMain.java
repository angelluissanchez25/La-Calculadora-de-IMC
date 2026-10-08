package com.calculadora.imc.main;

/**
 *
 * @author Angel Luis Sánchez Pérez
 */
import com.calculadora.imc.controller.IMCController;
import com.calculadora.imc.view.CalculadoraView;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CalculadoraMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora de IMC");
            CalculadoraView vista = new CalculadoraView();
            new IMCController(vista);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(vista);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
