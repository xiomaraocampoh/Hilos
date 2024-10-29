package org.example.Ejercicio2;

import org.example.Ejercicio2.hilo.Cajero;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
public static void main(String[] args) {
    AtomicInteger totalVentas = new AtomicInteger(0);
    String[] opciones = {"Iniciar Simulación", "Ver Resultados", "Salir"};
            Cajero cajero1 = new Cajero("Cajero 1", totalVentas);
            Cajero cajero2 = new Cajero("Cajero 2", totalVentas);

            Thread hilo1 = new Thread(cajero1);
            Thread hilo2 = new Thread(cajero2);

            boolean ejecutando = true;
            while (ejecutando) {
                int seleccion = JOptionPane.showOptionDialog(null, "Menú Principal", "Supermercado",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                switch (seleccion) {
                    case 0: // Iniciar simulación
                        if (!hilo1.isAlive() && !hilo2.isAlive()) {
                            hilo1.start();
                            hilo2.start();
                        }
                        break;
                    case 1: // Ver resultados
                        JOptionPane.showMessageDialog(null, "Total ventas: " + totalVentas.get() +
                                "\nCajero 1 atendió: " + cajero1.getClientesAtendidos() +
                                "\nCajero 2 atendió: " + cajero2.getClientesAtendidos());
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

