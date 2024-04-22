<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <img class="logo1" src="LA_logo.png" alt="Learners Academy">
        <nav>
            <ul>
                <li><a href="student.jsp">Home</a></li>
                <li><a href="about2.html">About</a></li>
                <li><a href="contact2.html">Contact</a></li>
            </ul>
        </nav>
    </header>
    <div class="background-image4">
    <div class="container">
        <h2>Change Password</h2>
        <form id="changePasswordForm" action="changePassword" method="post">
            <label for="currentPassword">Current Password:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>

            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>

            <button type="submit">Change Password</button>
        </form>
    </div>
    </div>
    <footer>
        <p>Learners Academy</p>
    </footer>
</body>
</html>
