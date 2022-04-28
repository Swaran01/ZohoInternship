package Hozo_supermarket;

import java.util.Scanner;
import java.sql.ResultSet;


class Products {
	
	static void productUpload(String name,int code,int stock,int price) throws Exception {
		DBconnect DB= new DBconnect();
		String query="insert into product_details(product_name,product_code,product_stock,product_price) values ('"+name+"',"+code+","+stock+","+price+")";
		DB.DBmain();
		DB.st.execute(query);
		
	}

	public static void newProduct(){
		
		Scanner input = new Scanner(System.in);    
		
		int opt;
		while(true) {
			System.out.println("1 to add product - 0 to stop ");
			System.out.print("Enter: ");
			opt=input.nextInt();
			input.nextLine();
			int code,stock,price;
			String name;
			if(opt==1) {
				
				try {

					System.out.print("product name: ");
					name=input.nextLine();
					System.out.print("code: ");
					code=input.nextInt();
					System.out.print("Stock: ");
					stock=input.nextInt();
					System.out.print("Price: ");
					price=input.nextInt();
					productUpload(name,code,stock,price);  //send to method to update in db
					System.out.println("\nProduct Uploaded.\n\n ");
					
				}catch(Exception e) {System.out.println("Error: Entered product format is incorrect");}
			}
			else if(opt==0) {
				System.out.println("Thank you for uploading products. ");
				break;
			}
			
			else
				System.out.println("Enter a valid option. ");
			
		}
		//input.close();

	}
	
}

class stocks{
	
	static void updateStock(int code,int qty) throws Exception {
		
	    DBconnect DB= new DBconnect();
	    DB.DBmain();
		String query1="select product_stock from product_details where product_code="+code+"";
		ResultSet rs=DB.st.executeQuery(query1);
		rs.next();
		int stock=rs.getInt(1);
		String query2="update product_details set product_stock="+(stock-qty)+" where product_code='"+code+"'";
		DB.st.executeUpdate(query2);
	}
	static void updateStock() {
		
        Scanner input = new Scanner(System.in);    
        int opt;
		while(true) {
			System.out.println("1 to add stock - 0 to stop ");
			System.out.print("Enter: ");
			
			opt=input.nextInt();
			input.nextLine();
			int code,stock;
			if(opt==1) {
				
				try {
					System.out.print("product code: ");
					code=input.nextInt();
					System.out.print("add stock: ");
					stock=input.nextInt();
					
					DBconnect DB= new DBconnect();
				    DB.DBmain();
					String query1="select product_stock from product_details where product_code="+code+"";
					ResultSet rs=DB.st.executeQuery(query1);
					rs.next();
					stock=stock+ rs.getInt(1);
					String query2="update product_details set product_stock="+(stock)+" where product_code='"+code+"'";
					DB.st.executeUpdate(query2);
					

					System.out.println("\nStock Updated.\n\n ");
				}catch(Exception e) {System.out.println("Error: Product code not available in DB");}
				
			}
			else if(opt==0) {
			System.out.println("Thank you for updating stocks. ");
			break;
			}
			
			else
				System.out.println("Enter a valid option. ");
				
	}
	//input.close();
}
}


