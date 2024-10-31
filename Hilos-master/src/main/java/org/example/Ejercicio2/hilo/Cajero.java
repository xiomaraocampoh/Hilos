package org.example.Ejercicio2.hilo;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Cajero  implements Runnable{
    private String nombre;
    private AtomicInteger clientesAtendidos;
    private AtomicInteger totalVentas;

    public Cajero(String nombre, AtomicInteger totalVentas) {
        this.nombre = nombre;
        this.clientesAtendidos = new AtomicInteger(0);
        this.totalVentas = totalVentas;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) { // Simulando que la caja siempre está atendiendo clientes
            try {
                int tiempoProceso = random.nextInt(5000); // Simulamos el tiempo de atención
                Thread.sleep(tiempoProceso);

                int costoCompra = random.nextInt(100); // Simulamos el total de la compra
                totalVentas.addAndGet(costoCompra);
                clientesAtendidos.incrementAndGet();

                System.out.println(nombre + " atendió a un cliente. Total ventas: " + totalVentas.get());
            } catch (InterruptedException e) {
                System.out.println(nombre + " dejó de trabajar.");
                break;
            }
        }
    }

    public int getClientesAtendidos() {
        return clientesAtendidos.get();
    }
}
