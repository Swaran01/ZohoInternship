package Customer;
import Login.*;
import Main.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class CustomerMain {

	Scanner input=new Scanner(System.in);
	public void customerMain() throws Exception {
		
		CustomerLogin obj = new CustomerLogin();
		obj.customerLogin();
		while(true) {
			System.out.println("\n1- Create new Shipment || 2- Track shipments || 3- View customer details || 4- Change address  || 0- End");
			System.out.print("Enter: ");
			//input.nextLine();
			int customerChoice=input.nextInt();
			if(customerChoice==1) {
				CustomerCreateShipment obj1=new CustomerCreateShipment();
				obj1.createShipment(obj.userName);
				
			}
			else if(customerChoice==2) {
				ShipmentStatus.customerShipmentStatus(obj.userName);
			}
			else if(customerChoice==3) {
				customerDetails(obj.userName);
				
			}
			else if(customerChoice==4) {
				CustomerAddress.customerAddressChange(obj.userName);
				System.out.println("\nCustomer Address change successfull !");
			}
			else if(customerChoice==0)
				break;
			else
				System.out.println("\nWrong Option entered....Please try again");
		}
		
	}
	
	
	
	void customerDetails(String userName) throws Exception {
		DBconnect DB= new DBconnect();
		String query="select * from customer_details where customer_username = '"+userName+"'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		rs.next();
		System.out.println("\nName: "+rs.getString(2));
		System.out.println("Mobile number: "+rs.getString(3));
		System.out.println("Username: "+rs.getString(4));
		System.out.println("City: "+rs.getString(6));
		System.out.println("Address: "+rs.getString(7));
		
		
	}
	

}
	
	
