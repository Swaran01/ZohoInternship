package Hozo_supermarket;

import java.sql.ResultSet;
import java.util.Formatter;  

public class Print_all_products {
	Formatter fmt;
	DBconnect DB;
	Print_all_products(){
		fmt = new Formatter();
		DB= new DBconnect();
		//DB.DBmain();
	}
	void start() throws Exception {
		DB.DBmain();
	}
	void print() throws Exception {
		System.out.println("");
	}
}

class Print_for_billing extends Print_all_products{
	
    public void print() throws Exception {//for billing
    	
        start(); 
 		String query="select * from product_details";
		ResultSet rs = DB.st.executeQuery(query);
		
		System.out.println("------------------------------------");      
		System.out.printf("%6s %18s %9s", "CODE", "PRODUCTS", "PRICE");  
		System.out.println("\n------------------------------------");
		
		while (rs.next())
			fmt.format("%6s %20s %6s \n",rs.getInt("product_code"),rs.getString("product_name"),rs.getInt("product_price"));
			System.out.println(fmt);

	}
}

 class Print_for_admin extends Print_all_products{
	
    public void print() throws Exception {//for admin
		
		start();
		String query="select * from product_details";
		ResultSet rs = DB.st.executeQuery(query);
		
		System.out.println("------------------------------------");      
		System.out.printf("%6s %18s %9s", "CODE", "PRODUCTS", "stock");  
		System.out.println("\n------------------------------------");
		
		while (rs.next())
			fmt.format("%6s %20s %6s \n",rs.getInt("product_code"),rs.getString("product_name"),rs.getInt("product_stock"));
			System.out.println(fmt);

	}
}