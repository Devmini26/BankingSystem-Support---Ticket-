package proj_support_package;

public class ticket_details 
{
	int id;
	String f_name;
	String l_name;
	String email;
	String date;
	String issue;
	
	
	public ticket_details(int id, String f_name, String l_name, String email, String date, String issue) 
	
	{
		//super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.date = date;
		this.issue = issue;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getL_name() {
		return l_name;
	}


	public void setL_name(String l_name) {
		this.l_name = l_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	
	
}
