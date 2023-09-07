<%
    if(session.getAttribute("name")==null){
    	response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BHEL Security</title>
    <link rel="stylesheet" href="BHEL_index.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <nav>
        <label class="logo" ><img src="images/signin-image.jpg" style=" width: 86px;
    height: 66px;
    border-radius: 8px;
    overflow: hidden;
    margin-top: 6px;"></label>
            <ul>
                <li><a class="active" href="#">HOME</a></li>
                <li><a href="#">About</a></li>
                <li><a href="BHEL.jsp">Check Portal</a></li>
                <li><a href="Logout">Logout</a></li>
				<li><a href="Logout"><%=session.getAttribute("name") %></a></li>
            </ul>
    </nav>

    <h2>Security Check</h2>
    <div class="container">
        <div class="content">
            <h3>Click on the link given below to go to the security check portal :</h3>
            <b>Clock : </b><span id="time"></span>
            
            <br>
            <a href="BHEL.jsp">BHEL Security Check Portal</a>     
            <br>               
        </div>
        <div class="content">
            <h3>All about security check :</h3>
            <br>
            <p>BHEL is India's largest engineering and manufacturing enterprise in the energy and infrastructure sectors. Established in 1964, we are a leading power equipment manufacturer globally and one of the earliest and leading contributors towards building an Aatmanirbhar Bharat.</p>
            <br>
            <p>Bharat Heavy Electricals Limited is an Indian central public sector undertaking and the largest government-owned power generation equipment manufacturer. It is under the ownership of Government of India and administrative control of the Ministry of Heavy Industries.</p>
        </div>
    </div>
    <script>
        setInterval(displaytime,1000);
        function displaytime(){
        	time.innerHTML = new Date() 
        }
    </script>
</body>
</html>
