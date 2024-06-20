<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Appointment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    
    <br>

    <div class="container mt-5">
        <h2>Edit Appointment</h2>
        <!-- Action 'update' sends to the AppointmentServlet to handle the update -->
        <form action="update" method="post">
            <!-- Include the appointment ID as a hidden field to identify which appointment to update -->
            <input type="hidden" name="id" value="${appointment.id}" />

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${appointment.name}" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" value="${appointment.age}" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number:</label>
                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="${appointment.phoneNumber}" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select class="form-control" id="gender" name="gender" required>
                    <option value="Male" ${appointment.gender == 'Male' ? 'selected' : ''}>Male</option>
                    <option value="Female" ${appointment.gender == 'Female' ? 'selected' : ''}>Female</option>
                    <option value="Other" ${appointment.gender == 'Other' ? 'selected' : ''}>Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${appointment.email}" required>
            </div>
            <div class="form-group">
                <label for="appointmentType">Appointment Type:</label>
                <input type="text" class="form-control" id="appointmentType" name="appointmentType" value="${appointment.appointmentType}" required>
            </div>
            <div class="form-group">
                <label for="doctorType">Doctor Type:</label>
                <input type="text" class="form-control" id="doctorType" name="doctorType" value="${appointment.doctorType}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Appointment</button>
        </form>
    </div>

    <%@ include file="footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
