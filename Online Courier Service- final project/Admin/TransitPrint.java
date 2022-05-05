package Admin;

import java.sql.ResultSet;
import java.util.Formatter;

import Main.DBconnect;

public class TransitPrint {
	static void TransitList() throws Exception {
		Formatter fmt=new Formatter();
		DBconnect DB= new DBconnect();
		String query="select * from transit";
		DB.dbMain();
		ResultSet rs = DB.st.executeQuery(query);
		//rs.next();		
		System.out.println("-------------------------------------------------");      
		System.out.printf("%5s %10s %10s %5s", "Shipment Id |", "    From    |", "    To     |"," Type  ");  
		System.out.println("\n-------------------------------------------------");
		
		while(rs.next())
			fmt.format("%7s %16s %11s %9s \n",rs.getInt("shipment_id"),rs.getString("from_city"),rs.getString("to_city"),rs.getString("shipment_type"));
		System.out.println(fmt);
	}

}
