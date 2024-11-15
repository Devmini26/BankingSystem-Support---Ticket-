package proj_support_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_update_TicketServlet")
public class view_update_TicketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    
    	
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println("EditSupportTicketServlet - updated id" + id); // for debug

        List<ticket_details> view_update = support_ticket_utill.get_view_updateSupportTicket(id);
        request.setAttribute("view_update", view_update);
        
        if (view_update != null) 
        {
        	RequestDispatcher disp = request.getRequestDispatcher("update.jsp");
        	disp.forward(request, response);
        
        } 
        else 
        {
        	System.out.println("can not get data for - updated id" + id);
        }
    }
}
