package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect;

public class DeliveryExecutive {
	
	void deliveryMain() throws Exception {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter City: ");
		String city=input.nextLine();
		System.out.println("1 - Pick Shipment || 2 - Delivery Shipment");
		System.out.print("Enter: ");
		int executiveOption = input.nextInt();
		if(executiveOption==1) {
			//pickUpPrint(city);
			ExecutivePick.deliveryPick(city);
		}
		else if(executiveOption==2) {
			ExecutiveDrop.executiveDrop(city);
		}
		
	}


}
