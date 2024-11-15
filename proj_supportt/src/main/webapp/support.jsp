<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Banking</title>
    <link rel="stylesheet" href="the.css">
	
	<link rel="stylesheet" href="css/the.css" >
</head>
<body>

	<header>
        <div class="logo">SDB Bank</div>
        <div class="h1">Online banking system</div>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Accounts</a></li>
                <li><a href="#">Transactions</a></li>
                <li><a href="#">Bill payments</a></li>
                <li><a href="#">Support</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </header>

	<div class="container">
	      <h2>Submit a Support Ticket</h2>
	      
	      <br><p>${successMsg}</p>
	      
	    <form action="insert_ticket_servlet" method="POST" >
	    
	    	<input type="hidden" name="id" value="0" >	  
	    	  	
	        <label for="firstName">First Name:</label>
	        <input type="text" id="firstName" name="firstName" required><br><br>
	        
	        <label for="lastName">Last Name:</label>
	        <input type="text" id="lastName" name="lastName" required><br><br>
	        
	        <label for="email">Email:</label>
	        <input type="email" id="email" name="email" required><br><br>
	        
	        <label for="date">Date:</label>
	        <input type="date" id="date" name="date" required><br><br>
	        
	        <label for="issue">About Issue:</label><br>
	        <textarea id="issue" name="issue" rows="4" cols="50" required></textarea><br><br>
	        
	        <label for="attachment">Attachment:</label>
	        <input type="file" id="attachment" name="attachment"><br><br>
	        
	        <input type="submit" value="Submit">
	        <input type="button" value="cancel">
	        
	        
	        
	       
	     </form>
	        
	       <form action="view_ticket_servlet" method="POST">
    <input type="submit" value="View">
</form>

	
		
	
	</div>
	  

	
	<div>
		<form action="#" method="post">
		<input type="submit" value="View">
	</form>
	</div>
	
	 <footer>
       
        <p>&copy; 2024 SDB Bank. All rights reserved.</p>
    </footer>

</body>
</html>