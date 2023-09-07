<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BHEL Security</title>
</head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<link rel="stylesheet" href="Other.css">


<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
    <nav>
    <label class="logo" ><img src="images/signin-image.jpg" style=" width: 86px;height: 66px;border-radius: 8px;
    overflow: hidden;margin-top: 6px;"></label>
            <ul>
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="#">About</a></li>
                <li><a class="active" href="#">Check Portal</a></li>
                <li><a href="Logout">Logout</a></li>
				<li><a href="Logout"><%=session.getAttribute("name") %></a></li>
            </ul>
    </nav>
    <br><br><br><br>
    <form action="Other" method="post">
        <div class="container">
        <div class="form-group">
                <input type="text" min="0" name="master" placeholder="Name Of Master">
            </div>
            <div class="form-group">
                <input type="number" min="0" name="people_no" placeholder="No. Of Colleague">
            </div>
            <div class="form-group">
                <input type="text" name="name" placeholder="Name Of Visitor">
            </div>
            <div class="form-group">
                <input type="text" name="phone" placeholder="Contact No.">
            </div>
            <div class="form-group">
                <select name="ID" id="ID">
                     <option value="">Select ID</option>
                     <option value="Aadhar Card">Aadhar Card</option>
                     <option value="Drivers License">Drivers License</option>
                     <option value="Passport">Passport</option>
                </select>
            </div>
            <div class="form-group">
                <input type="text" name="Id_No" placeholder="Enter ID Number">
            </div>
            <div class="form-group">
                <textarea  name="stuff" placeholder="Stuff Carrying"></textarea>
            </div>
            <button class="btn">SUBMIT / HOME</button>
        </div>    
    </form>
    <script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

	<script type="text/javascript">
		var status = document.getElementById("status").value;
    	if(status == "success"){
    		swal("Congrats","Account Created Successfully","success");
    	}
    </script>
</body>

</html>
