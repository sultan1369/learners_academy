package dto;

import java.sql.*;

public class Database {

	String url, uname, pass, db;
	Connection con;
	String query;
	Statement st;
	PreparedStatement pt;
	
	public Database(String db) {
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
		
		query = "select set_Password from instructor where set_Username='"+uname+"'";
		
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
			
			
		//wrong uname
		//wrong password
		//correct uname and password
					
	}

	public User read(String uname) throws SQLException, ClassNotFoundException {
		
		//load the drive
		//create connection
		this.connection();
		
		//write query
		query = "select * from instructor where set_Username='"+uname +"'";
		
		//create statement
		st = con.createStatement();
		
		//execute statement
		ResultSet result = st.executeQuery(query);
		User user = new User();
		//process the result(select)
		while(result.next()) {
			user.setfirstName(result.getString(2));
			user.setmiddleName(result.getString(3));
			user.setlastName(result.getString(4));
			user.setgender1(result.getString(5));
			user.dob(result.getString(6));
			user.setemail(result.getString(7));
		}
		//close the connection
		con.close();
		return user;
	}
}










