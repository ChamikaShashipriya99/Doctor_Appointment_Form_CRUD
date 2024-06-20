<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Appointments</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    
    <br>
    
    <div class="container mt-5">
        <h2>Appointment Details</h2>
        <a href="index.jsp" class="btn btn-success mb-3">Add Another Appointment</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Phone Number</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Appointment Type</th>
                    <th>Doctor Type</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appointment" items="${listAppointment}">
                    <tr>
                        <td><c:out value="${appointment.id}" /></td>
                        <td><c:out value="${appointment.name}" /></td>
                        <td><c:out value="${appointment.age}" /></td>
                        <td><c:out value="${appointment.phoneNumber}" /></td>
                        <td><c:out value="${appointment.gender}" /></td>
                        <td><c:out value="${appointment.email}" /></td>
                        <td><c:out value="${appointment.appointmentType}" /></td>
                        <td><c:out value="${appointment.doctorType}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${appointment.id}' />" class="btn btn-primary">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${appointment.id}' />" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <%@ include file="footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
