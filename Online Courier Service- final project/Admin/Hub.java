package Admin;

import java.util.Scanner;

public class Hub {
	void hubMain() throws Exception {
		Scanner input=new Scanner(System.in);
		while(true) {
			System.out.print("Enter City: ");
			String city=input.nextLine();
			if(city.equals("Coimbatore")||city.equals("Madurai")||city.equals("Chennai")) {
				System.out.println("\n1 - In Hub || 2 - Out Hub");
				System.out.print("Enter: ");
				int hubOption = input.nextInt();
				if(hubOption==1) {
					HubIn obj=new HubIn();
					obj.hubIn(city);
				}
				else if(hubOption==2) {
					HubOut obj1=new HubOut();
					obj1.hubOut(city);			
			    }
				break;
			
			}
			else
				System.out.println("\nWrong input - Service available only on Coimbatore, Madurai, Chennai\n");
		}
	}

}
