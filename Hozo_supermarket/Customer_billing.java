package Hozo_supermarket;

import java.sql.ResultSet;

class Customer_billing{
	long number;
	
	void customerWelcomeForOld(long number) throws Exception {  //customer details retrival
		/*long number;
		Scanner input = new Scanner(System.in);
		number=input.nextLong();*/
		try {
			this.number=number;
			DBconnect DB= new DBconnect();
			String query="select customer_name,customer_points from customer_details where customer_number="+number+"";
			DB.DBmain();
			ResultSet rs = DB.st.executeQuery(query);
			rs.next();
			
			System.out.println("Hi "+rs.getString(1)+", Glad to have you back!.\nYou have "+rs.getInt(2)+" points.\n");
		}catch (Exception e) {throw new Exception("Customer not found in DB");}
		
	}
	
	void customerWelcomeForNew(String name, long number) {
		System.out.println("Hi "+name+", Welcome to Hozo Supermarket!. Your points will increase for each purchase you do...Happy Shopping ");
		
	}
	
}
