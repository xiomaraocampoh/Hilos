package org.example.Ejercicio1.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HopitalRepository {

    public void insertarDatosMedico(String nombreMedico, int pacientesAtendidos) {
        String query = "INSERT INTO atencion_medica (medico, pacientes_atendidos) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nombreMedico);
            preparedStatement.setInt(2, pacientesAtendidos);

            preparedStatement.executeUpdate();
            System.out.println("Datos de médico guardados exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar el número de pacientes atendidos por un médico
    public void actualizarPacientesMedico(String nombreMedico, int nuevosPacientesAtendidos) {
        String query = "UPDATE atencion_medica SET pacientes_atendidos = ? WHERE medico = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nuevosPacientesAtendidos);
            preparedStatement.setString(2, nombreMedico);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pacientes atendidos actualizados correctamente.");
            } else {
                System.out.println("No se encontró el médico.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


