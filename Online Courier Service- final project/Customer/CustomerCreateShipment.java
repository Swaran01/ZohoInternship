package Customer;

import java.sql.ResultSet;
import Essentials.*;
import java.util.Scanner;

import Main.DBconnect;

public class CustomerCreateShipment {

	int price;
	String destinationName,destinationCity,destinationAddress,customerUsername,shipmentType;
	long destinationNumber;
	
	public void createShipment(String customerUsername) throws Exception {
		this.customerUsername=customerUsername;
		newShipmentEntry();
		newShipmentUpload(customerUsername,destinationName,destinationCity,destinationAddress,price,shipmentType,destinationNumber);
		uploadStatus(customerUsername,destinationName,destinationAddress,destinationNumber);
	}
	
	void newShipmentEntry() throws Exception {
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("\n***CREATE SHIPMENT***");
				System.out.print("To name: ");
				destinationName=input.nextLine();
				System.out.print("To number: ");
				destinationNumber=input.nextLong();
				input.nextLine();
				while(true) {
					System.out.print("Destination city: ");
					destinationCity=input.nextLine();
					if(destinationCity.equals("Coimbatore")||destinationCity.equals("Madurai")||destinationCity.equals("Chennai")) {
						break;
					}
					else
						System.out.println("\nService available only on Coimbatore, Madurai, Chennai\n");
				}
				
				System.out.print("Destination address: ");
				destinationAddress=input.nextLine();
				System.out.print("Shipment Type(road|air): ");
				shipmentType=input.nextLine();
				
				int length, breadth, height;
				float weight;
				System.out.println("\nENTER THE DIMENSIONS AND WEIGHT. ");
				System.out.print("Length (cm): ");
				length=input.nextInt();
				System.out.print("Breadth (cm): ");
				breadth=input.nextInt();
				System.out.print("Height (cm): ");
				height=input.nextInt();
				System.out.print("Weight (kg): ");
				weight=input.nextFloat();	
				System.out.println("\n***SHIPMENT PRICE AND DETAILS*** ");
				ShipmentPriceCalculator objj=new ShipmentPriceCalculator();
                objj.shipmentPrice(length,breadth,height,weight,shipmentType);
                this.price=objj.price;
				break;
				
				
			}catch(Exception e) {System.out.println("\nDetails format incorrect...Please enter in proper");}
						
		}
				
	}

	void newShipmentUpload(String customerUsername, String destinationName, String destinationCity, String destinationAddress, int price, String shipmentType, long destinationNumber) throws Exception {
		DBconnect DB= new DBconnect();
		DB.dbMain();
		String query="select * from customer_details where customer_username='"+customerUsername+"'";
		ResultSet rs = DB.st.executeQuery(query);
		rs.next();
		String query1="insert into new_shipments(customer_username,customer_number,customer_city,customer_address,destination_name,destination_number,destination_city,destination_address,shipment_price,shipment_type) values ('"+rs.getString(4)+"',"+rs.getLong(3)+",'"+rs.getString(6)+"','"+rs.getString(7)+"','"+destinationName+"',"+destinationNumber+",'"+destinationCity+"','"+destinationAddress+"',"+price+",'"+shipmentType+"')";
		DB.st.execute(query1);
		
		
		}
	void uploadStatus(String customerUsername, String destinationName, String destinationAddress, long destinationNumber) throws Exception {
		DBconnect DB= new DBconnect();
		DB.dbMain();
		String query2="select shipment_id from new_shipments order by shipment_id desc limit 1";
		ResultSet rs1 = DB.st.executeQuery(query2);
		rs1.next();
		String query3="insert into shipments(shipment_id,customer_username,from_city,to_city,to_name,to_number,to_address,shipment_price,shipment_type,shipment_status) values("+rs1.getInt(1)+",'"+customerUsername+"','"+getCustomerCity(customerUsername)+"','"+destinationCity+"','"+destinationName+"',"+destinationNumber+",'"+destinationAddress+"',"+price+",'"+shipmentType+"','YET TO PICK')";
		DB.st.execute(query3);
	}
	String getCustomerCity(String customerUsername) throws Exception {
		DBconnect DB= new DBconnect();
		DB.dbMain();
		String query="select customer_city from customer_details where customer_username='"+customerUsername+"'";
		ResultSet rs = DB.st.executeQuery(query);
		rs.next();
		return rs.getString(1);
		
	}

}
