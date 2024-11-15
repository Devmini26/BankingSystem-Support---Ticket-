package proj_support_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class support_ticket_utill 
{
	
//////////////////////	insert TICKET DETAILS /////////////////////////////////////////
    public static boolean insertSupportTicket(int tid, String fName, String lName, String email, String date, String issue) 
    {
        boolean isSuccess = false;

        String url = "jdbc:mysql://localhost:3306/support_db";
        String u_name = "root";
        String pwd = "1234";

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, u_name, pwd);

            Statement stmnt = con.createStatement();
            
            String sql = "INSERT INTO support_ticket (id, first_name, last_name, email, date, issue) VALUES ('"+tid+"', '"+ fName + "', '"+ lName + "', '"+ email + "', '"+ date + "', '"+ issue + "')";
            
            int result = stmnt.executeUpdate(sql);
            
            if(result > 0)	
            {
            	isSuccess = true;
            }
            else
            {
            	isSuccess = false;
            }
            
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }

        return isSuccess;
    }
    
    
    ////////////////////// DISPLAY TICKET DETAILS /////////////////////////////////////////
    
    public static List<ticket_details> getSupportTickets() 
    {
        List<ticket_details> supportTickets = new ArrayList<>();
        
        String url = "jdbc:mysql://localhost:3306/support_db"; 
        String u_name = "root";
        String pwd = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u_name, pwd);
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM support_ticket;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String date = rs.getString("date");
                String issue = rs.getString("issue");
                
                ticket_details ticket = new ticket_details(id, firstName, lastName, email, date, issue);
                supportTickets.add(ticket);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 

        return supportTickets;
    }
    
    //////////// DISPLAY DETAILS THAT SHOULD UPDATE ////////////////////
    
    public static List<ticket_details> get_view_updateSupportTicket(int id) 
    {
        List<ticket_details> v_u_supportTickets = new ArrayList<>();
        
        String url = "jdbc:mysql://localhost:3306/support_db"; 
        String u_name = "root";
        String pwd = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u_name, pwd);
            
            Statement stmnt = con.createStatement();
            
            ResultSet rs = stmnt.executeQuery("SELECT * FROM support_ticket WHERE id='"+id+"';");
            
            while (rs.next()) 
            {
                int v_id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String date = rs.getString("date");
                String issue = rs.getString("issue");
                
                ticket_details ticket = new ticket_details(v_id, firstName, lastName, email, date, issue);
                v_u_supportTickets.add(ticket);
            }
            con.close();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 

        return v_u_supportTickets;
    }
    
    ////////// UPDATE TICKET DETAILS//////////
    

    public static boolean updateSupportTicket(int id, String f_name, String l_name, String email, String date, String issue) 
    {
    		boolean checkSuccess = false;
    	
    		String url = "jdbc:mysql://localhost:3306/support_db"; 
            String u_name = "root";
            String pwd = "1234";

          try 
          {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u_name, pwd);
            
            Statement stmnt = con.createStatement();
            
            String sql = "UPDATE support_ticket SET first_name = '"+f_name+"', last_name = '"+l_name+"', email= '"+email+"', date = '"+date+"', issue = '"+issue+"' WHERE id = '"+id+"' ";
            
            System.out.println("DAO - updateSupportTicket" + "ID: " + id + ", First Name: " + f_name + ", Last Name: " + l_name + ", Email: " + email + ", Date: " + date + ", Issue: " + issue);

            
            int reslt = stmnt.executeUpdate(sql);
			
			if(reslt > 0)
			{
				checkSuccess = true;
			}
			else
			{
				checkSuccess = false;
			}
			
         } 
          catch (Exception e) 
         {
            e.printStackTrace();
         }
        System.out.println(checkSuccess);
        return checkSuccess;
    }
    
    ////////DELETE TICKET DETAILS //////
    public static boolean deleteSupportTicket(int id) {
    	
    	
 	    String url = "jdbc:mysql://localhost:3306/support_db";
        String u_name = "root";
        String pwd = "1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, u_name, pwd);
                 PreparedStatement stmnt = con.prepareStatement("DELETE  FROM support_ticket WHERE id = ?")) {
                stmnt.setInt(1, id);
                int rowsDeleted = stmnt.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    
}
