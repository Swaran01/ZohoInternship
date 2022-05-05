package Essentials;

public class ShipmentPriceCalculator {
	public int price;

	public void shipmentPrice(int length, int breadth, int height, float weight, String shipmentType) {
		float volumetricWeight, finalWeight;
		volumetricWeight=calculateVolumetricWeight(length,breadth,height);
		System.out.println("\nLength: "+length+"cm, Breadth: "+breadth+"cm, Height: "+height+"cm");
		System.out.println("Package Weight: "+weight+"kg");
		System.out.println("Volumetric Weight: "+volumetricWeight+"kg");
		if(volumetricWeight>weight) {
			System.out.println("\nThe Volumetric Weight is more than the actual Shipment Weight, So price is calculated with Volumetric Weight.");
			finalWeight=volumetricWeight;
			if(shipmentType.equals("road"))
				System.out.println("Shipment type: By Road ");
			else if(shipmentType.equals("air"))
				System.out.println("Shipment type: By Air ");
			System.out.println("Shipment price: "+calculatePrice(finalWeight,shipmentType));
		}
		else if(weight>volumetricWeight) {
			System.out.println("\nThe Actual shipment Weight is more than the Volumetric Weight, So price is calculated with the Actual Weight.");
			finalWeight=weight;
			if(shipmentType.equals("road"))
				System.out.println("Shipment type: By Road ");
			else if(shipmentType.equals("air"))
				System.out.println("Shipment type: By Air ");
			System.out.println("Shipment price: "+calculatePrice(finalWeight,shipmentType));
		}
	}
		float calculateVolumetricWeight(int length, int breadth, int height) {
			float volumetricWeight;
			volumetricWeight=(length*breadth*height)/5000;
			return volumetricWeight;
		}
		float calculatePrice(float finalWeight, String shipmentType) {
			this.price =(int)(finalWeight*60);
			if(shipmentType.equals("air"))
				price=price*2;
			return price;
		}
		
}
