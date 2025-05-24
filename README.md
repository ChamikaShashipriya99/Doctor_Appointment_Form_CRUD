# Web Application Module (JSP Pages)

This directory contains the JavaServer Pages (JSP) that form the user interface of the Doctor Appointment System.

## Key Files and Their Roles

*   **`index.jsp`**:
    *   This is the main landing page of the application.
    *   It features a form for users to submit their personal details (name, age, phone number, gender, email) and their appointment preferences (appointment type, doctor type).
    *   Includes client-side JavaScript for input validation (phone number format, email format, age range).
    *   Upon submission, the form data is sent to a backend servlet (details to be added after listing Java servlets).
    *   Provides a "View Details" button that links to a page displaying all appointments.
*   **`edit-appointment.jsp`**:
    *   This page is intended for modifying the details of an existing appointment.
    *   It would typically be accessed from the `viewdetails.jsp` page.
    *   (Further details about its interaction with backend servlets will be added as understood).
*   **`viewdetails.jsp`**:
    *   This page displays a list or table of all appointments currently stored in the database.
    *   It likely fetches data via a backend servlet that interacts with the database.
    *   (Further details about its interaction with backend servlets and options like editing or deleting appointments will be added as understood).
*   **`navbar.jsp`**:
    *   A common navigation bar component included in other JSP pages.
    *   Ensures consistent navigation across the application.
*   **`footer.jsp`**:
    *   A common footer component included in other JSP pages.
    *   Typically contains copyright information or other boilerplate content.

## Client-Side Validation (`index.jsp`)

The `index.jsp` page implements basic client-side validation using JavaScript to ensure data integrity before submission:

*   **Phone Number:** Validates that the input consists of 10 to 12 digits.
*   **Email:** Validates the email format using a regular expression.
*   **Age:** Ensures the age is within a reasonable range (e.g., 1 to 120).

## Backend Interaction

The JSP pages interact with the `com.appointment.controller.AppointmentServlet` to process data, interact with the database (via `com.appointment.dao.AppointmentDAO`), and manage application logic.

The `AppointmentServlet` is mapped to the root path (`/`) and handles different actions based on the URL pattern:

*   **`/insert`**:
    *   Called via a POST request from the form in `index.jsp`.
    *   Collects the form data (name, age, phone number, gender, email, appointment type, doctor type).
    *   Uses `AppointmentDAO` to insert a new appointment into the database.
    *   Redirects to `/list` after successful insertion.
*   **`/list` (or default `/`)**:
    *   Called via a GET request (e.g., when clicking "View Details" on `index.jsp` or by accessing the root path).
    *   Uses `AppointmentDAO` to fetch all appointments from the database.
    *   Forwards the request to `viewdetails.jsp`, passing the list of appointments as an attribute.
*   **`/edit`**:
    *   Called via a GET request, typically from `viewdetails.jsp`, with an appointment `id` as a parameter.
    *   Uses `AppointmentDAO` to fetch the details of the specified appointment.
    *   Forwards the request to `edit-appointment.jsp`, passing the appointment object as an attribute to prefill the form.
*   **`/update`**:
    *   Called via a POST request from the form in `edit-appointment.jsp`.
    *   Collects the updated appointment data, including the `id` of the appointment to be updated.
    *   Uses `AppointmentDAO` to update the appointment details in the database.
    *   Redirects to `/list` after successful update.
*   **`/delete`**:
    *   Called via a GET request, typically from `viewdetails.jsp`, with an appointment `id` as a parameter.
    *   Uses `AppointmentDAO` to delete the specified appointment from the database.
    *   Redirects to `/list` after successful deletion.
*   **`/new`**:
    *   Called via a GET request.
    *   Forwards the request to `index.jsp` to display the new appointment form.

The `com.appointment.dao.AppointmentDAO` class encapsulates all JDBC logic for database operations (CRUD - Create, Read, Update, Delete) on the `appointments` table. It contains the database connection details (URL, username, password), which might need configuration during setup.

The `com.appointment.model.Appointment` class is a simple Java Bean representing an appointment, used to pass data between the servlet and DAO.
