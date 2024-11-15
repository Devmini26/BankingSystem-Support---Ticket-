package proj_support_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteSupportTicketServlet")
public class delete_ticket_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	System.out.println("DeleteSupportTicketServlet working");
    	
        int id = Integer.parseInt(request.getParameter("id"));

        boolean isSuccess = support_ticket_utill.deleteSupportTicket(id);

        if (isSuccess) {
        	RequestDispatcher disp = request.getRequestDispatcher("view_ticket_servlet");
			disp.forward(request, response);
        } else 
        {
        	request.setAttribute("delete_failed", "failed to delete!");
        	RequestDispatcher disp = request.getRequestDispatcher("view_tickets.jsp");
			disp.forward(request, response);
        }
    }
}
