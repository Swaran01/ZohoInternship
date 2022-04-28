package XYZ;

import java.sql.ResultSet;

public class WelcomeCustomer {  //class to welcome the customer using a message with their names and balance
	
	/*
	 * method to obtain the customer name 
	 * and their balance with respect to 
	 * the userName from the db after 
	 * authentication and printing the 
	 * welcome message with name and balance 
	 * using the printNameBalance method
	 */
	static void customerWelcome(String userName) throws Exception {
		DBconnect DB= new DBconnect();  //creating object for the database connecting class
		String sqlQuery="select customer_name, customer_balance from customer_details where customer_username='"+userName+"'";  //sql query is assigned to the string variable
		DB.dbMain();  //calling the method in the database connecting class to connect the this method with the mysql db
		ResultSet resultSet = DB.statement.executeQuery(sqlQuery);   //creating the object to store the result set values that are obtained from the db
		resultSet.next();   //initializing to seek from the next row as the first row is with the header names
        printNameBalance(resultSet);  //putting method is used to print the values from another method
		
	}
	
	/*
	 * this method is getting the resultset 
	 * values from customerWelcome method 
	 * and printing the welcome message 
	 * with name and balance 
	 */
    static void printNameBalance(ResultSet resultSet) throws Exception { //getting method
		
		System.out.println("Authentication Successfull.\n\nHello "+resultSet.getString(1)+", Happy to have you again.\nBalance: "+resultSet.getInt(2)+"$");  // to print the welcome message with name and balance
	}
	
	
}
