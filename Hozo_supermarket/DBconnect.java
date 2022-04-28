package Hozo_supermarket;

import java.sql.*;


public class DBconnect {
	protected Statement st;

	public void DBmain() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HozoSupermarket", "root", "swaran");
		st=con.createStatement();
	  
	}

}