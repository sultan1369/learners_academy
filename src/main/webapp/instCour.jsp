

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Course Registration</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <img class="logo1" src="LA_logo.png" alt="Learners Academy">
    <div><h4>Instructor Course Registration</h4></div>
    <nav>
        <ul>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
        </ul>
    </nav>
</header>
<div class="background-image4">
    <div class="container1">
        <div id="menu1">
            <nav>
                <ul>
                    <li><a href="courses.jsp" onclick="showCourses()">Course Details</a></li>
                    
                </ul>
            </nav>
        </div>
    </div>
    <div class="avlcourse">
        <h1>Available Courses</h1>
        <ul>
            <li>Web App Development</li>
            <li>Mobile App Development</li>
            <li>Data Science</li>
        </ul>
        <h2>${user.firstName} ${user.middleName} ${user.lastName}!, Register Here For Course</h2>
    </div>
    <div class="container">
        <h2>Instructor Course Registration</h2>
        <form id="registrationForm" action="submitCRegistration" method="post">
            <label for="courseId">Course ID:</label>
            <input type="text" id="courseId" name="courseId" required onchange="updateCourseName()"><br>

            <label for="courseName">Course Name:</label>
            <select id="courseName" name="courseName" required>
                <option value="Web App Development">Web App Development</option>
                <option value="Mobile App Development">Mobile App Development</option>
                <option value="Data Science">Data Science</option>
                <!-- Add more courses here -->
            </select><br>

            

            <label for="enrollmentDate">Enrollment Date:</label>
            <input type="date" id="enrollmentDate" name="enrollmentDate" required><br>

            <button type="submit">Register</button>
        </form>
    </div>
</div>
<footer>
    <p>Learners Academy</p>
</footer>

<script>
    function updateCourseName() {
        var courseId = document.getElementById("courseId").value;
        var courseNameSelect = document.getElementById("courseName");
        var courseName;

        switch (courseId) {
            case "1":
                courseName = "Web App Development";
                break;
            case "2":
                courseName = "Mobile App Development";
                break;
            case "3":
                courseName = "Data Science";
                break;
            default:
                courseName = "";
                break;
        }

        // Update the selected option in the course name select element
        var options = courseNameSelect.options;
        for (var i = 0; i < options.length; i++) {
            if (options[i].value === courseName) {
                courseNameSelect.selectedIndex = i;
                break;
            }
        }
    }
</script>
</body>
</html>

