package dto;

import java.sql.*;

public class database1 {

	String url, uname, pass, db;
	Connection con;
	String query;
	Statement st;
	PreparedStatement pt;
	
	public database1(String db) {
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
		
		query = "select set_Password from admin where set_Username='"+uname+"'";
		
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

	public admin read(String uname) throws SQLException, ClassNotFoundException {
		
		//load the drive
		//create connection
		this.connection();
		
		//write query
		query = "select * from admin where set_Username='"+uname +"'";
		
		//create statement
		st = con.createStatement();
		
		//execute statement
		ResultSet result = st.executeQuery(query);
		admin admin = new admin();
		//process the result(select)
		while(result.next()) {
			admin.setfirstName(result.getString(2));
			admin.setmiddleName(result.getString(3));
			admin.setlastName(result.getString(4));
			admin.setdob(result.getString(5));
			admin.setgender(result.getString(6));
			
			admin.setemail(result.getString(7));
		}
		//close the connection
		con.close();
		return admin;
	}
}
