package Hozo_supermarket;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

public class Customers {
	
	static void customerUpload(String name,long num) throws Exception {
		DBconnect DB= new DBconnect();
		String query="insert into customer_details(customer_name,customer_number,customer_points) values ('"+name+"',"+num+",0)";
		DB.DBmain();
		DB.st.execute(query);
	}
		

	public static void newCustomer(){
		
        Scanner input = new Scanner(System.in);    //
		
		int opt=1;
		while(opt!=0) {
			System.out.println("1 to add customer - 0 to stop ");
			System.out.print("Enter: ");
			opt=input.nextInt();
			input.nextLine();
			long num;
			String name;
			if(opt==1) {
				
				try {
					System.out.print("Customer name: ");
					name=input.nextLine();
					System.out.print("Customer number: ");
					num=input.nextLong();
					
					customerUpload(name,num);  //send to method to update in db
					System.out.println("\nCustomer created.\n\n ");
				}catch(Exception e) {System.out.println("Error: Customer details format wrong");}
			
			}
			else if(opt!=0 && opt!=1)
				System.out.println("Enter a valid option. ");
			
			
		}System.out.println("Thank you for creating customers. ");
		
		//input.close();

	}
	
    public static void newCustomerForBill(String name, long number) throws Exception {
		
        //Scanner input = new Scanner(System.in);    //
			customerUpload(name,number);  //send to method to update in db
			System.out.println("\nCustomer created.\n\n ");
				
	}
	
	public static void printCustomers() throws Exception {
		
		Formatter fmt = new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from customer_details";
		DB.DBmain();
		ResultSet rs = DB.st.executeQuery(query);
		
		System.out.println("--------------------------------------");      
		System.out.printf("%10s %15s %10s", "NAME", "NUMBER", "POINTS");  
		System.out.println("\n--------------------------------------");
		
		while (rs.next())
			fmt.format("%15s %12s %6s \n",rs.getString("customer_name"),rs.getLong("customer_number"),rs.getInt("customer_points"));
			System.out.println(fmt);
	}

}
