package Hozo_supermarket;

import java.sql.ResultSet;

public class Invoices {
	void invoiceUpdate(int invoice_number,int bill_amount,long customer_number) throws Exception {
		
		DBconnect DB= new DBconnect();
	    DB.DBmain();
		String query="insert into invoice_details(invoice_number,bill_amount,customer_number) values("+invoice_number+","+bill_amount+","+customer_number+")";
		DB.st.executeUpdate(query);
		
	}
	
	void invoiceDetails(int total_amount,long number) throws Exception {
		
		DBconnect DB= new DBconnect();
	    DB.DBmain();
		String query1="select invoice_number from invoice_details order by invoice_number desc limit 1";
		ResultSet rs=DB.st.executeQuery(query1);
		rs.next();
		int current_invoice_number=(rs.getInt(1)+1);
		System.out.println("\nInvoice No- "+current_invoice_number);
		invoiceUpdate(current_invoice_number,total_amount,number);
		
		
	}
	
}
