<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <img class="logo1" src="LA_logo.png" alt="Learners Academy">
        
    </header>
    <div class="background-image4">
    <div class="container">
        <form action="logoutInstServlet" method="post">
        <h2>Logged out</h2>
        <p>Thank You, ${user.firstName} ${user.middleName} ${user.lastName}!</p>
        <p>You have successfully logged out of your account.</p>
        <p><a href="index.html">Back to Home</a></p>
        </form>
    </div>
    </div>
    <footer>
        <p>Learners Academy</p>
    </footer>
</body>
</html>
