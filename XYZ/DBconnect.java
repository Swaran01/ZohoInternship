package XYZ;
import java.sql.*;

public class DBconnect {
	protected Statement statement;  // creating object for Statement class to execute the given SQL statement which returns an object
	
	/*
	 * This method is used to connect and use
	 *  queries to execute sql statements and
	 *  get values. This method can be called
	 *  for connecting to database with
	 *  respective to object
	 */
	public void dbMain() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");  //for loading and registering the driver for connecting jdbc with mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/XYZ", "root", "swaran");  //connecting with database where the tables are stored with appropriate address, username and password
		statement=connection.createStatement();  //registering the object to send the sql statements to the database
	  
	}

}









