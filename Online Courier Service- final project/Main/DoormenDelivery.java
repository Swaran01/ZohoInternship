package Main;
import Animation.*;
import Customer.*;
import Admin.*;

import java.util.Scanner;

public class DoormenDelivery {

	
	public static void main(String[] args) throws Exception  {
		
		System.out.print("\nDoorMen Delivery !!!");
		WelcomeAnimation.welcomeText();
		System.out.print("\n\nCustomer - 1 || Admin - 2\nEnter: ");
		Scanner input=new Scanner(System.in);
		while(true) {
			try {
				int mainLoginOption = input.nextInt();
				if(mainLoginOption==1) {
					CustomerMain customerLogin=new CustomerMain();
					customerLogin.customerMain();
				}
				else if(mainLoginOption==2) {
					while(true) {
						try {
							System.out.print("\nAdmin Pin: ");
							int pin=input.nextInt();
							if(pin==0000) {
								AdminMain.adminMain();
								break;
							}
							else
								System.out.print("Wrong Pin\n");
						
						}catch(Exception e) {System.out.print("Wrong Pin(enter only integer)\n");input.next();}
						
					}
					
				}
				else
					System.out.print("Wrong input entered please try again\n\nCustomer - 1 || Admin - 2\nEnter:  ");
				
			}catch(Exception e) {System.out.print("Wrong input entered please try again\n\nCustomer - 1 || Admin - 2\nEnter:  ");input.next();}
			
		}
		
		
		
		
		//input.close();

	}

}
