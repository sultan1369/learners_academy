<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <img class="logo1" src="LA_logo.png" alt="Learners Academy">
    <div><h4>Student Dashboard</h4></div>
    <nav>
        <ul>
            <li><a href="about2.html">About</a></li>
            <li><a href="contact2.html">Contact</a></li>
        </ul>
    </nav>
</header>
<div class="background-image4">
    <div class="container1">
        <div id="menu1">
            <nav>
                <ul>
                    <li><a href="stdCouReg.jsp" onclick="showCourses()">Course Registration</a></li>
                    
                    <li><a href="cngpass.jsp" onclick="changePassword()">Change Password</a></li>
                    <li><a href="logout.jsp" onclick="logout()">Logout</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="container">
        <h2>Welcome, ${student.firstName} ${student.middleName} ${student.lastName}!</h2>
        <form id="editStudentForm" action="Student" method="post">
        <label for="studentId">Student Id:</label>
            <input type="text" id="studentId" name="studentId" value="${student.studentId}" required disablede>
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${student.firstName}" required>

            <label for="middleName">Middle Name:</label>
            <input type="text" id="middleName" name="middleName" value="${student.middleName}">

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${student.lastName}" required>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" value="${student.dob}" required>

            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="male" ${student.gender == 'male' ? 'selected' : ''}>Male</option>
                <option value="female" ${student.gender == 'female' ? 'selected' : ''}>Female</option>
                <option value="other" ${student.gender == 'other' ? 'selected' : ''}>Other</option>
            </select>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${student.email}" required>

            <label for="institute">Institute:</label>
            <input type="text" id="institute" name="institute" value="${student.institute}" required>

            <label for="course">Course:</label>
            <select id="course" name="course" required>
                <option value="btech" ${student.course == 'btech' ? 'selected' : ''}>B.Tech</option>
                <option value="mtech" ${student.course == 'mtech' ? 'selected' : ''}>M.Tech</option>
                <option value="degree" ${student.course == 'degree' ? 'selected' : ''}>Degree</option>
            </select>

            <button type="submit">Save Changes</button>
        </form>
    </div>
    <div class="link">
        <h3>Attempt Quiz</h3>
        <div class="quiz"></div>
        <div class="attempt">
            <p6><a class="blinking-text">Attempt The Quiz On Front end, Back end and Database</a></p6></div>
            <button class="buttons11"><a href="quiz.html" class="blinking-text">Start Quiz</a></button>
        </div>
    </div>
    <footer>
        <p>Learners Academy</p>
    </footer>
</body>
</html>
