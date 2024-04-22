<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Details</title>
    <link rel="stylesheet" href="styles.css"/>
</head>
<body>
<header>
    <div class="la"><img class="logo1" src="LA_logo.png" alt="Learners Academy"></div>
    <div><h4>Course Details</h4></div>
    
</header>

<form action="StudentCouServlet" method="post">
<div class="background-image4">
    <div class="alldash">
        <div class="containerdash">
            <h3>Skill Development Courses</h3>
            <!-- Course details grid -->
            <div class="grid-container">
                <div class="grid-item">
                    <img alt="web" src="456.png" style="width: 180px;">
                    <h3><a href="instWADev2.html">Web App Development</a></h3>
                    <p id="cid">Course ID:1 ${stdcou.cid}</p>
                    <p id="cname">Course Name:Web App Development ${stdcou.name}</p>
                    <p id="iid">Instructor Id:1 ${stdcou.iid}</p>
                    <p id="email">Email:sultan1369@gmail.com ${stdcou.email}</p>
                </div>
                <div class="grid-item">
                    <img alt="web" src="123.png" style="width: 180px;">
                    <h3><a href="instMADev2.html">Mobile App Development</a></h3>
                    <p id="cid1">Course ID:2 ${stdcou.cid1}</p>
                    <p id="cname1">Course Name:Mobile App Development ${stdcou.name1}</p>
                    <p id="iid1">Instructor Id:2 ${stdcou.iid1}</p>
                    <p id="email1">Email:mansur123@gmail.com ${stdcou.email1}</p>
                </div>
                <div class="grid-item">
                    <img alt="web" src="789.png" style="width: 180px;">
                    <h3><a href="instDSce2.html">Data Science</a></h3>
                    <p id="cid2">Course ID:3 ${stdcou.cid2}</p>
                    <p id="cname2">Course Name:Data Science ${stdcou.name2}</p>
                    <p id="iid2">Instructor Id:3 ${stdcou.iid2}</p>
                    <p id="email2">Email:gouse231@gmail ${stdcou.email2}</p>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Your form fields go here -->
</form>

</body>
</html>
