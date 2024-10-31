package org.example.Ejercicio2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConecction {



    public void guardarDatosCajero(String nombre, int clientesAtendidos, int totalVentas) {
        String query = "INSERT INTO caja_registradora (cajero, clientes_atendidos, total_ventas) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConecction.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setInt(2, clientesAtendidos);
            stmt.setInt(3, totalVentas);

            stmt.executeUpdate();
            System.out.println("Datos de cajero guardados exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
