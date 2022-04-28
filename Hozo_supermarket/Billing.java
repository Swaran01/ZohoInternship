package Hozo_supermarket;

import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Scanner;

public class Billing {
	Formatter fmt = new Formatter();
	int total_amount,total_qty,customer_points;
	long number;

	public void billInput (long number) {
		
		Scanner input=new Scanner(System.in);
		int code=1,qty;
		this.number=number;
		while(code!=0)
		{
			try{
				System.out.print("Product code: ");
				code=input.nextInt();
				if(code==0)
					break;
				System.out.print("Qty: ");
				qty=input.nextInt();
				
				DBconnect DB= new DBconnect();
				String query="select * from product_details where product_code="+code+";";
				DB.DBmain();
				ResultSet rs = DB.st.executeQuery(query);
				rs.next();
				int price=rs.getInt(4);
				price=price*qty;
				
				addInput(price, qty);
				stocks.updateStock(code,qty);
				fmt.format("%16s %4s %6s \n",rs.getString(1),qty,price);
			}catch(Exception e) {System.out.print("Error: Wrong product code\n");}
		}
		try {
			finalBill();
			updateCustomerPoints(number);
		}catch(Exception e) {System.out.print("Error while printing final bill or while updating customer points");}
        //input.close(); 
	}
	/*Add input method
	 * is used for
	 * price adding 
	 */
	public void addInput(int price, int qty) {
		
		total_amount=total_amount+price;
		total_qty=total_qty+qty;
	}
	
	public void finalBill() throws Exception {
		
		Invoices obj=new Invoices();
		obj.invoiceDetails(total_amount,number);
		System.out.println("------------------------------------");      
		System.out.printf("%17s %4s %7s", "PRODUCT NAME", "QTY", "AMOUNT");  
		System.out.println("\n------------------------------------");
		System.out.println(fmt);
		System.out.println("------------------------------------");
		System.out.println("Total Quantity= "+total_qty);
		System.out.println("Total Amount= "+total_amount);
		System.out.println("Points Earned= "+(int)(total_amount*0.02));
		System.out.println("------------------------------------");
		
	
	}
	public void updateCustomerPoints(long number) throws Exception {
		
		customer_points=(int)(total_amount*0.02);
		DBconnect DB= new DBconnect();
	    DB.DBmain();
		String query1="select customer_points from customer_details where customer_number="+number+"";
		ResultSet rs=DB.st.executeQuery(query1);
		rs.next();
		int existing_points=rs.getInt(1);
		String query2="update customer_details set customer_points="+(customer_points+existing_points)+" where customer_number='"+number+"'";
		DB.st.executeUpdate(query2);
		
	}

}
