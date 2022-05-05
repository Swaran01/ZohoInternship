package Customer;

import java.sql.ResultSet;
import java.util.Scanner;

import Main.DBconnect;

public class CustomerAddress {

	static void customerAddressChange(String userName) throws Exception {
		Scanner input = new Scanner(System.in);
		DBconnect DB= new DBconnect();
		String query="select customer_address from customer_details where customer_username = '"+userName+"'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		rs.next();
		System.out.println("\nOld address: "+rs.getString(1));
		System.out.print("New address: ");
		//input.nextLine();
		String newAddress=input.nextLine();
		String query1="update customer_details set customer_address='"+newAddress+"' where customer_username='"+userName+"'";
		DB.st.executeUpdate(query1);
		
	}
}
