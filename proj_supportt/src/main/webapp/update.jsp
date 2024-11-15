<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Ticket</title>
    <link rel="stylesheet" href="updatestyle.css">
    <link rel="stylesheet" href="css/updatestyle.css" >
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

    <h2>Update Ticket</h2>
    

    
    <form action="update_ticket_servlet" method="POST">
      <c:forEach items="${view_update}" var="details">
       
        <input type="text" name="" value="${details.id}" disabled>
        <input type="hidden" name="id" value="${details.id}" >
        
        <label for="firstName">First Name:</label>
	    <input type="text"  name="firstName" value="${details.f_name}" required><br><br>
	        
	    <label for="lastName">Last Name:</label>
	    <input type="text"  name="lastName" value="${details .l_name}" required><br><br>
	        
	    <label for="email">Email:</label>
	    <input type="email" name="email" value="${details.email}" required><br><br>
        
        <label for="date">Date:</label>
        <input type="date"  name="date" value="${details.date}" required><br><br>
        
        <label for="issue">Issue:</label><br>
        <textarea name="issue" rows="4" cols="50" required>${details.issue}</textarea><br><br>
        
        <button type="submit" class="btn1">Update</button>
        <a href="view_ticket.jsp" class="btn">Cancel</a>
     </c:forEach>
    </form>

    <footer>
        <p>&copy; 2024 SDB Bank. All rights reserved.</p>
    </footer>

</body>
</html>
