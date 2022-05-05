package Login;
import java.sql.ResultSet;

import Main.*;


interface CheckCredentials{   //interface for authentication process
	boolean validation(String user,int pin);
	boolean checkCredentials(String user, int pin);
}

public class CustomerAuthentication implements CheckCredentials {
	public String customerName;
	/* 
	 * This method is used for returning boolean
	 * true to the checkCredentials method if 
	 * the credentials are valid from the database
	 * with respective to the parameters.
	 */
    public boolean validation(String userName, int userPin)  {
		boolean authentication=false;
		DBconnect DB= new DBconnect();  //creating object for the database connecting class
		String sqlQuery="select customer_name, customer_username, customer_pin from customer_details where customer_username='"+userName+"'";  //sql query is assigned to the string variable
		try {
			DB.dbMain();  //calling the method in the database connecting class to connect the this method with the mysql db
			ResultSet resultSet = DB.st.executeQuery(sqlQuery);   //creating the object to store the result set values that are obtained from the db
			resultSet.next();   //initializing to seek from the next row as the first row is with the header names
			if(userName.equals(resultSet.getString(2)) && userPin==resultSet.getInt(3)) {  //checking if the user entered username and pin are matching with then db
				authentication=true;   //declares authentication variable as true if user entered matches with the db 
			}
			this.customerName=resultSet.getString(1);
		}catch(Exception e) {}  //error shows when the user entered data doesnt match with the database data
		return authentication;  //to return the boolean value to the called method
	}
	
    /*
     * This method is used to return
     * the boolean value obtained from
     * the validation method (getting)
     */
	public boolean checkCredentials (String userName, int userPin) {

			return validation(userName,userPin);  //returning the boolean value obtained from the validation method and sending to the called main method
	}
}
