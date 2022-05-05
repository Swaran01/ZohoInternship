package Main;

import java.sql.*;


public class DBconnect {
	public Statement st;
	public Connection con;

	public void dbMain() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DoorMen_Delivery", "root", "swaran");
		st=con.createStatement();
	  
	}

}