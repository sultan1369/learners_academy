<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <img class="logo1" src="LA_logo.png" alt="Learners Academy">
        <div><h4>Admin Dashboard</h4></div>
        <nav>
            <ul>
                <li><a href="about4.html">About</a></li>
                <li><a href="contact4.html">Contact</a></li>
            </ul>
        </nav>
    </header>
    <div class="background-image4">
        <div class="container1">
            <div id="menu1">
                <nav>
                    <ul>
                        <li><a href="admCourse.jsp" onclick="showCourses()">Manage Courses</a></li>
                        <li><a href="cngpass.jsp" onclick="changePassword()">Change Password</a></li>
                        <li><a href="logoutAdm.jsp" onclick="logout()">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="container" >
            <h2>Welcome, ${admin.firstName} ${admin.middleName} ${admin.lastName}!</h2>
            <form id="editStudentForm" action="admin" method="post">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${admin.firstName}" required>

                <label for="middleName">Middle Name:</label>
                <input type="text" id="middleName" name="middleName" value="${admin.middleName}">

                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${admin.lastName}" required>

                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" value="${admin.dob}" required>

                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="male" ${admin.gender == 'male' ? 'selected' : ''}>Male</option>
                    <option value="female" ${admin.gender == 'female' ? 'selected' : ''}>Female</option>
                    <option value="other" ${admin.gender == 'other' ? 'selected' : ''}>Other</option>
                </select>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${admin.email}" required>

                <button type="submit">Save Changes</button>
            </form>
        </div>
        <div class="link">
            <h3>Attempt Quiz</h3>
            <div class="quiz"></div>
            <div class="attempt">
                <p6><a class="blinking-text">Attempt The Quiz On Front end, Back end and Database</a></p6>
            </div>
            <button class="buttons11"><a href="quiz.html" class="blinking-text">Start Quiz</a></button>
        </div>
    </div>
    <footer>
        <p>Learners Academy</p>
    </footer>
</body>
</html>
