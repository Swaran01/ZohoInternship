package Admin;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

import Main.DBconnect;

public class HubOut {
	
	void hubOut(String city) throws Exception {
		hubOutPrint(city);
		Scanner input=new Scanner(System.in);
		System.out.println("ENTER THE UNLOADED SHIPMENT ID FROM TRANSIT or 0 TO END");
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
				String query1="select * from shipments join transit on shipments.shipment_id=transit.shipment_id where transit.shipment_id="+shipmentId+";";
				ResultSet rs = DB.st.executeQuery(query1);
				rs.next();
            	String query2= "insert into hub(shipment_id,customer_username,customer_city,destination_name,destination_number,destination_city,destination_address,shipment_type,hub_type) values("+rs.getInt(1)+",'"+rs.getString(2)+"','"+rs.getString(3)+"','"+rs.getString(5)+"','"+rs.getLong(6)+"','"+rs.getString(4)+"','"+rs.getString(7)+"','"+rs.getString(9)+"','out')";
            	DB.st.execute(query2);
            	String query3="delete from transit where shipment_id="+shipmentId+"";
            	DB.st.execute(query3);
            	String query4="update shipments set shipment_status='OUT FOR DELIVERY' where shipment_id="+shipmentId+"";
            	DB.st.execute(query4);
				
			}catch (Exception e) {System.out.println("shipment id is incorrect...Please try again");}
		}
	}
	
	void hubOutPrint(String city) throws Exception {
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from transit where to_city='"+city+"'";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("------------------------------------------------");      
		System.out.printf("%3s %15s %10s", "Shipping Id |", "From City |", "Shipment Type");  
		System.out.println("\n------------------------------------------------");
		
		while(rs.next())
			fmt.format("%6s %18s %15s \n",rs.getInt("shipment_id"),rs.getString("from_city"),rs.getString("shipment_type"));
		System.out.println(fmt);
		
	}

}
