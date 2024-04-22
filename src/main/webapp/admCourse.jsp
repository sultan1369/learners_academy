<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Courses</title>
    <link rel="stylesheet" href="styles.css"/>
</head>
<body>
<header>
    <div class="la"><img class="logo1" src="LA_logo.png" alt="Learners Academy"></div>
    <div><h4>Manage Courses</h4></div>
    <nav>
        <ul>
            <li><a href="admin.jsp">Back</a></li>
            <li><a href="about4.html">About</a></li>
            <li><a href="contact4.html">Contact</a></li>
        </ul>
    </nav>
</header>
<form action="adminCourseServlet" method="post">
<div class="background-image4">
    <div class="alldash" >
        <div class="containerdash" style="width: 80%";>
            <h3>Skill Development Courses</h3>

            <!-- Course details grid -->
            <div class="grid-container" >
                <div class="grid-item" >
                <img alt="web" src="456.png" style="width: 180px;">
                    <h3><a href="instWADev2.html">Web App Development</a></h3>
                    <p>Course ID: W001 ${instructor1.cid}</p>
                    <p>Course Name: Web Development ${instructor1.name}</p>
                    <p>Instructor Id:1 ${instructor1.id}</p>
                    
                    <p>Email:sultan1369@gmail.com ${instructor1.email}</p>
                </div>
                <div class="grid-item" >
                <img alt="web" src="123.png" style="width: 180px;">
                    <h3><a href="instMADev2.html">Mobile App Development</a></h3>
                    <p>Course ID: M002 ${instructor2.cid}</p>
                    <p>Course Name: Mobile Development ${instructor2.name}</p>
                    <p>Instructor Id:2 ${instructor2.id}</p>
                    
                    <p>Email:mansur123@gmail.com ${instructor2.email}</p>
                </div>
                <div class="grid-item" >
                    <img alt="web" src="789.png" style="width: 180px;">
                
                    <h3><a href="instDSce2.html">Data Science</a></h3>
                    <p>Course ID: D003 ${instructor3.cid}</p>
                    <p>Course Name: Data Science ${instructor3.name}</p>
                    <p>Instructor Id:3 ${instructor3.id}</p>
                    
                    <p>Email:gouse231@gmail ${instructor3.email}</p>
                </div>
                <div class="add-course">
                    <button onclick="location.href='#'">Add Another Course</button>
                </div>
                <!-- Add more courses as needed -->
            </div>
        </div>
    </div>
</div>

</form>
</body>
</html>
