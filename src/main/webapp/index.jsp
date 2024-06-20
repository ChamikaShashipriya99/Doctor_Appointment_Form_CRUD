<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Appointment Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    
    <br>
    
    <div class="container mt-5">
        <h2>Doctor Appointment Form</h2>
        <form action="insert" method="post" onsubmit="return validateForm();">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" min="1" max="120" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number:</label>
                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10,12}" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select class="form-control" id="gender" name="gender" required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="appointmentType">Appointment Type:</label>
                <input type="text" class="form-control" id="appointmentType" name="appointmentType" required>
            </div>
            <div class="form-group">
                <label for="doctorType">Doctor Type:</label>
                <input type="text" class="form-control" id="doctorType" name="doctorType" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="list" class="btn btn-secondary">View Details</a>
        </form>
    </div>

    <%@ include file="footer.jsp" %>
    
    <script>
        function validateForm() {
            // Validate Phone Number (Only digits, length between 10 to 12)
            var phoneNumber = document.getElementById("phoneNumber").value;
            var phonePattern = /^[0-9]{10,12}$/;
            if (!phonePattern.test(phoneNumber)) {
                alert("Please enter a valid phone number (10-12 digits).");
                return false;
            }

            // Validate Email
            var email = document.getElementById("email").value;
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }

            // Validate Age (between 1 and 120)
            var age = document.getElementById("age").value;
            if (age < 1 || age > 120) {
                alert("Please enter a valid age between 1 and 120.");
                return false;
            }

            return true; // If all validations are passed, submit the form
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
