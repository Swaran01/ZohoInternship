package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect;

public class HubIn {

	void hubIn(String city) throws Exception {
		hubInPrint(city);
		Scanner input=new Scanner(System.in);
		System.out.println("ENTER THE LOADED SHIPMENT ID FOR TRANSIT or 0 TO END");
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
				String query1="select * from hub where shipment_id="+shipmentId+"";
				ResultSet rs = DB.st.executeQuery(query1);
				rs.next();
            	String query2= "insert into transit(shipment_id,from_city,to_city,shipment_type) values("+rs.getInt("shipment_id")+",'"+rs.getString("customer_city")+"','"+rs.getString("destination_city")+"','"+rs.getString("shipment_type")+"')";
            	DB.st.execute(query2);
            	String query3="delete from hub where shipment_id="+shipmentId+"";
            	DB.st.execute(query3);
				
			}catch (Exception e) {System.out.println("shipment id is incorrect...Please try again");}
			
			
		}
		
	}
	void hubInPrint(String city) throws Exception {
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from hub where customer_city='"+city+"' and hub_type='in'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("------------------------------------------------");      
		System.out.printf("%3s %15s %10s", "Shipping Id |", "Destination City |", "Shipment Type");  
		System.out.println("\n------------------------------------------------");
		
		while(rs.next())
			fmt.format("%6s %18s %15s \n",rs.getInt("shipment_id"),rs.getString("destination_city"),rs.getString("shipment_type"));
		System.out.println(fmt);
		
	}
}
