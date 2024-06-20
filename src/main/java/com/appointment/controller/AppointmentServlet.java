package com.appointment.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appointment.dao.AppointmentDAO;
import com.appointment.model.Appointment;

@WebServlet("/")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AppointmentDAO appointmentDAO;

    public void init() {
        appointmentDAO = new AppointmentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertAppointment(request, response);
                break;
            case "/delete":
                deleteAppointment(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateAppointment(request, response);
                break;
            default:
                listAppointments(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // Displays the list of all appointments on viewdetails.jsp
    private void listAppointments(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Appointment> listAppointment = appointmentDAO.selectAllAppointments();
        request.setAttribute("listAppointment", listAppointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewdetails.jsp");
        dispatcher.forward(request, response);
    }

    // Shows the form for adding a new appointment
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    // Shows the form for editing an existing appointment, prefilled with current details
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Appointment existingAppointment = appointmentDAO.selectAppointment(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-appointment.jsp");
        request.setAttribute("appointment", existingAppointment);
        dispatcher.forward(request, response);
    }

    // Inserts a new appointment into the database
    private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String appointmentType = request.getParameter("appointmentType");
        String doctorType = request.getParameter("doctorType");
        Appointment newAppointment = new Appointment(name, age, phoneNumber, gender, email, appointmentType, doctorType);
        appointmentDAO.insertAppointment(newAppointment);
        response.sendRedirect("list");
    }

    // Updates an existing appointment based on the ID
    private void updateAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String appointmentType = request.getParameter("appointmentType");
        String doctorType = request.getParameter("doctorType");

        // Create appointment object with updated data
        Appointment updatedAppointment = new Appointment(id, name, age, phoneNumber, gender, email, appointmentType, doctorType);

        // Call DAO to update the appointment
        appointmentDAO.updateAppointment(updatedAppointment);
        
        // Redirect to the list page after successful update
        response.sendRedirect("list");
    }

    // Deletes an appointment based on the ID
    private void deleteAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        appointmentDAO.deleteAppointment(id);
        response.sendRedirect("list");
    }
}
