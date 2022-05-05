package Customer;

import java.sql.ResultSet;
import java.util.Formatter;

import Main.DBconnect;

public class ShipmentStatus {
	static void customerShipmentStatus(String userName) throws Exception {
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from shipments where customer_username='"+userName+"' order by shipment_id desc";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("---------------------------------------------------------------------------");      
		System.out.printf("%5s %9s %13s %8s %5s %12s", "Shipment Id |", "Destination |", "To Number |","Price |","Type |","Status");  
		System.out.println("\n---------------------------------------------------------------------------");
		
		while(rs.next())
			fmt.format("%6s %16s %15s  %6s %6s %18s \n",rs.getInt("shipment_id"),rs.getString("to_city"),rs.getLong("to_number"),rs.getInt("shipment_price"),rs.getString("shipment_type"),rs.getString("shipment_status"));
		System.out.println(fmt);
	}

}
