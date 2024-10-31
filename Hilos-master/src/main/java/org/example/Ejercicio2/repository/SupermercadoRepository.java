package org.example.Ejercicio2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupermercadoRepository {
    public void guardarDatosCajero(String nombre, int clientesAtendidos, int totalVentas) {
        String query = "INSERT INTO caja_registradora (cajero, clientes_atendidos, total_ventas) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConecction.getConnection;
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

    public void actualizarVentasCajero(String nombreCajero, int nuevasVentas) {
        String query = "UPDATE caja_registradora SET total_ventas = ? WHERE cajero = ?";

        try (Connection connection = DatabaseConecction.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nuevasVentas);
            preparedStatement.setString(2, nombreCajero);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ventas actualizadas correctamente.");
            } else {
                System.out.println("No se encontró el cajero.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
