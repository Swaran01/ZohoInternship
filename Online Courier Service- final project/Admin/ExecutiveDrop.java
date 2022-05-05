package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect; 

public class ExecutiveDrop {

	static void executiveDrop(String city) throws Exception {
		Scanner input=new Scanner(System.in);
		pickUpPrint(city);
		System.out.println("ENTER DELIVERED SHIPMENT ORDER-ID or 0 TO END");
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
				String query1="select * from hub where shipment_id="+shipmentId+" and hub_type='out'";
				ResultSet rs = DB.st.executeQuery(query1);
				rs.next();
            	String query2= "update shipments set shipment_status='Delivered' where shipment_id="+shipmentId+"";
            	DB.st.execute(query2);
            	String query3="delete from hub where shipment_id="+shipmentId+"";
            	DB.st.execute(query3);
				
			}catch (Exception e) {System.out.println("Entered id is incorrect...Please try again");}
			
			
		}
	}
	static void pickUpPrint(String city) throws Exception {
		
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from hub where destination_city='"+city+"' and hub_type='out'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("------------------------------------------------------------------------");      
		System.out.printf("%5s %9s %13s %15s", "Id |", "Name |", "Number |","Address");  
		System.out.println("\n------------------------------------------------------------------------");
		
		while(rs.next())
			fmt.format("%3s %10s %12s  %20s \n",rs.getInt("shipment_id"),rs.getString("destination_name"),rs.getLong("destination_number"),rs.getString("destination_address"));
		System.out.println(fmt);
	}

}
