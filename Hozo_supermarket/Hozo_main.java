package Hozo_supermarket;

import java.util.Scanner;

public class Hozo_main {

	public static void main(String[] args) throws Exception {

		Scanner input=new Scanner(System.in);
		
		while(true) {
			
			System.out.print("\nadmin or bill portal: ");
			String user=input.nextLine();
			Print_all_products obj=new Print_for_admin();
			if(user.equals("admin")) {
				String opt;
				while(true) {
					System.out.println("\nshow stock, show customers, new product, new customer, add stock, 0 - Go back");
					System.out.print("Enter admin choice: ");
					opt=input.nextLine();
					if(opt.equals("new customer"))
						Customers.newCustomer();
					else if(opt.equals("new product"))
						Products.newProduct();
					else if(opt.equals("show stock"))
						obj.print();
					else if(opt.equals("show customers"))
						Customers.printCustomers();
					else if(opt.equals("add stock"))  // yet to create
						stocks.updateStock();
					else if(opt.equals("0"))
						break;
					else
						System.out.print("wrong input\n");
				}
			}
			else if(user.equals("bill portal")) {
				Customer_billing obj1=new Customer_billing();
				Print_all_products obj2=new Print_for_billing();
				System.out.print("Old customer or New customer: ");
				String customer_type=input.nextLine();
				long number;
				
				if (customer_type.equals("new")) {
					String name;
					System.out.print("Customer name: ");
					name=input.nextLine();
					System.out.print("Customer number: ");
					number=input.nextLong();
					Customers.newCustomerForBill(name,number);
					obj1.customerWelcomeForNew(name,number);
					obj2.print();
					Billing bill=new Billing();
					bill.billInput(number);
					
				}
				
				else if(customer_type.equals("old")) {
					
					System.out.print("Enter Customer number: ");
					number=input.nextLong();
					obj1.customerWelcomeForOld(number);
					obj2.print();
					Billing bill=new Billing();
					bill.billInput(number);
				}
				else
					System.out.println("wrong input");
        	}
			
			
			
		}
		
	
				
	}

}
