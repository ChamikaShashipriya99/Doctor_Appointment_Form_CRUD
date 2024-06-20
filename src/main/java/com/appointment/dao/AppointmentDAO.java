package com.appointment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.appointment.model.Appointment;

public class AppointmentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/doctor_appointment_system";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Chamika1999";

    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO appointments " +
        "(name, age, phone_number, gender, email, appointment_type, doctor_type) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointments";
    private static final String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM appointments WHERE id = ?";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointments WHERE id = ?;";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE appointments SET name = ?, age = ?, phone_number = ?, gender = ?, email = ?, appointment_type = ?, doctor_type = ? WHERE id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Insert new appointment into the database
    public void insertAppointment(Appointment appointment) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setString(1, appointment.getName());
            preparedStatement.setInt(2, appointment.getAge());
            preparedStatement.setString(3, appointment.getPhoneNumber());
            preparedStatement.setString(4, appointment.getGender());
            preparedStatement.setString(5, appointment.getEmail());
            preparedStatement.setString(6, appointment.getAppointmentType());
            preparedStatement.setString(7, appointment.getDoctorType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Select all appointments from the database
    public List<Appointment> selectAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phoneNumber = rs.getString("phone_number");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String appointmentType = rs.getString("appointment_type");
                String doctorType = rs.getString("doctor_type");
                appointments.add(new Appointment(id, name, age, phoneNumber, gender, email, appointmentType, doctorType));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointments;
    }

    // Select appointment by ID
    public Appointment selectAppointment(int id) {
        Appointment appointment = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phoneNumber = rs.getString("phone_number");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String appointmentType = rs.getString("appointment_type");
                String doctorType = rs.getString("doctor_type");
                appointment = new Appointment(id, name, age, phoneNumber, gender, email, appointmentType, doctorType);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointment;
    }

    // Update appointment in the database
    public boolean updateAppointment(Appointment appointment) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_APPOINTMENT_SQL)) {
            statement.setString(1, appointment.getName());
            statement.setInt(2, appointment.getAge());
            statement.setString(3, appointment.getPhoneNumber());
            statement.setString(4, appointment.getGender());
            statement.setString(5, appointment.getEmail());
            statement.setString(6, appointment.getAppointmentType());
            statement.setString(7, appointment.getDoctorType());
            statement.setInt(8, appointment.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    // Delete appointment from the database
    public boolean deleteAppointment(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_APPOINTMENT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
        return rowDeleted;
    }

    // Print SQL Exceptions for debugging
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
