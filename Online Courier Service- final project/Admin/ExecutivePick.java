package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect; 

public class ExecutivePick {

	static void deliveryPick(String city) throws Exception {
		Scanner input=new Scanner(System.in);
		pickUpPrint(city);
		System.out.println("ENTER PICKED SHIPMENT ORDER-ID or 0 TO END");
		//int shipmentId;
		while(true) {
			System.out.print("Enter: ");
			int shipmentId=input.nextInt();
			if(shipmentId==0) {
				System.out.println("Thank you...");
				break;
			}
			try {
				DBconnect DB= new DBconnect();
				DB.dbMain();
				String query1="select * from new_shipments where shipment_id="+shipmentId+"";
				ResultSet rs = DB.st.executeQuery(query1);
				rs.next();
            	String query2= "insert into hub(shipment_id,customer_username,customer_city,destination_name,destination_number,destination_city,destination_address,shipment_type,hub_type) values("+rs.getInt(1)+",'"+rs.getString(2)+"','"+rs.getString(4)+"','"+rs.getString(6)+"',"+rs.getLong(7)+",'"+rs.getString(8)+"','"+rs.getString(9)+"','"+rs.getString(11)+"','in')";
            	DB.st.execute(query2);
            	String query3="delete from new_shipments where shipment_id="+shipmentId+"";
            	DB.st.execute(query3);
				
			}catch (Exception e) {System.out.println("Entered id is incorrect...Please try again");}
			
			
		}
	}
	static void pickUpPrint(String city) throws Exception {
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from new_shipments where customer_city='"+city+"'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("------------------------------------------------------------------------");      
		System.out.printf("%5s %9s %13s %15s", "Id |", "Name |", "Number |","Address");  
		System.out.println("\n------------------------------------------------------------------------");
		
		while(rs.next())
			fmt.format("%3s %10s %12s  %20s \n",rs.getInt("shipment_id"),rs.getString("customer_username"),rs.getLong("customer_number"),rs.getString("customer_address"));
		System.out.println(fmt);
	}

}
