package dto;

import java.sql.*;

public class database2 {

	String url, uname, pass, db;
	Connection con;
	String query;
	Statement st;
	PreparedStatement pt;
	
	public database2(String db) {
		super();
		this.db = db;
		this.url = "jdbc:mysql://localhost:3306/" + this.db;
		this.uname = "root";
		this.pass = "sultan1369";		
	}
	
	public void connection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, pass);
	}
	
	
	public int validate(String uname, String password) throws SQLException, ClassNotFoundException {
		
		this.connection();
		
		query = "select set_Password from student where set_Username='"+uname+"'";
		
		//create statement
		st = con.createStatement();
		
		//execute statement
		ResultSet result = st.executeQuery(query);		
		
		if(!result.next()) {
			con.close();
			return 1;
		}
		if(result.getString(1).equals(password)) {
			con.close();
			return 2;
		}
		else {
			con.close();
			return 3;
		}
	}

	public student read(String uname) throws SQLException, ClassNotFoundException {
		
		//load the drive
		//create connection
		this.connection();
		
		//write query
		query = "select * from student where set_Username='"+uname +"'";
		
		//create statement
		st = con.createStatement();
		
		//execute statement
		ResultSet result = st.executeQuery(query);
		student student = new student();
		//process the result(select)
		while(result.next()) {
			student.setfirstName(result.getString(2));
			student.setmiddleName(result.getString(3));
			student.setlastName(result.getString(4));
			
			student.setdob(result.getString(5));
			student.setgender(result.getString(6));
			student.setemail(result.getString(7));
			student.setInstitute(result.getString(8));
			student.setcourse(result.getString(9));
		}
		//close the connection
		con.close();
		return student;
	}
}
