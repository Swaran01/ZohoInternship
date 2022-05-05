package Admin;

import java.util.Scanner;

public class AdminMain {
	
	
	public static void adminMain() throws Exception {
		Scanner input=new Scanner(System.in);
		System.out.print("\n*** 1 - Delivery Executive || 2 - Hub || 3 - In Transit ***\nEnter: ");
		int option=input.nextInt();
		if(option==1) {
			System.out.println("\n*** DELIVERY EXECUTIVE PORTAL ***");
			DeliveryExecutive obj=new DeliveryExecutive();
			obj.deliveryMain();
			
		}
		else if(option==2) {
			System.out.println("\n*** HUB ***");
			Hub obj1=new Hub();
			obj1.hubMain();
			
		}
		else if(option==3) {
			TransitPrint.TransitList();
			
		}
		else
			System.out.println("Wrong input...Please try again");
	}

}
