package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect;

public class DeliveryExecutive {
	
	void deliveryMain() throws Exception {
		Scanner input=new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter City: ");
			String city=input.nextLine();
			if(city.equals("Coimbatore")||city.equals("Madurai")||city.equals("Chennai")) {
				System.out.println("1 - Pick Shipment || 2 - Delivery Shipment");
				System.out.print("Enter: ");
				int executiveOption = input.nextInt();
				if(executiveOption==1) {
					//pickUpPrint(city);
					ExecutivePick.deliveryPick(city);
					break;
				}
				else if(executiveOption==2) {
					ExecutiveDrop.executiveDrop(city);
					break;
				}
			}
			else
				System.out.println("\nWrong input - Service available only on Coimbatore, Madurai, Chennai\n");
			
			
		}
		
	}


}
