
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Banking</title>
    <link rel="stylesheet" href="viewstyle.css">
	
	<link rel="stylesheet" href="css/viewstyle.css" >
	<link rel="stylesheet" href="css/deletestyle.css" >
	<style>
		#delete_confirm_div {
			margin-top: 40px;
			text-align: center;
		    display: none;
		    flex-direction: column;
		    align-items: center;
		    justify-content: space-between;
		}
		#con_btns
		{
			display: flex;
			    justify-content: center;
		}
		.btn{
			margin:10px;
		}
	</style>
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

    <h2>Ticket History</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Date</th>
            <th>Issue</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        
        <c:forEach var="ticket" items="${tickets}">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.f_name}</td>
                <td>${ticket.l_name}</td>
                <td>${ticket.email}</td>
                <td>${ticket.date}</td>
                <td>${ticket.issue}</td>
                <td>
                    <form action="view_update_TicketServlet" method="POST">
                        <input type="hidden" name="id" value="${ticket.id}">
                        <button type="submit" class="btn">Edit</button>
                    </form>
                </td>
                <td>
                    <button class="btn btn-danger" onclick="show_delete_confirm(${ticket.id})">Remove</button>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div id="delete_confirm_div">
    	<h3>Are you sure you want to delete the following ticket?</h3>
        <div id="con_btns">
        	<form action="DeleteSupportTicketServlet" method="POST">
	            <input type="hidden" id="delete_ticket_id" name="id" value="">
	            <input type="submit" class="btn btn-danger" value="Confirm Delete">
	        </form>
	        <button onclick="hide_delete_confirm()" class="btn">Cancel</button>
        </div>
    </div>

    <script>
        function show_delete_confirm(ticketId) {
            document.getElementById("delete_ticket_id").value = ticketId;
            document.getElementById("delete_confirm_div").style.display = "block";
        }

        function hide_delete_confirm() {
            document.getElementById("delete_confirm_div").style.display = "none";
        }
    </script>
</body>
</html>
    
 
             
       
              
            
        

