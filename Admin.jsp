
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BHEL Admin Portal</title>
    <link rel="stylesheet" href="Admin.css">
</head>
<body>
     <nav>
    <label class="logo" ><img src="images/signin-image.jpg" style=" width: 86px;height: 66px;border-radius: 8px;
    overflow: hidden;margin-top: 6px;"></label>
            <ul>
                <li><a href="Logout">Logout</a></li>
				<li><a href="#" style="font-size:25px;font-weight:bold;background-color: gray;
				color: black; border-radius:8px;">ADMIN</a></li>
            </ul>
    </nav>
    
    
    <div class="container">
      <div class="wrapper">
        <div class="title"><span>Visitor Data Extractor</span></div>
        <form action="AdminServlet" method="post">
          <div class="row">
            <i class="fas fa-user"></i>
            <input type="date" name="date" placeholder="Enter Date" required>
          </div>
          <div class="row button">
            <input type="submit" value="Extract">
          </div>
        </form>
      </div>
      <br><br>
       <div class="wrapper">
        <div class="title"><span>Guest Data Extractor</span></div>
        <form action="GuestServlet" method="post">
          <div class="row">
            <i class="fas fa-user"></i>
            <input type="text" name="name" placeholder="Enter Name" required>
          </div>
          <div class="row button">
            <input type="submit" value="Extract">
          </div>
        </form>     
      </div>
      
    </div>
    
     
    <Script>
        let admin = prompt("Enter Admin Confirmation password");
        if(admin == 123){
        	console.log("You can do it further");
        }
        else{
        	window.location="login.jsp";
        }
    </Script>
</body>
</html>