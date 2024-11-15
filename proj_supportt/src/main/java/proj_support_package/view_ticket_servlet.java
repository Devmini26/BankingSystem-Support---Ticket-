

package proj_support_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/view_ticket_servlet")
public class view_ticket_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the JSP
        forwardToViewTicketJSP(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the JSP
        forwardToViewTicketJSP(request, response);
    }

    private void forwardToViewTicketJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        List<ticket_details> supportTickets = support_ticket_utill.getSupportTickets();
        request.setAttribute("tickets", supportTickets); // Set tickets list as a request attribute

        // Forward the request to the JSP
        RequestDispatcher disp = request.getRequestDispatcher("view_ticket.jsp");
        disp.forward(request, response);
    }
}


