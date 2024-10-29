package org.example.Ejercicio1.hilo;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
public class Medico implements Runnable{
        private String nombre;
        private AtomicInteger pacientesAtendidos;

        public Medico(String nombre) {
            this.nombre = nombre;
            this.pacientesAtendidos = new AtomicInteger(0);
        }

        public void run() {
            Random random = new Random();
            while (true) { // Simulación de atención continua
                try {
                    int tiempoAtencion = random.nextInt(5000); // Simulamos el tiempo de atención
                    Thread.sleep(tiempoAtencion);

                    pacientesAtendidos.incrementAndGet();
                    System.out.println(nombre + " atendió a un paciente. Total: " + pacientesAtendidos.get());
                } catch (InterruptedException e) {
                    System.out.println(nombre + " dejó de atender.");
                    break;
                }
            }
        }
    public int getPacientesAtendidos() {
        return pacientesAtendidos.get();
    }
    }
