package proj_support_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert_ticket_servlet")
public class insert_ticket_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int t_id = Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String issue = request.getParameter("issue");

		boolean isSuccess = false;
		
		System.out.println("servlet running");

		isSuccess = support_ticket_utill.insertSupportTicket(t_id, fName, lName, email, date, issue);

		if (isSuccess == true) 
		{
			request.setAttribute("successMsg", "Successfuly data inserted to table !");
			RequestDispatcher disp = request.getRequestDispatcher("support.jsp");
			disp.forward(request, response);
			
		} else 
		{
			RequestDispatcher disp = request.getRequestDispatcher("db_failed.jsp");
			disp.forward(request, response);
		}
	}
 
}
