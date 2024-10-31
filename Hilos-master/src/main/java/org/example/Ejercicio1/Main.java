package org.example.Ejercicio1;

import org.example.Ejercicio1.hilo.Medico;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] opciones = {"Iniciar Simulación", "Ver Resultados", "Salir"};
        Medico medico1 = new Medico("Dr. Pérez");
        Medico medico2 = new Medico("Dra. García");

        Thread hilo1 = new Thread(medico1);
        Thread hilo2 = new Thread(medico2);

        boolean ejecutando = true;
        while (ejecutando) {
            int seleccion = JOptionPane.showOptionDialog(null, "Menú Principal", "Hospital",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0: // Iniciar simulación
                    if (!hilo1.isAlive() && !hilo2.isAlive()) {
                        hilo1.start();
                        hilo2.start();
                    }
                    break;
                case 1: // Ver resultados
                    JOptionPane.showMessageDialog(null, "Dr. Pérez atendió: " + medico1.getPacientesAtendidos() +
                            "\nDra. García atendió: " + medico2.getPacientesAtendidos());
                    break;
                case 2: // Salir
                    hilo1.interrupt();
                    hilo2.interrupt();
                    ejecutando = false;
                    break;
            }
        }
    }
}
