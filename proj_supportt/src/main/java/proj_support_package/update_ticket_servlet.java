package proj_support_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_ticket_servlet")
public class update_ticket_servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
        String f_name=request.getParameter("firstName");
        String l_name=request.getParameter("lastName");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String issue = request.getParameter("issue");
        
        boolean isSuccess = false;
        
        System.out.println("\nupdate_ticket_servlet running");
        System.out.println("ID: " + id + ", First Name: " + f_name + ", Last Name: " + l_name + ", Email: " + email + ", Date: " + date + ", Issue: " + issue);

        
        isSuccess = support_ticket_utill.updateSupportTicket(id, f_name, l_name, email, date, issue);
     
        if(isSuccess == true)
        {
        	RequestDispatcher disp = request.getRequestDispatcher("view_ticket_servlet");
        	disp.forward(request, response);
        	
        }
        
        else
        {
        	RequestDispatcher disp = request.getRequestDispatcher("db_failed.jsp");
        	disp.forward(request, response);
        }
	}

}
