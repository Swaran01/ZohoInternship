package Customer;

import Login.*;
import Main.*;

import java.util.Scanner;


public class CustomerLogin {
	
	String userName;
	
	public void customerLogin() throws Exception {
		while(true) {
			Scanner input=new Scanner(System.in);
			System.out.print("Old customer or New customer?\nEnter(Old/New): ");
			String customerType=input.nextLine();
			if(customerType.equals("old")) {
				oldCustomerLoginEntry();
				break;
			}
			else if(customerType.equals("new")) {
				newCustomerLogin();
				break;
			}
			else
				System.out.println("Incorrect input...Please try again\n");
		}

}
	
	public void oldCustomerLoginEntry() {
		while(true) {
			System.out.print("\nEnter username: ");
			Scanner input=new Scanner(System.in);
			userName=input.nextLine();
			System.out.print("Enter pin: ");
			int userPin;
			try {
				userPin=input.nextInt();
			}catch(Exception e) {userPin=0;}
			CustomerAuthentication obj=new CustomerAuthentication();
			if(obj.checkCredentials(userName, userPin)) {
				System.out.println("\nHi "+obj.customerName+"!...Welcome back and Happy shipping.");
				break;
			}
			else
				System.out.println("\nIncorrect Credentials...Please try again");
		}
			
	
	}
	
	public void newCustomerLogin() throws Exception {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Customer Creation....Please give proper details.");
		System.out.print("Enter full name: ");
		String name=input.nextLine();
		System.out.print("Enter mobile number: ");
		long number=input.nextLong();
		input.nextLine();
		System.out.print("Enter username: ");
		userName=input.nextLine();
		System.out.print("Create pin: ");
		int userPin=input.nextInt();
		System.out.print("Enter city: ");
		//input.nextLine();
		String city=input.nextLine();
		System.out.print("Enter address: ");
		String address=input.nextLine();
		DBconnect DB= new DBconnect();
		String query="insert into customer_details(customer_name,customer_number,customer_username,customer_pin,customer_city,customer_address) values ('"+name+"',"+number+",'"+userName+"',"+userPin+",'"+city+"','"+address+"')";
		DB.dbMain();
		DB.st.execute(query);
		
		System.out.println("\nCustomer created. ");
		System.out.println("\nHi "+name+"!...May your shipping journey begins.");
	}
	

}
